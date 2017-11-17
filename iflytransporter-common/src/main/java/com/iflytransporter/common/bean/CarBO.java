package com.iflytransporter.common.bean;

public class CarBO extends Car{
	private static final long serialVersionUID = 1L;

    private String attachmentId1Link;

    private String attachmentId2Link;

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


}