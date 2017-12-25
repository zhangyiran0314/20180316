package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.GoodsType;

public interface GoodsTypeService  {
	//详情查询
	GoodsType queryDetail(String id);
	//分页查询
	PageInfo<GoodsType> queryPage(Integer pageNo,Integer pageSize);
	
}
