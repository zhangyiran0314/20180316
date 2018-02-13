package com.iflytransporter.api.bean;

import java.util.Date;
import java.util.Map;

import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.OrderApply;

public class TransporterOrderResp{
	
	public TransporterOrderResp() {
	}

	public TransporterOrderResp(Order order) {
		super();
		this.id = order.getId();
		this.tyreNo = order.getTyreNo();
		this.carLength = order.getCarLength();
		this.goodsType = order.getGoodsType();
		this.deliverDate = order.getDeliverDate();
		this.remark = order.getRemark();
		this.length = order.getLength();
		this.width = order.getWidth();
		this.height = order.getHeight();
		this.orderNo = order.getOrderNo();
		this.weight = order.getWeight();
		this.goodsUnits = order.getGoodsUnits();
		this.publishTime = order.getAuthDate();
		this.shipperId = order.getShipperId();
	}


	private String id;

    private String tyreNo;

    private Integer carLength;

    private String goodsType;

    private Date deliverDate;

    private String remark;

    private String length;

    private String width;

    private String height;

    private String orderNo;
    
    private Integer weight;

	private String goodsUnits;
	
	private CommonParam departureProvince;

    private CommonParam departureCity;

    private CommonParam departureArea;
    
    private CommonParam destinationProvince;

    private CommonParam destinationCity;

    private CommonParam destinationArea;
    
	private CommonParam carType;
	
	private CommonParam useType;

    private CommonParam handlingType;

    private CommonParam paymentType;
    
    private String shipperId;//货主id
    
    private Date publishTime;//发布时间
    
    private Map<String,Object> shipper;//货主信息
    
    /**---我的报价部分---*/
    private Date applyDate;//报价时间
    private Integer applyStatus;//报价状态
    private Double costs;//报价
    
    /**---我的报价记录---*/
    private Date recordDate;//记录时间
    private Integer recordStatus;//记录状态
   
    public void setOrderApply(OrderApply orderApply) {
    	this.applyDate = orderApply.getCreateDate();
    	this.applyStatus = orderApply.getStatus();
    	this.costs = orderApply.getCosts();
	}

    public void setOrderApplyRecord(OrderApply orderApply) {
    	this.applyDate = orderApply.getCreateDate();
    	this.applyStatus = orderApply.getStatus();
    	this.recordDate = orderApply.getBrowseDate();
    	this.recordStatus = orderApply.getBrowseStatus();
    	this.costs = orderApply.getCosts();
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

	public Double getCosts() {
		return costs;
	}

	public void setCosts(Double costs) {
		this.costs = costs;
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


	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}


	public String getShipperId() {
		return shipperId;
	}

	public void setShipperId(String shipperId) {
		this.shipperId = shipperId;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public Integer getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		this.recordStatus = recordStatus;
	}

	public Map<String, Object> getShipper() {
		return shipper;
	}

	public void setShipper(Map<String, Object> shipper) {
		this.shipper = shipper;
	}
	
}
