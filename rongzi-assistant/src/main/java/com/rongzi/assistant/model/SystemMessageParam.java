package com.rongzi.assistant.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 获取销售系统短信到手机的实体类
 */
public class SystemMessageParam implements Serializable{


    private static final long serialVersionUID = 4910613719976587532L;
    /**
     * 销售工号
     */
    @NotBlank
    private String empCode;


    /**
     * 客户编号
     */
    @NotBlank
    private String customerCode;


    /**
     * 销售名称
     */
    private String empName;


    /**
     * 客户手机号码
     */
    @NotBlank
    @Pattern(regexp="^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$",message="手机号码格式不正确")
    private String customerMobile;


    /**
     * 每页记录行数
     */
    @NotNull
    private int pageSize;

    /**
     * pageIndex 从1开始
     */
    @Min(value = 1)
    @NotNull
    private int pageIndex;


    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
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


    @Override
    public String toString() {
        return "SystemMessageParam{" +
                "empCode='" + empCode + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", empName='" + empName + '\'' +
                ", customerMobile='" + customerMobile + '\'' +
                ", pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                '}';
    }
}
