package com.iflytransporter.api.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.TransporterComment;
import com.iflytransporter.common.bean.TransporterComplaint;
import com.iflytransporter.common.bean.Complaint;
import com.iflytransporter.common.bean.Waybill;

public interface TransporterWaybillService {
	
	Waybill query(String id);
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param userId
	 * @param status
	 * @return
	 */
	PageInfo<Waybill> queryPage(Integer pageNo,Integer pageSize,String transporterId,String  transporterCompanyId,Integer status,Integer dispenseStatus);
	
	/**
	 * 列表
	 * @param userId
	 * @param status 发布状态
	 * @return
	 */
	List<Waybill> list(String userId,String transporterCompanyId,Integer status,Integer dispenseStatus);
	/**
	 * 货主公司信息
	 * @param companyId
	 * @return
	 */
	Map<String,Object> detailShipperCompany(String id);
	
	Map<String,Object> detailShipperComment(String id);
	
	//收货凭证
	Map<String, Object> takeAttachmentList(String id);
	
	//交货凭证
	Map<String, Object> deliverAttachmentList(String id);
	
	//修改运单状态
	int updateStatus(String id,Integer status);
	
	int addComment(TransporterComment comment);
	
	int addComplaint(TransporterComplaint complaint);
	
	//运单查看当前车主是否评价此运单
	Integer countCommentByWaybill(String waybillId,String shipperId);
	//运单查看当前车主评价详情
	Map<String,Object> queryCommentByWaybill(String waybillId,String shipperId);
	
	//运单查看当前车主是否评价此运单
	Integer countComplaintByWaybill(String waybillId,String shipperId);
	//运单查看当前车主评价详情
	Map<String,Object> queryComplaintByWaybill(String waybillId,String shipperId);
	/** 司机列表 */
	Map<String,Object> listDriver(String companyId);
	/** 车辆列表 */
	Map<String,Object> listCar(String companyId);
	
	/**派单*/
	int dispense(String id,String driverId,String carId,Integer dispenseStatus);
	/** 派单司机以及车辆信息 */
	Map<String,Object> detailDispense(String id);
	
}
