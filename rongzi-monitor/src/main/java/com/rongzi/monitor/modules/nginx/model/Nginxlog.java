package com.rongzi.monitor.modules.nginx.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sun_y on 2018/7/3.
 */
@TableName("Nginxlog")
public class Nginxlog extends Model<Nginxlog> {

    /**
     * 主键id
     */
    @TableId(value = "nginxlogId", type = IdType.AUTO)
    private static final long serialVersionUID = 1L;
    private Long nginxlogId;
    private String clientip;
    private Date createtime;
    private String url;
    private String httptype;
    private Integer status;
    private Integer contentsize;
    private String referurl;
    private String brower;
    private String nginxwanip;
    private float iiscosttime;
    private String nginxlanip;
    private float nginxcosttime;
    private String submittype;
    private String controller;
    private String action;
    private Integer isStatic;
    private Integer os;

    private String count;
    private String avg_iiscosttime;
    private String max_iiscosttime;
    private String memo;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getAvg_iiscosttime() {
        return avg_iiscosttime;
    }

    public void setAvg_iiscosttime(String avg_iiscosttime) {
        this.avg_iiscosttime = avg_iiscosttime;
    }

    public String getMax_iiscosttime() {
        return max_iiscosttime;
    }

    public void setMax_iiscosttime(String max_iiscosttime) {
        this.max_iiscosttime = max_iiscosttime;
    }

    @Override
    protected Serializable pkVal() {
        return this.nginxlogId;
    }


    public String getClientip() {
        return clientip;
    }

    public void setClientip(String clientip) {
        this.clientip = clientip;
    }


    public Long getNginxlogId() {
        return nginxlogId;
    }

    public void setNginxlogId(Long nginxlogId) {
        this.nginxlogId = nginxlogId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHttptype() {
        return httptype;
    }

    public void setHttptype(String httptype) {
        this.httptype = httptype;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getContentsize() {
        return contentsize;
    }

    public void setContentsize(Integer contentsize) {
        this.contentsize = contentsize;
    }

    public String getReferurl() {
        return referurl;
    }

    public void setReferurl(String referurl) {
        this.referurl = referurl;
    }

    public String getBrower() {
        return brower;
    }

    public void setBrower(String brower) {
        this.brower = brower;
    }

    public String getNginxwanip() {
        return nginxwanip;
    }

    public void setNginxwanip(String nginxwanip) {
        this.nginxwanip = nginxwanip;
    }

    public float getIiscosttime() {
        return iiscosttime;
    }

    public void setIiscosttime(float iiscosttime) {
        this.iiscosttime = iiscosttime;
    }

    public String getNginxlanip() {
        return nginxlanip;
    }

    public void setNginxlanip(String nginxlanip) {
        this.nginxlanip = nginxlanip;
    }

    public float getNginxcosttime() {
        return nginxcosttime;
    }

    public void setNginxcosttime(float nginxcosttime) {
        this.nginxcosttime = nginxcosttime;
    }

    public String getSubmittype() {
        return submittype;
    }

    public void setSubmittype(String submittype) {
        this.submittype = submittype;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getIsStatic() {
        return isStatic;
    }

    public void setIsStatic(Integer isStatic) {
        this.isStatic = isStatic;
    }

    public Integer getOs() {
        return os;
    }

    public void setOs(Integer os) {
        this.os = os;
    }
}
