package com.iflytransporter.web.mapper;

import java.util.Map;

public interface CommonMapper {
	
	Map<String,Object> queryProvince(String id);
	
	Map<String,Object> queryCity(String id);
	
	Map<String,Object> queryArea(String id);
	
	Map<String,Object> queryCarType(String id);
	
	Map<String,Object> queryHandlingType(String id);
	
	Map<String,Object> queryPaymentType(String id);
	
	Map<String,Object> queryUseType(String id);
}
