package com.rongzi.assistant.dao;


import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.model.CallRecord;
import com.rongzi.assistant.model.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CustomerMapper {

    /**
     * @Author
     * @Description 查询所有的客户
     * @Date 14:08 2018/9/19
     * @Param [page, empCode, customerExeStatus]
     * @return java.util.List<com.rongzi.assistant.model.Customer>
     **/
    List<Customer> queryAllCutomers(@Param("page") Page page, @Param("empCode") String empCode, @Param("customerExeStatus") int customerExeStatus);

    /**
     * @Author xulei
     * @Description 通过客户编号和备注来修改客户备注
     * @Date 14:09 2018/9/19
     * @Param [customerCode, comment]
     * @return void
     **/
    void editCommentByCodeAndComment(@Param("customerCode") String customerCode, @Param("comment") String comment);

    /**
     * @Author xulei
     * @Description 同步通话拨打状态
     * @Date 14:10 2018/9/19
     * @Param [callRecords]
     * @return boolean
     **/
    boolean syncContactStatusByCallRecords(@Param("callRecords") List<CallRecord> callRecords);

    /**
     * @Author xulei
     * @Description 查询客户姓名和客户编号
     * @Date 14:10 2018/9/19
     * @Param [mobile]
     * @return com.rongzi.assistant.model.Customer
     **/
    Customer queryCustomerNameAndCustomerCode(@Param("mobile") String mobile);

    /**
     * @Author xulei
     * @Description  更新客户微信状态
     * @Date 14:11 2018/9/19
     * @Param [weChatStatus, date, customerMobile]
     * @return void
     **/
    void updateCustomerWechatStatus(@Param("wechatFriendStatus") int weChatStatus, @Param("date") Date date, @Param("customerMobile") String customerMobile);

}
