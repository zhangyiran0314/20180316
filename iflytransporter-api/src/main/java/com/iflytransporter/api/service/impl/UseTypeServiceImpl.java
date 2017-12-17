package com.iflytransporter.api.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.api.mapper.UseTypeMapper;
import com.iflytransporter.api.service.UseTypeService;
import com.iflytransporter.common.bean.UseType;

@Service("useTypeService")
public class UseTypeServiceImpl implements UseTypeService{

	@Autowired
	private UseTypeMapper useTypeMapper;

	@Override
	public List<UseType> queryAll() {
		return useTypeMapper.queryAll();
	}
	@Override
	public CommonParam queryCommonParam(String id) {
		return useTypeMapper.queryCommonParam(id);
	}
	@Override
	public List<Map<String, Object>> list() {
		return useTypeMapper.list();
	}
}
