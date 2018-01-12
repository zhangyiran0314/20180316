package com.iflytransporter.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Transporter;
import com.iflytransporter.common.bean.TransporterBO;
import com.iflytransporter.web.mapper.TransporterMapper;
import com.iflytransporter.web.service.TransporterService;

@Service("transporterService")
public class TransporterServiceImpl implements TransporterService{

	@Autowired
	private TransporterMapper transporterMapper;

	@Override
	public Transporter queryDetail(String id) {
		return transporterMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<Map<String,Object>> queryPage(Integer pageNo, Integer pageSize) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Map<String,Object>> list= transporterMapper.queryAll();
		return new PageInfo<Map<String,Object>>(list);
	}

	@Override
	public TransporterBO queryDetailBO(String id) {
		return transporterMapper.selectByPrimaryKeyBO(id);
	}
}
