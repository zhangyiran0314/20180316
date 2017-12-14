package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.api.mapper.CarTypeMapper;
import com.iflytransporter.api.service.CarTypeService;
import com.iflytransporter.common.bean.CarType;

@Service("carTypeService")
public class CarTypeServiceImpl implements CarTypeService{

	@Autowired
	private CarTypeMapper carTypeMapper;

	@Override
	public List<CarType> queryAll() {
		return carTypeMapper.queryAll();
	}
	@Override
	public CommonParam queryCommonParam(String id) {
		return carTypeMapper.queryCommonParam(id);
	}

}
