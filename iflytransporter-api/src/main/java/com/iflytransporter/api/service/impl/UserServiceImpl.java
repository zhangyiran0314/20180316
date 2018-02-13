package com.iflytransporter.api.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.iflytransporter.api.mapper.UserMapper;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.api.utils.UUIDUtil;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;
import com.iflytransporter.common.enums.BuzExceptionEnums;
import com.iflytransporter.common.enums.Status;
import com.iflytransporter.common.exception.ServiceException;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
    private RedisTemplate<String, String> redisTemplate;//注入redis缓存
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User queryByMobile(String countryCode,Integer userType,String mobile) {
		return userMapper.selectByMobile(countryCode,userType,mobile);
	}

	@Override
	public int register(User record) {
		return userMapper.insert(record);
	}

	@Override
	public int updateLoginInfo(User record) {
		return userMapper.updateLoginInfo(record);
	}

	@Override
	public User login(String countryCode,Integer userType,String mobile, String password) {
		return userMapper.selectByMobileAndPassword(countryCode,userType,mobile, password);
	}

	@Override
	public String addDown(User user) throws ServiceException{
		
		User userDown = userMapper.selectByMobile(user.getCountryCode(), user.getUserType(), user.getMobile());
		//员工不存在,添加员工信息并设置权限
		if(userDown == null){
			user.setId(UUIDUtil.UUID());
			user.setLevel(Status.User_Level_Staff);
			user.setAuthStatus(Status.Auth_No);
			user.setCompanyAuthStatus(Status.Auth_Yes);
			int result = userMapper.insert(user);
			if(result > 0){
				return user.getId();
			}
		}
		//用户存在且为管理员,不允许被绑定
		if(Status.User_Level_Admin == userDown.getLevel().intValue()){
			throw new ServiceException(BuzExceptionEnums.AdminCannotBind);
		}
		//用户存在且已经被绑定,不允许重复绑定
		if(StringUtils.isNotBlank(userDown.getParentId()) && !userDown.getParentId().equals(user.getParentId()) ){
			throw new ServiceException(BuzExceptionEnums.StaffCannotRepeatBind);
		}
		//员工存在
		userDown.setLevel(Status.User_Level_Staff);
		userDown.setParentId(user.getParentId());
		//userDown.setAuthStatus(Status.Auth_No);
		userDown.setCompanyAuthStatus(Status.Auth_Yes);
		userDown.setCompanyId(user.getCompanyId());
		int result =  userMapper.updateByPrimaryKeySelective(userDown);
		if(result > 0){
			return userDown.getId();
		}
		return null;
	}

	@Override
	public int update(User user) {
		/*int result = userMapper.updateByPrimaryKeySelective(user);
		if(result > 0 ){
			return userMapper.selectByPrimaryKeyBO(user.getId());
		}
		return null;*/
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int auth(User user) {
		/*if(user!=null && user.getAttachmentId1()!=null && user.getAttachmentId2()!=null && user.getAttachmentId3()!=null){
			int result = userMapper.updateByPrimaryKeySelective(user);
			return result ;
		}*/
		user.setAuthStatus(Status.Auth_Pending);
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public UserBO queryBO(String id) {
		return userMapper.selectByPrimaryKeyBO(id);
	}

	@Override
	public int updateDown(String userId,User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public UserBO detailDown(String userId,String downId) {
		UserBO user = userMapper.selectByPrimaryKeyBO(downId);
		if(user==null || StringUtils.isBlank(user.getParentId()) || !user.getParentId().equals(userId)){
			return null;
		}
		return user;
	}

	@Override
	public List<User> listDown(String parentId) {
		return userMapper.listDown(parentId);
	}

	@Override
	public int deleteDown(String userId, String downId) {
		return userMapper.deleteDown(downId, userId);
	}

	@Override
	public User detailUp(String id) {
		User user = userMapper.selectByPrimaryKey(id);
		if(user==null || StringUtils.isBlank(user.getParentId())){
			return null;
		}
		return userMapper.selectByPrimaryKey(user.getParentId());
	}

	@Override
	public int deleteUp(String id, String upId) {
		return userMapper.deleteUp(id, upId);
	}

	@Override
	public UserBO detailByCache(String id) {
		return userMapper.selectByPrimaryKeyBO(id);//测试阶段不采用缓存
		/*try{
			boolean hasKey = redisTemplate.hasKey(id);
			if(hasKey){
				ValueOperations<String, String> operations=redisTemplate.opsForValue();
				String jsonString = operations.get(id);
				UserBO user= JSONObject.parseObject(jsonString, UserBO.class);
				return user;
			}
			UserBO user = userMapper.selectByPrimaryKeyBO(id);
			String result = JSONObject.toJSONString(user);
			//存放到redis缓存
			ValueOperations<String, String> operations=redisTemplate.opsForValue();
			operations.set(id, result, 5, TimeUnit.DAYS);//保存五天
			return user;
		}catch(Exception e){
			return null;
		} */
		
	}

	@Override
	public int updatePwdOrMobileOrEmail(String userId, String pwd, String mobile, String email) {
		return userMapper.updatePwdOrMobileOrEmail(userId, pwd, mobile, email);
	}

	@Override
	public User detailUserByCache(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

}
