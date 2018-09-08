package com.rongzi.assistant.service.impl;

import com.alibaba.fastjson.JSON;
import com.rongzi.AssistantApp;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.service.sms.CustomerReplyMsgService;
import com.rongzi.core.constant.DatasourceEnum;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AssistantApp.class)
public class CustomerReplyMsgServiceImplTest {

    @Autowired
    CustomerReplyMsgService customerReplyMsgService;

    @Test
    public void findReplyMsgsByCustomerMobile() {


        DataSourceContextHolder.setDataSourceType(DatasourceEnum.DATA_SOURCE_GUNS);


//        Page page = new Page(1, 10);

        List<SmsMessage> aac16102000396 = customerReplyMsgService.findReplyMsgsByCustomerMobile("15295663265", "AACT13091609966", "AA1611");


//        page.setRecords(aac16102000396);
//
//        PageInfoBT<SmsMessage> pageinfo = new PageInfoBT<SmsMessage>(page);
//
//        System.out.println(pageinfo.getTotal()+"------------------");
//        System.out.println(pageinfo.getRows()+"----------------");


        String data = JSON.toJSONString(aac16102000396);


        System.out.println(data);

//        for (SmsMessage smsMessage : aac16102000396) {
//
//
//            System.out.println(smsMessage);
//        }
    
    
    }



    @Test
    public void addMsgsToSaleSystem(){

        List<SmsMessage> list=new ArrayList<SmsMessage>();

        for(int i=0;i<5;i++){

            SmsMessage smsMessage=new SmsMessage();

            //客户发送
            smsMessage.setSenderRole(2);
            smsMessage.setSenderName("客户1");
            smsMessage.setSender("AACT13091609966");
            smsMessage.setSenderMobile("15295663265");
            smsMessage.setSignature("【东方融资网】");

            //发送体
            smsMessage.setOccurTime(new Date());
            smsMessage.setContent("测试销售回复        "+i+"      条信息");

            //销售接受
            smsMessage.setReceiver("AA0252");
            smsMessage.setReceiverMobile("");
            smsMessage.setReceiverName("倪梨花[AA0252]");

            //其他属性
            smsMessage.setSendStatus(1);
            smsMessage.setIsRead(1);


            list.add(smsMessage);



        }
        customerReplyMsgService.addMsgsToSaleSystem(list);


    }
}