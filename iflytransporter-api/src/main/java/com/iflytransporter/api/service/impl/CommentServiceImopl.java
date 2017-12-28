package com.iflytransporter.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.CommentMapper;
import com.iflytransporter.api.service.CommentService;
import com.iflytransporter.common.bean.Comment;

@Service("commentService")
public class CommentServiceImopl implements CommentService{

	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public int add(Comment record) {
		return commentMapper.insert(record);
	}

}
