package com.rongzi.assistant.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.model.Customer;

import java.util.List;

public interface CustomerService {


    List<Customer> findAllCustomers(Page page, String empCode, int customerExeStatus);

    void editCommentByCode(String customerCode, String comment);
}