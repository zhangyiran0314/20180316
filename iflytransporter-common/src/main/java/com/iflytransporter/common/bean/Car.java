package com.iflytransporter.common.bean;

import java.util.Date;

public class Car {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private String name;

    private String code;

    private String attachmentId1;

    private String attachmentId2;

    private String companyId;

    private String transporterId;

    private String driverId;

    private Date insuranceStartDate;

    private Date insuranceEndDate;

    private String attachmentId3;

    private Date taxStartDate;

    private Date taxEndDate;

    private String attachmentId4;

    private Date checkStartDate;

    private Date checkEndDate;

    private String attachmentId5;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getTransporterId() {
        return transporterId;
    }

    public void setTransporterId(String transporterId) {
        this.transporterId = transporterId == null ? null : transporterId.trim();
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public Date getInsuranceStartDate() {
        return insuranceStartDate;
    }

    public void setInsuranceStartDate(Date insuranceStartDate) {
        this.insuranceStartDate = insuranceStartDate;
    }

    public Date getInsuranceEndDate() {
        return insuranceEndDate;
    }

    public void setInsuranceEndDate(Date insuranceEndDate) {
        this.insuranceEndDate = insuranceEndDate;
    }

    public String getAttachmentId3() {
        return attachmentId3;
    }

    public void setAttachmentId3(String attachmentId3) {
        this.attachmentId3 = attachmentId3 == null ? null : attachmentId3.trim();
    }

    public Date getTaxStartDate() {
        return taxStartDate;
    }

    public void setTaxStartDate(Date taxStartDate) {
        this.taxStartDate = taxStartDate;
    }

    public Date getTaxEndDate() {
        return taxEndDate;
    }

    public void setTaxEndDate(Date taxEndDate) {
        this.taxEndDate = taxEndDate;
    }

    public String getAttachmentId4() {
        return attachmentId4;
    }

    public void setAttachmentId4(String attachmentId4) {
        this.attachmentId4 = attachmentId4 == null ? null : attachmentId4.trim();
    }

    public Date getCheckStartDate() {
        return checkStartDate;
    }

    public void setCheckStartDate(Date checkStartDate) {
        this.checkStartDate = checkStartDate;
    }

    public Date getCheckEndDate() {
        return checkEndDate;
    }

    public void setCheckEndDate(Date checkEndDate) {
        this.checkEndDate = checkEndDate;
    }

    public String getAttachmentId5() {
        return attachmentId5;
    }

    public void setAttachmentId5(String attachmentId5) {
        this.attachmentId5 = attachmentId5 == null ? null : attachmentId5.trim();
    }
}