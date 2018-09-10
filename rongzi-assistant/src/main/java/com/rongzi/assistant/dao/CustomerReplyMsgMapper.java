package com.rongzi.assistant.dao;

import com.rongzi.assistant.model.SmsMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerReplyMsgMapper {

    List<SmsMessage> queryCustomerReplyMsgs(@Param("customerMobile") String customerMobile);

    boolean addMsgsToSaleSystem(@Param("list") List<SmsMessage> replyList);

}
