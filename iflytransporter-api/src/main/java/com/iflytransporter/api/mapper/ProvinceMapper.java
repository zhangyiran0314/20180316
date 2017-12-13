package com.iflytransporter.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.common.bean.Province;

public interface ProvinceMapper {
	
//	List<Province> queryAll();
	
	List<Province> queryAll(@Param("countryCode")String countryCode);
	
	/**
	 * 查询通用参数
	 * @param id
	 * @return
	 */
	CommonParam queryCommonParam(String id);
}