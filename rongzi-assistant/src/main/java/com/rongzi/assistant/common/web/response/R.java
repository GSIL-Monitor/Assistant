package com.rongzi.assistant.common.web.response;

/**
 * 返回数据
 */
public class R<T> {

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;
    private T data;

    public R() {
        code = 0;
    }

    public static R ok() {
        return ok("");
    }

    public static R ok(String msg) {
        return ok(msg, null);
    }

    public static R ok(Object data) {
        return ok("", data);
    }

    public static R ok(String msg, Object data) {
        R r = new R();
        r.data = data;
        return r;
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.code = code;
        r.msg = msg;
        return r;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

