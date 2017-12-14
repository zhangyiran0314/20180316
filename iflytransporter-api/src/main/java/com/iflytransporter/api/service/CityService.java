package com.iflytransporter.api.service;

import java.util.List;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.common.bean.City;

public interface CityService  {
	
//	List<City> queryAll(String provinceId);
	
	List<City> queryAll(String countryCode,String provinceId);
	
	CommonParam queryCommonParam(String id);
}
