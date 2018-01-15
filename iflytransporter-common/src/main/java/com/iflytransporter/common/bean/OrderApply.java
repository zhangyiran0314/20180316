package com.iflytransporter.common.bean;

import java.util.Date;

public class OrderApply {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Integer dataStatus;

    private String desp;

    private Integer status;

    private Double costs;

    private String orderId;

    private String transporterId;

    private String companyId;

    private Integer browseStatus;

    private Date browseDate;
    
    private String orderNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp == null ? null : desp.trim();
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getTransporterId() {
        return transporterId;
    }

    public void setTransporterId(String transporterId) {
        this.transporterId = transporterId == null ? null : transporterId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Integer getBrowseStatus() {
        return browseStatus;
    }

    public void setBrowseStatus(Integer browseStatus) {
        this.browseStatus = browseStatus;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public Date getBrowseDate() {
		return browseDate;
	}

	public void setBrowseDate(Date browseDate) {
		this.browseDate = browseDate;
	}

	public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }
}