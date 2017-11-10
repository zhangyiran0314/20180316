package com.iflytransporter.web.service;

import com.iflytransporter.web.bean.Attachment;

public interface AttachmentService {
	
	public int saveAttachment(Attachment record);
	
	public Attachment queryAttachment(String id);
}
