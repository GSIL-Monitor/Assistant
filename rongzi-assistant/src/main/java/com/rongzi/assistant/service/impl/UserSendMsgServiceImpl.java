package com.rongzi.assistant.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.common.context.UserContextHolder;
import com.rongzi.assistant.dao.UserSendMsgMapper;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.model.UserInfo;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.assistant.service.UserSendMsgService;
import com.rongzi.config.aop.CityDataSource;
import com.rongzi.config.aop.CityDatasourceEnum;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserSendMsgServiceImpl implements UserSendMsgService {


    @Autowired
    UserSendMsgMapper userSendMsgMapper;


    @Autowired
    CustomerService customerService;

    /**
     * 从销售系统获取短信
     *
     * @param empCode
     * @param customerMobile
     * @param customerCode
     * @return
     */
    @Override
    @CityDataSource(name = CityDatasourceEnum.DATA_SOURCE_CITY)
    public List<SmsMessage> findMsgsFromSaleSystemByUserAndCustomer(String empCode, String customerMobile, String customerCode) {

        /**
         * 1:销售发往客户
         */
        List<SmsMessage> sendMsgs = userSendMsgMapper.findAllMsgsByUserAndCustomer(empCode, customerCode);
        List<SmsMessage> resultList = new ArrayList<SmsMessage>();

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

    /**
     * 增加客户发送的短信到销售系统
     *
     * @param sendList
     * @return
     */
    @Override
    public boolean addMsgsToSaleSystem(List<SmsMessage> sendList) {

        for (SmsMessage smsMessage : sendList) {
            /**
             * 通过客户手机号码去查询客户的姓名和客户编号
             */
            Customer customer = customerService.findCustomerCodeAndCustomerNameByCustomerMobile(smsMessage.getReceiverMobile());
            smsMessage.setReceiver(customer.getCustomerCode());
            smsMessage.setReceiverName(customer.getName());
        }

        UserInfo currentUser = UserContextHolder.getCurrentUserInfo();
        DataSourceContextHolder.setDataSourceType(currentUser.getCityCode());
        boolean flag = userSendMsgMapper.addMsgsToSaleSystem(sendList);
        DataSourceContextHolder.clearDataSourceType();
        return flag;
    }
}
