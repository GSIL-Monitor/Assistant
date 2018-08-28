package com.rongzi.assistant.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.AssistantApp;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AssistantApp.class)
public class CustomerServiceImplTest {


    @Autowired
    CustomerService customerService;

    @Test
    public void findAllCustomers() {

        Page page = new Page(1, 50);

        List<Customer> aa5322 = customerService.findAllCustomers(page, "AA5322", 1);


        System.out.println(JSON.toJSONString(aa5322, SerializerFeature.WriteNullStringAsEmpty));

    }

    @Test
    public void editCommentByCode() {
    }
}