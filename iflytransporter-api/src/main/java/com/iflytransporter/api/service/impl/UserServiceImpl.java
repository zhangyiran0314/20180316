package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.UserMapper;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;

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
	public int addDown(User user) {
		return 0;
	}

	@Override
	public User update(User user) {
		int result = userMapper.updateByPrimaryKeySelective(user);
		if(result >0 ){
			return userMapper.selectByPrimaryKeyBO(user.getId());
		}
		return null;
	}

	@Override
	public UserBO auth(User user) {
		if(user!=null && user.getAttachmentId1()!=null && user.getAttachmentId2()!=null && user.getAttachmentId3()!=null){
			int result = userMapper.updateByPrimaryKeySelective(user);
			if(result >0 ){
				return userMapper.selectByPrimaryKeyBO(user.getId());
			}
		}
		return null;
	}

	@Override
	public UserBO queryBO(String id) {
		return userMapper.selectByPrimaryKeyBO(id);
	}

	@Override
	public User updateDown(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User detailDown(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listDown(String parentId) {
		return userMapper.listDown(parentId);
	}

}
