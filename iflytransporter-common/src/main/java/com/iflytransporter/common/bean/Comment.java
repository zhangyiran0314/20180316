package com.iflytransporter.common.bean;

import java.util.Date;

public class Comment {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private Integer serveGrade;

    private Integer loadingGrade;

    private Integer goodsGrade;

    private String content;

    private String shipperId;

    private String transporterId;

    private String waybillId;

    private String shipperCompanyId;

    private String transporterCompanyId;

    private String attachmentId1;

    private String attachmentId2;

    private String attachmentId3;

    private String attachmentId4;
    
    private Integer anonymity;
    
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


    public Integer getServeGrade() {
		return serveGrade;
	}

	public void setServeGrade(Integer serveGrade) {
		this.serveGrade = serveGrade;
	}

	public Integer getLoadingGrade() {
        return loadingGrade;
    }

    public void setLoadingGrade(Integer loadingGrade) {
        this.loadingGrade = loadingGrade;
    }

    public Integer getGoodsGrade() {
        return goodsGrade;
    }

    public void setGoodsGrade(Integer goodsGrade) {
        this.goodsGrade = goodsGrade;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId == null ? null : waybillId.trim();
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

	public Integer getAnonymity() {
		return anonymity;
	}

	public void setAnonymity(Integer anonymity) {
		this.anonymity = anonymity;
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
}