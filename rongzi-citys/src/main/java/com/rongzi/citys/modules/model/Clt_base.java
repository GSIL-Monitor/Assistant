package com.rongzi.citys.modules.model;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("SAL_CLT_BASE")
public class Clt_base implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String clt_code;
    private int clt_type;
    private int clt_source;
    private int clt_status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClt_code() {
        return clt_code;
    }

    public void setClt_code(String clt_code) {
        this.clt_code = clt_code;
    }

    public int getClt_type() {
        return clt_type;
    }

    public void setClt_type(int clt_type) {
        this.clt_type = clt_type;
    }

    public int getClt_source() {
        return clt_source;
    }

    public void setClt_source(int clt_source) {
        this.clt_source = clt_source;
    }

    public int getClt_status() {
        return clt_status;
    }

    public void setClt_status(int clt_status) {
        this.clt_status = clt_status;
    }

    @Override
    public String toString() {
        return "Clt_base{" +
                "id=" + id +
                ", clt_code='" + clt_code + '\'' +
                ", clt_type=" + clt_type +
                ", clt_source=" + clt_source +
                ", clt_status=" + clt_status +
                '}';
    }
}
