package com.rongzi.assistant.common.tips;

import java.io.Serializable;

public class AssistantTip implements Serializable {

    private static final long serialVersionUID = -1272471914355954490L;

    private int code;
    private String msg;
    private Object data;

    public AssistantTip() {
    }

    public static AssistantTip ok() {
        return ok(null);
    }

    public static AssistantTip ok(Object data) {
        AssistantTip tip = new AssistantTip();
        tip.code = 0;
        tip.msg = "操作成功";
        tip.data = data;
        return tip;
    }

    public static AssistantTip error(int code, String msg) {
        AssistantTip tip = new AssistantTip();
        tip.code = code;
        tip.msg = msg;
        tip.data = null;
        return tip;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AssistantTip{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
