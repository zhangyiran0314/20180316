package com.iflytransporter.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.bean.Attachment;
import com.iflytransporter.api.mapper.AttachmentMapper;
import com.iflytransporter.api.service.AttachmentService;

@Service("attachmentService")
public class AttachmentServiceImpl implements AttachmentService{

	@Autowired
	private AttachmentMapper attachmentMapper;
	@Override
	public int saveAttachment(Attachment record) {
		return attachmentMapper.insert(record);
	}

	@Override
	public Attachment queryAttachment(String id) {
		return attachmentMapper.selectByPrimaryKey(id);
	}

}
