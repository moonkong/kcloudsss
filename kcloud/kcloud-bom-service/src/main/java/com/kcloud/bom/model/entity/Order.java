package com.kcloud.bom.model.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Walle
 * @since 2019-01-25
 */
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @TableField("order_num")
    private String orderNum;
    @TableField("tenant_id")
    private Integer tenantId;
    @TableField("goods_version_id")
    private Integer goodsVersionId;
    @TableField("expire_time")
    private Long expireTime;
    @TableField("create_time")
    private Long createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getGoodsVersionId() {
        return goodsVersionId;
    }

    public void setGoodsVersionId(Integer goodsVersionId) {
        this.goodsVersionId = goodsVersionId;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Order{" +
        ", id=" + id +
        ", orderNum=" + orderNum +
        ", tenantId=" + tenantId +
        ", goodsVersionId=" + goodsVersionId +
        ", expireTime=" + expireTime +
        ", createTime=" + createTime +
        "}";
    }
}
