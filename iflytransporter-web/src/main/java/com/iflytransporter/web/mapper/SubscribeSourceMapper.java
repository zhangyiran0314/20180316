package com.iflytransporter.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.SubscribeSource;

public interface SubscribeSourceMapper {
	
	List<Map<String,Object>> queryAll(@Param("orderNo")String orderNo,@Param("mobile")String mobile);
	
	Map<String,Object> queryDetail(String id);
	
    int deleteByPrimaryKey(String id);

    int insert(SubscribeSource record);

    int insertSelective(SubscribeSource record);

    SubscribeSource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SubscribeSource record);

    int updateByPrimaryKey(SubscribeSource record);
}