package com.rongzi.config.exception;

import com.rongzi.core.exception.ServiceExceptionEnum;

/**
 * @Description 所有业务异常的枚举
 * @author fengshuonan
 * @date 2016年11月12日 下午5:04:51
 */
public enum AssistantExceptionEnum implements ServiceExceptionEnum {


	/**
	 * 账户问题
	 */

	/**
	 * 错误的请求
	 */
	WECHAT_ADDFRIEND_ERROR(500,"微信添加好友请求失败"),
	REQUEST_NULL(400, "请求有错误"),
	SESSION_TIMEOUT(400, "会话超时"),
	SERVER_ERROR(500, "服务器异常"),
	CUSTOMER_NOT_FOUNT(500,"该客户并不存在数据库中");

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
