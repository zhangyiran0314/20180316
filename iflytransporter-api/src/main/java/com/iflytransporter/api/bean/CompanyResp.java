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

	public CompanyResp(CompanyBO company) {
		this.id=company.getId();
		this.name = company.getName();
		this.code = company.getCode();
//		this.email = company.getEmail();
//		this.address = company.getAddress();
		this.attachmentId1 = company.getAttachmentId1();
		this.attachmentId1Link = company.getAttachmentId1Link();
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
    
    
}
