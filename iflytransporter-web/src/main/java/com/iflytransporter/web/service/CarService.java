package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.CarBO;

public interface CarService  {
	//详情查询
	CarBO queryDetailBO(String id);
	//分页查询
	PageInfo<CarBO> queryPage(String cId,Integer pageNo,Integer pageSize);
	
}
