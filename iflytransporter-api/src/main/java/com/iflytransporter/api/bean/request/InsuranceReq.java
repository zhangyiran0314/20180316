package com.iflytransporter.api.bean.request;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class InsuranceReq {
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

//    private Double goodsValue;
    private String goodsValueStr;

    @JSONField(format="yyyy-MM-dd")
    private Date deliverDate;

    private String transportScope;

//    private Double costs;
    private String costsStr;

    private String departureProvinceId;

    private String departureCityId;

    private String departureAreaId;

    private String destinationProvinceId;

    private String destinationCityId;

    private String destinationAreaId;

	public String getWaybillNo() {
		return waybillNo;
	}

	public void setWaybillNo(String waybillNo) {
		this.waybillNo = waybillNo;
	}

	public String getPolicyholderName() {
		return policyholderName;
	}

	public void setPolicyholderName(String policyholderName) {
		this.policyholderName = policyholderName;
	}

	public String getPolicyholderMobile() {
		return policyholderMobile;
	}

	public void setPolicyholderMobile(String policyholderMobile) {
		this.policyholderMobile = policyholderMobile;
	}

	public String getTransportCompany() {
		return transportCompany;
	}

	public void setTransportCompany(String transportCompany) {
		this.transportCompany = transportCompany;
	}

	public String getTransportName() {
		return transportName;
	}

	public void setTransportName(String transportName) {
		this.transportName = transportName;
	}

	public String getTransportMobile() {
		return transportMobile;
	}

	public void setTransportMobile(String transportMobile) {
		this.transportMobile = transportMobile;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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
		this.transportScope = transportScope;
	}

	public String getDepartureProvinceId() {
		return departureProvinceId;
	}

	public void setDepartureProvinceId(String departureProvinceId) {
		this.departureProvinceId = departureProvinceId;
	}

	public String getDepartureCityId() {
		return departureCityId;
	}

	public void setDepartureCityId(String departureCityId) {
		this.departureCityId = departureCityId;
	}

	public String getDepartureAreaId() {
		return departureAreaId;
	}

	public void setDepartureAreaId(String departureAreaId) {
		this.departureAreaId = departureAreaId;
	}

	public String getDestinationProvinceId() {
		return destinationProvinceId;
	}

	public void setDestinationProvinceId(String destinationProvinceId) {
		this.destinationProvinceId = destinationProvinceId;
	}

	public String getDestinationCityId() {
		return destinationCityId;
	}

	public void setDestinationCityId(String destinationCityId) {
		this.destinationCityId = destinationCityId;
	}

	public String getDestinationAreaId() {
		return destinationAreaId;
	}

	public void setDestinationAreaId(String destinationAreaId) {
		this.destinationAreaId = destinationAreaId;
	}

	public String getGoodsValueStr() {
		return goodsValueStr;
	}

	public void setGoodsValueStr(String goodsValueStr) {
		this.goodsValueStr = goodsValueStr;
	}

	public String getCostsStr() {
		return costsStr;
	}

	public void setCostsStr(String costsStr) {
		this.costsStr = costsStr;
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
