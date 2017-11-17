package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.GoodsUnits;

public interface GoodsUnitsService  {
	//详情查询
	GoodsUnits queryDetail(String id);
	//分页查询
	PageInfo<GoodsUnits> queryPage(Integer pageNo,Integer pageSize);
	
}
