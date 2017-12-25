package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.UseType;

public interface UseTypeService  {
	//详情查询
	UseType queryDetail(String id);
	//分页查询
	PageInfo<UseType> queryPage(Integer pageNo,Integer pageSize);
	
}
