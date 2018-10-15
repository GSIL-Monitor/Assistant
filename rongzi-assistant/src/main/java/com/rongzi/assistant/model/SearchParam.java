package com.rongzi.assistant.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SearchParam implements Serializable{

    private static final long serialVersionUID = 4558372390347679593L;

    /**
     * 用款开始时间
     */
    private Date  payStartTime;

    /**
     * 用款结束时间
     */
    private Date  payEndTime;

    /**
     * 合同类型
     */
    private Integer contractType;

    /**
     * 客户进程id
     */
    private Integer customerExeStatus;

    /**
     * 客户通话状态
     */
    private List<Integer> contactStatus;

    /**
     * 每页记录行数
     */
    @Min(value = 1)
    @NotNull
    private  int  pageSize;

    /**
     *  初始化加载第几页
     */
    @Min(value = 1)
    @NotNull
    private int pageIndex;

    /**
     * 搜索参数
     */
    private  String searchName;

    @NotEmpty
    private String empCode;

    public Date getPayStartTime() {
        return payStartTime;
    }

    public void setPayStartTime(Date payStartTime) {
        this.payStartTime = payStartTime;
    }

    public Date getPayEndTime() {
        return payEndTime;
    }

    public void setPayEndTime(Date payEndTime) {
        this.payEndTime = payEndTime;
    }

    public Integer getContractType() {
        return contractType;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    public Integer getCustomerExeStatus() {
        return customerExeStatus;
    }

    public void setCustomerExeStatus(Integer customerExeStatus) {
        this.customerExeStatus = customerExeStatus;
    }

    public List<Integer> getContactStatus() {
        return contactStatus;
    }

    public void setContactStatus(List<Integer> contactStatus) {
        this.contactStatus = contactStatus;
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

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    @Override
    public String toString() {
        return "SearchParam{" +
                "payStartTime=" + payStartTime +
                ", payEndTime=" + payEndTime +
                ", contractType=" + contractType +
                ", customerExeStatus=" + customerExeStatus +
                ", contactStatus=" + contactStatus +
                ", pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", searchName='" + searchName + '\'' +
                ", empCode='" + empCode + '\'' +
                '}';
    }
}
