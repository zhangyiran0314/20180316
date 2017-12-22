package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.CarType;
import com.iflytransporter.web.mapper.CarTypeMapper;
import com.iflytransporter.web.service.CarTypeService;

@Service("carTypeService")
public class CarTypeServiceImpl implements CarTypeService{

	@Autowired
	private CarTypeMapper carTypeMapper;


	@Override
	public PageInfo<CarType> queryPage(Integer pageNo, Integer pageSize) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<CarType> list= carTypeMapper.queryAll();
		return new PageInfo<CarType>(list);
	}

	@Override
	public CarType queryDetail(String id) {
		return carTypeMapper.selectByPrimaryKey(id);
	}
}
