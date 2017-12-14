package com.iflytransporter.api.service;

import java.util.List;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.common.bean.CarType;

public interface CarTypeService  {
	
	List<CarType> queryAll();
	
	CommonParam queryCommonParam(String id);
}
