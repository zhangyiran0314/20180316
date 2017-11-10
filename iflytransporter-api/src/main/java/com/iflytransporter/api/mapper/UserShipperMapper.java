package com.iflytransporter.api.mapper;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.api.bean.UserShipper;

public interface UserShipperMapper {
	
	//根据mobile查询
	UserShipper selectByMobile(@Param("mobile")String mobile);
	//根据mobile和密码查询用户
	UserShipper selectByMobileAndPassword(@Param("mobile")String mobile,@Param("password")String password);
	//修改当前登录信息
	int updateLoginInfo(UserShipper record);
	
    int deleteByPrimaryKey(String id);

    int insert(UserShipper record);

    int insertSelective(UserShipper record);

    UserShipper selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserShipper record);

    int updateByPrimaryKey(UserShipper record);
}