package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.web.mapper.OrderMapper;
import com.iflytransporter.web.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public Order queryDetail(String id) {
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<Order> queryPage(Integer pageNo, Integer pageSize,String sId) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Order> list= orderMapper.queryAll(sId);
		return new PageInfo<Order>(list);
	}

}
