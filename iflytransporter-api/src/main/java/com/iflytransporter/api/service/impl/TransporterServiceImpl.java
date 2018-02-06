package com.iflytransporter.api.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.TransporterMapper;
import com.iflytransporter.api.mapper.UserMapper;
import com.iflytransporter.api.service.TransporterService;
import com.iflytransporter.api.utils.UUIDUtil;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;
import com.iflytransporter.common.enums.Status;
import com.iflytransporter.common.exception.ServiceException;

@Service("transporterService")
public class TransporterServiceImpl implements TransporterService{

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private TransporterMapper transporterMapper;
	
	@Override
	public String addDown(User user) throws ServiceException{
		
		User userDown = userMapper.selectByMobile(user.getCountryCode(), user.getUserType(), user.getMobile());
		//员工不存在,添加员工信息并设置权限
		if(userDown == null){
			user.setId(UUIDUtil.UUID());
			user.setLevel(Status.User_Level_Staff);
			user.setAuthStatus(Status.Auth_No);
			user.setCompanyAuthStatus(Status.Auth_Yes);
			user.setUserType(Status.Type_User_Transporter);
			int result = userMapper.insert(user);
			if(result > 0){
				return user.getId();
			}
		}
		//员工存在
		userDown.setCompanyId(user.getCompanyId());
		userDown.setParentId(user.getParentId());
		userDown.setUserType(user.getUserType());
		userDown.setUserType(Status.Type_User_Transporter);
		userDown.setLevel(Status.User_Level_Staff);
		userDown.setAuthStatus(Status.Auth_No);
		userDown.setCompanyAuthStatus(Status.Auth_Yes);
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
	public List<Map<String,Object>> listDown(String parentId) {
		return transporterMapper.listDown(parentId);
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
	public int updatePwdOrMobileOrEmail(String userId, String pwd, String mobile, String email) {
		return userMapper.updatePwdOrMobileOrEmail(userId, pwd, mobile, email);
	}

	
}
