package com.iflytransporter.web.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;

public interface TransporterCarService {
	
	PageInfo<Map<String, Object>> queryPage(Integer pageNo, Integer pageSize,String code,String companyName,String transporterMobile,String driverMobile);
	
	Map<String,Object> queryDetail(String id);

}
