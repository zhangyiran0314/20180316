package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.AreaMapper;
import com.iflytransporter.api.service.AreaService;
import com.iflytransporter.common.bean.Area;

@Service("areaService")
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaMapper areaMapper;

	@Override
	public List<Area> queryAll(String cityId) {
		return areaMapper.queryAll(cityId);
	}

}
