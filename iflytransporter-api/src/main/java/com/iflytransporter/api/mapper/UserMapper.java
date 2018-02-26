package com.iflytransporter.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;

public interface UserMapper {
	//根据mobile查询用户是否注册
	public int queryRegisterByMobile(@Param("countryCode")String countryCode,@Param("userType")Integer userType,@Param("mobile")String mobile);
	//根据mobile查询
	User selectByMobile(@Param("countryCode")String countryCode,@Param("userType")Integer userType,@Param("mobile")String mobile);
	//根据mobile和密码查询用户
	User selectByMobileAndPassword(@Param("countryCode")String countryCode,@Param("userType")Integer userType,
			@Param("mobile")String mobile,@Param("password")String password);
	//修改当前登录信息
	int updateLoginInfo(User record);
	
	//查询用户详情
	public UserBO selectByPrimaryKeyBO(String id);
	
	//查看下级列表
	public List<Map<String,Object>> listDown(String parentId);
	
	//查看下级列表
	public List<Map<String,Object>> listDownByTransporter(String parentId);
		
	
	//修改认证状态
	int updateAuthStatus(@Param("id")String id,@Param("authStatus")Integer authStatus,@Param("companyAuthStatus")Integer companyAuthStatus);
	
	//修改用户公司信息
	int updateCompany(@Param("id")String id,@Param("companyId")String companyId,@Param("companyAuthStatus")Integer companyAuthStatus);
	
	//删除下级
	int deleteDown(@Param("id")String id,@Param("parentId")String parentId);
	
	//解除上级绑定
	int deleteUp(@Param("id")String id,@Param("upId")String upId);
	
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
	int updatePwdOrMobileOrEmail(@Param("id")String userId,@Param("password")String password,@Param("mobile")String mobile,@Param("email")String email);
}