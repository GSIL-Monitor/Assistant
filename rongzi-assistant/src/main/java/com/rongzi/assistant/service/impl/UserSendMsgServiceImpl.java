package com.rongzi.assistant.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.dao.UserSendMsgMapper;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.service.UserSendMsgService;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserSendMsgServiceImpl implements UserSendMsgService {


    @Autowired
    UserSendMsgMapper userSendMsgMapper;

    @Override
    public List<SmsMessage> findMsgsFromSaleSystemByUserAndCustomer(String empCode, String customerMobile,String customerCode) {

        DataSourceContextHolder.setDataSourceType("suzhou");


        /**
         * 1:销售发往客户
         */
        List<SmsMessage> sendMsgs=userSendMsgMapper.findAllMsgsByUserAndCustomer(empCode,customerMobile);

        System.out.println("********************************"+sendMsgs.size());


        List<SmsMessage> resultList=new ArrayList<SmsMessage>();

        for (SmsMessage sendMsg : sendMsgs) {
            sendMsg.setSendStatus(1);
            sendMsg.setSender(empCode);
            sendMsg.setSenderMobile("");
            sendMsg.setSenderRole(1);
            sendMsg.setReceiver(customerCode);
            sendMsg.setReceiverMobile(customerMobile);
            resultList.add(sendMsg);
        }
        return resultList;
    }

    @Override
    public boolean addMsgsToSaleSystem(List<SmsMessage> sendList) {

        DataSourceContextHolder.setDataSourceType("suzhou");

        return userSendMsgMapper.addMsgsToSaleSystem(sendList);
    }
}
