package com.iflytransporter.common.bean;

import com.iflytransporter.common.base.BaseEntity;

public class Waybill extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String orderId;

    private String shipperId;

    private String transporterId;

    private Integer isTransfer;

    private String transferTransporterId;

    private String attachmentTakeId;

    private String attachmentDeliverId;

    private Integer status;

    private Double costs;

    private String orderNo;
    
    private String shipperCompanyId;

    private String transporterCompanyId;


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
	
	public void setShipperCompanyId(String shipperCompanyId) {
        this.shipperCompanyId = shipperCompanyId == null ? null : shipperCompanyId.trim();
    }

    public String getTransporterCompanyId() {
        return transporterCompanyId;
    }

    public void setTransporterCompanyId(String transporterCompanyId) {
        this.transporterCompanyId = transporterCompanyId == null ? null : transporterCompanyId.trim();
    }

	public String getShipperCompanyId() {
		return shipperCompanyId;
	}

	public String getTransferTransporterId() {
		return transferTransporterId;
	}

	public void setTransferTransporterId(String transferTransporterId) {
		this.transferTransporterId = transferTransporterId;
	}
    
}