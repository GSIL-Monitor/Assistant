package com.rongzi.assistant.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

public class CallRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 通话号码
     */
    @NotBlank
    private String mobile;

    /**
     * 通话时长(秒)
     */
    @NotBlank
    private int billSec;

    /**
     * 拨打时间
     */
    @NotBlank
    private Date callDate;

    /**
     * 销售手机号码
     */
    private String empWorkMobile;

    /**
     * 销售编号
     */
    @NotBlank
    private String empCode;

    /**
     * 通话类型
     * 0 销售未拨打客户
     * 1：销售拨打客户，客户接通
     * 2：销售拨打了客户，但是客户未接通
     * 3：客户拨打销售，销售未接
     * 4：客户拨打销售，销售接通
     */
    private int callStatus;


    /**
     * 拨打者
     */
    private String src;

    /**
     * 接受者
     */
    private String dst;


    /**
     * 客户编号
     *
     * @return
     */
    private String customerCode;


    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getBillSec() {
        return billSec;
    }

    public void setBillSec(int billSec) {
        this.billSec = billSec;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public String getEmpWorkMobile() {
        return empWorkMobile;
    }

    public void setEmpWorkMobile(String empWorkMobile) {
        this.empWorkMobile = empWorkMobile;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public int getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(int callStatus) {
        this.callStatus = callStatus;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    @Override
    public String toString() {
        return "CallRecord{" +
                "mobile='" + mobile + '\'' +
                ", billSec=" + billSec +
                ", callDate=" + callDate +
                ", empWorkMobile='" + empWorkMobile + '\'' +
                ", empCode='" + empCode + '\'' +
                ", callStatus=" + callStatus +
                ", src='" + src + '\'' +
                ", dst='" + dst + '\'' +
                ", customerCode='" + customerCode + '\'' +
                '}';
    }
}
