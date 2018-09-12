package com.rongzi.assistant.service.sms.impl;

import com.rongzi.assistant.model.MobileDataSyncInfo;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.service.MobileDataSnycInfoService;
import com.rongzi.assistant.service.sms.CustomerReplyMsgService;
import com.rongzi.assistant.service.sms.SmsMessageService;
import com.rongzi.assistant.service.sms.UserSendMsgService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SmsMessageServiceImpl implements SmsMessageService {



    private Logger logger= LoggerFactory.getLogger(SmsMessageServiceImpl.class);
    @Autowired
    UserSendMsgService userSendMsgService;

    @Autowired
    CustomerReplyMsgService customerReplyMsgService;

    @Autowired
    MobileDataSnycInfoService mobileDataSnycInfoService;

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

        Date HighCallDate = null;
        Date lowCallDate = null;
        String empCode = null;
        if (messages.size() >= 1) {
            lowCallDate = messages.get(messages.size() - 1).getOccurTime();
            HighCallDate = messages.get(0).getOccurTime();
        }
        for(int i=0;i<messages.size();i++){
            if(StringUtils.isEmpty(messages.get(i).getSenderMobile())){
                messages.remove(messages.get(i));
                continue;
            }
            if(messages.get(i).getSenderMobile()!=null){
                if(messages.get(i).getSenderMobile().startsWith("+86")){
                    String newSenderMobile = messages.get(i).getSenderMobile().substring(3, messages.get(i).getSenderMobile().length());
                    messages.get(i).setSenderMobile(newSenderMobile);
                }
            }
            if(messages.get(i).getReceiverMobile()!=null){
                if(messages.get(i).getReceiverMobile().startsWith("+86")){
                    String newReceiveMobile = messages.get(i).getReceiverMobile().substring(3, messages.get(i).getReceiverMobile().length());
                    messages.get(i).setReceiverMobile(newReceiveMobile);
                }
            }
        }
        logger.info("短信同步最大的时间数据是： "+HighCallDate);
        logger.info("短信同步最小的时间数据是： "+lowCallDate);
        List<SmsMessage> empSendMsgs = new ArrayList<SmsMessage>();
        List<SmsMessage> customerSendMsgs = new ArrayList<SmsMessage>();
        for (SmsMessage message : messages) {
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
            if(mobileDataSyncInfo.getLastSmsSyncTime()!=null){
                logger.info("数据库里面保存的时间是："+mobileDataSyncInfo.getLastSmsSyncTime()+"毫秒数目是："+mobileDataSyncInfo.getLastSmsSyncTime().getTime());
                logger.info("传入过来的通话时间是："+lowCallDate+" 毫秒数目是："+lowCallDate.getTime());
                if (mobileDataSyncInfo.getLastSmsSyncTime().getTime() >= lowCallDate.getTime()) {
                    logger.info("数据库时间大于等于最小时间,所以返回： "+mobileDataSyncInfo.getLastSmsSyncTime());
                    Date lastSmsSyncTime = mobileDataSyncInfo.getLastSmsSyncTime();
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
        HighCallDate.setTime(HighCallDate.getTime()+1000);
        mobileDataSnycInfoService.syncSmsMessageAndCallRecordInfo(new MobileDataSyncInfo(empCode, HighCallDate, null, new Date()));
        logger.info("短信同步返回的时间数据是： "+HighCallDate);
        return HighCallDate;
    }
}
