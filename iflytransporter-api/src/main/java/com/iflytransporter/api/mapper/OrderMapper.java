package com.iflytransporter.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.OrderBO;

public interface OrderMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    int invalidByPrimaryKey(String id);
    
    List<Order> queryAll(@Param("shipperId")String sId,@Param("status") Integer status);
    
    OrderBO queryBO(String id);
}