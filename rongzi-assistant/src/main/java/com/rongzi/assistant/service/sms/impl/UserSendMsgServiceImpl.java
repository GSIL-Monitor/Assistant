package com.rongzi.assistant.service.sms.impl;

import com.rongzi.assistant.common.datasource.DataSource;
import com.rongzi.assistant.common.datasource.DatasourceEnum;
import com.rongzi.assistant.common.web.context.UserContextHolder;
import com.rongzi.assistant.dao.UserSendMsgMapper;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.model.UserInfo;
import com.rongzi.assistant.service.CustomerInternalService;
import com.rongzi.assistant.service.sms.UserSendMsgService;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSendMsgServiceImpl implements UserSendMsgService {


    private Logger logger= LoggerFactory.getLogger(UserSendMsgServiceImpl.class);

    @Autowired
    UserSendMsgMapper userSendMsgMapper;

    @Autowired
    CustomerInternalService customerInternalService;

    /**
     * 从销售系统获取短信
     *
     * @param empCode
     * @param customerMobile
     * @param customerCode
     * @return
     */
    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_CITY)
    public List<SmsMessage> findMsgsFromSaleSystemByUserAndCustomer(String empCode, String customerMobile, String customerCode) {
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
     * 增加销售发送的短信到销售系统
     *
     * @param sendList
     * @return
     */
    @Override
    public boolean addMsgsToSaleSystem(List<SmsMessage> sendList) {
        for (int i = 0; i < sendList.size(); i++) {
            SmsMessage smsMessage = sendList.get(i);
            Customer customer = customerInternalService.findCustomerCodeAndNameByMobile(smsMessage.getReceiverMobile());
            if (customer == null) {
                sendList.remove(smsMessage);
                continue;
            }
            smsMessage.setReceiver(customer.getCustomerCode());
            if (StringUtils.isEmpty(customer.getName())) {
                smsMessage.setReceiverName("");
            }
            smsMessage.setReceiverName(customer.getName());
        }

        if (sendList.size() <= 0) {
            return true;
        }
        logger.info("**************销售发送的短信******************");
        for (SmsMessage smsMessage : sendList) {
            logger.info(smsMessage.toString());
        }
        logger.info("**************销售发送的短信******************");
        UserInfo currentUser = UserContextHolder.getCurrentUserInfo();
        DataSourceContextHolder.setDataSourceType(currentUser.getCityCode());
        boolean flag = userSendMsgMapper.addMsgsToSaleSystem(sendList);
        DataSourceContextHolder.clearDataSourceType();
        return flag;
    }
}
