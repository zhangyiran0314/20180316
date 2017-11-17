package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Comment;
import com.iflytransporter.web.mapper.CommentMapper;
import com.iflytransporter.web.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public Comment queryDetail(String id) {
		return commentMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<Comment> queryPage(Integer pageNo, Integer pageSize,String sId,String tId,String wId) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Comment> list= commentMapper.queryAll(sId, tId, wId);
		return new PageInfo<Comment>(list);
	}

}
