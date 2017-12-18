package com.iflytransporter.api.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.OrderMapper;
import com.iflytransporter.api.service.OrderService;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.enums.Status;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderMapper orderMapper;
	@Override
	public int save(Order order) {
		return  orderMapper.insert(order);
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
		return orderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PageInfo<Order> queryPage(Integer pageNo, Integer pageSize, String sId,Integer status,Integer authStatus) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Order> list= orderMapper.queryAll(sId,status);
		return new PageInfo<Order>(list);
	}
	@Override
	public List<Order> list(String sId, Integer status,Integer authStatus) {
		return orderMapper.queryAll(sId, status);
	}


	@Override
	public int cancel(String id) {
		return orderMapper.updateStatus(id,Status.Order_Cancel);
	}

	@Override
	public List<Map<String, Object>> detailAudit(String id,Integer applyStatus) {
		return orderMapper.detailAudit(id,applyStatus);
	}

	@Override
	public int updateStatus(String id, Integer status) {
		return orderMapper.updateStatus(id, status);
	}



}
