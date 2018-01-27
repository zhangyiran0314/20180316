package com.iflytransporter.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Province;

public interface CommonMapper {
	
	List<Map<String,Object>> queryProvinceAll(@Param("countryCode")String countryCode);
	List<Map<String,Object>> queryCityAll(@Param("countryCode")String countryCode,@Param("provinceId")String provinceId);
	List<Map<String,Object>> queryAreaAll(@Param("countryCode")String countryCode,@Param("cityId")String cityId);
	
	Map<String,Object> queryProvince(String id);
	
	Map<String,Object> queryCity(String id);
	
	Map<String,Object> queryArea(String id);
	
	Map<String,Object> queryCarType(String id);
	
	Map<String,Object> queryHandlingType(String id);
	
	Map<String,Object> queryPaymentType(String id);
	
	Map<String,Object> queryUseType(String id);
	
	List<Map<String,Object>> listUseType();
	List<Map<String,Object>> listCarType();
	List<Map<String,Object>> listHandlingType();
	List<Map<String,Object>> listPaymentType();
	List<Map<String,Object>> listGoodsType();
	
	
}
