package com.iflytransporter.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.GoodsSource;

public interface GoodsSourceMapper {
	
	List<Map<String,Object>> queryAll(@Param("orderNo")String orderNo,@Param("mobile")String mobile);
	
	Map<String,Object> queryDetail(String id);
	
    int deleteByPrimaryKey(String id);

    int insert(GoodsSource record);

    int insertSelective(GoodsSource record);

    GoodsSource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsSource record);

    int updateByPrimaryKey(GoodsSource record);
}