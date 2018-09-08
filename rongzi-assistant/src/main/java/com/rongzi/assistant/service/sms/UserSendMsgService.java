package com.rongzi.assistant.service.sms;

import com.rongzi.assistant.model.SmsMessage;

import java.util.List;

public interface UserSendMsgService {

    List<SmsMessage> findMsgsFromSaleSystemByUserAndCustomer(String empCode, String customerMobile, String customerCode);

    boolean addMsgsToSaleSystem(List<SmsMessage> sendList);

}
