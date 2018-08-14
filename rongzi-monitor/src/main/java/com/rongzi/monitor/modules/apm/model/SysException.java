package com.rongzi.monitor.modules.apm.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

@TableName("Stats_ExceptionBySystem")
public class SysException extends Model<SysException> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private int Id;
    /**
     * 系统编号
     */
    private int SystemCode;
    /**
     * 系统名称
     */
    private String SystemName;
    /**
     * 异常数量
     */
    private int Count;
    /**
     * 异常发生时间
     */
    private String OccurDate;
    /**
     * 数据创建时间
     */
    private Date CreateTime;
    /**
     * 数据修改时间
     */
    private Date UpdateTime;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getSystemCode() {
        return SystemCode;
    }

    public void setSystemCode(int systemCode) {
        SystemCode = systemCode;
    }

    public String getSystemName() {
        return SystemName;
    }

    public void setSystemName(String systemName) {
        SystemName = systemName;
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

    public void setOccurDate(String occurDate) throws ParseException {

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

    @Override
    protected Serializable pkVal() {
        return this.Id;
    }

    @Override
    public String toString() {
        return "SysException{" +
                "Id=" + Id +
                ", SystemCode=" + SystemCode +
                ", SystemName='" + SystemName + '\'' +
                ", Count=" + Count +
                ", OccurDate=" + OccurDate +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                '}';
    }


}
