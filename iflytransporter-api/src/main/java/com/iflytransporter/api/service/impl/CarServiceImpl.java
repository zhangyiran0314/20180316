package com.iflytransporter.api.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.CarMapper;
import com.iflytransporter.api.mapper.UserMapper;
import com.iflytransporter.api.service.CarService;
import com.iflytransporter.common.bean.Car;
import com.iflytransporter.common.bean.CarBO;
import com.iflytransporter.common.bean.User;

@Service("carService")
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarMapper carMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public CarBO save(Car record,String userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		if(user==null  || StringUtils.isBlank(user.getCompanyId())){
			return null;
		}
		record.setCompanyId(user.getCompanyId());
		int result  =  carMapper.insert(record);
		if(result > 0){
			return carMapper.selectByPrimaryKeyBO(record.getId());
		}
		return null;
	}

	@Override
	public Car query(String id) {
		return carMapper.selectByPrimaryKeyBO(id);
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
	public PageInfo<Car> queryPage(Integer pageNo, Integer pageSize, String userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		if(user==null  || StringUtils.isBlank(user.getCompanyId())){
			return null;
		}
		String companyId = user.getCompanyId();
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Car> list= carMapper.queryAll(companyId);
		return new PageInfo<Car>(list);
	}

	@Override
	public List<Car> list(String userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		if(user==null  || StringUtils.isBlank(user.getCompanyId())){
			return null;
		}
		String companyId = user.getCompanyId();
		return carMapper.queryAll(companyId);
	}

}
