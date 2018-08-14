package com.rongzi.monitor.modules.apm.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

@TableName("Stats_ExceptionByType")
public class TypeException extends Model<TypeException> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private int Id;
    /**
     * 错误类别
     */
    private String ErrorType;

    /**
     * 错误数量
     */
    private int Count;

    /**
     * 错误发生时间 yyyy-MM-dd
     */
    private String OccurDate;

    /**
     * 数据产生时间
     */
    private Date CreateTime;

    /**
     * 数据更新时间
     */
    private Date UpdateTime;

    /**
     * 系统编号
     */
    private int SystemCode;

    @Override
    protected Serializable pkVal() {
        return this.Id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getErrorType() {
        return ErrorType;
    }

    public void setErrorType(String errorType) {
        ErrorType = errorType;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public String getOccurDate() {
        return OccurDate;
    }

    public void setOccurDate(String occurDate) {
        OccurDate = occurDate;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        UpdateTime = updateTime;
    }

    public int getSystemCode() {
        return SystemCode;
    }

    public void setSystemCode(int systemCode) {
        SystemCode = systemCode;
    }

    @Override
    public String toString() {
        return "TypeException{" +
                "Id=" + Id +
                ", ErrorType='" + ErrorType + '\'' +
                ", Count=" + Count +
                ", OccurDate=" + OccurDate +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", SystemCode=" + SystemCode +
                '}';
    }
}
