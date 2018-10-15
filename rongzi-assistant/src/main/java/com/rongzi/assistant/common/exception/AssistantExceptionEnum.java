package com.rongzi.assistant.common.exception;

import com.rongzi.core.exception.ServiceExceptionEnum;

/**
 * @author fengshuonan
 * @Description 所有业务异常的枚举
 * @date 2016年11月12日 下午5:04:51
 */
public enum AssistantExceptionEnum implements ServiceExceptionEnum {

    /**
     * 账户问题
     */
    INVALID_TOKEN(500, "不合法的Token。"),
    WRONG_USERNAME_PASSWORD(1, "用户名或密码错误。"),

    /**
     * 数据异常
     */

    DATA_NULL(500,"数据库该字段没有对应值"),
    EMPCODE_NULL(500,"去掉发送者手机号码为空的状态后，数据仍然为空.此时不会同步数据"),
    REQUESTDATA_NULL(500,"请求数据不能为空"),
    SEARCH_DATA_NULL(500,"请至少选择一项条件来进行搜索"),

    /**
     * 错误的请求
     */
    WECHAT_ADDFRIEND_ERROR(500, "微信添加好友请求失败"),
    REQUEST_NULL(400, "请求有错误"),
    SESSION_TIMEOUT(400, "会话超时"),
    SERVER_ERROR(500, "服务器异常"),
    CUSTOMER_NOT_FOUNT(500, "该客户并不存在数据库中");

    AssistantExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

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
