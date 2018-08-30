package com.rongzi.assistant.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.AssistantApp;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.service.SmsMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AssistantApp.class)
public class SmsMessageServiceImplTest {



    @Autowired
    SmsMessageService smsMessageService;

    @Test
    public void findMsgsFromSaleSystem() {

//        Page page = new Page(1, 10);

        List<SmsMessage> msgs = smsMessageService.findMsgsFromSaleSystem("AA1611", "AACT13091609966", "15295663265");

//        for (SmsMessage msg : msgs) {
//
//            System.out.println(msg);
//        }

        String dATA = JSON.toJSONString(msgs);

        System.out.println(dATA);


    }

    @Test
    public void addMsgsToSaleSystem() {

        long time=System.currentTimeMillis();

        List<SmsMessage> msgs=new ArrayList<SmsMessage>();
        //1:模拟客户回复短信到销售
        for(int i=0;i<200;i++){

            SmsMessage smsMessage=new SmsMessage();

            //发送者
            smsMessage.setSender("AAC17011600001");
            smsMessage.setSenderName("AAC17011600001");
            smsMessage.setSenderMobile("10278185747");
            smsMessage.setSenderRole(2);

            //接受者
            smsMessage.setReceiverName("刘超");
            smsMessage.setReceiver("AA1611");
            smsMessage.setReceiverMobile("");

            //发送体
            smsMessage.setContent("客户发送给销售的第   "+i+"   条信息");
            smsMessage.setOccurTime(new Date(System.currentTimeMillis()+(i*10)));


            //其他
            smsMessage.setIsRead(1);
            smsMessage.setSendStatus(1);
            smsMessage.setSignature("【东方融资网】");

            msgs.add(smsMessage);


        }
        //2：模拟销售发送短信到客户

        for(int j=0;j<200;j++){
            SmsMessage smsMessage=new SmsMessage();
            //发送者
            smsMessage.setSender("AA1611");
            smsMessage.setSenderMobile("");
            smsMessage.setSenderName("刘超");
            smsMessage.setSenderRole(1);


            //接受者
            smsMessage.setReceiver("AAC17011600001");
            smsMessage.setReceiverMobile("10278185747");
            smsMessage.setReceiverName("AAC17011600001");


            //发送体
            smsMessage.setContent("销售发送给客户的第   "+j+"   条信息");
            smsMessage.setOccurTime(new Date(System.currentTimeMillis()+(j*10)));
            smsMessage.setSignature("【东方融资网】");
            //其他
            smsMessage.setIsRead(1);
            smsMessage.setSendStatus(1);


            msgs.add(smsMessage);

        }

        boolean flag = smsMessageService.addMsgsToSaleSystem(msgs);

        System.out.println(flag);
        System.out.println(System.currentTimeMillis()-time);
    }
}