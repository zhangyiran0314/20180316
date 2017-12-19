package com.iflytransporter.common.bean;

import com.iflytransporter.common.base.BaseEntity;

public class Waybill extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String orderId;

    private String shipperId;

    private String transporterId;

    private Integer isTransfer;

    private String transporterTransferId;

    private String attachmentTakeId;

    private String attachmentDeliverId;

    private Integer status;

    private Double costs;

    private String orderNo;

	public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getShipperId() {
        return shipperId;
    }

    public void setShipperId(String shipperId) {
        this.shipperId = shipperId == null ? null : shipperId.trim();
    }

    public String getTransporterId() {
        return transporterId;
    }

    public void setTransporterId(String transporterId) {
        this.transporterId = transporterId == null ? null : transporterId.trim();
    }

    public Integer getIsTransfer() {
        return isTransfer;
    }

    public void setIsTransfer(Integer isTransfer) {
        this.isTransfer = isTransfer;
    }

    public String getTransporterTransferId() {
        return transporterTransferId;
    }

    public void setTransporterTransferId(String transporterTransferId) {
        this.transporterTransferId = transporterTransferId == null ? null : transporterTransferId.trim();
    }

    public String getAttachmentTakeId() {
        return attachmentTakeId;
    }

    public void setAttachmentTakeId(String attachmentTakeId) {
        this.attachmentTakeId = attachmentTakeId == null ? null : attachmentTakeId.trim();
    }

    public String getAttachmentDeliverId() {
        return attachmentDeliverId;
    }

    public void setAttachmentDeliverId(String attachmentDeliverId) {
        this.attachmentDeliverId = attachmentDeliverId == null ? null : attachmentDeliverId.trim();
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
    
}