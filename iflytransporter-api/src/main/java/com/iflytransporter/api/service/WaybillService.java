package com.iflytransporter.api.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Comment;
import com.iflytransporter.common.bean.Complaint;
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
	PageInfo<Waybill> queryPage(Integer pageNo,Integer pageSize,String shipperId,String shipperCompanyId,Integer status,Date lastCreateDate);
	
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
	
	//收货凭证
	Map<String, Object> takeAttachmentList(String id);
	
	//交货凭证
	Map<String, Object> deliverAttachmentList(String id);
	//修改运单状态
	int updateStatus(String id,Integer status);
	
	int addComment(Comment comment);
	
	int addComplaint(Complaint complaint);
	
	//运单查看当前货主是否评价此运单
	Integer countCommentByWaybill(String waybillId,String shipperId);
	//运单查看当前货主评价详情
	Map<String,Object> queryCommentByWaybill(String waybillId,String shipperId);
	
	//运单查看当前货主是否评价此运单
	Integer countComplaintByWaybill(String waybillId,String shipperId);
	//运单查看当前货主评价详情
	Map<String,Object> queryComplaintByWaybill(String waybillId,String shipperId);
}
