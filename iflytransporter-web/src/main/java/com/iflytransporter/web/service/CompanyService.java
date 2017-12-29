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
	PageInfo<CompanyBO> queryPage(Integer pageNo,Integer pageSize,String name);
	
	//修改
	int update(Company record);
	
	/**
	 * 审核成功,
	 * 设置当前company创建用户为管理员
	 * */
	int auth(Company record);
}
