package com.iflytransporter.common.bean;

import com.alibaba.fastjson.JSONObject;

public class ShipperBO extends Shipper {
	
	private static final long serialVersionUID = 1L;
    
    private String attachmentId1Link;
    private String attachmentId2Link;
    private String attachmentId3Link;


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
	@Override
  	public String toString() {
    	  return JSONObject.toJSONString(this).toString();
  	}
}