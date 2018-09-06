package com.rongzi.assistant.model;

import java.io.Serializable;
import java.util.Date;

public class RequestJsonParam implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 每页记录行数
     */

    private int pageSize;

    /**
     * pageIndex 从1开始
     */
    private int pageIndex;


    /**
     * 客户意向进程
     */
    private int customerExeStatus;

    /**
     * 客户编号
     */
    private String customerCode;


    /**
     * 客户手机号码
     */
    private String customerMobile;

    /**
     * 销售名称
     */
    private String empName;

    /**
     * 销售工号
     */
    private String empCode;


    /**
     * 微信好友关系状态
     * @return
     */
    private int friendStatus;


    /**
     * 微信好友申请时间
     * @return
     */
    private Date addFriendTime;


    public int getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(int friendStatus) {
        this.friendStatus = friendStatus;
    }

    public Date getAddFriendTime() {
        return addFriendTime;
    }

    public void setAddFriendTime(Date addFriendTime) {
        this.addFriendTime = addFriendTime;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getCustomerExeStatus() {
        return customerExeStatus;
    }

    public void setCustomerExeStatus(int customerExeStatus) {
        this.customerExeStatus = customerExeStatus;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }


}
