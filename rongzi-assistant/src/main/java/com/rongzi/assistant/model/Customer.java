package com.rongzi.assistant.model;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.text.Collator;
import java.util.Date;
import java.util.Locale;

public class Customer implements Serializable,Comparable<Customer> {

    private static final long serialVersionUID = 4597661105769038855L;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 是否有车产
     */
    private int hasCars;

    /**
     * 是否有担保
     */
    private int hasPolicy;

    /**
     * 月打卡工资
     */
    private Double salary;

    /**
     * 是否有房产
     */
    private int hasHouse;

    /**
     * 是否社保公积金
     */
    private int IsSecuityOrFund;

    /**
     * 工作身份
     */
    private String job;

    /**
     * 借款期限
     */
    private int rqrDuration;

    /**
     * 借款额度
     */
    private int rqrAmount;

    /**
     * 用款时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date paymentDate;

    /**
     * 工作城市
     */
    private String workPlace;


    /**
     * 备注
     */
    @NotBlank
    private String comment;

    /**
     * 客户意向进程
     */
    private int exeStatus;

    /**
     * 客户编号
     */
    @NotBlank
    private String customerCode;

    /**
     * 客户手机号码
     */
    private String mobile;

    /**
     * 拨打状态
     */
    private int contactStatus;

    /**
     * 微信好友状态
     */
    private int  wechatFriendStatus;

    /**
     * 申请好友的时间
     */
    private Date addFriendTime;


    /**
     * 微信ID
     */
    private String customerWechatId;


    public String getCustomerWechatId() {
        return customerWechatId;
    }

    public void setCustomerWechatId(String customerWechatId) {
        this.customerWechatId = customerWechatId;
    }

    public int getWechatFriendStatus() {
        return wechatFriendStatus;
    }

    public void setWechatFriendStatus(int wechatFriendStatus) {
        this.wechatFriendStatus = wechatFriendStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHasCars() {
        return hasCars;
    }

    public void setHasCars(int hasCars) {
        this.hasCars = hasCars;
    }

    public int getHasPolicy() {
        return hasPolicy;
    }

    public void setHasPolicy(int hasPolicy) {
        this.hasPolicy = hasPolicy;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getHasHouse() {
        return hasHouse;
    }

    public void setHasHouse(int hasHouse) {
        this.hasHouse = hasHouse;
    }

    public int getIsSecuityOrFund() {
        return IsSecuityOrFund;
    }

    public void setIsSecuityOrFund(int isSecuityOrFund) {
        IsSecuityOrFund = isSecuityOrFund;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getRqrDuration() {
        return rqrDuration;
    }

    public void setRqrDuration(int rqrDuration) {
        this.rqrDuration = rqrDuration;
    }

    public int getRqrAmount() {
        return rqrAmount;
    }

    public void setRqrAmount(int rqrAmount) {
        this.rqrAmount = rqrAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getExeStatus() {
        return exeStatus;
    }

    public void setExeStatus(int exeStatus) {
        this.exeStatus = exeStatus;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getContactStatus() {
        return contactStatus;
    }

    public void setContactStatus(int contactStatus) {
        this.contactStatus = contactStatus;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", hasCars=" + hasCars +
                ", hasPolicy=" + hasPolicy +
                ", salary=" + salary +
                ", hasHouse=" + hasHouse +
                ", IsSecuityOrFund=" + IsSecuityOrFund +
                ", job='" + job + '\'' +
                ", rqrDuration=" + rqrDuration +
                ", rqrAmount=" + rqrAmount +
                ", paymentDate=" + paymentDate +
                ", workPlace='" + workPlace + '\'' +
                ", comment='" + comment + '\'' +
                ", exeStatus=" + exeStatus +
                ", customerCode='" + customerCode + '\'' +
                ", mobile='" + mobile + '\'' +
                ", contactStatus=" + contactStatus +
                ", wechatFriendStatus=" + wechatFriendStatus +
                ", customerWechatId='" + customerWechatId + '\'' +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        return Collator.getInstance(Locale.CHINA).compare(this.name,o.name);
    }
}
