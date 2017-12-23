package com.iflytransporter.common.bean;

import java.util.Date;

public class Waybill {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private String orderId;

    private String shipperId;

    private String transporterId;

    private Integer isTransfer;

    private String transferTransporterId;

    private Integer status;

    private Double costs;

    private String orderNo;

    private String transporterCompanyId;

    private String shipperCompanyId;

    private String takeAttachmentId1;

    private String takeAttachmentId2;

    private String takeAttachmentId3;

    private String takeAttachmentId4;

    private String deliverAttachmentId1;

    private String deliverAttachmentId2;

    private String deliverAttachmentId3;

    private String deliverAttachmentId4;

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

    public String getTransferTransporterId() {
        return transferTransporterId;
    }

    public void setTransferTransporterId(String transferTransporterId) {
        this.transferTransporterId = transferTransporterId == null ? null : transferTransporterId.trim();
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
        this.orderNo = orderNo == null ? null : orderNo.trim();
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

    public void setShipperCompanyId(String shipperCompanyId) {
        this.shipperCompanyId = shipperCompanyId == null ? null : shipperCompanyId.trim();
    }

    public String getTakeAttachmentId1() {
        return takeAttachmentId1;
    }

    public void setTakeAttachmentId1(String takeAttachmentId1) {
        this.takeAttachmentId1 = takeAttachmentId1 == null ? null : takeAttachmentId1.trim();
    }

    public String getTakeAttachmentId2() {
        return takeAttachmentId2;
    }

    public void setTakeAttachmentId2(String takeAttachmentId2) {
        this.takeAttachmentId2 = takeAttachmentId2 == null ? null : takeAttachmentId2.trim();
    }

    public String getTakeAttachmentId3() {
        return takeAttachmentId3;
    }

    public void setTakeAttachmentId3(String takeAttachmentId3) {
        this.takeAttachmentId3 = takeAttachmentId3 == null ? null : takeAttachmentId3.trim();
    }

    public String getTakeAttachmentId4() {
        return takeAttachmentId4;
    }

    public void setTakeAttachmentId4(String takeAttachmentId4) {
        this.takeAttachmentId4 = takeAttachmentId4 == null ? null : takeAttachmentId4.trim();
    }

    public String getDeliverAttachmentId1() {
        return deliverAttachmentId1;
    }

    public void setDeliverAttachmentId1(String deliverAttachmentId1) {
        this.deliverAttachmentId1 = deliverAttachmentId1 == null ? null : deliverAttachmentId1.trim();
    }

    public String getDeliverAttachmentId2() {
        return deliverAttachmentId2;
    }

    public void setDeliverAttachmentId2(String deliverAttachmentId2) {
        this.deliverAttachmentId2 = deliverAttachmentId2 == null ? null : deliverAttachmentId2.trim();
    }

    public String getDeliverAttachmentId3() {
        return deliverAttachmentId3;
    }

    public void setDeliverAttachmentId3(String deliverAttachmentId3) {
        this.deliverAttachmentId3 = deliverAttachmentId3 == null ? null : deliverAttachmentId3.trim();
    }

    public String getDeliverAttachmentId4() {
        return deliverAttachmentId4;
    }

    public void setDeliverAttachmentId4(String deliverAttachmentId4) {
        this.deliverAttachmentId4 = deliverAttachmentId4 == null ? null : deliverAttachmentId4.trim();
    }
}