package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.GoodsTypeMapper;
import com.iflytransporter.api.service.GoodsTypeService;
import com.iflytransporter.common.bean.GoodsType;

@Service("goodsTypeService")
public class GoodsTypeServiceImpl implements GoodsTypeService{

	@Autowired
	private GoodsTypeMapper goodsTypeMapper;

	@Override
	public List<GoodsType> queryAll() {
		return goodsTypeMapper.queryAll();
	}

}
