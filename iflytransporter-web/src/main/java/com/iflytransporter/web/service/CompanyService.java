package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Company;
import com.iflytransporter.common.bean.CompanyBO;

public interface CompanyService {
	//详情查询
	CompanyBO queryDetailBO(String id);
	//详情查询
	Company queryDetail(String id);
	//分页查询
	PageInfo<Company> queryPage(Integer pageNo,Integer pageSize);
}
