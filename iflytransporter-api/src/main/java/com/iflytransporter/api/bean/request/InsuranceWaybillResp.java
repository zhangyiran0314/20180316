package com.iflytransporter.api.bean.request;

import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;
import com.iflytransporter.api.bean.CommonParam;

public class InsuranceWaybillResp {
	private String waybillNo;

    private String transportCompany;

    private String transportName;

    private String transportMobile;
    
    @JSONField(format="yyyy-MM-dd")
    private Date deliverDate;
    
	private CommonParam departureProvince;

    private CommonParam departureCity;

    private CommonParam departureArea;
    
    private CommonParam destinationProvince;

    private CommonParam destinationCity;

    private CommonParam destinationArea;
    
    public InsuranceWaybillResp(Map<String,Object> map){
    	this.waybillNo = map.get("waybillNo").toString();
    	this.transportCompany = map.get("transportCompany").toString();
    	this.transportName = map.get("transporterSurname").toString() + " "+map.get("transporterName").toString();
    	this.transportMobile = map.get("transporterMobile").toString();
    	this.deliverDate = (Date) map.get("deliverDate");
    }

	public String getWaybillNo() {
		return waybillNo;
	}

	public void setWaybillNo(String waybillNo) {
		this.waybillNo = waybillNo;
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

	public CommonParam getDepartureProvince() {
		return departureProvince;
	}

	public void setDepartureProvince(CommonParam departureProvince) {
		this.departureProvince = departureProvince;
	}

	public CommonParam getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(CommonParam departureCity) {
		this.departureCity = departureCity;
	}

	public CommonParam getDepartureArea() {
		return departureArea;
	}

	public void setDepartureArea(CommonParam departureArea) {
		this.departureArea = departureArea;
	}

	public CommonParam getDestinationProvince() {
		return destinationProvince;
	}

	public void setDestinationProvince(CommonParam destinationProvince) {
		this.destinationProvince = destinationProvince;
	}

	public CommonParam getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(CommonParam destinationCity) {
		this.destinationCity = destinationCity;
	}

	public CommonParam getDestinationArea() {
		return destinationArea;
	}

	public void setDestinationArea(CommonParam destinationArea) {
		this.destinationArea = destinationArea;
	}

	public Date getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}
    
}
