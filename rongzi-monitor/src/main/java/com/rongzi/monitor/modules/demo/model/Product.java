package com.rongzi.monitor.modules.demo.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@TableName("Product")
@ExcelTarget("product")
public class Product extends Model<Product> {


    private static final long serialVersionUID = 1L;
    /**
     * 产品ID
     */
    @TableId(value="id", type= IdType.AUTO)
    private  Long id;

    /**
     * 产品名称
     */
    @Excel(name="产品名称",orderNum = "1")
    private  String name;
    /**
     * 产品数量
     */
    @Excel(name="产品数量",orderNum = "2")
    private  int count;

    /**
     * 产品描述
     */
    @Excel(name="产品描述",orderNum = "3", width = 30)
    private String description;

    /**
     * 产品生产日期
     */
    @Excel(name = "生产时间",format = "yyyy-MM-dd",orderNum = "4", width = 25)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productionDate;

    /**
     * 产品过期时间
     */
    @Excel(name = "过期时间",format = "yyyy-MM-dd",orderNum = "5", width = 25)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expireDate;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", description='" + description + '\'' +
                ", productionDate=" + productionDate +
                ", expireDate=" + expireDate +
                '}';
    }
}
