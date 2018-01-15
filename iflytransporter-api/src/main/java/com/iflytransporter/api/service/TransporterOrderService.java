package com.iflytransporter.api.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.OrderApply;
import com.iflytransporter.common.bean.SubscribeSource;
import com.iflytransporter.common.bean.User;

public interface TransporterOrderService  {
	
	public Order query(String id);
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param userId
	 * @param status
	 * @return
	 */
	PageInfo<Order> queryPage(Integer pageNo,Integer pageSize,Integer status,Integer authStatus);
	
	/**
	 * 列表-发布
	 * @param userId
	 * @param status 发布状态
	 * @return
	 */
	List<Order> list(Integer status,Integer checkStatus);
	/**
	 * 申请订单
	 * @param id
	 * @param userId
	 * @return
	 */
	OrderApply apply(String id,Double costs,User user);
	
	/**
	 * 审核详情
	 */
	List<Map<String,Object>> detailAudit(String id,Integer applyStatus);
	
	//审核状态修改
	int updateStatus(String id,Integer status);
	
	/**订阅路线部分*/
	//增删改查
	public int save(SubscribeSource record);
	
	public SubscribeSource querySubscribeSource(String id);
	
	public int update(SubscribeSource record);
	
	public int delete(String id);
	
	public List<SubscribeSource> listByUserId(String userId);
}
