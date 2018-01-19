package com.iflytransporter.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.OrderApply;

public interface OrderApplyMapper {
	
	List<Map<String,Object>> queryAll(@Param("orderNo")String orderNo,@Param("mobile")String mobile,@Param("companyName")String tCompanyName);
	
    int deleteByPrimaryKey(String id);

    int insert(OrderApply record);

    int insertSelective(OrderApply record);

    OrderApply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderApply record);

    int updateByPrimaryKey(OrderApply record);
}