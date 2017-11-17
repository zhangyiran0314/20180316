package com.iflytransporter.common.bean;

import com.alibaba.fastjson.JSONObject;

public class CompanyBO extends Company{
	private static final long serialVersionUID = 1L;

    private String attachmentId1Link;
    
    public String getAttachmentId1Link() {
		return attachmentId1Link;
	}
	public void setAttachmentId1Link(String attachmentId1Link) {
        this.attachmentId1Link = attachmentId1Link == null ? null : attachmentId1Link.trim();
    }
    @Override
  	public String toString() {
    	  return JSONObject.toJSONString(this).toString();
  	}
}