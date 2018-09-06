package com.rongzi.assistant.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.model.Customer;

import java.util.List;

public interface ApiService {


    /**
     * 分页查询所有的客户列表信息
     * @param page
     * @param empCode
     * @param customerExeStatus
     * @return
     */
    List<Customer> findAllCustomers(Page page, String empCode, int customerExeStatus);


    /**
     * 通过客户的手机号码去查询·客户编号和客户姓名
     * @param mobile
     * @return
     */
    Customer findCustomerCodeAndCustomerNameByCustomerMobile(String mobile);
}
