package com.iflytransporter.api.service;

import java.util.List;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.common.bean.Province;

public interface ProvinceService  {
	
//	List<Province> queryAll();
	
	List<Province> queryAll(String countryCode);
	
	CommonParam queryCommonParam(String id);
	
}
