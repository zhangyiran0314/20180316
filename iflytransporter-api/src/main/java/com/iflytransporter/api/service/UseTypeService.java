package com.iflytransporter.api.service;

import java.util.List;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.common.bean.UseType;

public interface UseTypeService  {
	
	List<UseType> queryAll();

	CommonParam queryCommonParam(String id);
	
}
