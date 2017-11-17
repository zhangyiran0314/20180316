package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.AreaBO;
import com.iflytransporter.web.mapper.AreaMapper;
import com.iflytransporter.web.service.AreaService;

@Service("areaService")
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaMapper areaMapper;

	@Override
	public AreaBO queryDetailBO(String id) {
		return areaMapper.selectByPrimaryKeyBO(id);
	}

	@Override
	public PageInfo<AreaBO> queryPage(Integer pageNo, Integer pageSize) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<AreaBO> list= areaMapper.queryAllBO();
		return new PageInfo<AreaBO>(list);
	}

}
