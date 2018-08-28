package com.rongzi.assistant.service;

import com.rongzi.assistant.model.SmsMessage;

import java.util.List;

public interface SmsMessageService {


    List<SmsMessage> findMsgsFromSaleSystem(String empCode, String customerCode, String customerMobile);

    boolean addMsgsToSaleSystem(List<SmsMessage> messages);
}
