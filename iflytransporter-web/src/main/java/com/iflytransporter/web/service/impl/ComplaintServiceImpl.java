package com.iflytransporter.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.web.mapper.ComplaintMapper;
import com.iflytransporter.web.service.ComplaintService;

@Service("complaintService")
public class ComplaintServiceImpl implements ComplaintService{

	@Autowired
	private ComplaintMapper complaintMapper;

	@Override
	public Map<String,Object> queryDetail(String id) {
		return complaintMapper.queryDetail(id);
	}


	@Override
	public PageInfo<Map<String, Object>> queryPage(Integer pageNo, Integer pageSize, String orderNo, String sMobile,
			String tCompanyName, String tMobile, String dMobile) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Map<String,Object>> list= complaintMapper.queryAll(orderNo, sMobile, tCompanyName, tMobile,dMobile);
		return new PageInfo<Map<String,Object>>(list);
	}

}
