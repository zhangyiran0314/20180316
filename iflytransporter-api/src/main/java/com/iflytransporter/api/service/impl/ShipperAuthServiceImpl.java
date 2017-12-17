package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.OrderMapper;
import com.iflytransporter.api.service.ShipperAuthService;
import com.iflytransporter.common.bean.Order;

@Service("shipperAuthService")
public class ShipperAuthServiceImpl implements ShipperAuthService{

	@Autowired
	private OrderMapper orderMapper;
	@Override
	public PageInfo<Order> queryPage(Integer pageNo, Integer pageSize, String companyId, String userId,
			Integer status) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Order> list= orderMapper.queryAllAuth(companyId, userId, status);
		return new PageInfo<Order>(list);
	}

	@Override
	public List<Order> list(String companyId, String userId, Integer status) {
		return orderMapper.queryAllAuth(companyId, userId, status);
	}

	@Override
	public Order query(String id) {
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateAuthStatus(String id,Integer status) {
		return orderMapper.updateAuthStatus(id, status);
	}


}
