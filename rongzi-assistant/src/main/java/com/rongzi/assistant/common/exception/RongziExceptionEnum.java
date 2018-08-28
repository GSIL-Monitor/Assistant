package com.rongzi.assistant.common.exception;

import com.rongzi.core.exception.ServiceExceptionEnum;

public enum RongziExceptionEnum implements ServiceExceptionEnum {

    WRONG_USERNAME_PASSWORD(1, "用户名或密码错误。");

    private Integer code;
    private String message;

    RongziExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
