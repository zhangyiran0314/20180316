package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.HandlingType;
import com.iflytransporter.web.mapper.HandlingTypeMapper;
import com.iflytransporter.web.service.HandlingTypeService;

@Service("handlingTypeService")
public class HandlingTypeServiceImpl implements HandlingTypeService{

	@Autowired
	private HandlingTypeMapper handlingTypeMapper;


	@Override
	public PageInfo<HandlingType> queryPage(Integer pageNo, Integer pageSize) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<HandlingType> list= handlingTypeMapper.queryAll();
		return new PageInfo<HandlingType>(list);
	}

	@Override
	public HandlingType queryDetail(String id) {
		return handlingTypeMapper.selectByPrimaryKey(id);
	}
}
