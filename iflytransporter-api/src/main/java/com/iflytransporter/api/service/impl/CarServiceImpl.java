package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.CarMapper;
import com.iflytransporter.api.service.CarService;
import com.iflytransporter.common.bean.Car;

@Service("carService")
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarMapper carMapper;

	@Override
	public int save(Car record) {
		return carMapper.insert(record);
	}

	@Override
	public Car query(String id) {
		return carMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Car record) {
		return carMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(String id) {
		return carMapper.invalidByPrimaryKey(id);
	}

	@Override
	public PageInfo<Car> queryPage(Integer pageNo, Integer pageSize, String sId) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Car> list= carMapper.queryAll(sId);
		return new PageInfo<Car>(list);
	}

	@Override
	public List<Car> list(String userId) {
		return carMapper.queryAll(userId);
	}

}
