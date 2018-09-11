package com.rongzi.assistant.service.sms;

import com.rongzi.assistant.model.SmsMessage;

import java.util.Date;
import java.util.List;

public interface SmsMessageService {

    List<SmsMessage> findMsgsFromSaleSystem(String empCode, String customerCode, String customerMobile);

    Date addMsgsToSaleSystem(List<SmsMessage> messages);

}
