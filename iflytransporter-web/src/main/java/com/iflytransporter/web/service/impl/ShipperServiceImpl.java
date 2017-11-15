package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Shipper;
import com.iflytransporter.common.bean.ShipperBO;
import com.iflytransporter.web.mapper.ShipperMapper;
import com.iflytransporter.web.service.ShipperService;

@Service("shipperService")
public class ShipperServiceImpl implements ShipperService{

	@Autowired
	private ShipperMapper shipperMapper;

	@Override
	public Shipper queryDetail(String id) {
		return shipperMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<Shipper> queryPage(Integer pageNo, Integer pageSize) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Shipper> list= shipperMapper.queryAll();
		return new PageInfo<Shipper>(list);
	}

	@Override
	public ShipperBO queryDetailBO(String id) {
		return shipperMapper.selectByPrimaryKeyBO(id);
	}
}
