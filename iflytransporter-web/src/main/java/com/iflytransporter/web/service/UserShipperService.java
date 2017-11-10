package com.iflytransporter.web.service;

import com.iflytransporter.web.bean.UserShipper;

public interface UserShipperService  {
	//通过mobile查询用户
	public UserShipper queryByMobile(String mobile);
	//注册
	public int register(UserShipper record);
	//修改登录信息
	public int updateLoginInfo(UserShipper record);
	//通过账户密码查询用户
	public UserShipper login(String mobile,String password);
	
}
