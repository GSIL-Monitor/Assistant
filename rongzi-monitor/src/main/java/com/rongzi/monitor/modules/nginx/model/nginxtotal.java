package com.rongzi.monitor.modules.nginx.model;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sun_y on 2018/7/9.
 */
@TableName("nginxtotal")
public class nginxtotal extends Model<nginxtotal>   {

    /**
     * 主键id
     */
    @TableId(value = "keyid", type = IdType.AUTO)
    private static final long serialVersionUID = 1L;
    private Integer keyid;

    public Integer getKeyid() {
        return keyid;
    }

    public void setKeyid(Integer keyid) {
        this.keyid = keyid;
    }

    @Override

    protected Serializable pkVal() {
        return this.keyid;
    }

    private Integer nginxtotalcount;
    private Integer nginxover1seccount;
    private Integer nginxover3seccount;
    private Integer nginxover10seccount;
    private Integer iisover1seccount;
    private Date createdate;

    public Integer getNginxtotalcount() {
        return nginxtotalcount;
    }

    public void setNginxtotalcount(Integer nginxtotalcount) {
        this.nginxtotalcount = nginxtotalcount;
    }

    public Integer getNginxover1seccount() {
        return nginxover1seccount;
    }

    public void setNginxover1seccount(Integer nginxover1seccount) {
        this.nginxover1seccount = nginxover1seccount;
    }

    public Integer getNginxover3seccount() {
        return nginxover3seccount;
    }

    public void setNginxover3seccount(Integer nginxover3seccount) {
        this.nginxover3seccount = nginxover3seccount;
    }

    public Integer getNginxover10seccount() {
        return nginxover10seccount;
    }

    public void setNginxover10seccount(Integer nginxover10seccount) {
        this.nginxover10seccount = nginxover10seccount;
    }

    public Integer getIisover1seccount() {
        return iisover1seccount;
    }

    public void setIisover1seccount(Integer iisover1seccount) {
        this.iisover1seccount = iisover1seccount;
    }

    public Integer getIisover3seccount() {
        return iisover3seccount;
    }

    public void setIisover3seccount(Integer iisover3seccount) {
        this.iisover3seccount = iisover3seccount;
    }

    public Integer getIisover10seccount() {
        return iisover10seccount;
    }

    public void setIisover10seccount(Integer iisover10seccount) {
        this.iisover10seccount = iisover10seccount;
    }

    private Integer iisover3seccount;
    private Integer iisover10seccount;


    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
