package com.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Car {
    private Integer id;

    private String carName;

    private String carType;

    private String carImageURL;

    private String carBrand;

    private String carModel;

    private BigDecimal additionalPrice;

    private Integer seatingCapacity;

    private Integer baggageQuantity;

    private String carDesc;

    private Date creatTime;

    private Date lastUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    public String getCarImageURL() {
        return carImageURL;
    }

    public void setCarImageURL(String carImageURL) {
        this.carImageURL = carImageURL == null ? null : carImageURL.trim();
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand == null ? null : carBrand.trim();
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel == null ? null : carModel.trim();
    }

    public BigDecimal getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(BigDecimal additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public Integer getBaggageQuantity() {
        return baggageQuantity;
    }

    public void setBaggageQuantity(Integer baggageQuantity) {
        this.baggageQuantity = baggageQuantity;
    }

    public String getCarDesc() {
        return carDesc;
    }

    public void setCarDesc(String carDesc) {
        this.carDesc = carDesc == null ? null : carDesc.trim();
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