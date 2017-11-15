package com.iflytransporter.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.ShipperMapper;
import com.iflytransporter.api.service.ShipperService;
import com.iflytransporter.common.bean.Shipper;

@Service("shipperService")
public class ShipperServiceImpl implements ShipperService{

	@Autowired
	private ShipperMapper shipperMapper;
	
	@Override
	public Shipper queryByMobile(String mobile) {
		return shipperMapper.selectByMobile(mobile);
	}

	@Override
	public int register(Shipper record) {
		return shipperMapper.insert(record);
	}

	@Override
	public int updateLoginInfo(Shipper record) {
		return shipperMapper.updateLoginInfo(record);
	}

	@Override
	public Shipper login(String mobile, String password) {
		return shipperMapper.selectByMobileAndPassword(mobile, password);
	}

}
