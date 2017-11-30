package com.iflytransporter.api.service;

import java.util.List;

import com.iflytransporter.common.bean.City;

public interface CityService  {
	
	List<City> queryAll(String provinceId);
}
