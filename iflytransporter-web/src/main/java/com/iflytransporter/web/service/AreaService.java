package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.AreaBO;

public interface AreaService  {
	//详情查询
	AreaBO queryDetailBO(String id);
	//分页查询
	PageInfo<AreaBO> queryPage(Integer pageNo,Integer pageSize);
	
}
