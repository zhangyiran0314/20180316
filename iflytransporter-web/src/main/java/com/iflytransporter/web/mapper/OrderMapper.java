package com.iflytransporter.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Order;

public interface OrderMapper {
	
	List<Map<String,Object>> queryAll(@Param("orderNo")String orderNo,@Param("mobile")String mobile,@Param("companyName")String companyNo);
	
	Map<String,Object> queryDetail(String id);
	
    int deleteByPrimaryKey(String id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}