package com.rongzi.config.tips;

import java.io.Serializable;

public class AssistantTip implements Serializable{


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


    public AssistantTip(String msg,int code,  Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public AssistantTip() {
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
