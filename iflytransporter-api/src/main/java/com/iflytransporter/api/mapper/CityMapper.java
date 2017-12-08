package com.iflytransporter.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.City;

public interface CityMapper {
	
//	List<City> queryAll(@Param("provinceId")String provinceId);
	
	List<City> queryAll(@Param("countryCode")String countryCode,@Param("provinceId")String provinceId);
}