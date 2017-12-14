package com.iflytransporter.api.service;

import java.util.List;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.common.bean.Insurance;

public interface InsuranceService  {
	
	List<Insurance> queryAll();
	
	CommonParam queryCommonParam(String id);
}
