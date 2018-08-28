package com.rongzi.assistant.model;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable{

    private static final long serialVersionUID = 1L;
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
     *  工作身份
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
    private Date paymentDate;

    /**
     * 工作城市
     */
    private String workPlace;


    /**
     * 备注
     */
    private String comment;

    /**
     * 客户进程
     */
    private int exeStatus;

    /**
     * 客户编号
     */
    private String customerCode;

    /**
     * 客户手机号码
     */
    private String mobile;

    /**
     * 拨打状态
     */
    private int contactStatus;


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
                '}';
    }
}
