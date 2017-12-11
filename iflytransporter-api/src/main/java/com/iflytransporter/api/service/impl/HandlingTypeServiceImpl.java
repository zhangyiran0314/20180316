package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.HandlingTypeMapper;
import com.iflytransporter.api.service.HandlingTypeService;
import com.iflytransporter.common.bean.HandlingType;

@Service("handlingTypeService")
public class HandlingTypeServiceImpl implements HandlingTypeService{

	@Autowired
	private HandlingTypeMapper handlingTypeMapper;

	@Override
	public List<HandlingType> queryAll() {
		return handlingTypeMapper.queryAll();
	}

}
