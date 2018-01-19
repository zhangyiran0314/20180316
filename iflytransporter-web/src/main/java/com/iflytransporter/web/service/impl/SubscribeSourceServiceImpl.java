package com.iflytransporter.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.web.mapper.SubscribeSourceMapper;
import com.iflytransporter.web.service.SubscribeSourceService;

@Service("subscribeSourceService")
public class SubscribeSourceServiceImpl implements SubscribeSourceService{

	@Autowired
	private SubscribeSourceMapper subscribeSourceMapper;

	@Override
	public Map<String,Object> queryDetail(String id) {
		return subscribeSourceMapper.queryDetail(id);
	}

	@Override
	public PageInfo<Map<String,Object>> queryPage(Integer pageNo, Integer pageSize,String orderNo,String mobile) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Map<String,Object>> list= subscribeSourceMapper.queryAll(orderNo,mobile);
		return new PageInfo<Map<String,Object>>(list);
	}

}
