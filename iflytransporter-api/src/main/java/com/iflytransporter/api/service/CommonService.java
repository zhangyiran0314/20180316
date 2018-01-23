package com.iflytransporter.api.service;

import java.util.List;
import java.util.Map;

import com.iflytransporter.api.bean.CommonParam;

public interface CommonService {
	
	CommonParam queryProvince(String lang,String id);
	
	CommonParam queryCity(String lang,String id);
	
	CommonParam queryArea(String lang,String id);
	
	CommonParam queryCarType(String lang,String id);
	
	CommonParam queryHandlingType(String lang,String id);
	
	CommonParam queryPaymentType(String lang,String id);
	
	CommonParam queryUseType(String lang,String id);
	
	List<Map<String,Object>> listUseType(String lang);
	List<Map<String,Object>> listCarType(String lang);
	List<Map<String,Object>> listHandlingType(String lang);
	List<Map<String,Object>> listPaymentType(String lang);
	List<Map<String,Object>> listGoodsType(String lang);
}
