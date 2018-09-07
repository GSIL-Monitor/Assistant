package com.rongzi.assistant.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.common.context.UserContextHolder;
import com.rongzi.assistant.dao.UserSendMsgMapper;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.model.UserInfo;
import com.rongzi.assistant.service.ApiService;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.assistant.service.UserSendMsgService;
import com.rongzi.config.aop.CityDataSource;
import com.rongzi.config.aop.CityDatasourceEnum;
import com.rongzi.config.exception.AssistantExceptionEnum;
import com.rongzi.core.exception.GunsException;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.apache.commons.lang3.StringUtils;
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



    @Autowired
    ApiService apiService;
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

        for(int i=0;i<sendList.size();i++){
            SmsMessage smsMessage = sendList.get(i);
            Customer customer = apiService.findCustomerCodeAndCustomerNameByCustomerMobile(smsMessage.getReceiverMobile());
            if(customer==null){
                sendList.remove(smsMessage);
                continue;
            }
            smsMessage.setReceiver(customer.getCustomerCode());
            if(StringUtils.isEmpty(customer.getName())){
                smsMessage.setReceiverName("");
            }
            smsMessage.setReceiverName(customer.getName());
        }
        if(sendList.size()<=0){
            throw new GunsException(AssistantExceptionEnum.CUSTOMER_NOT_FOUNT);
        }
        UserInfo currentUser = UserContextHolder.getCurrentUserInfo();
        DataSourceContextHolder.setDataSourceType(currentUser.getCityCode());
        boolean flag = userSendMsgMapper.addMsgsToSaleSystem(sendList);
        DataSourceContextHolder.clearDataSourceType();
        return flag;
    }
}
