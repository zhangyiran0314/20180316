package com.iflytransporter.common.bean;

public class WaybillBO extends Waybill{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String attachmentTakeIdLink;

    private String attachmentDeliverIdLink;

	public String getAttachmentTakeIdLink() {
		return attachmentTakeIdLink;
	}

	public void setAttachmentTakeIdLink(String attachmentTakeIdLink) {
		this.attachmentTakeIdLink = attachmentTakeIdLink;
	}

	public String getAttachmentDeliverIdLink() {
		return attachmentDeliverIdLink;
	}

	public void setAttachmentDeliverIdLink(String attachmentDeliverIdLink) {
		this.attachmentDeliverIdLink = attachmentDeliverIdLink;
	}
}