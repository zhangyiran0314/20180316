package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.CarType;

public interface CarTypeService  {
	//详情查询
	CarType queryDetail(String id);
	//分页查询
	PageInfo<CarType> queryPage(Integer pageNo,Integer pageSize);
	
}
