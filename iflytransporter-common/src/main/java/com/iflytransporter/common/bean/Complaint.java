package com.iflytransporter.common.bean;

import java.util.Date;

public class Complaint {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private String reason;

    private String content;

    private String mobile;

    private String waybillId;

    private String shipperId;

    private String transporterId;
    
    private String driverId;

    private String attachmentId1;

    private String attachmentId2;

    private String attachmentId3;

    private String attachmentId4;

    private String shipperCompanyId;

    private String transporterCompanyId;
    
    private String orderId;
    
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

    public Short getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Short dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp == null ? null : desp.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId == null ? null : waybillId.trim();
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

    public String getAttachmentId1() {
        return attachmentId1;
    }

    public void setAttachmentId1(String attachmentId1) {
        this.attachmentId1 = attachmentId1 == null ? null : attachmentId1.trim();
    }

    public String getAttachmentId2() {
        return attachmentId2;
    }

    public void setAttachmentId2(String attachmentId2) {
        this.attachmentId2 = attachmentId2 == null ? null : attachmentId2.trim();
    }

    public String getAttachmentId3() {
        return attachmentId3;
    }

    public void setAttachmentId3(String attachmentId3) {
        this.attachmentId3 = attachmentId3 == null ? null : attachmentId3.trim();
    }

    public String getAttachmentId4() {
        return attachmentId4;
    }

    public void setAttachmentId4(String attachmentId4) {
        this.attachmentId4 = attachmentId4 == null ? null : attachmentId4.trim();
    }

    public String getShipperCompanyId() {
        return shipperCompanyId;
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

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	
    
}