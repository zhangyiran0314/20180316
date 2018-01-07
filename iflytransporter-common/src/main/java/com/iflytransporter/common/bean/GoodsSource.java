package com.iflytransporter.common.bean;

import java.util.Date;

public class GoodsSource {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private Integer defaultStatus;

    private String userId;

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

    private String goodsUnits;

    private Date deliverDate;

    private String remark;

    private String useTypeId;

    private String length;

    private String width;

    private String height;

    private String handlingTypeId;

    private String paymentTypeId;

    private Integer weight;
    
    public GoodsSource() {
	}

	public GoodsSource(Order order) {
		this.userId = order.getShipperId();
		this.departureProvinceId = order.getDepartureProvinceId();
		this.departureCityId = order.getDepartureCityId();
		this.departureAreaId = order.getDepartureAreaId();
		this.destinationProvinceId = order.getDestinationProvinceId();
		this.destinationCityId = order.getDestinationCityId();
		this.destinationAreaId = order.getDestinationAreaId();
		this.carTypeId = order.getCarTypeId();
		this.tyreNo = order.getTyreNo();
		this.carLength = order.getCarLength();
		this.goodsType = order.getGoodsType();
		this.goodsUnits = order.getGoodsUnits();
		this.deliverDate = order.getDeliverDate();
		this.remark = order.getRemark();
		this.useTypeId = order.getUseTypeId();
		this.length = order.getLength();
		this.width = order.getWidth();
		this.height = order.getHeight();
		this.handlingTypeId = order.getHandlingTypeId();
		this.paymentTypeId = order.getPaymentTypeId();
		this.weight = order.getWeight();
		this.deliverDate = order.getDeliverDate();
	}

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

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public String getGoodsUnits() {
        return goodsUnits;
    }

    public void setGoodsUnits(String goodsUnits) {
        this.goodsUnits = goodsUnits == null ? null : goodsUnits.trim();
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
    
}