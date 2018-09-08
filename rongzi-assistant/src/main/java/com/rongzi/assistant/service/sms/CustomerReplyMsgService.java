package com.rongzi.assistant.service.sms;

import com.rongzi.assistant.model.SmsMessage;

import java.util.List;

public interface CustomerReplyMsgService {

    List<SmsMessage> findReplyMsgsByCustomerMobile(String customerMobile,String customerCode,String empCode);

    boolean addMsgsToSaleSystem(List<SmsMessage> replyList);

}
