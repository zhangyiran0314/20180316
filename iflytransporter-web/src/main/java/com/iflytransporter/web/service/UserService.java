package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;

public interface UserService {
	//详情查询
	User queryDetail(String id);
	
	UserBO queryDetailBO(String id);
	//分页查询
	PageInfo<UserBO> queryPage(Integer pageNo,Integer pageSize,Integer userType,String mobile);
	
	int updateUser(User user);
}
