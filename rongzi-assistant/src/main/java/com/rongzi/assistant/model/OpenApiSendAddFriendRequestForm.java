package com.rongzi.assistant.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class OpenApiSendAddFriendRequestForm implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     *  销售微信本身id
     */
    private String wechatId;

    /**
     * 客户微信号
     */
    private  String targetWechatId;

    /**
     * 客户手机号
     */
    private  String phone;

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


    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getTargetWechatId() {
        return targetWechatId;
    }

    public void setTargetWechatId(String targetWechatId) {
        this.targetWechatId = targetWechatId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public String toString() {
        return "OpenApiSendAddFriendRequestForm{" +
                "wechatId='" + wechatId + '\'' +
                ", targetWechatId='" + targetWechatId + '\'' +
                ", phone='" + phone + '\'' +
                ", message='" + message + '\'' +
                ", remark='" + remark + '\'' +
                ", accountSecret='" + accountSecret + '\'' +
                '}';
    }
}
