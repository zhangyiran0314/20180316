package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Comment;

public interface CommentService  {
	//详情查询
	Comment queryDetail(String id);
	//分页查询
	PageInfo<Comment> queryPage(Integer pageNo,Integer pageSize,String sId,String tId,String wId);
	
}
