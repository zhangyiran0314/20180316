package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Province;
import com.iflytransporter.web.mapper.ProvinceMapper;
import com.iflytransporter.web.service.ProvinceService;

@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService{

	@Autowired
	private ProvinceMapper provinceMapper;

	@Override
	public Province queryDetail(String id) {
		return provinceMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<Province> queryPage(Integer pageNo, Integer pageSize) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Province> list= provinceMapper.queryAll();
		return new PageInfo<Province>(list);
	}

}
