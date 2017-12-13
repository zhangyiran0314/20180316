package com.iflytransporter.api.mapper;

import java.util.List;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.common.bean.GoodsUnits;

public interface GoodsUnitsMapper {
	
	List<GoodsUnits> queryAll();
	
	
	/**
	 * 查询通用参数
	 * @param id
	 * @return
	 */
	CommonParam queryCommonParam(String id);
}