package com.iflytransporter.api.bean;

import java.util.Date;

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
	
	private CommonParam departureProvince;

    private CommonParam departureCity;

    private CommonParam departureArea;
    
    private CommonParam destinationProvince;

    private CommonParam destinationCity;

    private CommonParam destinationArea;
    
	private CommonParam carType;
	
	private CommonParam goodsUnits;

	private CommonParam useType;

    private CommonParam handlingType;

    private CommonParam paymentType;
    
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

	public CommonParam getCarType() {
		return carType;
	}

	public void setCarType(CommonParam carType) {
		this.carType = carType;
	}

	public CommonParam getGoodsUnits() {
		return goodsUnits;
	}

	public void setGoodsUnits(CommonParam goodsUnits) {
		this.goodsUnits = goodsUnits;
	}

	public CommonParam getUseType() {
		return useType;
	}

	public void setUseType(CommonParam useType) {
		this.useType = useType;
	}

	public CommonParam getHandlingType() {
		return handlingType;
	}

	public void setHandlingType(CommonParam handlingType) {
		this.handlingType = handlingType;
	}

	public CommonParam getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(CommonParam paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
}
