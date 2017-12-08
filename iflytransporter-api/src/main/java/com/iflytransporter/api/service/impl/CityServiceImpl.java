package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.CityMapper;
import com.iflytransporter.api.service.CityService;
import com.iflytransporter.common.bean.City;

@Service("cityService")
public class CityServiceImpl implements CityService{

	@Autowired
	private CityMapper cityMapper;


	@Override
	public List<City> queryAll(String countryCode, String provinceId) {
		return cityMapper.queryAll(countryCode, provinceId);
	}


}
