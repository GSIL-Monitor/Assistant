package com.rongzi.assistant.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.model.SmsMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserSendMsgMapper {


    List<SmsMessage> findAllMsgsByUserAndCustomer(@Param("empCode") String empCode, @Param("customerMobile") String customerMobile);

    boolean addMsgsToSaleSystem(@Param("list") List<SmsMessage> sendList);
}
