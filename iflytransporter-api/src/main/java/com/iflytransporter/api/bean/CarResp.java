package com.iflytransporter.api.bean;

import com.iflytransporter.common.bean.CarBO;

public class CarResp {
	private String id;
	
	private String name;

    private String code;

    private String attachmentId1;

    private String attachmentId2;
    
    private String companyId;
    
//    private String attachmentId1Link;
//
//    private String attachmentId2Link;

    
	public CarResp(CarBO car) {
		this.id = car.getId();
		this.name = car.getName();
		this.code = car.getCode();
		this.attachmentId1 = car.getAttachmentId1();
		this.attachmentId2 = car.getAttachmentId2();
//		this.companyId = car.getCompanyId();
//		this.attachmentId1Link = car.getAttachmentId1Link();
//		this.attachmentId2Link = car.getAttachmentId2Link();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

//	public String getAttachmentId1Link() {
//		return attachmentId1Link;
//	}
//
//	public void setAttachmentId1Link(String attachmentId1Link) {
//		this.attachmentId1Link = attachmentId1Link;
//	}
//
//	public String getAttachmentId2Link() {
//		return attachmentId2Link;
//	}
//
//	public void setAttachmentId2Link(String attachmentId2Link) {
//		this.attachmentId2Link = attachmentId2Link;
//	}
//    
    
}
