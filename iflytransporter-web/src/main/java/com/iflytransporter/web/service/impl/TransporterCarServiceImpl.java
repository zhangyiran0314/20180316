package com.iflytransporter.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.web.mapper.CarMapper;
import com.iflytransporter.web.service.TransporterCarService;

@Service("transporterCarService")
public class TransporterCarServiceImpl implements TransporterCarService{

	@Autowired
	private CarMapper carMapper;

	@Override
	public Map<String,Object> queryDetail(String id) {
		return carMapper.queryDetail(id);
	}

	@Override
	public PageInfo<Map<String, Object>> queryPage(Integer pageNo, Integer pageSize,String code, String companyName, String transporterMobile,String driverMobile) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Map<String,Object>> list= carMapper.queryAll(code, companyName, transporterMobile, driverMobile);
		return  new PageInfo<Map<String,Object>>(list);
	}

}
