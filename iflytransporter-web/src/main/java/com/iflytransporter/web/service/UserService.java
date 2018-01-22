package com.iflytransporter.web.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.User;

public interface UserService {
	//获取对象
	User selectOne(String id);
	//详情查询
	Map<String,Object> queryDetail(String id);
	
	//分页查询
	PageInfo<User> queryPage(Integer pageNo,Integer pageSize,Integer userType,String mobile);
	
	int updateUser(User user);
}
