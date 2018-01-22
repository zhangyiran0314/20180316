package com.iflytransporter.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;
import com.iflytransporter.web.mapper.UserMapper;
import com.iflytransporter.web.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;


	@Override
	public PageInfo<User> queryPage(Integer pageNo, Integer pageSize, Integer userType, String mobile) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<User> list= userMapper.queryAll(userType,mobile);
		return new PageInfo<User>(list);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}


	@Override
	public User selectOne(String id) {
		return userMapper.selectByPrimaryKey(id);
	}


	@Override
	public Map<String, Object> queryDetail(String id) {
		return userMapper.queryDetail(id);
	}

}
