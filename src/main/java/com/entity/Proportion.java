package com.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Proportion {
    private Integer id;

    private BigDecimal payProportion;

    private Date creatTime;

    private Date lastUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPayProportion() {
        return payProportion;
    }

    public void setPayProportion(BigDecimal payProportion) {
        this.payProportion = payProportion;
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