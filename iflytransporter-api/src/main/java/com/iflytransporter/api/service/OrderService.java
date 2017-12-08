package com.iflytransporter.api.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.OrderBO;

public interface OrderService  {
	//增删改查
	public int save(Order record);
	
	public Order query(String id);
	
	public OrderBO queryBO(String id);
	
	public int update(Order record);
	
	public int delete(String id);
	
	//分页查询
	PageInfo<Order> queryPage(Integer pageNo,Integer pageSize,String sId,Integer status);
	//列表查询
	List<Order> list(String sId,Integer status);
}
