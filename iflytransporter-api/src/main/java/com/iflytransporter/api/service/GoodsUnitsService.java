package com.iflytransporter.api.service;

import java.util.List;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.common.bean.GoodsUnits;

public interface GoodsUnitsService  {
	
	List<GoodsUnits> queryAll();
	
	CommonParam queryCommonParam(String id);
}
