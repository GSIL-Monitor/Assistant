package com.rongzi.assistant.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class WechatParam implements Serializable{


    private static final long serialVersionUID = 471859428024316880L;


    /**
     * 客户手机号码
     */
    @NotBlank
    @Pattern(regexp="^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$",message="手机号码格式不正确")
    private String customerMobile;

    /**
     * 客户微信ID
     */
    @NotBlank
    private String customerWechatId;

    /**
     * 销售工作手机
     */
    private String empWorkMobile;

    /**
     * 销售微信ID
     */
    private String empWechatId;


    /**
     *  招呼语
     */
    private  String message;

    /**
     * 备注
     */
    private  String remark;

    /**
     *  Api调用者身份
     */
    private  String accountSecret;


    /**
     * 调用拼接所需字符串
     */
    private String weChatConstantStr;


    public String getWeChatConstantStr() {
        return weChatConstantStr;
    }

    public void setWeChatConstantStr(String weChatConstantStr) {
        this.weChatConstantStr = weChatConstantStr;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAccountSecret() {
        return accountSecret;
    }

    public void setAccountSecret(String accountSecret) {
        this.accountSecret = accountSecret;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerWechatId() {
        return customerWechatId;
    }

    public void setCustomerWechatId(String customerWechatId) {
        this.customerWechatId = customerWechatId;
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
        return "WechatParam{" +
                "customerMobile='" + customerMobile + '\'' +
                ", customerWechatId='" + customerWechatId + '\'' +
                ", empWorkMobile='" + empWorkMobile + '\'' +
                ", empWechatId='" + empWechatId + '\'' +
                ", message='" + message + '\'' +
                ", remark='" + remark + '\'' +
                ", accountSecret='" + accountSecret + '\'' +
                ", weChatConstantStr='" + weChatConstantStr + '\'' +
                '}';
    }
}
