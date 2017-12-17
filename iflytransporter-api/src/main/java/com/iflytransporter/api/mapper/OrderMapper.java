package com.iflytransporter.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Order;

public interface OrderMapper {
	
    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    int deleteByPrimaryKey(String id);
    
    List<Order> queryAll(@Param("shipperId")String sId,@Param("status") Integer status);
    
    List<Order> queryAllAuth(@Param("companyId")String companyId,@Param("shipperId")String sId,@Param("authStatus")Integer authStatus);
    
    int updateStatus(@Param("id")String id,@Param("status")Integer status);
    
    int updateAuthStatus(@Param("id")String id,@Param("authStatus")Integer authStatus);
    
    List<Map<String, Object>> detailAudit(@Param("id")String id,@Param("applyStatus")Integer applyStatus) ;
}