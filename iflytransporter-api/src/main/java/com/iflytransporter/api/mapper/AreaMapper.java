package com.iflytransporter.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Area;

public interface AreaMapper {
	
//	List<Area> queryAll(@Param("cityId")String cityId);
	
	List<Area> queryAll(@Param("countryCode") String countryCode,@Param("cityId")String cityId);
}