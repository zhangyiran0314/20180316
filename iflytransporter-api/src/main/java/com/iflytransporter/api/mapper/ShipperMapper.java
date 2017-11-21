package com.iflytransporter.api.mapper;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Shipper;

public interface ShipperMapper {
	
	//根据mobile查询
	Shipper selectByMobile(@Param("countryCode")String countryCode,@Param("mobile")String mobile);
	//根据mobile和密码查询用户
	Shipper selectByMobileAndPassword(@Param("countryCode")String countryCode,@Param("mobile")String mobile,@Param("password")String password);
	//修改当前登录信息
	int updateLoginInfo(Shipper record);
	
    int deleteByPrimaryKey(String id);

    int insert(Shipper record);

    int insertSelective(Shipper record);

    Shipper selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Shipper record);

    int updateByPrimaryKey(Shipper record);
}