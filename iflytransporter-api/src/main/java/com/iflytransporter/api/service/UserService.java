package com.iflytransporter.api.service;

import java.util.List;

import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;

public interface UserService  {
	//通过mobile查询用户
	public User queryByMobile(String countryCode,Integer userType,String mobile);
	//注册
	public int register(User record);
	//修改登录信息
	public int updateLoginInfo(User record);
	//通过账户密码查询用户
	public User login(String countryCode,Integer userType,String mobile,String password);
	//
	public UserBO detailByCache(String id);
	
	//认证个人
	public User auth(User user) ;
	//查看个人信息
	public User queryBO(String id);
	//修改个人信息
	public User update(User user);
	//添加下级
	public User addDown(User user);
	//修改下级
	public User updateDown(String userId,User user);
	//查看下级
	public User detailDown(String userId,String downId);
	//删除下级
	public int deleteDown(String userId,String downId);
	//查看下级列表
	public List<User> listDown(String parentId);
	//查看上级
	public User detailUp(String id);
	//解除上级绑定
	public int deleteUp(String id,String upId);
	
	
}
