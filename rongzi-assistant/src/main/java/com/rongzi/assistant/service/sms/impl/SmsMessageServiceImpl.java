package com.rongzi.assistant.service.sms.impl;

import com.rongzi.assistant.common.exception.AssistantExceptionEnum;
import com.rongzi.assistant.model.MobileDataSyncInfo;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.service.MobileDataSnycInfoService;
import com.rongzi.assistant.service.sms.CustomerReplyMsgService;
import com.rongzi.assistant.service.sms.SmsMessageService;
import com.rongzi.assistant.service.sms.UserSendMsgService;
import com.rongzi.core.exception.GunsException;
import com.rongzi.core.support.DateTimeKit;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SmsMessageServiceImpl implements SmsMessageService {


    private Logger logger = LoggerFactory.getLogger(SmsMessageServiceImpl.class);
    @Autowired
    UserSendMsgService userSendMsgService;

    @Autowired
    CustomerReplyMsgService customerReplyMsgService;

    @Autowired
    MobileDataSnycInfoService mobileDataSnycInfoService;

    AtomicInteger msgCount=new AtomicInteger();

    /**
     * 从销售系统导入短信到手机
     *
     * @param empCode
     * @param customerCode
     * @param customerMobile
     * @return
     */
    @Override
    public List<SmsMessage> findMsgsFromSaleSystem(String empCode, String customerCode, String customerMobile) {
        List<SmsMessage> sendMsgs = userSendMsgService.findMsgsFromSaleSystemByUserAndCustomer(empCode, customerMobile, customerCode);
        List<SmsMessage> replyMsgs = customerReplyMsgService.findReplyMsgsByCustomerMobile(customerMobile, customerCode, empCode);
        List<SmsMessage> results = new ArrayList<SmsMessage>();

        results.addAll(sendMsgs);
        results.addAll(replyMsgs);
        listSort(results);

        return results;
    }

    private void listSort(List<SmsMessage> msgs) {
        Collections.sort(msgs, new Comparator<SmsMessage>() {
            @Override
            public int compare(SmsMessage o1, SmsMessage o2) {
                Long time1 = o1.getOccurTime().getTime();
                Long time2 = o2.getOccurTime().getTime();
                if (time1 > time2) {
                    return 1;
                } else if (time1 < time2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    /**
     * 增加短信到销售系统
     *
     * @param messages
     */
    @Override
    public Date addMsgsToSaleSystem(List<SmsMessage> messages) {
        Date highCallDate = null;
        Date lowCallDate = null;
        String empCode = null;
        List<SmsMessage> correctMsg = new ArrayList<>();
        if (messages.size() >= 1) {
            for (int i = 0; i < messages.size(); i++) {
                if (!(StringUtils.isEmpty(messages.get(i).getSenderMobile()) || (messages.get(i).getSenderMobile().equals("null")))) {
                    correctMsg.add(messages.get(i));
                }
            }
        }

        if (correctMsg.size() >= 1) {
            for (int i = 0; i < correctMsg.size(); i++) {
                if (correctMsg.get(i).getSenderMobile() != null) {
                    if (correctMsg.get(i).getSenderMobile().startsWith("+86")) {
                        String newSenderMobile = correctMsg.get(i).getSenderMobile().substring(3, correctMsg.get(i).getSenderMobile().length());
                        correctMsg.get(i).setSenderMobile(newSenderMobile);
                    }
                }
                if (correctMsg.get(i).getReceiverMobile() != null) {
                    if (correctMsg.get(i).getReceiverMobile().startsWith("+86")) {
                        String newReceiveMobile = correctMsg.get(i).getReceiverMobile().substring(3, correctMsg.get(i).getReceiverMobile().length());
                        correctMsg.get(i).setReceiverMobile(newReceiveMobile);
                    }
                }

            }
            lowCallDate = correctMsg.get(correctMsg.size() - 1).getOccurTime();
            highCallDate = correctMsg.get(0).getOccurTime();
        } else {
            throw new GunsException(AssistantExceptionEnum.EMPCODE_NULL);
        }

        logger.info("短信同步最大的时间数据是： " + highCallDate + " 毫秒数目：" + highCallDate.getTime());
        logger.info("短信同步最小的时间数据是： " + lowCallDate + " 毫秒数目：" + lowCallDate.getTime());
        List<SmsMessage> empSendMsgs = new ArrayList<SmsMessage>();
        List<SmsMessage> customerSendMsgs = new ArrayList<SmsMessage>();
        for (SmsMessage message : correctMsg) {
            int senderRole = message.getSenderRole();
            if (senderRole == 1) {
                empCode = message.getSender();
                empSendMsgs.add(message);
            } else {
                empCode = message.getReceiver();
                customerSendMsgs.add(message);
            }
        }
        MobileDataSyncInfo mobileDataSyncInfo = mobileDataSnycInfoService.findLastTime(empCode);
        if (mobileDataSyncInfo != null) {

            Date lastSmsSyncTime = mobileDataSyncInfo.getLastSmsSyncTime();

            if (mobileDataSyncInfo.getLastSmsSyncTime() != null) {
                logger.info("短信  数据库里面保存的最后时间是：" + lastSmsSyncTime + "毫秒数目是：" + lastSmsSyncTime.getTime());
                if (mobileDataSyncInfo.getLastSmsSyncTime().getTime() > lowCallDate.getTime()) {
                    logger.info("短信  数据库最后时间大于传入过来的最小时间,所以返回数据库里时间： " + lastSmsSyncTime);
                    logger.info("短信  无效的请求次数为： "+msgCount.addAndGet(1));
                    return lastSmsSyncTime;
                }
            }
        }
        if (empSendMsgs.size() > 0) {
            logger.info("开始调用**********增加销售发送的短信到销售系统");
            userSendMsgService.addMsgsToSaleSystem(empSendMsgs);
        }
        if (customerSendMsgs.size() > 0) {
            logger.info("开始调用*********将客户回复的短信增加到销售系统");
            customerReplyMsgService.addMsgsToSaleSystem(customerSendMsgs);
        }
        highCallDate= DateTimeKit.offsiteDate(highCallDate, Calendar.MILLISECOND,3);
        mobileDataSnycInfoService.syncSmsMessageAndCallRecordInfo(new MobileDataSyncInfo(empCode, highCallDate, null, new Date()));
        logger.info("短信  同步返回的时间数据是： " + highCallDate);
        return highCallDate;
    }
}
