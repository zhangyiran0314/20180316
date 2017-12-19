package com.iflytransporter.common.bean;

import com.iflytransporter.common.base.BaseEntity;

public class OrderApply extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private Short status;

    private Double costs;

    private String orderId;

    private String transporterId;


    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
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

}