package com.rongzi.monitor.modules.apm.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@TableName("ExceptionLog")
@ExcelTarget("exceptionLog")
public class ExceptionLog extends Model<ExceptionLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "ExceptionId", type = IdType.AUTO)
    /**
     * 异常ID
     */
    private Long ExceptionId;
    /**
     * 客户端IP
     */
    private String IP;
    /**
     * 服务端IP
     */
    private String serverIP;

    /**
     *  发生时间
     */
    @Excel(name="发生时间",orderNum = "1",format = "yyyy-MM-dd",width=25)
    private Date occurTime;

    /**
     * 异常类型
     */
    @Excel(name="异常类型",orderNum = "2",width=25)
    private String errorType;

    /**
     * 异常信息
     */
    @Excel(name="异常信息",orderNum = "3",width=80, height = 25)
    private String message;

    /**
     * 异常栈
     */
    @Excel(name="异常栈",orderNum = "4",width=200, height = 25)
     String stackTrace;

    /**
     * 处理状态
     */
    private Integer processStatus;

    /**
     *  处理者
     */
    private String Owner;
    /**
     *  处理状态
     */
    private Integer Status;

    @Override
    protected Serializable pkVal() {
        return this.ExceptionId;
    }

    public Long getExceptionId() {
        return ExceptionId;
    }

    public void setExceptionId(Long exceptionId) {
        ExceptionId = exceptionId;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    public Date getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(Date occurTime) {
        this.occurTime = occurTime;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "ExceptionLog{" +
                "ExceptionId=" + ExceptionId +
                ", IP='" + IP + '\'' +
                ", serverIP='" + serverIP + '\'' +
                ", message='" + message + '\'' +
                ", stackTrace='" + stackTrace + '\'' +
                ", errorType='" + errorType + '\'' +
                ", processStatus=" + processStatus +
                ", occurTime=" + occurTime +
                ", Owner='" + Owner + '\'' +
                ", Status=" + Status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExceptionLog)) return false;
        ExceptionLog that = (ExceptionLog) o;
        return Objects.equals(getExceptionId(), that.getExceptionId()) &&
                Objects.equals(getIP(), that.getIP()) &&
                Objects.equals(getServerIP(), that.getServerIP()) &&
                Objects.equals(getOccurTime(), that.getOccurTime()) &&
                Objects.equals(getErrorType(), that.getErrorType()) &&
                Objects.equals(getMessage(), that.getMessage()) &&
                Objects.equals(getStackTrace(), that.getStackTrace()) &&
                Objects.equals(getProcessStatus(), that.getProcessStatus()) &&
                Objects.equals(getOwner(), that.getOwner()) &&
                Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getExceptionId(), getIP(), getServerIP(), getOccurTime(), getErrorType(), getMessage(), getStackTrace(), getProcessStatus(), getOwner(), getStatus());
    }
}
