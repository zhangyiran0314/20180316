package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.GoodsUnits;
import com.iflytransporter.web.mapper.GoodsUnitsMapper;
import com.iflytransporter.web.service.GoodsUnitsService;

@Service("goodsUnitsService")
public class GoodsUnitsServiceImpl implements GoodsUnitsService{

	@Autowired
	private GoodsUnitsMapper goodsUnitsMapper;

	@Override
	public GoodsUnits queryDetail(String id) {
		return goodsUnitsMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<GoodsUnits> queryPage(Integer pageNo, Integer pageSize) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<GoodsUnits> list= goodsUnitsMapper.queryAll();
		return new PageInfo<GoodsUnits>(list);
	}

}
