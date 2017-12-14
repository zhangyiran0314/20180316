package com.iflytransporter.api.service;

import java.util.List;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.common.bean.HandlingType;

public interface HandlingTypeService  {
	
	List<HandlingType> queryAll();
	
	CommonParam queryCommonParam(String id);
}
