package com.iflytransporter.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.common.bean.Insurance;

public interface InsuranceMapper {
	
	List<Map<String,Object>> listWaybillByUserId(@Param("userId")String userId);
	
	int insert(Insurance record);
	 
	List<Insurance> queryAll();
	/**
	 * 查询通用参数
	 * @param id
	 * @return
	 */
	CommonParam queryCommonParam(String id);
}