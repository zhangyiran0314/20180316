package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.UseType;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;
import com.iflytransporter.web.mapper.UserMapper;
import com.iflytransporter.web.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public User queryDetail(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public UserBO queryDetailBO(String id) {
		return userMapper.selectByPrimaryKeyBO(id);
	}

	@Override
	public PageInfo<UserBO> queryPage(Integer pageNo, Integer pageSize, Integer userType, String mobile) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<UserBO> list= userMapper.queryAll(userType,mobile);
		return new PageInfo<UserBO>(list);
	}

}
