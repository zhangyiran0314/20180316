package com.iflytransporter.api.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Order;

public interface OrderService  {
	//增删改查
	public int save(Order record);
	
	public Order query(String id);
	
	public int update(Order record);
	
	public int delete(String id);
	
	public int cancel(String id);
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param userId
	 * @param status
	 * @return
	 */
	PageInfo<Order> queryPage(Integer pageNo,Integer pageSize,String userId,Integer status,Integer checkStatus);
	
	/**
	 * 列表-发布
	 * @param userId
	 * @param status 发布状态
	 * @return
	 */
	List<Order> list(String userId,Integer status,Integer checkStatus);
	/**
	 * 审核详情
	 */
	List<Map<String,Object>> detailAudit(String id,Integer applyStatus);
	
	//审核状态修改
	int updateStatus(String id,Integer status);
	
}
