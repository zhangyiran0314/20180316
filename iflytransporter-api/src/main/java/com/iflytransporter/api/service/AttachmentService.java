package com.iflytransporter.api.service;

import com.iflytransporter.common.bean.Attachment;

public interface AttachmentService {
	
	public int saveAttachment(Attachment record);
	
	public Attachment queryAttachment(String id);
}
