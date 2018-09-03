package com.rongzi.assistant.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.zxing.client.result.SMSMMSResultParser;
import com.rongzi.AssistantApp;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.service.UserSendMsgService;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import com.rongzi.core.page.PageInfoBT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AssistantApp.class)
public class UserSendMsgServiceImplTest {


    @Autowired
    UserSendMsgService userSendMsgService;

    @Test
    public void findMsgsFromSaleSystemByUserAndCustomer() {


//        DataSourceContextHolder.setDataSourceType("suzhou");

//        Page page = new Page(1, 10);

        List<SmsMessage> aac16102000396 = userSendMsgService.findMsgsFromSaleSystemByUserAndCustomer("AA1611", "15295663265", "AACT13091609966");

//        page.setRecords(aac16102000396);

//        PageInfoBT<SmsMessage> pageinfo = new PageInfoBT<SmsMessage>(page);

//        System.out.println(pageinfo.getTotal()+"------------------");
//        System.out.println(pageinfo.getRows()+"----------------");

//        for (SmsMessage smsMessage : aac16102000396) {
//
//            System.out.println(smsMessage);
//        }

        System.out.println(JSON.toJSONString(aac16102000396));

        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("msg", "操作成功");
        resultMap.put("code", 0);
        resultMap.put("data", JSON.toJSONString(aac16102000396));

        System.out.println(JSON.toJSONString(resultMap));

    }


    @Test
    public  void  addMsgsToSaleSystem(){


        List<SmsMessage> list=new ArrayList<SmsMessage>();

        for(int i=0;i<5;i++){

            SmsMessage smsMessage=new SmsMessage();

            //销售发送
            smsMessage.setSenderRole(1);
            smsMessage.setSender("AF1399");
            smsMessage.setSenderName("黄瑛[AF1399]");
            smsMessage.setSenderMobile("");

            //客户接受
            smsMessage.setReceiver("AFC15020400058");
            smsMessage.setReceiverMobile("13357103466");
            smsMessage.setReceiverName("AFC15020400058");

            //发送体
            smsMessage.setContent("这个是测试的第++"+i+"++个数据");
            smsMessage.setSignature("【东方融资网】");
            smsMessage.setOccurTime(new Date());

            //其他属性
            smsMessage.setIsRead(1);
            smsMessage.setSendStatus(1);


            list.add(smsMessage);

        }


        String jsonData= JSON.toJSONString(list);

        boolean b = userSendMsgService.addMsgsToSaleSystem(list);
        System.out.println(b);

    }
}