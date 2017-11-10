package com.iflytransporter.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.bean.UserShipper;
import com.iflytransporter.api.mapper.UserShipperMapper;
import com.iflytransporter.api.service.UserShipperService;

@Service("userShipperService")
public class UserShipperServiceImpl implements UserShipperService{

	@Autowired
	private UserShipperMapper userShipperMapper;
	
	@Override
	public UserShipper queryByMobile(String mobile) {
		return userShipperMapper.selectByMobile(mobile);
	}

	@Override
	public int register(UserShipper record) {
		return userShipperMapper.insert(record);
	}

	@Override
	public int updateLoginInfo(UserShipper record) {
		return userShipperMapper.updateLoginInfo(record);
	}

	@Override
	public UserShipper login(String mobile, String password) {
		return userShipperMapper.selectByMobileAndPassword(mobile, password);
	}

}
