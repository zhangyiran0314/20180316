package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.UserMapper;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.common.bean.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User queryByMobile(String countryCode,Integer userType,String mobile) {
		return userMapper.selectByMobile(countryCode,userType,mobile);
	}

	@Override
	public int register(User record) {
		return userMapper.insert(record);
	}

	@Override
	public int updateLoginInfo(User record) {
		return userMapper.updateLoginInfo(record);
	}

	@Override
	public User login(String countryCode,Integer userType,String mobile, String password) {
		return userMapper.selectByMobileAndPassword(countryCode,userType,mobile, password);
	}

	@Override
	public int add(User user) {
		User record = userMapper.selectByCardNo(user.getCountryCode(), user.getUserType(), user.getCardNo());
		return 0;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User detail(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> list(String parentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
