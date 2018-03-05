package com.iflytransporter.web.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Insurance;

public interface InsuranceService  {
	//详情查询
	Insurance queryDetail(String id);
	//分页查询
	PageInfo<Map<String,Object>> queryPage(Integer pageNo,Integer pageSize,String policyhodlerCompany,String policyhodlerMobile,String policyhodlerName);
	
}
