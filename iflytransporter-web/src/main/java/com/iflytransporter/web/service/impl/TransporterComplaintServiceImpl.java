package com.iflytransporter.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.web.mapper.TransporterComplaintMapper;
import com.iflytransporter.web.service.TransporterComplaintService;

@Service("transporterComplaintService")
public class TransporterComplaintServiceImpl implements TransporterComplaintService{

	@Autowired
	private TransporterComplaintMapper transporterComplaintMapper;

	@Override
	public Map<String,Object> queryDetail(String id) {
		return transporterComplaintMapper.queryDetail(id);
	}


	@Override
	public PageInfo<Map<String, Object>> queryPage(Integer pageNo,Integer pageSize,String orderNo,String tMobile,String sCompanyName,String sMobile) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Map<String,Object>> list= transporterComplaintMapper.queryAll(orderNo, tMobile, sCompanyName, sMobile);
		return new PageInfo<Map<String,Object>>(list);
	}

}
