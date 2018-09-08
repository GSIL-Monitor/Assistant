package com.rongzi.assistant.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.common.datasource.DataSource;
import com.rongzi.assistant.common.datasource.DatasourceEnum;
import com.rongzi.assistant.dao.CustomerMapper;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.service.CustomerInternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerInternalServiceImpl implements CustomerInternalService {

    @Autowired
    CustomerMapper customerMapper;

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_CITY)
    public List<Customer> findAllCustomers(Page page, String empCode, int customerExeStatus) {
        return customerMapper.queryAllCutomers(page, empCode, customerExeStatus);
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_CITY)
    public Customer findCustomerCodeAndNameByMobile(String mobile) {
        return customerMapper.queryCustomerNameAndCustomerCode(mobile);
    }

}
