package com.iflytransporter.api.bean;

import java.util.Date;

import com.iflytransporter.common.bean.CarBO;

public class CarResp {
	private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private String name;

    private String code;

    private String attachmentId1;
    
    private String registerNo;

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

    private String attachmentId1Link;

    private String attachmentId2Link;
    private String attachmentId3Link;

    private String attachmentId4Link;
    private String attachmentId5Link;
    
    public CarResp(){
    	
    }
	public void setCar(CarBO car) {
		this.id = car.getId();
		this.name = car.getName();
		this.code = car.getCode();
		this.registerNo = car.getRegisterNo();
		this.insuranceStartDate = car.getInsuranceStartDate();
		this.insuranceEndDate = car.getInsuranceEndDate();
		this.taxStartDate = car.getTaxStartDate();
		this.taxEndDate = car.getTaxEndDate();
		this.checkStartDate = car.getCheckStartDate();
		this.checkEndDate = car.getCheckEndDate();
	}
	public CarResp(CarBO car) {
		this.id = car.getId();
		this.name = car.getName();
		this.code = car.getCode();
		this.attachmentId1 = car.getAttachmentId1();
		this.registerNo = car.getRegisterNo();
		this.attachmentId2 = car.getAttachmentId2();
		this.insuranceStartDate = car.getInsuranceStartDate();
		this.insuranceEndDate = car.getInsuranceEndDate();
		this.attachmentId3 = car.getAttachmentId3();
		this.taxStartDate = car.getTaxStartDate();
		this.taxEndDate = car.getTaxEndDate();
		this.attachmentId4 = car.getAttachmentId4();
		this.checkStartDate = car.getCheckStartDate();
		this.checkEndDate = car.getCheckEndDate();
		this.attachmentId5 = car.getAttachmentId5();
		this.attachmentId1Link = car.getAttachmentId1Link();
		this.attachmentId2Link = car.getAttachmentId2Link();;
		this.attachmentId3Link = car.getAttachmentId3Link();;
		this.attachmentId4Link = car.getAttachmentId4Link();;
		this.attachmentId5Link = car.getAttachmentId5Link();;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		this.desp = desp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAttachmentId1() {
		return attachmentId1;
	}
	public void setAttachmentId1(String attachmentId1) {
		this.attachmentId1 = attachmentId1;
	}
	public String getRegisterNo() {
		return registerNo;
	}
	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}
	public String getAttachmentId2() {
		return attachmentId2;
	}
	public void setAttachmentId2(String attachmentId2) {
		this.attachmentId2 = attachmentId2;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getTransporterId() {
		return transporterId;
	}
	public void setTransporterId(String transporterId) {
		this.transporterId = transporterId;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
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
		this.attachmentId3 = attachmentId3;
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
		this.attachmentId4 = attachmentId4;
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
		this.attachmentId5 = attachmentId5;
	}
	public String getAttachmentId1Link() {
		return attachmentId1Link;
	}
	public void setAttachmentId1Link(String attachmentId1Link) {
		this.attachmentId1Link = attachmentId1Link;
	}
	public String getAttachmentId2Link() {
		return attachmentId2Link;
	}
	public void setAttachmentId2Link(String attachmentId2Link) {
		this.attachmentId2Link = attachmentId2Link;
	}
	public String getAttachmentId3Link() {
		return attachmentId3Link;
	}
	public void setAttachmentId3Link(String attachmentId3Link) {
		this.attachmentId3Link = attachmentId3Link;
	}
	public String getAttachmentId4Link() {
		return attachmentId4Link;
	}
	public void setAttachmentId4Link(String attachmentId4Link) {
		this.attachmentId4Link = attachmentId4Link;
	}
	public String getAttachmentId5Link() {
		return attachmentId5Link;
	}
	public void setAttachmentId5Link(String attachmentId5Link) {
		this.attachmentId5Link = attachmentId5Link;
	}
    
}
