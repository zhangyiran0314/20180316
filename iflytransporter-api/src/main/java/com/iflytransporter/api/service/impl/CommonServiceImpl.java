package com.iflytransporter.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.api.mapper.CommonMapper;
import com.iflytransporter.api.service.CommonService;
import com.iflytransporter.api.utils.RedisUtil;
import com.iflytransporter.common.bean.Area;
import com.iflytransporter.common.bean.City;
import com.iflytransporter.common.bean.Position;
import com.iflytransporter.common.bean.Province;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
	
	
	public static String Lang_China ="zh";
	public static String Lang_English ="en";
	public static String Lang_Maya="my";
	
	public static Locale myLocale =  new Locale("en", "MY");  
	@Autowired
	private CommonMapper commonMapper;
	
	@Autowired
	private  MessageSource messageSource;
	
	@Autowired
    private RedisTemplate<String, Object> redisTemplate;//注入redis缓存
	
	@Override
	public CommonParam queryProvince(String lang, String id) {
		HashOperations<String, String, Object>  hash =  redisTemplate.opsForHash();
		Map<String, Object> map = hash.entries(RedisUtil.getPositionKey(RedisUtil.Redis_Position_Province,id));
		if(map== null || map.isEmpty()){
			map =  commonMapper.queryProvince(id);
			 hash.putAll(RedisUtil.getPositionKey(RedisUtil.Redis_Position_Province,id), map);
		}
		return getMessage(lang,map);
	}

	@Override
	public CommonParam queryCity(String lang, String id) {
		HashOperations<String, String, Object>  hash =  redisTemplate.opsForHash();
		Map<String, Object> map = hash.entries(RedisUtil.getPositionKey(RedisUtil.Redis_Position_City,id));
		if(map== null || map.isEmpty()){
			map =  commonMapper.queryCity(id);
			 hash.putAll(RedisUtil.getPositionKey(RedisUtil.Redis_Position_City,id), map);
		}
		return getMessage(lang,map);
	}

	@Override
	public CommonParam queryArea(String lang, String id) {
		HashOperations<String, String, Object>  hash =  redisTemplate.opsForHash();
		Map<String, Object> map = hash.entries(RedisUtil.getPositionKey(RedisUtil.Redis_Position_Area,id));
		if(map== null || map.isEmpty()){
			map =  commonMapper.queryArea(id);
			 hash.putAll(RedisUtil.getPositionKey(RedisUtil.Redis_Position_Area,id), map);
		}
		return getMessage(lang,map);
	}

	@Override
	public CommonParam queryCarType(String lang, String id) {
		HashOperations<String, String, Object>  hash =  redisTemplate.opsForHash();
		Map<String, Object> map = hash.entries(RedisUtil.getTypeKey(RedisUtil.Redis_CarType,id));
		if(map== null || map.isEmpty()){
			map = commonMapper.queryCarType(id);
			 hash.putAll(RedisUtil.getTypeKey(RedisUtil.Redis_CarType,id), map);
		}
		return getMessage(lang,map);
	}

	@Override
	public CommonParam queryHandlingType(String lang, String id) {
		HashOperations<String, String, Object>  hash =  redisTemplate.opsForHash();
		Map<String, Object> map = hash.entries(RedisUtil.getTypeKey(RedisUtil.Redis_HandlingType,id));
		if(map== null || map.isEmpty()){
			map = commonMapper.queryHandlingType(id);
			 hash.putAll(RedisUtil.getTypeKey(RedisUtil.Redis_HandlingType,id), map);
		}
		return getMessage(lang,map);
	}

	@Override
	public CommonParam queryPaymentType(String lang, String id) {
		HashOperations<String, String, Object>  hash =  redisTemplate.opsForHash();
		Map<String, Object> map = hash.entries(RedisUtil.getTypeKey(RedisUtil.Redis_PaymentType,id));
		if(map== null || map.isEmpty()){
			map = commonMapper.queryPaymentType(id);
			 hash.putAll(RedisUtil.getTypeKey(RedisUtil.Redis_PaymentType,id), map);
		}
		return getMessage(lang,map);
	}
	@Override
	public CommonParam queryUseType(String lang, String id) {
		HashOperations<String, String, Object>  hash =  redisTemplate.opsForHash();
		Map<String, Object> map = hash.entries(RedisUtil.getTypeKey(RedisUtil.Redis_UseType,id));
		if(map==null || map.isEmpty()){
			 map = commonMapper.queryUseType(id);
			 hash.putAll(RedisUtil.getTypeKey(RedisUtil.Redis_UseType,id), map);
		}
		return getMessage(lang,map);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> listUseType(String lang) {
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		List<Map<String, Object>> list =  (List<Map<String, Object>>) listOperations.leftPop(RedisUtil.getTypeKey(RedisUtil.Redis_UseType,null));
		if(list == null || list.isEmpty()){
			list =  commonMapper.listUseType();
			listOperations.leftPush(RedisUtil.getTypeKey(RedisUtil.Redis_UseType,null), list);
		}
		getMessage(lang,list);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> listCarType(String lang) {
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		List<Map<String, Object>> list =  (List<Map<String, Object>>) listOperations.leftPop(RedisUtil.getTypeKey(RedisUtil.Redis_CarType,null));
		if(list == null || list.isEmpty()){
			list =  commonMapper.listCarType();
			listOperations.leftPush(RedisUtil.getTypeKey(RedisUtil.Redis_CarType,null), list);
		}
		getMessage(lang,list);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> listHandlingType(String lang) {
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		List<Map<String, Object>> list =  (List<Map<String, Object>>) listOperations.leftPop(RedisUtil.getTypeKey(RedisUtil.Redis_HandlingType,null));
		if(list == null || list.isEmpty()){
			list =  commonMapper.listHandlingType();
			listOperations.leftPush(RedisUtil.getTypeKey(RedisUtil.Redis_HandlingType,null), list);
		}
		getMessage(lang,list);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> listPaymentType(String lang) {
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		List<Map<String, Object>> list =  (List<Map<String, Object>>) listOperations.leftPop(RedisUtil.getTypeKey(RedisUtil.Redis_PaymentType,null));
		if(list == null || list.isEmpty()){
			list =  commonMapper.listPaymentType();
			listOperations.leftPush(RedisUtil.getTypeKey(RedisUtil.Redis_PaymentType,null), list);
		}
		getMessage(lang,list);
		return list;
	}
	@Override
	public List<Map<String, Object>> listGoodsType(String lang) {
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		List<Map<String, Object>> list =  (List<Map<String, Object>>) listOperations.leftPop(RedisUtil.getTypeKey(RedisUtil.Redis_GoodsType,null));
		if(list == null || list.isEmpty()){
			list =  commonMapper.listGoodsType();
			listOperations.leftPush(RedisUtil.getTypeKey(RedisUtil.Redis_GoodsType,null), list);
		}
		getMessage(lang,list);
		return list;
	}
	public CommonParam getMessage(String lang,Map<String,Object> map){
		CommonParam commonParam = new CommonParam();
		commonParam.setId((String)map.get("id"));
		commonParam.setCode((String)map.get("code"));
		if(Lang_China.equals(lang)){
			try{
				commonParam.setName(messageSource.getMessage((String)map.get("code"), null, Locale.SIMPLIFIED_CHINESE));
				return commonParam;
			}catch(NoSuchMessageException e){
				//捕获当前适配属性不存在异常
			}
		}
		if(Lang_English.equals(lang)){
			try{
				commonParam.setName(messageSource.getMessage((String)map.get("code"), null, Locale.US));
				return commonParam;
			}catch(NoSuchMessageException e){
				//捕获当前适配属性不存在异常
			}
		}
		if(Lang_Maya.equals(lang)){
			try{
				commonParam.setName(messageSource.getMessage((String)map.get("code"), null, myLocale));
				return commonParam;
			}catch(NoSuchMessageException e){
				//捕获当前适配属性不存在异常
			}
		}
		if(commonParam.getName()==null){
			commonParam.setName(map.get("name").toString());
		}
		return commonParam;
	}

	public void getMessage(String lang,List<Map<String,Object>> list){
		if(Lang_China.equals(lang)){
			for(Map<String,Object> map :list){
				try{
					map.put("name", messageSource.getMessage((String)map.get("code"), null, Locale.SIMPLIFIED_CHINESE));
				}catch(NoSuchMessageException e){
					//捕获当前适配属性不存在异常
				}
			}
		}
		if(Lang_English.equals(lang)){
			for(Map<String,Object> map :list){
				try{
					map.put("name",(messageSource.getMessage((String)map.get("code"), null, Locale.US)));
				}catch(NoSuchMessageException e){
					//捕获当前适配属性不存在异常
				}
//				map.put("name",(messageSource.getMessage((String)map.get("code"), null, Locale.US)));
			}
		}
		if(Lang_Maya.equals(lang)){
			for(Map<String,Object> map :list){
				try{
					map.put("name",(messageSource.getMessage((String)map.get("code"), null, myLocale)));
				}catch(NoSuchMessageException e){
					//捕获当前适配属性不存在异常
				}
			}
		}
		/*for(Map<String,Object> map :list){
			map.put("name",(messageSource.getMessage(map.get("code").toString(), null, null, Locale.US)));
		}*/
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getPosition(String lang, String countryCode) {
		String key = RedisUtil.getPositionCountryKey(countryCode);
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		List<Map<String, Object>> list = (List<Map<String, Object>>) listOperations.leftPop(key);
		if(list!=null && list.size() > 0){
			return list;
		}
		List<Map<String,Object>> provinceList = commonMapper.queryProvinceAll(countryCode);
		getMessage(lang,provinceList);
		for(Map<String,Object> province :provinceList){
			List<Map<String,Object>> cityList = commonMapper.queryCityAll(countryCode, (String) province.get("id"));
			getMessage(lang,cityList);
			for(Map<String,Object> city:cityList){
				List<Map<String,Object>> areaList = commonMapper.queryAreaAll(countryCode, (String)city.get("id"));
				getMessage(lang,areaList);
				city.put("areaList", areaList);
			}
			province.put("cityList", cityList);
		}
		listOperations.leftPush(key, provinceList);
		return provinceList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> queryProvinceAll(String lang, String countryCode) {
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		List<Map<String, Object>> list =  (List<Map<String, Object>>) listOperations.leftPop(RedisUtil.getPositionKey(RedisUtil.Redis_Position_Province,null));
		if(list == null || list.isEmpty()){
			list =  commonMapper.queryProvinceAll(countryCode);
			listOperations.leftPush(RedisUtil.getPositionKey(RedisUtil.Redis_Position_Province,null), list);
		}
		getMessage(lang,list);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> queryCityAll(String lang, String countryCode,String provinceId) {
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		List<Map<String, Object>> list =  (List<Map<String, Object>>) listOperations.leftPop(RedisUtil.getPositionKey(RedisUtil.Redis_Position_City,null));
		if(list == null || list.isEmpty()){
			list =  commonMapper.queryCityAll(countryCode, provinceId);
			listOperations.leftPush(RedisUtil.getPositionKey(RedisUtil.Redis_Position_City,null), list);
		}
		getMessage(lang,list);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> queryAreaAll(String lang, String countryCode,String cityId) {
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		List<Map<String, Object>> list =  (List<Map<String, Object>>) listOperations.leftPop(RedisUtil.getPositionKey(RedisUtil.Redis_Position_Area,null));
		if(list == null || list.isEmpty()){
			list =  commonMapper.queryAreaAll(countryCode, cityId);
			listOperations.leftPush(RedisUtil.getPositionKey(RedisUtil.Redis_Position_Area,null), list);
		}
		getMessage(lang,list);
		return list;
	}
}
