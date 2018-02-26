package com.iflytransporter.api.service;

import java.util.List;
import java.util.Map;

import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;
import com.iflytransporter.common.exception.ServiceException;

public interface UserService  {
	//通过mobile查询用户
	public User queryByMobile(String countryCode,Integer userType,String mobile);
	//通过mobile查询用户是否注册
	public int queryRegisterByMobile(String countryCode,Integer userType,String mobile);
	//注册
	public int register(User record);
	//修改登录信息
	public int updateLoginInfo(User record);
	//通过账户密码查询用户
	public User login(String countryCode,Integer userType,String mobile,String password);
	/**
	 * 通过缓存查询userBO
	 * @param id
	 * @return
	 */
	public UserBO detailBOByCache(String id);
	/**
	 * 通过缓存查询user
	 * @param id
	 * @return
	 */
	public User detailByCache(String id);
	
	//认证个人
	public int auth(User user) ;
	//查看个人信息
	public UserBO queryBO(String id);
	//修改个人信息
	public int update(User user);
	//添加下级
	public String addDown(User user) throws ServiceException;
	//修改下级
	public int updateDown(String userId,User user);
	//查看下级
	public User detailDown(String userId,String downId);
	//删除下级
	public int deleteDown(String userId,String downId);
	//查看下级列表
	public List<Map<String,Object>> listDown(String parentId);
	
	public List<Map<String,Object>> listDownByTransporter(String parentId);
	//查看上级
	public User detailUp(String id);
	//解除上级绑定
	public int deleteUp(String id,String upId);
	
	//更改密码/手机号码/邮箱
	int updatePwdOrMobileOrEmail(String userId,String pwd,String mobile,String email);
	
}
