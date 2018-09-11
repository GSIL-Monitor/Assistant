package com.rongzi.assistant.model;

import java.io.Serializable;
import java.util.Date;

public class MobileDataSyncInfo implements Serializable {

    private static final long serialVersionUID = 3061711658057418432L;


    /**
     * 客户编号
     */
    private String  empCode;

    /**
     * 短信同步时间
     */
    private Date lastSmsSyncTime;

    /**
     * 通话记录同步时间
     */
    private Date lastCallRecordSyncTime;

    /**
     * 数据修改时间
     */
    private Date updateTime;

    public MobileDataSyncInfo() {
    }

    public MobileDataSyncInfo(String empCode, Date lastSmsSyncTime, Date lastCallRecordSyncTime, Date updateTime) {
        this.empCode = empCode;
        this.lastSmsSyncTime = lastSmsSyncTime;
        this.lastCallRecordSyncTime = lastCallRecordSyncTime;
        this.updateTime = updateTime;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public Date getLastSmsSyncTime() {
        return lastSmsSyncTime;
    }

    public void setLastSmsSyncTime(Date lastSmsSyncTime) {
        this.lastSmsSyncTime = lastSmsSyncTime;
    }

    public Date getLastCallRecordSyncTime() {
        return lastCallRecordSyncTime;
    }

    public void setLastCallRecordSyncTime(Date lastCallRecordSyncTime) {
        this.lastCallRecordSyncTime = lastCallRecordSyncTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "MobileDataSyncInfo{" +
                "empCode='" + empCode + '\'' +
                ", lastSmsSyncTime=" + lastSmsSyncTime +
                ", lastCallRecordSyncTime=" + lastCallRecordSyncTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
