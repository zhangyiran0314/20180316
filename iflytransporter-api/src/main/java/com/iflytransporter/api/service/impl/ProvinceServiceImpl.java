package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.api.mapper.ProvinceMapper;
import com.iflytransporter.api.service.ProvinceService;
import com.iflytransporter.common.bean.Province;

@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService{

	@Autowired
	private ProvinceMapper provinceMapper;

	@Override
	public List<Province> queryAll(String countryCode) {
		return provinceMapper.queryAll(countryCode);
	}

	@Override
	public CommonParam queryCommonParam(String id) {
		return provinceMapper.queryCommonParam(id);
	}


}
