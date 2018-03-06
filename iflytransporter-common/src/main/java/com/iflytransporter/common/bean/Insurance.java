package com.iflytransporter.common.bean;

import java.util.Date;

public class Insurance {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private String name;

    private String waybillNo;

    private String policyholderName;

    private String policyholderCompany;

    private String policyholderMobile;

    private String transportCompany;

    private String transportName;

    private String transportMobile;

    private String goodsName;

    private Integer weight;

    private String goodsUnits;
    
    private Double goodsValue;

    private Date deliverDate;

    private String transportScope;

    private Double costs;

    private String departureProvinceId;

    private String departureCityId;

    private String departureAreaId;

    private String destinationProvinceId;

    private String destinationCityId;

    private String destinationAreaId;

    private String userId;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo == null ? null : waybillNo.trim();
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public void setPolicyholderName(String policyholderName) {
        this.policyholderName = policyholderName == null ? null : policyholderName.trim();
    }


    public String getPolicyholderMobile() {
        return policyholderMobile;
    }

    public void setPolicyholderMobile(String policyholderMobile) {
        this.policyholderMobile = policyholderMobile == null ? null : policyholderMobile.trim();
    }

    public String getTransportCompany() {
        return transportCompany;
    }

    public void setTransportCompany(String transportCompany) {
        this.transportCompany = transportCompany == null ? null : transportCompany.trim();
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName == null ? null : transportName.trim();
    }

    public String getTransportMobile() {
        return transportMobile;
    }

    public void setTransportMobile(String transportMobile) {
        this.transportMobile = transportMobile == null ? null : transportMobile.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }


    public Double getGoodsValue() {
        return goodsValue;
    }

    public void setGoodsValue(Double goodsValue) {
        this.goodsValue = goodsValue;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getTransportScope() {
        return transportScope;
    }

    public void setTransportScope(String transportScope) {
        this.transportScope = transportScope == null ? null : transportScope.trim();
    }

    public Double getCosts() {
        return costs;
    }

    public void setCosts(Double costs) {
        this.costs = costs;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

	public String getPolicyholderCompany() {
		return policyholderCompany;
	}

	public void setPolicyholderCompany(String policyholderCompany) {
		this.policyholderCompany = policyholderCompany;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getGoodsUnits() {
		return goodsUnits;
	}

	public void setGoodsUnits(String goodsUnits) {
		this.goodsUnits = goodsUnits;
	}
    
}