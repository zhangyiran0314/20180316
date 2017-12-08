package com.iflytransporter.api.service;

import java.util.List;

import com.iflytransporter.common.bean.Area;

public interface AreaService  {
	
//	List<Area> queryAll(String cityId);
	
	List<Area> queryAll(String countryCode,String cityId);
}
