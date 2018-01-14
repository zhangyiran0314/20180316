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
		this.driverId = driverId;
	}
    
}