package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;

public interface CommonService {
	
	//详情查询
	Object queryDetail(String id);
	//分页查询
	PageInfo<Object> queryPage(Integer pageNo,Integer pageSize);
}
