package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Insurance;

public interface InsuranceService  {
	//详情查询
	Insurance queryDetail(String id);
	//分页查询
	PageInfo<Insurance> queryPage(Integer pageNo,Integer pageSize);
	
}
