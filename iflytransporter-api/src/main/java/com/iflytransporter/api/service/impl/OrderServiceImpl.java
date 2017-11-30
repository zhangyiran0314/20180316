package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.OrderMapper;
import com.iflytransporter.api.service.OrderService;
import com.iflytransporter.common.bean.Order;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public int save(Order record) {
		return orderMapper.insert(record);
	}

	@Override
	public Order query(String id) {
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Order record) {
		return orderMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(String id) {
		return orderMapper.invalidByPrimaryKey(id);
	}

	@Override
	public PageInfo<Order> queryPage(Integer pageNo, Integer pageSize, String sId) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Order> list= orderMapper.queryAll(sId);
		return new PageInfo<Order>(list);
	}

}
