package com.iflytransporter.common.bean;

import java.util.Date;

public class Order {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private String departureProvinceId;

    private String departureCityId;

    private String departureAreaId;

    private String destinationProvinceId;

    private String destinationCityId;

    private String destinationAreaId;

    private String carTypeId;

    private String tyreNo;

    private Integer carLength;

    private String goodsType;

    private String goodsUnitsId;

    private Date deliverDate;

    private Integer costs;

    private String remark;

    private Short status;

    private String shipperId;

    private String insuranceId;

    private Integer repeatFlag;

    private String useTypeId;

    private String length;

    private String width;

    private String height;

    private String handlingTypeId;

    private String paymentTypeId;

    private Integer checkStatus;

    private Date checkDate;

    private String orderNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Short getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Short dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp == null ? null : desp.trim();
    }

    public String getDepartureProvinceId() {
        return departureProvinceId;
    }

    public void setDepartureProvinceId(String departureProvinceId) {
        this.departureProvinceId = departureProvinceId == null ? null : departureProvinceId.trim();
    }

    public String getDepartureCityId() {
        return departureCityId;
    }

    public void setDepartureCityId(String departureCityId) {
        this.departureCityId = departureCityId == null ? null : departureCityId.trim();
    }

    public String getDepartureAreaId() {
        return departureAreaId;
    }

    public void setDepartureAreaId(String departureAreaId) {
        this.departureAreaId = departureAreaId == null ? null : departureAreaId.trim();
    }

    public String getDestinationProvinceId() {
        return destinationProvinceId;
    }

    public void setDestinationProvinceId(String destinationProvinceId) {
        this.destinationProvinceId = destinationProvinceId == null ? null : destinationProvinceId.trim();
    }

    public String getDestinationCityId() {
        return destinationCityId;
    }

    public void setDestinationCityId(String destinationCityId) {
        this.destinationCityId = destinationCityId == null ? null : destinationCityId.trim();
    }

    public String getDestinationAreaId() {
        return destinationAreaId;
    }

    public void setDestinationAreaId(String destinationAreaId) {
        this.destinationAreaId = destinationAreaId == null ? null : destinationAreaId.trim();
    }

    public String getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(String carTypeId) {
        this.carTypeId = carTypeId == null ? null : carTypeId.trim();
    }

    public String getTyreNo() {
        return tyreNo;
    }

    public void setTyreNo(String tyreNo) {
        this.tyreNo = tyreNo == null ? null : tyreNo.trim();
    }

    public Integer getCarLength() {
        return carLength;
    }

    public void setCarLength(Integer carLength) {
        this.carLength = carLength;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public String getGoodsUnitsId() {
        return goodsUnitsId;
    }

    public void setGoodsUnitsId(String goodsUnitsId) {
        this.goodsUnitsId = goodsUnitsId == null ? null : goodsUnitsId.trim();
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Integer getCosts() {
        return costs;
    }

    public void setCosts(Integer costs) {
        this.costs = costs;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getShipperId() {
        return shipperId;
    }

    public void setShipperId(String shipperId) {
        this.shipperId = shipperId == null ? null : shipperId.trim();
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId == null ? null : insuranceId.trim();
    }

    public Integer getRepeatFlag() {
        return repeatFlag;
    }

    public void setRepeatFlag(Integer repeatFlag) {
        this.repeatFlag = repeatFlag;
    }

    public String getUseTypeId() {
        return useTypeId;
    }

    public void setUseTypeId(String useTypeId) {
        this.useTypeId = useTypeId == null ? null : useTypeId.trim();
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length == null ? null : length.trim();
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width == null ? null : width.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getHandlingTypeId() {
        return handlingTypeId;
    }

    public void setHandlingTypeId(String handlingTypeId) {
        this.handlingTypeId = handlingTypeId == null ? null : handlingTypeId.trim();
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId == null ? null : paymentTypeId.trim();
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }
}