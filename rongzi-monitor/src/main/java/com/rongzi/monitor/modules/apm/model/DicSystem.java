package com.rongzi.monitor.modules.apm.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

@TableName("Dic_System")
public class DicSystem extends Model<DicSystem> {

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


    @Override
    protected Serializable pkVal() {
        return this.Id;
    }

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

    @Override
    public String toString() {
        return "DicSystem{" +
                "Id=" + Id +
                ", SystemCode=" + SystemCode +
                ", SystemName='" + SystemName + '\'' +
                '}';
    }
}
