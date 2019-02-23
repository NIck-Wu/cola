package com.entity;

import java.util.Date;

public class Transaction {
    private Integer id;

    private String transactionNO;

    private String ordersNO;

    private String payType;

    private Date creatTime;

    private Date lastUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionNO() {
        return transactionNO;
    }

    public void setTransactionNO(String transactionNO) {
        this.transactionNO = transactionNO == null ? null : transactionNO.trim();
    }

    public String getOrdersNO() {
        return ordersNO;
    }

    public void setOrdersNO(String ordersNO) {
        this.ordersNO = ordersNO == null ? null : ordersNO.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}