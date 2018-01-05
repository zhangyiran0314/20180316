package com.iflytransporter.web.bean;

import java.util.Date;
import java.util.Map;

import com.iflytransporter.common.bean.GoodsSource;

public class GoodsSourceResp {
	private String id;

    private String tyreNo;

    private Integer carLength;

    private String goodsType;

    private Date deliverDate;

    private String remark;

    private String length;

    private String width;

    private String height;
    
    private Integer weight;
    
    private String goodsUnits;
    
    private Date createDate;
    private Date updateDate;
	
	private Map<String,Object> departureProvince;

    private Map<String,Object> departureCity;

    private Map<String,Object> departureArea;
    
    private Map<String,Object> destinationProvince;

    private Map<String,Object> destinationCity;

    private Map<String,Object> destinationArea;
    
	private Map<String,Object> carType;
	
	private Map<String,Object> useType;

    private Map<String,Object> handlingType;

    private Map<String,Object> paymentType;
    
	public GoodsSourceResp(GoodsSource gs) {
		this.id = gs.getId();
		this.tyreNo = gs.getTyreNo();
		this.carLength = gs.getCarLength();
		this.goodsType = gs.getGoodsType();
		this.deliverDate = gs.getDeliverDate();
		this.remark = gs.getRemark();
		this.length = gs.getLength();
		this.width = gs.getWidth();
		this.height = gs.getHeight();
		this.weight =gs.getWeight();
		this.goodsUnits=gs.getGoodsUnits();
		this.createDate =gs.getCreateDate();
		this.updateDate = gs.getUpdateDate();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTyreNo() {
		return tyreNo;
	}

	public void setTyreNo(String tyreNo) {
		this.tyreNo = tyreNo;
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
		this.goodsType = goodsType;
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
		this.remark = remark;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public Map<String,Object> getDepartureProvince() {
		return departureProvince;
	}

	public void setDepartureProvince(Map<String,Object> departureProvince) {
		this.departureProvince = departureProvince;
	}

	public Map<String,Object> getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(Map<String,Object> departureCity) {
		this.departureCity = departureCity;
	}

	public Map<String,Object> getDepartureArea() {
		return departureArea;
	}

	public void setDepartureArea(Map<String,Object> departureArea) {
		this.departureArea = departureArea;
	}

	public Map<String,Object> getDestinationProvince() {
		return destinationProvince;
	}

	public void setDestinationProvince(Map<String,Object> destinationProvince) {
		this.destinationProvince = destinationProvince;
	}

	public Map<String,Object> getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(Map<String,Object> destinationCity) {
		this.destinationCity = destinationCity;
	}

	public Map<String,Object> getDestinationArea() {
		return destinationArea;
	}

	public void setDestinationArea(Map<String,Object> destinationArea) {
		this.destinationArea = destinationArea;
	}

	public Map<String,Object> getCarType() {
		return carType;
	}

	public void setCarType(Map<String,Object> carType) {
		this.carType = carType;
	}

	public String getGoodsUnits() {
		return goodsUnits;
	}

	public void setGoodsUnits(String goodsUnits) {
		this.goodsUnits = goodsUnits;
	}

	public Map<String,Object> getUseType() {
		return useType;
	}

	public void setUseType(Map<String,Object> useType) {
		this.useType = useType;
	}

	public Map<String,Object> getHandlingType() {
		return handlingType;
	}

	public void setHandlingType(Map<String,Object> handlingType) {
		this.handlingType = handlingType;
	}

	public Map<String,Object> getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Map<String,Object> paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
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
	
}
