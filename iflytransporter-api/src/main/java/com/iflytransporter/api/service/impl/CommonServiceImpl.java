package com.iflytransporter.api.service.impl;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.api.mapper.CommonMapper;
import com.iflytransporter.api.service.CommonService;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
	
	public static String Lang_China ="zh-cn";
	public static String Lang_English ="en";
	public static String Lang_Maya="maya";
	
	public static Locale mayaLocale =  new Locale("ma", "MAYA");  
	@Autowired
	private CommonMapper commonMapper;
	
	@Autowired
	private  MessageSource messageSource;
	
	@Override
	public CommonParam queryProvince(String lang, String id) {
		Map<String,String> map = commonMapper.queryProvince(id);
		return getMessage(lang,map);
	}

	@Override
	public CommonParam queryCity(String lang, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonParam queryArea(String lang, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonParam queryCarType(String lang, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonParam queryHandlingType(String lang, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonParam queryPaymentType(String lang, String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CommonParam queryUseType(String lang, String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Map<String, Object>> listUseType(String lang) {
		List<Map<String, String>> map = commonMapper.listUseType();
		return null;
	}

	@Override
	public List<Map<String, Object>> listCarType(String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> listHandlingType(String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> listPaymentType(String lang) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public CommonParam getMessage(String lang,Map<String,String> map){
		CommonParam commonParam = new CommonParam();
		commonParam.setId(map.get("id"));
		if(Lang_China.equals(lang)){
			commonParam.setName(messageSource.getMessage(map.get("code"), null, Locale.SIMPLIFIED_CHINESE));
			return commonParam;
		}
		if(Lang_English.equals(lang)){
			commonParam.setName(messageSource.getMessage(map.get("code"), null, Locale.US));
			return commonParam;
		}
		if(Lang_Maya.equals(lang)){
			commonParam.setName(messageSource.getMessage(map.get("code"), null, mayaLocale));
			return commonParam;
		}
		commonParam.setName(messageSource.getMessage(map.get("code"), null, null, Locale.US));
		return commonParam;
	}

	public void getMessage(String lang,List<Map<String,Object>> list){
		if(Lang_China.equals(lang)){
			for(Map<String,Object> map :list){
				map.put("name", messageSource.getMessage(map.get("code").toString(), null, Locale.SIMPLIFIED_CHINESE));
			}
		}
		if(Lang_English.equals(lang)){
			for(Map<String,Object> map :list){
				map.put("name",(messageSource.getMessage(map.get("code").toString(), null, Locale.US)));
			}
		}
		if(Lang_Maya.equals(lang)){
			for(Map<String,Object> map :list){
				map.put("name",(messageSource.getMessage(map.get("code").toString(), null, mayaLocale)));
			}
		}
		/*for(Map<String,Object> map :list){
			map.put("name",(messageSource.getMessage(map.get("code").toString(), null, null, Locale.US)));
		}*/
	}
}
