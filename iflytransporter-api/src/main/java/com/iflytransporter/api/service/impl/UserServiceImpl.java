package com.iflytransporter.api.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
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
import com.iflytransporter.common.utils.RedisUtil;

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
		if(StringUtils.isNotBlank(userDown.getParentId()) && userDown.getParentId().equals(user.getParentId()) ){
			throw new ServiceException(BuzExceptionEnums.StaffAlreadyBind);
		}
		//用户存在且已经被绑定,不允许重复绑定
		if(StringUtils.isNotBlank(userDown.getParentId()) && !userDown.getParentId().equals(user.getParentId()) ){
			throw new ServiceException(BuzExceptionEnums.StaffCannotRepeatBind);
		}
		//员工存在
		userDown.setLevel(Status.User_Level_Staff);
		userDown.setParentId(user.getParentId());
		userDown.setUserType(user.getUserType());
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
		User userTemp = userMapper.selectByPrimaryKey(user.getId());
		if(!userTemp.getSurname().equals(user.getSurname())){
			user.setAuthStatus(Status.Auth_Pending);
		}
		if(!userTemp.getName().equals(user.getName())){
			user.setAuthStatus(Status.Auth_Pending);
		}
		if(!userTemp.getCardNo().equals(user.getCardNo())){
			user.setAuthStatus(Status.Auth_Pending);
		}
		if(user.getAttachmentId1()!=null && !user.getAttachmentId1().equals(userTemp.getAttachmentId1())){
			user.setAuthStatus(Status.Auth_Pending);
		}
		if(user.getAttachmentId2()!=null && !user.getAttachmentId2().equals(userTemp.getAttachmentId2())){
			user.setAuthStatus(Status.Auth_Pending);
		}
		if(user.getAttachmentId3()!=null && !user.getAttachmentId3().equals(userTemp.getAttachmentId3())){
			user.setAuthStatus(Status.Auth_Pending);
		}
		//车主相关
		if(user.getGdl()!=null && !user.getGdl().equals(userTemp.getGdl())){
			user.setAuthStatus(Status.Auth_Pending);
		}
		if(user.getDrivingLicenseNo()!=null && !user.getDrivingLicenseNo().equals(userTemp.getDrivingLicenseNo())){
			user.setAuthStatus(Status.Auth_Pending);
		}
		if(user.getAttachmentId4()!=null && !user.getAttachmentId4().equals(userTemp.getAttachmentId4())){
			user.setAuthStatus(Status.Auth_Pending);
		}
		if(user.getAttachmentId5()!=null && !user.getAttachmentId5().equals(userTemp.getAttachmentId5())){
			user.setAuthStatus(Status.Auth_Pending);
		}
		user.setUpdateDate(new Date());
		int result  =userMapper.updateByPrimaryKeySelective(user);
		if(result > 0){
			deleteCache(user.getId());
		}
		return result;
	}

	@Override
	public int auth(User user) {
		/*if(user!=null && user.getAttachmentId1()!=null && user.getAttachmentId2()!=null && user.getAttachmentId3()!=null){
			int result = userMapper.updateByPrimaryKeySelective(user);
			return result ;
		}*/
		user.setAuthStatus(Status.Auth_Pending);
		int result =  userMapper.updateByPrimaryKeySelective(user);
		if(result > 0){
			deleteCache(user.getId());
		}
		return result;
	}

	@Override
	public UserBO queryBO(String id) {
		return this.detailBOByCache(id);
	}

	@Override
	public int updateDown(String userId,User user) {
		int result  = userMapper.updateByPrimaryKeySelective(user);
		if(result > 0){
			deleteCache(userId);
		}
		return result;
	}

	@Override
	public UserBO detailDown(String userId,String downId) {
		UserBO user = this.detailBOByCache(downId);
		if(user==null || StringUtils.isBlank(user.getParentId()) || !user.getParentId().equals(userId)){
			return null;
		}
		return user;
	}

	@Override
	public List<Map<String,Object>> listDown(String parentId) {
		return userMapper.listDown(parentId);
	}

	@Override
	public int deleteDown(String userId, String downId) {
		return userMapper.deleteDown(downId, userId);
	}

	@Override
	public User detailUp(String id) {
		User user =this.detailByCache(id);
		if(user==null || StringUtils.isBlank(user.getParentId())){
			return null;
		}
		return this.detailByCache(user.getParentId());
	}

	@Override
	public int deleteUp(String id, String upId) {
		return userMapper.deleteUp(id, upId);
	}

	@Override
	public UserBO detailBOByCache(String id) {
//		return userMapper.selectByPrimaryKeyBO(id);//测试阶段不采用缓存
		try{
			String key = RedisUtil.getUserBOKey(id);
			boolean hasKey = redisTemplate.hasKey(key);
			if(hasKey){
				ValueOperations<String, String> operations=redisTemplate.opsForValue();
				String jsonString = operations.get(key);
				UserBO user= JSONObject.parseObject(jsonString, UserBO.class);
				return user;
			}
			UserBO user = userMapper.selectByPrimaryKeyBO(id);
			String result = JSONObject.toJSONString(user);
			//存放到redis缓存
			ValueOperations<String, String> operations=redisTemplate.opsForValue();
			operations.set(key, result, 5, TimeUnit.DAYS);//保存五天
			return user;
		}catch(Exception e){
			return null;
		} 
		
	}

	@Override
	public int updatePwdOrMobileOrEmail(String userId, String pwd, String mobile, String email) {
		int result = userMapper.updatePwdOrMobileOrEmail(userId, pwd, mobile, email);
		if(result >0 ){
			deleteCache(userId);
		}
		return result;
	}

	@Override
	public User detailByCache(String id) {
		try{
			String key = RedisUtil.getUserKey(id);
			boolean hasKey = redisTemplate.hasKey(key);
			if(hasKey){
				ValueOperations<String, String> operations=redisTemplate.opsForValue();
				String jsonString = operations.get(key);
				UserBO user= JSONObject.parseObject(jsonString, UserBO.class);
				return user;
			}
			UserBO user = userMapper.selectByPrimaryKeyBO(id);
			String result = JSONObject.toJSONString(user);
			//存放到redis缓存
			ValueOperations<String, String> operations=redisTemplate.opsForValue();
			operations.set(key, result, 5, TimeUnit.DAYS);//保存五天
			return user;
		}catch(Exception e){
			return null;
		} 
	}

	@Override
	public List<Map<String, Object>> listDownByTransporter(String parentId) {
		return userMapper.listDownByTransporter(parentId);
	}
	
	//刷新用户缓存
	private void deleteCache(String userId){
		String key = RedisUtil.getUserBOKey(userId);
		redisTemplate.delete(key);
	}
}
