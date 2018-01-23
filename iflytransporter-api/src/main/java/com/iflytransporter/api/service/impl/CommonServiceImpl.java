package com.iflytransporter.api.service.impl;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.api.mapper.CommonMapper;
import com.iflytransporter.api.service.CommonService;
import com.iflytransporter.api.utils.RedisUtil;

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
	
	@Autowired
    private RedisTemplate<String, Object> redisTemplate;//注入redis缓存
	
	@Override
	public CommonParam queryProvince(String lang, String id) {
		HashOperations<String, String, Object>  hash =  redisTemplate.opsForHash();
		Map<String, Object> map = hash.entries(RedisUtil.getPositionKey(RedisUtil.Redis_Position_Province,id));
		if(map== null){
			map =  commonMapper.queryProvince(id);
			 hash.putAll(RedisUtil.getPositionKey(RedisUtil.Redis_Position_Province,id), map);
		}
		return getMessage(lang,map);
	}

	@Override
	public CommonParam queryCity(String lang, String id) {
		HashOperations<String, String, Object>  hash =  redisTemplate.opsForHash();
		Map<String, Object> map = hash.entries(RedisUtil.getPositionKey(RedisUtil.Redis_Position_City,id));
		if(map== null){
			map =  commonMapper.queryCity(id);
			 hash.putAll(RedisUtil.getPositionKey(RedisUtil.Redis_Position_City,id), map);
		}
		return getMessage(lang,map);
	}

	@Override
	public CommonParam queryArea(String lang, String id) {
		HashOperations<String, String, Object>  hash =  redisTemplate.opsForHash();
		Map<String, Object> map = hash.entries(RedisUtil.getPositionKey(RedisUtil.Redis_Position_Area,id));
		if(map== null){
			map =  commonMapper.queryArea(id);
			 hash.putAll(RedisUtil.getPositionKey(RedisUtil.Redis_Position_Area,id), map);
		}
		return getMessage(lang,map);
	}

	@Override
	public CommonParam queryCarType(String lang, String id) {
		HashOperations<String, String, Object>  hash =  redisTemplate.opsForHash();
		Map<String, Object> map = hash.entries(RedisUtil.getTypeKey(RedisUtil.Redis_CarType,id));
		if(map== null){
			map = commonMapper.queryCarType(id);
			 hash.putAll(RedisUtil.getTypeKey(RedisUtil.Redis_CarType,id), map);
		}
		return getMessage(lang,map);
	}

	@Override
	public CommonParam queryHandlingType(String lang, String id) {
		HashOperations<String, String, Object>  hash =  redisTemplate.opsForHash();
		Map<String, Object> map = hash.entries(RedisUtil.getTypeKey(RedisUtil.Redis_HandlingType,id));
		if(map== null){
			map = commonMapper.queryHandlingType(id);
			 hash.putAll(RedisUtil.getTypeKey(RedisUtil.Redis_HandlingType,id), map);
		}
		return getMessage(lang,map);
	}

	@Override
	public CommonParam queryPaymentType(String lang, String id) {
		HashOperations<String, String, Object>  hash =  redisTemplate.opsForHash();
		Map<String, Object> map = hash.entries(RedisUtil.getTypeKey(RedisUtil.Redis_PaymentType,id));
		if(map== null){
			map = commonMapper.queryPaymentType(id);
			 hash.putAll(RedisUtil.getTypeKey(RedisUtil.Redis_PaymentType,id), map);
		}
		return getMessage(lang,map);
	}
	@Override
	public CommonParam queryUseType(String lang, String id) {
		HashOperations<String, String, Object>  hash =  redisTemplate.opsForHash();
		Map<String, Object> map = hash.entries(RedisUtil.getTypeKey(RedisUtil.Redis_UseType,id));
		if(map==null){
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
			list =  commonMapper.listUseType();
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
			list =  commonMapper.listUseType();
			listOperations.leftPush(RedisUtil.getTypeKey(RedisUtil.Redis_PaymentType,null), list);
		}
		getMessage(lang,list);
		return list;
	}
	@Override
	public List<Map<String, Object>> listGoodsType(String lang) {
		return null;
	}
	public CommonParam getMessage(String lang,Map<String,Object> map){
		CommonParam commonParam = new CommonParam();
		commonParam.setId((String)map.get("id"));
		if(Lang_China.equals(lang)){
			commonParam.setName(messageSource.getMessage((String)map.get("code"), null, Locale.SIMPLIFIED_CHINESE));
			return commonParam;
		}
		if(Lang_English.equals(lang)){
			commonParam.setName(messageSource.getMessage((String)map.get("code"), null, Locale.US));
			return commonParam;
		}
		if(Lang_Maya.equals(lang)){
			commonParam.setName(messageSource.getMessage((String)map.get("code"), null, mayaLocale));
			return commonParam;
		}
		commonParam.setName(messageSource.getMessage((String)map.get("code"), null, null, Locale.US));
		return commonParam;
	}

	public void getMessage(String lang,List<Map<String,Object>> list){
		if(Lang_China.equals(lang)){
			for(Map<String,Object> map :list){
				map.put("name", messageSource.getMessage((String)map.get("code"), null, Locale.SIMPLIFIED_CHINESE));
			}
		}
		if(Lang_English.equals(lang)){
			for(Map<String,Object> map :list){
				map.put("name",(messageSource.getMessage((String)map.get("code"), null, Locale.US)));
			}
		}
		if(Lang_Maya.equals(lang)){
			for(Map<String,Object> map :list){
				map.put("name",(messageSource.getMessage((String)map.get("code"), null, mayaLocale)));
			}
		}
		/*for(Map<String,Object> map :list){
			map.put("name",(messageSource.getMessage(map.get("code").toString(), null, null, Locale.US)));
		}*/
	}
}
