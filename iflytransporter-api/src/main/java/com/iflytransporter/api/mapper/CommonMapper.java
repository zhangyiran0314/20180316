package com.iflytransporter.api.mapper;

import java.util.List;
import java.util.Map;

public interface CommonMapper {
	
	Map<String,String> queryProvince(String id);
	
	Map<String,String> queryCity(String id);
	
	Map<String,String> queryArea(String id);
	
	Map<String,String> queryCarType(String id);
	
	Map<String,String> queryHandlingType(String id);
	
	Map<String,String> queryPaymentType(String id);
	
	Map<String,String> queryUseType(String id);
	
	List<Map<String,String>> listUseType();
	List<Map<String,String>> listCarType();
	List<Map<String,String>> listHandlingType();
	List<Map<String,String>> listPaymentType();
}
