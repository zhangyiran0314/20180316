package com.iflytransporter.web.service.impl;

import java.util.List;
import java.util.Map;

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
	public PageInfo<Map<String,Object>> queryPage(Integer pageNo, Integer pageSize,String orderNo,String mobile) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Map<String,Object>> list= complaintMapper.queryAll(orderNo,mobile);
		return new PageInfo<Map<String,Object>>(list);
	}

}
