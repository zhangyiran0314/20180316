package com.iflytransporter.web.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.iflytransporter.common.bean.Order;

public class OrderResp{
	
	public OrderResp() {
	}

	public OrderResp(Order order) {
		super();
		this.id = order.getId();
		this.tyreNo = order.getTyreNo();
		this.carLength = order.getCarLength();
		this.goodsType = order.getGoodsType();
		this.deliverDate = order.getDeliverDate();
		this.costs = order.getCosts();
		this.remark = order.getRemark();
		this.status = order.getStatus();
		this.repeatFlag = order.getRepeatFlag();
		this.length = order.getLength();
		this.width = order.getWidth();
		this.height = order.getHeight();
		this.authStatus = order.getAuthStatus();
		this.authDate = order.getAuthDate();
		this.orderNo = order.getOrderNo();
		this.weight = order.getWeight();
		this.goodsUnits = order.getGoodsUnits();
		this.createDate = order.getCreateDate();
		this.updateDate = order.getUpdateDate();
	}


	private String id;

    private String tyreNo;

    private Integer carLength;

    private String goodsType;

    private Date deliverDate;

    private Integer costs;

    private String remark;

    private Integer status;

    private Integer repeatFlag;

    private String length;

    private String width;

    private String height;

    private Integer authStatus;

    private Date authDate;

    private String orderNo;
    
    private Integer weight;

	private String goodsUnits;
	
	private Date createDate;
	private Date updateDate;
	
	private String mobile;
	
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
    
    //待审核数量
    private int applyTotal;
    //申请列表
    private List<Map<String,Object>> applyList;
    //审核通过详情
    private Map<String,Object> applyDetail;
    
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

	public Map<String,Object> getUseType() {
		return useType;
	}

	public void setUseType(Map<String,Object> useType) {
		this.useType = useType;
	}

	public Map<String,Object> getDestinationProvince() {
		return destinationProvince;
	}

	public void setDestinationProvince(Map<String,Object> destinationProvince) {
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

	public Integer getCosts() {
		return costs;
	}

	public void setCosts(Integer costs) {
		this.costs = costs;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRepeatFlag() {
		return repeatFlag;
	}

	public void setRepeatFlag(Integer repeatFlag) {
		this.repeatFlag = repeatFlag;
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

	public Integer getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(Integer authStatus) {
		this.authStatus = authStatus;
	}

	public Date getAuthDate() {
		return authDate;
	}

	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public int getApplyTotal() {
		return applyTotal;
	}

	public void setApplyTotal(int applyTotal) {
		this.applyTotal = applyTotal;
	}

	public List<Map<String, Object>> getApplyList() {
		return applyList;
	}

	public void setApplyList(List<Map<String, Object>> applyList) {
		this.applyList = applyList;
	}

	public Map<String, Object> getApplyDetail() {
		return applyDetail;
	}

	public void setApplyDetail(Map<String, Object> applyDetail) {
		this.applyDetail = applyDetail;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
