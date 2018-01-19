package com.iflytransporter.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Car;

public interface CarMapper {
	
	List<Map<String,Object>> queryAll(@Param("code")String code,@Param("companyName")String companyName,@Param("transporterMobile")String transporterMobile,@Param("driverMobile")String driverMobile);
	
	Map<String,Object> queryDetail(String id);
	
    int deleteByPrimaryKey(String id);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
}