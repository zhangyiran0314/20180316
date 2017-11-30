package com.iflytransporter.api.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Order;

public interface OrderService  {
	//增删改查
	public int save(Order record);
	
	public Order query(String id);
	
	public int update(Order record);
	
	public int delete(String id);
	
	//分页查询
	PageInfo<Order> queryPage(Integer pageNo,Integer pageSize,String sId);
}
