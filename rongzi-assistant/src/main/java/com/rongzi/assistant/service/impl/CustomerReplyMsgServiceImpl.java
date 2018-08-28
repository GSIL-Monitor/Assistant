package com.rongzi.assistant.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.common.context.UserContextHolder;
import com.rongzi.assistant.dao.CustomerReplyMsgMapper;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.model.UserInfo;
import com.rongzi.assistant.service.CustomerReplyMsgService;
import com.rongzi.core.constant.DatasourceEnum;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerReplyMsgServiceImpl implements CustomerReplyMsgService{



    @Autowired
    CustomerReplyMsgMapper customerReplyMsgMapper;

    /**
     *  获取销售系统里面的客户回复的短信
     * @param customerMobile
     * @param customerCode
     * @param empCode
     * @param page
     * @return
     */
    @Override
    public List<SmsMessage> findReplyMsgsByCustomerMobile(String customerMobile,String customerCode,String empCode) {



        DataSourceContextHolder.setDataSourceType(DatasourceEnum.DATA_SOURCE_GUNS);


        List<SmsMessage> replyMsgs=  customerReplyMsgMapper.queryCustomerReplyMsgs(customerMobile);

        List<SmsMessage> resultList=new ArrayList<SmsMessage>();
        /**
         * 客户回复方，没有签名和接受者手机号码。
         */
        for (SmsMessage replyMsg : replyMsgs) {
            replyMsg.setSenderRole(2);
            replyMsg.setSender(customerCode);
            replyMsg.setSenderMobile(customerMobile);
            replyMsg.setReceiverMobile("");
            replyMsg.setReceiver(empCode);
            replyMsg.setIsRead(1);
            replyMsg.setSignature("");




            resultList.add(replyMsg);
        }
        return resultList;
    }

    /**
     * 将客户回复的短信增加到销售系统
     * @param replyList
     * @return
     */
    @Override
    public boolean addMsgsToSaleSystem(List<SmsMessage> replyList) {

        DataSourceContextHolder.setDataSourceType(DatasourceEnum.DATA_SOURCE_GUNS);

        return customerReplyMsgMapper.addMsgsToSaleSystem(replyList);
    }
}
