package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.HandlingType;

public interface HandlingTypeService  {
	//详情查询
	HandlingType queryDetail(String id);
	//分页查询
	PageInfo<HandlingType> queryPage(Integer pageNo,Integer pageSize);
	
}
