package com.iflytransporter.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.OrderApply;

public interface OrderApplyMapper {
	
	List<OrderApply> queryAll(@Param("transporterId")String tId,@Param("orderId")String oId);
	
    int deleteByPrimaryKey(String id);

    int insert(OrderApply record);

    int insertSelective(OrderApply record);

    OrderApply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderApply record);

    int updateByPrimaryKey(OrderApply record);
}