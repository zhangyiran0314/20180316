package com.iflytransporter.web.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Company;
import com.iflytransporter.common.bean.CompanyBO;

public interface CompanyService {
	//详情查询
	Map<String,Object> queryDetail(String id);
	//分页查询
	PageInfo<Map<String,Object>> queryPage(Integer pageNo,Integer pageSize,Integer userType,String name);
	
	//修改
	int update(Company record);
	
	/**
	 * 审核成功,
	 * 设置当前company创建用户为管理员
	 * */
	int auth(Company record);
}
