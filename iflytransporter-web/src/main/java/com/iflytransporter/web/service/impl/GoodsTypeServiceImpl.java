package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.GoodsType;
import com.iflytransporter.web.mapper.GoodsTypeMapper;
import com.iflytransporter.web.service.GoodsTypeService;

@Service("goodsTypeService")
public class GoodsTypeServiceImpl implements GoodsTypeService{

	@Autowired
	private GoodsTypeMapper goodsTypeMapper;


	@Override
	public PageInfo<GoodsType> queryPage(Integer pageNo, Integer pageSize) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<GoodsType> list= goodsTypeMapper.queryAll();
		return new PageInfo<GoodsType>(list);
	}

	@Override
	public GoodsType queryDetail(String id) {
		return goodsTypeMapper.selectByPrimaryKey(id);
	}
}
