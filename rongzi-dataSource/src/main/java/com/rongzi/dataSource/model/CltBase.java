package com.rongzi.dataSource.model;


public class CltBase {

    private Long id;

    private String code;

    private int type;

    private int source;

    private  int status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CltBase{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", source=" + source +
                ", status=" + status +
                '}';
    }
}
