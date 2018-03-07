package com.iflytransporter.api.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Order;

public interface ShipperOrderMapper {
	
    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    int deleteByPrimaryKey(String id);
    
    List<Order> queryAll(@Param("shipperId")String sId,@Param("status") Integer status);
    
    List<Order> queryAllAuth(@Param("companyId")String companyId,@Param("shipperId")String sId,@Param("authStatus")Integer authStatus,
    		@Param("lastCreateDate")Date lastCreateDate,@Param("than")String than);
    
    /**
     * 管理员查询授权列表,不包括自身发布发货
     * */
    List<Order> queryAllAuthByAdmin(@Param("companyId")String companyId,@Param("shipperId")String sId,@Param("authStatus")Integer authStatus,
    		@Param("lastCreateDate")Date lastCreateDate,@Param("than")String than);
    
    int updateStatus(@Param("id")String id,@Param("status")Integer status);
    
    int updateAuthStatus(@Param("id")String id,@Param("authStatus")Integer authStatus);
    
    List<Map<String, Object>> detailAudit(@Param("id")String id,@Param("applyStatus")Integer applyStatus) ;
    
    Map<String, Object> detailTransporter(@Param("applyId")String id,@Param("applyStatus")Integer applyStatus,@Param("contactStatus")Integer contactStatus) ;
}