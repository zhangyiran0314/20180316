package com.iflytransporter.api.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.User;

public interface UserService  {
	//通过mobile查询用户
	public User queryByMobile(String countryCode,Integer userType,String mobile);
	//注册
	public int register(User record);
	//修改登录信息
	public int updateLoginInfo(User record);
	//通过账户密码查询用户
	public User login(String countryCode,Integer userType,String mobile,String password);
	
	//添加下级
	public int add(User user);
	//修改下级
	public int update(User user);
	//查看下级
	public User detail(String id);
	//查看下级列表
	public List<User> list(String parentId);
	
}
