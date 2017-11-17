package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Province;

public interface ProvinceService  {
	//详情查询
	Province queryDetail(String id);
	//分页查询
	PageInfo<Province> queryPage(Integer pageNo,Integer pageSize);
	
}
