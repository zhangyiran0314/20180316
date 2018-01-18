package com.iflytransporter.common.bean;

import com.alibaba.fastjson.JSONObject;
import com.iflytransporter.common.base.BaseEntity;

public class Company extends BaseEntity{
	private static final long serialVersionUID = 1L;

    private String name;

    private String code;

    private String email;

    private String address;

    private Integer status;

    private String attachmentId1;

    private String userId;
    private Integer userType;
    
    private String attachmentId2;//spad照片
    private String attachmentId3;//公司保单

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAttachmentId1() {
        return attachmentId1;
    }

    public void setAttachmentId1(String attachmentId1) {
        this.attachmentId1 = attachmentId1 == null ? null : attachmentId1.trim();
    }
    
    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAttachmentId2() {
		return attachmentId2;
	}

	public void setAttachmentId2(String attachmentId2) {
		this.attachmentId2 = attachmentId2;
	}

	public String getAttachmentId3() {
		return attachmentId3;
	}

	public void setAttachmentId3(String attachmentId3) {
		this.attachmentId3 = attachmentId3;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	@Override
  	public String toString() {
    	  return JSONObject.toJSONString(this).toString();
  	}
}