package com.iflytransporter.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.CarMaintenance;
import com.iflytransporter.web.mapper.CarMaintenanceMapper;
import com.iflytransporter.web.service.CarMaintenanceService;

@Service("carMaintenanceService")
public class CarMaintenanceServiceImpl implements CarMaintenanceService{

	@Autowired
	private CarMaintenanceMapper carMaintenanceMapper;


	@Override
	public PageInfo<Map<String,Object>> queryPage(Integer pageNo, Integer pageSize,String name) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Map<String,Object>> list= carMaintenanceMapper.queryAll(name);
		return new PageInfo<Map<String,Object>>(list);
	}


	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int insert(CarMaintenance record) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int insertSelective(CarMaintenance record) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public CarMaintenance selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int updateByPrimaryKeySelective(CarMaintenance record) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int updateByPrimaryKey(CarMaintenance record) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Map<String, Object> queryDetail(String id) {
		return carMaintenanceMapper.queryDetail(id);
	}

}
