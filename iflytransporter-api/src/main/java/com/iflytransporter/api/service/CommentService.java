package com.iflytransporter.api.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Comment;

public interface CommentService {
	
	int add(Comment record);
	
	PageInfo<Map<String,Object>> queryPageTransporter(Integer pageNo,Integer pageSize,
			String transporterId,String transporterCompanyId);
	
	PageInfo<Map<String,Object>> queryPageShipper(Integer pageNo,Integer pageSize,
			String shipperId,String shipperCompanyId);
}
