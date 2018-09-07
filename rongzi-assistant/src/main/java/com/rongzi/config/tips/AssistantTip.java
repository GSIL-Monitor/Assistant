package com.rongzi.config.tips;

import java.io.Serializable;

public class AssistantTip implements Serializable {


    private static final long serialVersionUID = -1272471914355954490L;

    private int code;

    private String msg;

    private Object data;


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

    public AssistantTip() {

    }

    public AssistantTip(String msg, int code, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static AssistantTip successReturnNull() {

        AssistantTip tip = new AssistantTip();
        tip.code = 0;
        tip.data = null;
        tip.msg = "操作成功";
        return tip;
    }

    public static AssistantTip successReturnData(Object data) {

        AssistantTip tip = new AssistantTip();
        tip.msg = "操作成功";
        tip.data = data;
        tip.code = 0;
        return tip;

    }


    public static AssistantTip error(int code, Object data) {

        AssistantTip tip = new AssistantTip();
        tip.data = data;
        tip.msg = "操作失败";
        tip.code = code;

        return tip;
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
