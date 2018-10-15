package com.rongzi.assistant.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS",timezone="GMT+8")
    private Date paymentDate;

    /**
     * 工作城市
     */
    private String workPlace;


    /**
     * 备注
     */
    @NotBlank
    @Size(min = 1,max = 500)
    private String comment;

    /**
     * 客户意向进程
     */
    private Integer exeStatus;

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
    private Integer contactStatus;

    /**
     * 微信好友状态
     */
    private int wechatFriendStatus;

    /**
     * 申请好友的时间
     */
    private Date addFriendTime;


    /**
     * 微信ID
     */
    private String customerWechatId;


    /**
     * 合同类型
     * 1：会员客户 对应数据库的 1
     * 2：外包客户 对应数据库的 2 3
     * 3：协议客户 对应数据库的 4 5 6 7 8
     */
    private Integer contractType;


    public Integer getContractType() {
        return contractType;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

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

    public Integer getExeStatus() {
        return exeStatus;
    }

    public void setExeStatus(Integer exeStatus) {
        this.exeStatus = exeStatus;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getContactStatus() {
        return contactStatus;
    }

    public void setContactStatus(Integer contactStatus) {
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
                ", contractType=" + contractType +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        if((!StringUtils.isEmpty(o.name)) && (!StringUtils.isEmpty(this.name))){
            return Collator.getInstance(Locale.CHINA).compare(this.name, o.name);
        }else{
            return this.mobile.compareTo(o.mobile);
        }
    }
}
