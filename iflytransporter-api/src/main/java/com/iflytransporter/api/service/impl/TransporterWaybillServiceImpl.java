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
import com.iflytransporter.api.service.TransporterWaybillService;
import com.iflytransporter.common.bean.Comment;
import com.iflytransporter.common.bean.Complaint;
import com.iflytransporter.common.bean.Waybill;

@Service("transporterWaybillService")
public class TransporterWaybillServiceImpl implements TransporterWaybillService {

	@Autowired
	private WaybillMapper waybillMapper;
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private ComplaintMapper complaintMapper;

	@Override
	public List<Waybill> list(String userId, String transporterCompanyId, Integer status) {
		return waybillMapper.queryAll(null, userId, null, transporterCompanyId, status);
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
	public Map<String, Object> detailShipper(String id) {
		return waybillMapper.detailTransporter(id);
	}

	@Override
	public PageInfo<Waybill> queryPage(Integer pageNo, Integer pageSize, String transporterId, String transporterCompanyId,
			Integer status) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Waybill> list= waybillMapper.queryAll(null, transporterId, null, transporterCompanyId, status);
		return new PageInfo<Waybill>(list);
	}

	@Override
	public List<Map<String, Object>> takeAttachmentList(String id) {
		return waybillMapper.takeAttachmentList(id);
	}

	@Override
	public List<Map<String, Object>> deliverAttachmentList(String id) {
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

	/*@Override
	public List<WaybillBO> listBO(String userId, String shipperCompanyId, Integer status) {
		return waybillMapper.queryAllBO(userId, null, shipperCompanyId, null, status);
	}*/

}
