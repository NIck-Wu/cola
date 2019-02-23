package com.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
    private Integer id;

    private String orderNO;

    private Integer userID;

    private Date useCarTime;

    private String startPlace;

    private String endPlace;

    private String startPlaceLongitudeAndLatitude;

    private String endPlaceLongitudeAndLatitude;

    private String channelPlace;

    private String channelPlaceLongitudeAndLatitude;

    private String gatewaysCode;

    private String contactNumber;

    private String linkName;

    private Integer driveID;

    private String isAssignment;

    private Date assignmentTime;

    private Integer totalKilometres;

    private BigDecimal orderAmount;

    private BigDecimal earnestMoney;

    private BigDecimal adjustmentMoney;

    private String earnestMoneyPayStatus;

    private Date earnestMoneyPayFinshTime;

    private Date payFinishTime;

    private Integer carID;

    private String couponCode;

    private String isArrange;

    private String flightNO;

    private String orderStatus;

    private String memo;

    private Date creatTime;

    private Date lastUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNO() {
        return orderNO;
    }

    public void setOrderNO(String orderNO) {
        this.orderNO = orderNO == null ? null : orderNO.trim();
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Date getUseCarTime() {
        return useCarTime;
    }

    public void setUseCarTime(Date useCarTime) {
        this.useCarTime = useCarTime;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace == null ? null : startPlace.trim();
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace == null ? null : endPlace.trim();
    }

    public String getStartPlaceLongitudeAndLatitude() {
        return startPlaceLongitudeAndLatitude;
    }

    public void setStartPlaceLongitudeAndLatitude(String startPlaceLongitudeAndLatitude) {
        this.startPlaceLongitudeAndLatitude = startPlaceLongitudeAndLatitude == null ? null : startPlaceLongitudeAndLatitude.trim();
    }

    public String getEndPlaceLongitudeAndLatitude() {
        return endPlaceLongitudeAndLatitude;
    }

    public void setEndPlaceLongitudeAndLatitude(String endPlaceLongitudeAndLatitude) {
        this.endPlaceLongitudeAndLatitude = endPlaceLongitudeAndLatitude == null ? null : endPlaceLongitudeAndLatitude.trim();
    }

    public String getChannelPlace() {
        return channelPlace;
    }

    public void setChannelPlace(String channelPlace) {
        this.channelPlace = channelPlace == null ? null : channelPlace.trim();
    }

    public String getChannelPlaceLongitudeAndLatitude() {
        return channelPlaceLongitudeAndLatitude;
    }

    public void setChannelPlaceLongitudeAndLatitude(String channelPlaceLongitudeAndLatitude) {
        this.channelPlaceLongitudeAndLatitude = channelPlaceLongitudeAndLatitude == null ? null : channelPlaceLongitudeAndLatitude.trim();
    }

    public String getGatewaysCode() {
        return gatewaysCode;
    }

    public void setGatewaysCode(String gatewaysCode) {
        this.gatewaysCode = gatewaysCode == null ? null : gatewaysCode.trim();
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public Integer getDriveID() {
        return driveID;
    }

    public void setDriveID(Integer driveID) {
        this.driveID = driveID;
    }

    public String getIsAssignment() {
        return isAssignment;
    }

    public void setIsAssignment(String isAssignment) {
        this.isAssignment = isAssignment == null ? null : isAssignment.trim();
    }

    public Date getAssignmentTime() {
        return assignmentTime;
    }

    public void setAssignmentTime(Date assignmentTime) {
        this.assignmentTime = assignmentTime;
    }

    public Integer getTotalKilometres() {
        return totalKilometres;
    }

    public void setTotalKilometres(Integer totalKilometres) {
        this.totalKilometres = totalKilometres;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getEarnestMoney() {
        return earnestMoney;
    }

    public void setEarnestMoney(BigDecimal earnestMoney) {
        this.earnestMoney = earnestMoney;
    }

    public BigDecimal getAdjustmentMoney() {
        return adjustmentMoney;
    }

    public void setAdjustmentMoney(BigDecimal adjustmentMoney) {
        this.adjustmentMoney = adjustmentMoney;
    }

    public String getEarnestMoneyPayStatus() {
        return earnestMoneyPayStatus;
    }

    public void setEarnestMoneyPayStatus(String earnestMoneyPayStatus) {
        this.earnestMoneyPayStatus = earnestMoneyPayStatus == null ? null : earnestMoneyPayStatus.trim();
    }

    public Date getEarnestMoneyPayFinshTime() {
        return earnestMoneyPayFinshTime;
    }

    public void setEarnestMoneyPayFinshTime(Date earnestMoneyPayFinshTime) {
        this.earnestMoneyPayFinshTime = earnestMoneyPayFinshTime;
    }

    public Date getPayFinishTime() {
        return payFinishTime;
    }

    public void setPayFinishTime(Date payFinishTime) {
        this.payFinishTime = payFinishTime;
    }

    public Integer getCarID() {
        return carID;
    }

    public void setCarID(Integer carID) {
        this.carID = carID;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode == null ? null : couponCode.trim();
    }

    public String getIsArrange() {
        return isArrange;
    }

    public void setIsArrange(String isArrange) {
        this.isArrange = isArrange == null ? null : isArrange.trim();
    }

    public String getFlightNO() {
        return flightNO;
    }

    public void setFlightNO(String flightNO) {
        this.flightNO = flightNO == null ? null : flightNO.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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