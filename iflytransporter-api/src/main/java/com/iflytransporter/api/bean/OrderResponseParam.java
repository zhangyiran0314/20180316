package com.iflytransporter.api.bean;

import java.util.List;

import com.iflytransporter.common.bean.Order;

public class OrderResponseParam extends Order{
	
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
    
    private List<CommonParam> applyList;
    
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

	public CommonParam getUseType() {
		return useType;
	}

	public void setUseType(CommonParam useType) {
		this.useType = useType;
	}

	public CommonParam getDestinationProvince() {
		return destinationProvince;
	}

	public void setDestinationProvince(CommonParam destinationProvince) {
		this.destinationProvince = destinationProvince;
	}

	
}
