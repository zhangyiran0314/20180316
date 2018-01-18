package com.iflytransporter.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.GoodsSource;
import com.iflytransporter.web.mapper.GoodsSourceMapper;
import com.iflytransporter.web.service.GoodsSourceService;

@Service("goodsSourceService")
public class GoodsSourceServiceImpl implements GoodsSourceService{

	@Autowired
	private GoodsSourceMapper goodsSourceMapper;

	@Override
	public Map<String,Object> queryDetail(String id) {
		return goodsSourceMapper.queryDetail(id);
	}

	@Override
	public PageInfo<Map<String,Object>> queryPage(Integer pageNo, Integer pageSize,String orderNo,String mobile) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Map<String,Object>> list= goodsSourceMapper.queryAll(orderNo,mobile);
		return new PageInfo<Map<String,Object>>(list);
	}

}
