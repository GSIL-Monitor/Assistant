package com.rongzi.assistant.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.dao.CustomerMapper;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Customer> findAllCustomers(Page page, int empCode, int customerExeStatus) {

        List<Customer>  list=  customerMapper.queryAllCutomers(page,empCode,customerExeStatus);
        return list;
    }
}
