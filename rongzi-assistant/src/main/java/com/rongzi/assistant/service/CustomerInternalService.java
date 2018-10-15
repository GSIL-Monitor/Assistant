package com.rongzi.assistant.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.model.Customer;

import java.util.Date;
import java.util.List;

public interface CustomerInternalService {

    /**
     * 分页查询所有的客户列表信息
     *
     * @param page
     * @param empCode
     * @param customerExeStatus
     * @return
     */
    List<Customer> findAllCustomers(Page page, String empCode, int customerExeStatus);


    /**
     * 通过客户的手机号码去查询·客户编号和客户姓名
     *
     * @param mobile  客户的手机号码
     * @return Customer 客户对象
     *
     * @author  Neal Gafter
     */

    Customer findCustomerCodeAndNameByMobile(String mobile);


    /**
     * 查询满足搜索条件的客户信息
     *
     * @Author xulei
     * @Date 17:54 2018/10/12
     * @Param [page, empCode, contactStatus, contractType, customerExeStatus, searchName, payStartTime, payEndTime]
     * @return java.util.List<com.rongzi.assistant.model.Customer>
     **/
    List<Customer> searchCustomersByCondition(Page page, String empCode, List<Integer> contactStatus, Integer contractType, Integer customerExeStatus, String searchName, Date payStartTime, Date payEndTime);

}
