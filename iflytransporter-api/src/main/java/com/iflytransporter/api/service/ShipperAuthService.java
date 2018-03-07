package com.iflytransporter.api.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Order;

public interface ShipperAuthService  {
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param companyId
	 * @param userId
	 * @param status
	 * @return
	 */
	PageInfo<Order> queryPage(Integer pageNo,Integer pageSize,String companyId,String userId,Integer status,Date lastCreateDate,String than);
	
	PageInfo<Order> queryPageByAdmin(Integer pageNo,Integer pageSize,String companyId,String userId,Integer status,Date lastCreateDate,String than);
	
	/**
	 * 列表
	 * @param companyId
	 * @param userId
	 * @param status 审核状态
	 * @return
	 */
	List<Order> list(String companyId,String userId,Integer status);
	
	List<Order> listByAdmin(String companyId,String userId,Integer status);
	
	Order query(String id);
	
	int updateAuthStatus(String id,Integer status);
	
}
