package com.iflytransporter.api.mapper;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Transporter;

public interface TransporterMapper {
	
	//根据mobile查询
	Transporter selectByMobile(@Param("countryCode")String countryCode,@Param("mobile")String mobile);
	//根据mobile和密码查询用户
	Transporter selectByMobileAndPassword(@Param("countryCode")String countryCode,@Param("mobile")String mobile,@Param("password")String password);
	//修改当前登录信息
	int updateLoginInfo(Transporter record);
	
    int deleteByPrimaryKey(String id);

    int insert(Transporter record);

    int insertSelective(Transporter record);

    Transporter selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Transporter record);

    int updateByPrimaryKey(Transporter record);
}