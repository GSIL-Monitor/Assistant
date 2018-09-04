package com.rongzi.assistant.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.model.CallRecord;
import com.rongzi.assistant.model.Customer;

import java.util.Date;
import java.util.List;

public interface CustomerService {


    List<Customer> findAllCustomers(Page page, String empCode, int customerExeStatus);

    void editCommentByCode(String customerCode, String comment);

    boolean syncContactStatusByCallRecords(List<CallRecord> callRecords);


    /**
     * 通过客户的手机号码去查询·客户编号和客户姓名
     * @param mobile
     * @return
     */
    Customer findCustomerCodeAndCustomerNameByCustomerMobile(String mobile);

}
