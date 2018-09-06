package com.rongzi.assistant.model;

import java.io.Serializable;

public class UserInfo implements Serializable{

    private static final long serialVersionUID = 4673338693637430141L;
    private String accountName;
    private String empCode;
    private String empName;
    private String cityCode;
    private String cityName;
    private String dprCode;
    private String dprName;
    private String roleCode;
    private String roleName;
    private String empWorkMobile;
    private String empWechatId;

    public String getEmpWorkMobile() {
        return empWorkMobile;
    }

    public void setEmpWorkMobile(String empWorkMobile) {
        this.empWorkMobile = empWorkMobile;
    }

    public String getEmpWechatId() {
        return empWechatId;
    }

    public void setEmpWechatId(String empWechatId) {
        this.empWechatId = empWechatId;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDprCode() {
        return dprCode;
    }

    public void setDprCode(String dprCode) {
        this.dprCode = dprCode;
    }

    public String getDprName() {
        return dprName;
    }

    public void setDprName(String dprName) {
        this.dprName = dprName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
