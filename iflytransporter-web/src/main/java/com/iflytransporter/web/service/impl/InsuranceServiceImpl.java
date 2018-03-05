package com.iflytransporter.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Insurance;
import com.iflytransporter.web.mapper.InsuranceMapper;
import com.iflytransporter.web.service.InsuranceService;

@Service("insuranceService")
public class InsuranceServiceImpl implements InsuranceService{

	@Autowired
	private InsuranceMapper insuranceMapper;

	@Override
	public Insurance queryDetail(String id) {
		return insuranceMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<Map<String, Object>> queryPage(Integer pageNo, Integer pageSize, String policyhodlerCompany,
			String policyhodlerMobile, String policyhodlerName) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Map<String,Object>> list= insuranceMapper.queryAll(policyhodlerCompany, policyhodlerMobile, policyhodlerName);
		return new PageInfo<Map<String,Object>>(list);
	}

}
