package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.GoodsUnitsMapper;
import com.iflytransporter.api.service.GoodsUnitsService;
import com.iflytransporter.common.bean.GoodsUnits;

@Service("goodsUnitsService")
public class GoodsUnitsServiceImpl implements GoodsUnitsService{

	@Autowired
	private GoodsUnitsMapper goodsUnitsMapper;

	@Override
	public List<GoodsUnits> queryAll() {
		return goodsUnitsMapper.queryAll();
	}

}
