package com.iflytransporter.api.bean;

import com.iflytransporter.common.bean.CompanyBO;

public class CompanyResp {
	 
	private String id;
	
	private String name;

    private String code;

//    private String email;
//
//    private String address;

    private String attachmentId1;
    
    private String attachmentId1Link;
    
    private String attachmentId2;//spad照片
    private String attachmentId2Link;
    private String attachmentId3;//公司保单
    private String attachmentId3Link;
    private Integer amount;

	public CompanyResp(CompanyBO company) {
		this.id=company.getId();
		this.name = company.getName();
		this.code = company.getCode();
//		this.email = company.getEmail();
//		this.address = company.getAddress();
		this.attachmentId1 = company.getAttachmentId1();
		this.attachmentId1Link = company.getAttachmentId1Link();
		this.attachmentId2 = company.getAttachmentId2();
		this.attachmentId2Link = company.getAttachmentId2Link();
		this.attachmentId3 = company.getAttachmentId3();
		this.attachmentId3Link = company.getAttachmentId3Link();
		this.amount = company.getAmount();
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

	public String getAttachmentId1Link() {
		return attachmentId1Link;
	}

	public void setAttachmentId1Link(String attachmentId1Link) {
		this.attachmentId1Link = attachmentId1Link;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAttachmentId2() {
		return attachmentId2;
	}

	public void setAttachmentId2(String attachmentId2) {
		this.attachmentId2 = attachmentId2;
	}

	public String getAttachmentId2Link() {
		return attachmentId2Link;
	}

	public void setAttachmentId2Link(String attachmentId2Link) {
		this.attachmentId2Link = attachmentId2Link;
	}

	public String getAttachmentId3() {
		return attachmentId3;
	}

	public void setAttachmentId3(String attachmentId3) {
		this.attachmentId3 = attachmentId3;
	}

	public String getAttachmentId3Link() {
		return attachmentId3Link;
	}

	public void setAttachmentId3Link(String attachmentId3Link) {
		this.attachmentId3Link = attachmentId3Link;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
    
    
}
