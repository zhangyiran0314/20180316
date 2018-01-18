package com.iflytransporter.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.web.mapper.OrderMapper;
import com.iflytransporter.web.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public Map<String,Object> queryDetail(String id) {
		return orderMapper.queryDetail(id);
	}

	@Override
	public PageInfo<Map<String,Object>> queryPage(Integer pageNo, Integer pageSize,String orderNo,String mobile,String companyName) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Map<String,Object>> list= orderMapper.queryAll(orderNo,mobile,companyName);
		return new PageInfo<Map<String,Object>>(list);
	}

}
