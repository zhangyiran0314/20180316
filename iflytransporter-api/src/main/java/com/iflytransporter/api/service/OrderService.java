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
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param userId
	 * @param status
	 * @return
	 */
	PageInfo<Order> queryPage(Integer pageNo,Integer pageSize,String userId,Integer status);
	/**
	 * 列表-审核
	 * @param userId
	 * @param status 审核状态
	 * @return
	 */
	List<Order> listCheck(String userId,Integer status);
	/**
	 * 列表-发布
	 * @param userId
	 * @param status 发布状态
	 * @return
	 */
	List<Order> list(String userId,Integer status);
	
}
