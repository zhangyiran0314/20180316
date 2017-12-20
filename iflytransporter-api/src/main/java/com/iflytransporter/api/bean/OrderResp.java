package com.iflytransporter.api.bean;

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
	}


	private String id;

    private String tyreNo;

    private Integer carLength;

    private String goodsType;

    private Date deliverDate;

    private Integer costs;

    private String remark;

    private Short status;

    private Integer repeatFlag;

    private String length;

    private String width;

    private String height;

    private Integer authStatus;

    private Date authDate;

    private String orderNo;
    
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
    
    //待审核数量
    private int applyTotal;
    //申请列表
    private List<Map<String,Object>> applyList;
    //审核通过详情
    private Map<String,Object> applyDetail;
    
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

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
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
	
}
