package com.iflytransporter.api.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.TransporterCommentMapper;
import com.iflytransporter.api.mapper.TransporterComplaintMapper;
import com.iflytransporter.api.mapper.TransporterWaybillMapper;
import com.iflytransporter.api.mapper.WaybillMapper;
import com.iflytransporter.api.service.TransporterWaybillService;
import com.iflytransporter.common.bean.TransporterComment;
import com.iflytransporter.common.bean.TransporterComplaint;
import com.iflytransporter.common.bean.Waybill;
import com.iflytransporter.common.enums.Status;

@Service("transporterWaybillService")
public class TransporterWaybillServiceImpl implements TransporterWaybillService {

	@Autowired
	private WaybillMapper waybillMapper;
	
	@Autowired
	private TransporterCommentMapper transporterCommentMapper;
	
	@Autowired
	private TransporterComplaintMapper transporterComplaintMapper;
	
	@Autowired
	private TransporterWaybillMapper transporterWaybillMapper;

	@Override
	public List<Waybill> list(String userId, String transporterCompanyId, Integer status,Integer dispenseStatus) {
		return transporterWaybillMapper.queryAll(null, userId, null, transporterCompanyId, status,dispenseStatus,null,null);
	}

	@Override
	public Waybill query(String id) {
		return waybillMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> detailShipperCompany(String id) {
		return transporterWaybillMapper.detailShipperCompany(id);
	}

	@Override
	public Map<String, Object> detailShipperComment(String id) {
		return transporterWaybillMapper.detailShipperComment(id);
	}

	@Override
	public PageInfo<Waybill> queryPage(Integer pageNo, Integer pageSize, String transporterId, String transporterCompanyId,
			Integer status,Integer dispenseStatus,Date lastCreateDate,String than) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Waybill> list= transporterWaybillMapper.queryAll(null, transporterId, null, transporterCompanyId, status,dispenseStatus,lastCreateDate,than);
		return new PageInfo<Waybill>(list);
	}

	@Override
	public Map<String, Object> takeAttachmentList(String id) {
		return waybillMapper.takeAttachmentList(id);
	}

	@Override
	public Map<String, Object> deliverAttachmentList(String id) {
		return waybillMapper.deliverAttachmentList(id);
	}

	@Override
	public int updateStatus(String id, Integer status) {
		return waybillMapper.updateStatus(id, status);
	}

	@Override
	public int addComment(TransporterComment comment) {
		return transporterCommentMapper.insert(comment);
	}

	@Override
	public int addComplaint(TransporterComplaint complaint) {
		return transporterComplaintMapper.insert(complaint);
	}

	@Override
	public Integer countCommentByWaybill(String waybillId) {
		return transporterCommentMapper.countByWaybill(waybillId, null);
	}

	@Override
	public Map<String, Object> queryCommentByWaybill(String waybillId) {
		return transporterCommentMapper.queryDetailByWaybill(waybillId, null);
	}

	@Override
	public Integer countComplaintByWaybill(String waybillId, String shipperId) {
		return transporterComplaintMapper.countByWaybill(waybillId, shipperId);
	}

	@Override
	public Map<String, Object> queryComplaintByWaybill(String waybillId) {
		return transporterComplaintMapper.queryDetailByWaybill(waybillId, null);
	}

	@Override
	public List<Map<String,Object>> listDriver(String companyId,Integer level) {
		return transporterWaybillMapper.listDriver(companyId, level);
	}

	@Override
	public List<Map<String,Object>> listCar(String companyId) {
		return transporterWaybillMapper.listCar(companyId);
	}

	@Override
	public int dispense(String id, String driverId, String carId,Integer dispenseStatus) {
		return transporterWaybillMapper.dispense(id, driverId, carId,dispenseStatus);
	}

	@Override
	public Map<String, Object> detailDispense(String id) {
		return transporterWaybillMapper.detailDispense(id);
	}

	@Override
	public Map<String, Object> detailDispenseComment(String driverId) {
		return transporterWaybillMapper.detailDispenseComment(driverId);
	}

	@Override
	public int loadingProof(String id, String attachment1, String attachment2, String attachment3, String attachment4) {
		return transporterWaybillMapper.loadingProof(id, attachment1, attachment2, attachment3, attachment4,Status.Waybill_In_Transit);
	}

	@Override
	public int deliverProof(String id, String attachment1, String attachment2, String attachment3, String attachment4) {
		return transporterWaybillMapper.deliverProof(id, attachment1, attachment2, attachment3, attachment4,Status.Waybill_To_Confirm);
	}

	@Override
	public Map<String, Object> detailShipper(String shipperId) {
		return transporterWaybillMapper.detailShipper(shipperId);
	}

	@Override
	public Map<String, Object> detailDriver(String driverId) {
		return transporterWaybillMapper.detailDriver(driverId);
	}
}
