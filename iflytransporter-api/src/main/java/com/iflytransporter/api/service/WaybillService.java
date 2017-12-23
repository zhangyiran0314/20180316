package com.iflytransporter.api.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Waybill;

public interface WaybillService {
	
	Waybill query(String id);
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param userId
	 * @param status
	 * @return
	 */
	//PageInfo<WaybillBO> queryPageBO(Integer pageNo,Integer pageSize,String shipperId,String shipperCompanyId,Integer status);
	
	/**
	 * 列表
	 * @param userId
	 * @param status 发布状态
	 * @return
	 */
	//List<WaybillBO> listBO(String userId,String shipperCompanyId,Integer status);
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param userId
	 * @param status
	 * @return
	 */
	PageInfo<Waybill> queryPage(Integer pageNo,Integer pageSize,String shipperId,String shipperCompanyId,Integer status);
	
	/**
	 * 列表
	 * @param userId
	 * @param status 发布状态
	 * @return
	 */
	List<Waybill> list(String userId,String shipperCompanyId,Integer status);
	/**
	 * 运单公司信息
	 * @param companyId
	 * @return
	 */
	Map<String,Object> detailCompany(String id);
	/**
	 * 运单车主以及车辆信息
	 * @param companyId
	 * @return
	 */
	Map<String,Object> detailTransporter(String id);
	
}
