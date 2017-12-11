package com.iflytransporter.api.mapper;

import java.util.List;

import com.iflytransporter.common.bean.GoodsType;
import com.iflytransporter.common.bean.HandlingType;

public interface HandlingTypeMapper {
	
	List<HandlingType> queryAll();
	
}