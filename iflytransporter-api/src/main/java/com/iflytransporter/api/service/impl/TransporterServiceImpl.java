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
import com.iflytransporter.common.enums.BuzExceptionEnums;
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
		//用户存在且为管理员,不允许被绑定
		if(Status.User_Level_Admin == userDown.getLevel().intValue()){
			throw new ServiceException(BuzExceptionEnums.AdminCannotBind);
		}
		//用户存在且已经被绑定,不允许重复绑定
		if(StringUtils.isNotBlank(userDown.getParentId()) && !userDown.getParentId().equals(user.getParentId()) ){
			throw new ServiceException(BuzExceptionEnums.StaffCannotRepeatBind);
		}
		//员工存在
		userDown.setCompanyId(user.getCompanyId());
		userDown.setParentId(user.getParentId());
		userDown.setUserType(Status.Type_User_Transporter);
		userDown.setLevel(Status.User_Level_Staff);
//		userDown.setAuthStatus(Status.Auth_No);
		userDown.setCompanyAuthStatus(Status.Auth_Yes);
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
		if(user.getGdl()!=null && !user.getGdl().equals(userTemp.getGdl())){
			user.setAuthStatus(Status.Auth_Pending);
		}
		if(user.getDrivingLicenseNo()!=null && !user.getDrivingLicenseNo().equals(userTemp.getDrivingLicenseNo())){
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
		if(user.getAttachmentId4()!=null && !user.getAttachmentId4().equals(userTemp.getAttachmentId4())){
			user.setAuthStatus(Status.Auth_Pending);
		}
		if(user.getAttachmentId5()!=null && !user.getAttachmentId5().equals(userTemp.getAttachmentId5())){
			user.setAuthStatus(Status.Auth_Pending);
		}
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
