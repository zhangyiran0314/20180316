package com.iflytransporter.api.service;

import com.iflytransporter.common.bean.Transporter;

public interface TransporterService  {
	//通过mobile查询用户
	public Transporter queryByMobile(String countryCode,String mobile);
	//注册
	public int register(Transporter record);
	//修改登录信息
	public int updateLoginInfo(Transporter record);
	//通过账户密码查询用户
	public Transporter login(String countryCode,String mobile,String password);
	
}
