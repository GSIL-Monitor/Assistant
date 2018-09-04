package com.rongzi.assistant.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CustomerListParam implements Serializable {


    private static final long serialVersionUID = 1413794341190086344L;

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


    /**
     * 客户意向进程
     */
    @NotNull
    private int customerExeStatus;


    /**
     * 客户编号
     */
    @NotBlank
    private String empCode;


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

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }


    @Override
    public String toString() {
        return "CustomerListParam{" +
                "pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", customerExeStatus=" + customerExeStatus +
                ", empCode='" + empCode + '\'' +
                '}';
    }
}
