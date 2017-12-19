package com.iflytransporter.api.bean;

import java.util.Date;
import java.util.Map;

import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.WaybillBO;

import io.swagger.annotations.ApiModelProperty;

public class WaybillResp {
	
	private String id;
	 
	private String orderId;

    private Integer status;

    private Double costs;

    private String orderNo;
    
    private String tyreNo;

    private Integer carLength;

    private String goodsType;

    private Date deliverDate;

    private String remark;

    private String length;

    private String width;

    private String height;
    
    private String attachmentDeliverIdLink;
    
    private String attachmentTakeIdLink;
    
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
    
    public WaybillResp(WaybillBO waybill) {
    	this.orderId = waybill.getOrderId();
    	this.id = waybill.getId();
		this.attachmentTakeIdLink = waybill.getAttachmentTakeIdLink();
		this.attachmentDeliverIdLink = waybill.getAttachmentDeliverIdLink();
		this.status = waybill.getStatus();
		this.costs = waybill.getCosts();
		this.orderNo = waybill.getOrderNo();
	}
    
    public void setOrder(Order order){
    	this.tyreNo = order.getTyreNo();
		this.carLength = order.getCarLength();
		this.goodsType = order.getGoodsType();
		this.deliverDate = order.getDeliverDate();
		this.remark = order.getRemark();
		this.length = order.getLength();
		this.width = order.getWidth();
		this.height = order.getHeight();
		this.orderNo = order.getOrderNo();
    }
    
    @ApiModelProperty(value="车主")
    private Map<String,Object> transporter;
    
    @ApiModelProperty(value="货主")
    private Map<String,Object> shipper;
    
    @ApiModelProperty(value="公司")
    private Map<String,Object> company;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getCosts() {
		return costs;
	}

	public void setCosts(Double costs) {
		this.costs = costs;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	public String getAttachmentDeliverIdLink() {
		return attachmentDeliverIdLink;
	}

	public void setAttachmentDeliverIdLink(String attachmentDeliverIdLink) {
		this.attachmentDeliverIdLink = attachmentDeliverIdLink;
	}

	public String getAttachmentTakeIdLink() {
		return attachmentTakeIdLink;
	}

	public void setAttachmentTakeIdLink(String attachmentTakeIdLink) {
		this.attachmentTakeIdLink = attachmentTakeIdLink;
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

	public Map<String, Object> getTransporter() {
		return transporter;
	}

	public void setTransporter(Map<String, Object> transporter) {
		this.transporter = transporter;
	}

	public Map<String, Object> getShipper() {
		return shipper;
	}

	public void setShipper(Map<String, Object> shipper) {
		this.shipper = shipper;
	}

	public Map<String, Object> getCompany() {
		return company;
	}

	public void setCompany(Map<String, Object> company) {
		this.company = company;
	}
    
    
}
