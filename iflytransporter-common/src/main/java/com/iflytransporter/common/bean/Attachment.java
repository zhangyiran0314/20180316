package com.iflytransporter.common.bean;

import com.iflytransporter.common.base.BaseEntity;

public class Attachment extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String attachmentLink;

    private String attachmentName;

    private String attachmentType;

    private String refId;

    public String getAttachementLink() {
        return attachmentLink;
    }

    public void setAttachementLink(String attachmentLink) {
        this.attachmentLink = attachmentLink == null ? null : attachmentLink.trim();
    }

    public String getAttachementName() {
        return attachmentName;
    }

    public void setAttachementName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    public String getAttachementType() {
        return attachmentType;
    }

    public void setAttachementType(String attachmentType) {
        this.attachmentType = attachmentType == null ? null : attachmentType.trim();
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId == null ? null : refId.trim();
    }
}