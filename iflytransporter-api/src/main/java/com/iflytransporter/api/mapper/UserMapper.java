package com.iflytransporter.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;

public interface UserMapper {
	
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
	public List<User> listDown(String parentId);
	
	//修改用户公司信息
	int updateCompany(@Param("id")String id,@Param("companyId")String companyId);
	
	
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}