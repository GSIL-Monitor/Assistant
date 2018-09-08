package com.rongzi.assistant.service.sms.impl;

import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.service.sms.CustomerReplyMsgService;
import com.rongzi.assistant.service.sms.SmsMessageService;
import com.rongzi.assistant.service.sms.UserSendMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class SmsMessageServiceImpl implements SmsMessageService {

    @Autowired
    UserSendMsgService userSendMsgService;

    @Autowired
    CustomerReplyMsgService customerReplyMsgService;

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
    public boolean addMsgsToSaleSystem(List<SmsMessage> messages) {
        List<SmsMessage> empSendMsgs = new ArrayList<SmsMessage>();
        List<SmsMessage> customerSendMsgs = new ArrayList<SmsMessage>();
        for (SmsMessage message : messages) {
            int senderRole = message.getSenderRole();
            if (senderRole == 1) {
                empSendMsgs.add(message);
            } else {
                customerSendMsgs.add(message);
            }
        }
        if (empSendMsgs.size() > 0) {
            userSendMsgService.addMsgsToSaleSystem(empSendMsgs);
        }
        if (customerSendMsgs.size() > 0) {
            customerReplyMsgService.addMsgsToSaleSystem(customerSendMsgs);
        }
        return true;
    }
}
