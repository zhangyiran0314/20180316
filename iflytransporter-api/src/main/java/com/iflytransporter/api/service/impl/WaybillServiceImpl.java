package com.iflytransporter.api.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.CommentMapper;
import com.iflytransporter.api.mapper.ComplaintMapper;
import com.iflytransporter.api.mapper.WaybillMapper;
import com.iflytransporter.api.service.WaybillService;
import com.iflytransporter.common.bean.Comment;
import com.iflytransporter.common.bean.Complaint;
import com.iflytransporter.common.bean.Waybill;

@Service("waybillService")
public class WaybillServiceImpl implements WaybillService {

	@Autowired
	private WaybillMapper waybillMapper;
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private ComplaintMapper complaintMapper;
	/*@Override
	public PageInfo<WaybillBO> queryPageBO(Integer pageNo, Integer pageSize, String userId, String shipperCompanyId,Integer status) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<WaybillBO> list= waybillMapper.queryAllBO(userId, null, shipperCompanyId, null, status);
		return new PageInfo<WaybillBO>(list);
	}*/

	@Override
	public List<Waybill> list(String userId, String shipperCompanyId, Integer status) {
		return waybillMapper.queryAll(userId, null, shipperCompanyId, null, status);
	}

	@Override
	public Waybill query(String id) {
		return waybillMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> detailCompany(String id) {
		return waybillMapper.detailCompany(id);
	}

	@Override
	public Map<String, Object> detailTransporter(String id) {
		return waybillMapper.detailTransporter(id);
	}

	@Override
	public PageInfo<Waybill> queryPage(Integer pageNo, Integer pageSize, String shipperId, String shipperCompanyId,
			Integer status) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Waybill> list= waybillMapper.queryAll(shipperId, null, shipperCompanyId, null, status);
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
	public int addComment(Comment comment) {
		return commentMapper.insert(comment);
	}

	@Override
	public int addComplaint(Complaint complaint) {
		return complaintMapper.insert(complaint);
	}

	@Override
	public Integer countCommentByWaybill(String waybillId, String shipperId) {
		return commentMapper.countByWaybill(waybillId, shipperId);
	}

	@Override
	public Map<String, Object> queryCommentByWaybill(String waybillId, String shipperId) {
		return commentMapper.queryDetailByWaybill(waybillId, shipperId);
	}

	@Override
	public Integer countComplaintByWaybill(String waybillId, String shipperId) {
		return complaintMapper.countByWaybill(waybillId, shipperId);
	}

	@Override
	public Map<String, Object> queryComplaintByWaybill(String waybillId, String shipperId) {
		return complaintMapper.queryDetailByWaybill(waybillId, shipperId);
	}

	/*@Override
	public List<WaybillBO> listBO(String userId, String shipperCompanyId, Integer status) {
		return waybillMapper.queryAllBO(userId, null, shipperCompanyId, null, status);
	}*/

}
