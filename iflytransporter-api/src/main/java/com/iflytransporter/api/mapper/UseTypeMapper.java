package com.iflytransporter.api.mapper;

import java.util.List;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.common.bean.UseType;

public interface UseTypeMapper {
	
	List<UseType> queryAll();
	
	/**
	 * 查询通用参数
	 * @param id
	 * @return
	 */
	CommonParam queryCommonParam(String id);
}