package com.iflytransporter.api.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Order;

public interface ShipperOrderService  {
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
	
	/**
	 * 车主详情
	 */
	Map<String,Object> detailTransporter(String applyId,String orderId,Integer applyStatus);
	
	/**
	 * 审核成功
	 * 1.修改订单为运单状态
	 * 2.取消其他申请
	 * 3.生成运单
	 * @param id
	 * @param status
	 * @return
	 */
	int auditOk(String orderId,String orderApplyId);
	
}
