package com.rongzi.assistant.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.dao.UserSendMsgMapper;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.service.CustomerReplyMsgService;
import com.rongzi.assistant.service.SmsMessageService;
import com.rongzi.assistant.service.UserSendMsgService;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
     * @param empCode
     * @param customerCode
     * @param customerMobile
     * @param page
     * @return
     */
    @Override
    public List<SmsMessage> findMsgsFromSaleSystem(String empCode, String customerCode, String customerMobile) {

        List<SmsMessage> sendMsgs = userSendMsgService.findMsgsFromSaleSystemByUserAndCustomer(empCode, customerMobile,customerCode);
        List<SmsMessage> replyMsgs = customerReplyMsgService.findReplyMsgsByCustomerMobile(customerMobile, customerCode, empCode);
        List<SmsMessage> results=new ArrayList<SmsMessage>();

        results.addAll(sendMsgs);
        results.addAll(replyMsgs);
        listSort(results);

        return results;
    }

    private void listSort(List<SmsMessage> msgs){

        Collections.sort(msgs, new Comparator<SmsMessage>() {

            @Override
            public int compare(SmsMessage o1, SmsMessage o2) {
                    Long time1=o1.getOccurTime().getTime();
                    Long time2=o2.getOccurTime().getTime();
                    if(time1>time2){
                        return 1;
                    }else if(time1<time2){
                        return -1;
                    }else{
                        return 0;
                    }
            }
        });
    }

    /**
     * 增加短信到销售系统
     * @param messages
     */
    @Override
    public boolean addMsgsToSaleSystem(List<SmsMessage> messages) {

        List<SmsMessage> sendList=new ArrayList<SmsMessage>();

        List<SmsMessage>  replyList=new ArrayList<SmsMessage>();

        for (SmsMessage message : messages) {
            int senderRole = message.getSenderRole();
            /**
             * 1:销售 2 客户
             */
            if(senderRole==1){
                sendList.add(message);

            }else{
                replyList.add(message);
            }

        }
        boolean userflag=userSendMsgService.addMsgsToSaleSystem(sendList);
        boolean customerFlag=customerReplyMsgService.addMsgsToSaleSystem(replyList);
        if(userflag&&customerFlag){
            return true;
        }
        return false;

    }
}
