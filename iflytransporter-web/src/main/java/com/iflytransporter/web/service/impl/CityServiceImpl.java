package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.City;
import com.iflytransporter.common.bean.CityBO;
import com.iflytransporter.web.mapper.CityMapper;
import com.iflytransporter.web.service.CityService;

@Service("cityService")
public class CityServiceImpl implements CityService{

	@Autowired
	private CityMapper cityMapper;

	@Override
	public CityBO queryDetailBO(String id) {
		return cityMapper.selectByPrimaryKeyBO(id);
	}
	@Override
	public City queryDetail(String id) {
		return cityMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<CityBO> queryPage(Integer pageNo, Integer pageSize,String name) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<CityBO> list= cityMapper.queryAllBO(name);
		return new PageInfo<CityBO>(list);
	}

}
