package com.iflytransporter.api.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.CarMapper;
import com.iflytransporter.api.service.CarService;
import com.iflytransporter.common.bean.Car;
import com.iflytransporter.common.bean.CarBO;

@Service("carService")
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarMapper carMapper;
	@Override
	public int save(Car record,String companyId) {
		return carMapper.insert(record);
	}

	@Override
	public CarBO query(String id) {
		return carMapper.selectByPrimaryKeyBO(id);
	}

	@Override
	public int update(Car record) {
		return carMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(String id) {
		return carMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PageInfo<CarBO> queryPage(Integer pageNo, Integer pageSize, String companyId,String userId) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<CarBO> list= carMapper.queryAllBO(companyId,userId);
		return new PageInfo<CarBO>(list);
	}

	@Override
	public List<CarBO> list(String companyId,String userId) {
		return carMapper.queryAllBO(companyId,userId);
	}

	@Override
	public int bindCar(String id, String driverId) {
		return carMapper.bindCar(id, driverId);
	}

	@Override
	public int unbindCar(String id, String driverId) {
		return carMapper.unbindCar(id, driverId);
	}

	@Override
	public Map<String, Object> queryByUserId(String userId) {
		return carMapper.queryByUserId(userId);
	}

	@Override
	public List<CarBO> listCarNotBind(String companyId, String userId) {
		return carMapper.queryAllBO(companyId, userId);
	}


}
