package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.UseType;
import com.iflytransporter.web.mapper.UseTypeMapper;
import com.iflytransporter.web.service.UseTypeService;

@Service("useTypeService")
public class UseTypeServiceImpl implements UseTypeService{

	@Autowired
	private UseTypeMapper useTypeMapper;


	@Override
	public PageInfo<UseType> queryPage(Integer pageNo, Integer pageSize) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<UseType> list= useTypeMapper.queryAll();
		return new PageInfo<UseType>(list);
	}

	@Override
	public UseType queryDetail(String id) {
		return useTypeMapper.selectByPrimaryKey(id);
	}
}
