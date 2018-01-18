package com.iflytransporter.web.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Order;

public interface OrderService  {
	//详情查询
	Map<String,Object> queryDetail(String id);
	//分页查询
	PageInfo<Map<String,Object>> queryPage(Integer pageNo,Integer pageSize,String orderNo,String mobile,String companyName);
	
}
