package com.iflytransporter.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.ShipperOrderMapper;
import com.iflytransporter.api.service.ShipperAuthService;
import com.iflytransporter.common.bean.Order;

@Service("shipperAuthService")
public class ShipperAuthServiceImpl implements ShipperAuthService{

	@Autowired
	private ShipperOrderMapper shipperOrderMapper;
	@Override
	public PageInfo<Order> queryPage(Integer pageNo, Integer pageSize, String companyId, String userId,
			Integer status,Date lastCreateDate,String than) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Order> list= shipperOrderMapper.queryAllAuth(companyId, userId, status,lastCreateDate, than);
		return new PageInfo<Order>(list);
	}

	@Override
	public List<Order> list(String companyId, String userId, Integer status) {
		return shipperOrderMapper.queryAllAuth(companyId, userId, status,null, null);
	}

	@Override
	public Order query(String id) {
		return shipperOrderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateAuthStatus(String id,Integer status) {
		return shipperOrderMapper.updateAuthStatus(id, status);
	}

	@Override
	public PageInfo<Order> queryPageByAdmin(Integer pageNo, Integer pageSize, String companyId, String userId,
			Integer status,Date lastCreateDate,String than) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Order> list= shipperOrderMapper.queryAllAuthByAdmin(companyId, userId, status, lastCreateDate, than);
		return new PageInfo<Order>(list);
	}

	@Override
	public List<Order> listByAdmin(String companyId, String userId, Integer status) {
		return shipperOrderMapper.queryAllAuthByAdmin(companyId, userId, status,null,null);
	}


}
