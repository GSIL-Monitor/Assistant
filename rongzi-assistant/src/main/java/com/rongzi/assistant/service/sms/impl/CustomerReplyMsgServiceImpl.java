package com.rongzi.assistant.service.sms.impl;

import com.rongzi.assistant.dao.CustomerReplyMsgMapper;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.service.sms.CustomerReplyMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerReplyMsgServiceImpl implements CustomerReplyMsgService {

    @Autowired
    CustomerReplyMsgMapper customerReplyMsgMapper;

    /**
     * 获取销售系统里面的客户回复的短信
     *
     * @param customerMobile
     * @param customerCode
     * @param empCode
     * @return
     */
    @Override
    public List<SmsMessage> findReplyMsgsByCustomerMobile(String customerMobile, String customerCode, String empCode) {
        List<SmsMessage> replyMsgs = customerReplyMsgMapper.queryCustomerReplyMsgs(customerMobile);
        List<SmsMessage> resultList = new ArrayList<SmsMessage>();
        for (SmsMessage replyMsg : replyMsgs) {
            replyMsg.setSenderRole(2);
            replyMsg.setSender(customerCode);
            replyMsg.setSenderMobile(customerMobile);
            replyMsg.setReceiverMobile("");
            replyMsg.setReceiver(empCode);
            replyMsg.setIsRead(1);
            replyMsg.setSignature("");
            resultList.add(replyMsg);
        }
        return resultList;
    }

    /**
     * 将客户回复的短信增加到销售系统
     *
     * @param replyList
     * @return
     */
    @Override
    public boolean addMsgsToSaleSystem(List<SmsMessage> replyList) {
        boolean flag = customerReplyMsgMapper.addMsgsToSaleSystem(replyList);
        return flag;
    }

}
