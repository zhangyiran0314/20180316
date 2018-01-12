package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Order;

public interface OrderService  {
	//详情查询
	Order queryDetail(String id);
	//分页查询
	PageInfo<Order> queryPage(Integer pageNo,Integer pageSize,String orderNo,String mobile);
	
}
