package com.iflytransporter.api.bean;

import com.iflytransporter.common.bean.UserBO;

public class UserResp {
	private String surname;

    private String name;
    
    private String mobile;
    
    private String attachment;

	public UserResp(UserBO userbo) {
		this.surname = userbo.getSurname();
		this.name = userbo.getName();
		this.mobile = userbo.getMobile();
		this.attachment = userbo.getAttachmentId3();
	}

	public String getSurname() {
		return surname;
	}

	public String getName() {
		return name;
	}

	public String getMobile() {
		return mobile;
	}

	public String getAttachment() {
		return attachment;
	}
    
}
