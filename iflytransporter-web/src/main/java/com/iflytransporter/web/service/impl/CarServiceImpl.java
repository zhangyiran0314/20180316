package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.CarBO;
import com.iflytransporter.web.mapper.CarMapper;
import com.iflytransporter.web.service.CarService;

@Service("carService")
public class CarServiceImpl implements CarService{

	@Autowired
	private CarMapper carMapper;


	@Override
	public PageInfo<CarBO> queryPage(String cId,Integer pageNo, Integer pageSize) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<CarBO> list= carMapper.queryAllBO(cId);
		return new PageInfo<CarBO>(list);
	}

	@Override
	public CarBO queryDetailBO(String id) {
		return carMapper.selectByPrimaryKeyBO(id);
	}
}
