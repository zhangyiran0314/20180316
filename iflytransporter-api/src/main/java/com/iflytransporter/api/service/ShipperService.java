package com.iflytransporter.api.service;

import com.iflytransporter.common.bean.Shipper;

public interface ShipperService  {
	//通过mobile查询用户
	public Shipper queryByMobile(String countryCode,String mobile);
	//注册
	public int register(Shipper record);
	//修改登录信息
	public int updateLoginInfo(Shipper record);
	//通过账户密码查询用户
	public Shipper login(String countryCode,String mobile,String password);
	
}
