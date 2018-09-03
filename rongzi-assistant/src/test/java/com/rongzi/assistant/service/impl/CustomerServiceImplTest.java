package com.rongzi.assistant.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.gson.JsonObject;
import com.rongzi.AssistantApp;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.core.page.PageInfoBT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AssistantApp.class)
public class CustomerServiceImplTest {


    @Autowired
    CustomerService customerService;

    @Test
    public void findAllCustomers() {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        Page page = new Page(1, 50);

        List<Customer> aa5322 = customerService.findAllCustomers(page, "AA5322", 1);
//        System.out.println(JSON.toJSONString(aa5322, SerializerFeature.WriteNullStringAsEmpty));


        page.setRecords(aa5322);


        PageInfoBT<Customer> pageinfo = new PageInfoBT<Customer>(page);


        resultMap.put("msg", "操作成功");
        resultMap.put("code", 0);
//        resultMap.put("data", JSON.toJSONString(pageinfo));
        resultMap.put("data", JSON.toJSON(pageinfo));

       System.out.println(JSON.toJSONString(pageinfo));


        JSONObject json = new JSONObject(resultMap);

        System.out.println(json);




    }

    @Test
    public void editCommentByCode() {
    }


    @Test
    public void markWechatFriendship() {


        String customerMobile="13357103466";
        int friendStatus=1;


        customerService.markWechatFriendship(customerMobile,friendStatus,new Date());
    }



}