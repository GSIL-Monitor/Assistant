package com.rongzi.assistant.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.dao.CustomerMapper;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.service.CustomerListService;
import com.rongzi.config.aop.CityDataSource;
import com.rongzi.config.aop.CityDatasourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerListServiceImpl implements CustomerListService {

    @Autowired
    CustomerMapper customerMapper;


    @Override
    @CityDataSource(name = CityDatasourceEnum.DATA_SOURCE_CITY)
    public List<Customer> findAllCustomers(Page page, String empCode, int customerExeStatus) {

        return customerMapper.queryAllCutomers(page, empCode, customerExeStatus);
    }
}
