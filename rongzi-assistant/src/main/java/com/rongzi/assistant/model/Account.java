package com.rongzi.assistant.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author rongzi123
 * @since 2018-08-27
 */
@TableName("MNG_LOGIN_ACCOUNT")
public class Account extends Model<Account> {

    private static final long serialVersionUID = 1L;

    @TableField("LGN_ID")
    private Long lgnId;
    @TableId("LGN_ACCOUNT")
    private String lgnAccount;
    @TableField("LGN_PSWD")
    private String lgnPswd;
    @TableField("CITY_CODE")
    private String cityCode;
    @TableField("EMP_CODE")
    private String empCode;
    @TableField("EMP_DESC")
    private String empDesc;
    @TableField("CURR_CITY")
    private String currCity;
    @TableField("SOFT_PHONE")
    private String softPhone;
    @TableField("LGN_STATUS")
    private Integer lgnStatus;
    @TableField("LGN_DATE")
    private Date lgnDate;
    @TableField("USE_FLAG")
    private Integer useFlag;
    @TableField("CREATE_DATE")
    private Date createDate;
    @TableField("CREATOR")
    private String creator;
    @TableField("EmpWorkMobile")
    private String empWorkMobile;
    @TableField("EmpWechatId")
    private String empWechatId;

    public Long getLgnId() {
        return lgnId;
    }

    public void setLgnId(Long lgnId) {
        this.lgnId = lgnId;
    }

    public String getLgnAccount() {
        return lgnAccount;
    }

    public void setLgnAccount(String lgnAccount) {
        this.lgnAccount = lgnAccount;
    }

    public String getLgnPswd() {
        return lgnPswd;
    }

    public void setLgnPswd(String lgnPswd) {
        this.lgnPswd = lgnPswd;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpDesc() {
        return empDesc;
    }

    public void setEmpDesc(String empDesc) {
        this.empDesc = empDesc;
    }

    public String getCurrCity() {
        return currCity;
    }

    public void setCurrCity(String currCity) {
        this.currCity = currCity;
    }

    public String getSoftPhone() {
        return softPhone;
    }

    public void setSoftPhone(String softPhone) {
        this.softPhone = softPhone;
    }

    public Integer getLgnStatus() {
        return lgnStatus;
    }

    public void setLgnStatus(Integer lgnStatus) {
        this.lgnStatus = lgnStatus;
    }

    public Date getLgnDate() {
        return lgnDate;
    }

    public void setLgnDate(Date lgnDate) {
        this.lgnDate = lgnDate;
    }

    public Integer getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(Integer useFlag) {
        this.useFlag = useFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    protected Serializable pkVal() {
        return this.lgnAccount;
    }

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

    @Override
    public String toString() {
        return "Account{" +
                "lgnId=" + lgnId +
                ", lgnAccount='" + lgnAccount + '\'' +
                ", lgnPswd='" + lgnPswd + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", empCode='" + empCode + '\'' +
                ", empDesc='" + empDesc + '\'' +
                ", currCity='" + currCity + '\'' +
                ", softPhone='" + softPhone + '\'' +
                ", lgnStatus=" + lgnStatus +
                ", lgnDate=" + lgnDate +
                ", useFlag=" + useFlag +
                ", createDate=" + createDate +
                ", creator='" + creator + '\'' +
                ", empWorkMobile='" + empWorkMobile + '\'' +
                ", empWechatId='" + empWechatId + '\'' +
                '}';
    }
}
