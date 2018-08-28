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
    }
}