package com.entity;

import java.util.Date;

public class Refunds {
    private Integer id;

    private String refundNO;

    private String ordersNO;

    private String transactionNO;

    private String refundType;

    private String refundStatus;

    private Date creatTime;

    private Date lastUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRefundNO() {
        return refundNO;
    }

    public void setRefundNO(String refundNO) {
        this.refundNO = refundNO == null ? null : refundNO.trim();
    }

    public String getOrdersNO() {
        return ordersNO;
    }

    public void setOrdersNO(String ordersNO) {
        this.ordersNO = ordersNO == null ? null : ordersNO.trim();
    }

    public String getTransactionNO() {
        return transactionNO;
    }

    public void setTransactionNO(String transactionNO) {
        this.transactionNO = transactionNO == null ? null : transactionNO.trim();
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType == null ? null : refundType.trim();
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus == null ? null : refundStatus.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}