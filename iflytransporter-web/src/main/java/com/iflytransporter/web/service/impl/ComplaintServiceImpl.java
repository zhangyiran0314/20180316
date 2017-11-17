package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Complaint;
import com.iflytransporter.web.mapper.ComplaintMapper;
import com.iflytransporter.web.service.ComplaintService;

@Service("complaintService")
public class ComplaintServiceImpl implements ComplaintService{

	@Autowired
	private ComplaintMapper complaintMapper;

	@Override
	public Complaint queryDetail(String id) {
		return complaintMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<Complaint> queryPage(Integer pageNo, Integer pageSize,String sId,String tId,String wId) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Complaint> list= complaintMapper.queryAll(sId, tId, wId);
		return new PageInfo<Complaint>(list);
	}

}
