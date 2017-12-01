package com.iflytransporter.api.mapper;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.User;

public interface UserMapper {
	
	//根据mobile查询
	User selectByMobile(@Param("countryCode")String countryCode,@Param("userType")Integer userType,@Param("mobile")String mobile);
	//根据mobile和密码查询用户
	User selectByMobileAndPassword(@Param("countryCode")String countryCode,@Param("userType")Integer userType,
			@Param("mobile")String mobile,@Param("password")String password);
	//修改当前登录信息
	int updateLoginInfo(User record);
	
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}