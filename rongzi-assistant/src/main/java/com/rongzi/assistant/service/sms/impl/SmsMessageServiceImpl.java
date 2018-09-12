package com.rongzi.assistant.service.sms.impl;

import com.rongzi.assistant.common.exception.AssistantExceptionEnum;
import com.rongzi.assistant.model.MobileDataSyncInfo;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.service.MobileDataSnycInfoService;
import com.rongzi.assistant.service.sms.CustomerReplyMsgService;
import com.rongzi.assistant.service.sms.SmsMessageService;
import com.rongzi.assistant.service.sms.UserSendMsgService;
import com.rongzi.core.exception.GunsException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SmsMessageServiceImpl implements SmsMessageService {

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

        Date lastSmsSyncTime = null;
        Date firstSmsSyncTime = null;
        String empCode = null;
        if (messages.size() >= 1) {
            firstSmsSyncTime = messages.get(messages.size() - 1).getOccurTime();
            lastSmsSyncTime = messages.get(0).getOccurTime();
        }
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
                if (mobileDataSyncInfo.getLastSmsSyncTime().getTime() >= lastSmsSyncTime.getTime()) {
                    return mobileDataSyncInfo.getLastSmsSyncTime();
                }
            }
        }
        if (empSendMsgs.size() > 0) {
            userSendMsgService.addMsgsToSaleSystem(empSendMsgs);
        }
        if (customerSendMsgs.size() > 0) {
            customerReplyMsgService.addMsgsToSaleSystem(customerSendMsgs);
        }
        mobileDataSnycInfoService.syncSmsMessageAndCallRecordInfo(new MobileDataSyncInfo(empCode, firstSmsSyncTime, null, new Date()));

        return firstSmsSyncTime;
    }
}
