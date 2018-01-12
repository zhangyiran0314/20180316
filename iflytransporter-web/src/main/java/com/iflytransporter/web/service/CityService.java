package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.City;
import com.iflytransporter.common.bean.CityBO;

public interface CityService  {
	//详情查询
	City queryDetail(String id);
	//详情查询
	CityBO queryDetailBO(String id);
	//分页查询
	PageInfo<CityBO> queryPage(Integer pageNo,Integer pageSize,String name);
	
}
