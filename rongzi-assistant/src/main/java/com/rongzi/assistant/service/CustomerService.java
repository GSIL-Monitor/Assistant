package com.rongzi.assistant.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.model.CallRecord;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.model.SearchParam;

import java.util.Date;
import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomers(Page page, String empCode, int customerExeStatus);

    void editCommentByCode(String customerCode, String comment);

    boolean syncContactStatusByCallRecords(List<CallRecord> callRecords);

    /**
     * @Author xulei
     * @Description  查询满足搜索条件的客户
     * @Date 15:26 2018/10/12
     * @Param [page, searchParam]
     * @return java.util.List<com.rongzi.assistant.model.Customer>
     **/
    List<Customer> searchAllCustomersByCondition(Page page, String empCode, List<Integer> contactStatus, Integer contractType, Integer customerExeStatus, String searchName, Date payStartTime, Date payEndTime);


}
