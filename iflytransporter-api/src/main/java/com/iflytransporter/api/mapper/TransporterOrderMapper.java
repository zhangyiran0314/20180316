package com.iflytransporter.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Order;

public interface TransporterOrderMapper {
    
	Order selectByPrimaryKey(String id);
	 
    List<Order> queryAll(@Param("status") Integer status);
    
    List<Order> queryAllAuth(@Param("companyId")String companyId,@Param("shipperId")String sId,@Param("authStatus")Integer authStatus);
    
    int updateStatus(@Param("id")String id,@Param("status")Integer status);
    
    int updateAuthStatus(@Param("id")String id,@Param("authStatus")Integer authStatus);
    
    List<Map<String, Object>> detailAudit(@Param("id")String id,@Param("applyStatus")Integer applyStatus) ;
    
    //货主资料
  	public Map<String,Object> detailShipper(String shipperId);
  	//货主评价
  	public Map<String,Object> commentShipper(String shipperId);
  	
    //报价列表
  	public List<Map<String,Object>> listApplyByUserId(String userId);
    
}