package com.iflytransporter.api.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.Waybill;
import com.iflytransporter.common.bean.WaybillBO;

import io.swagger.annotations.ApiModelProperty;

public class WaybillResp {
	
	private String id;
	 
	private String orderId;

    private Integer status;

    private String costs;

    private String orderNo;
    
    private String tyreNo;

    private Integer carLength;

    private String goodsType;

    private Date deliverDate;

    private String remark;

    private String length;

    private String width;

    private String height;
    
    private CommonParam departureProvince;

    private CommonParam departureCity;

    private CommonParam departureArea;
    
    private CommonParam destinationProvince;

    private CommonParam destinationCity;

    private CommonParam destinationArea;
    
	private CommonParam carType;
	
	private String goodsUnits;

	private CommonParam useType;

    private CommonParam handlingType;

    private CommonParam paymentType;
    
    private Date confirmDate;
    
    private Integer weight;
    
    public WaybillResp(WaybillBO waybill) {
    	this.orderId = waybill.getOrderId();
    	this.id = waybill.getId();
		this.status = waybill.getStatus();
		this.costs = waybill.getCosts().toString();
		this.orderNo = waybill.getOrderNo();
		this.confirmDate =waybill.getConfirmDate();
	}
    public WaybillResp(Waybill waybill) {
    	this.orderId = waybill.getOrderId();
    	this.id = waybill.getId();
		this.status = waybill.getStatus();
		this.costs = waybill.getCosts().toString();
		this.orderNo = waybill.getOrderNo();
		this.confirmDate = waybill.getConfirmDate();
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
		this.goodsUnits = order.getGoodsUnits();
		this.weight = order.getWeight();
    }
    //车主
    private Map<String,Object> transporter;
    //货主
    private Map<String,Object> shipper;
    //公司
    private Map<String,Object> company;
    //收货凭证
    private List<Map<String,Object>> takeAttachmentList;
    //交货凭证
    private List<Map<String,Object>> deliverAttachmentList;
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

	public String getCosts() {
		return costs;
	}

	public void setCosts(String costs) {
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

	public String getGoodsUnits() {
		return goodsUnits;
	}

	public void setGoodsUnits(String goodsUnits) {
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
	public List<Map<String, Object>> getTakeAttachmentList() {
		return takeAttachmentList;
	}
	public void setTakeAttachmentList(List<Map<String, Object>> takeAttachmentList) {
		this.takeAttachmentList = takeAttachmentList;
	}
	public List<Map<String, Object>> getDeliverAttachmentList() {
		return deliverAttachmentList;
	}
	public void setDeliverAttachmentList(List<Map<String, Object>> deliverAttachmentList) {
		this.deliverAttachmentList = deliverAttachmentList;
	}
	public Date getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
    
    
}
