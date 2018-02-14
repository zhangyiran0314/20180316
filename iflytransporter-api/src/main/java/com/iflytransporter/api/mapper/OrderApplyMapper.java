package com.iflytransporter.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.OrderApply;

public interface OrderApplyMapper {
	//查询当前报价订单是否报价
	int countApplyByTransporter(@Param("orderId")String orderId,@Param("transporterId")String transporterId,@Param("companyId")String companyId,@Param("status")Integer status);
	
	//查询当前订单报价数量
	int count(@Param("orderId")String orderId,@Param("status")Integer status);
	//修改当前审核状态
	int updateStatus(@Param("id")String id,@Param("status")Integer status);
	//当前审核成功,修改其他申请状态
	int updateOtherStatus(@Param("orderId")String orderId,@Param("status")Integer status);
	//修改是否联系状态
	int updateOtherContactStatus(@Param("id")String id,@Param("orderId")String orderId,@Param("contactStatus")Integer contactStatus);
	
	List<OrderApply> queryAll(@Param("transporterId")String tId,@Param("orderId")String oId);
	
	//修改浏览状态
	int updateBrowseStatus(@Param("id")String id,@Param("browseStatus")Integer browseStatus);
	
    int deleteByPrimaryKey(String id);

    int insert(OrderApply record);

    int insertSelective(OrderApply record);

    OrderApply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderApply record);

    int updateByPrimaryKey(OrderApply record);
    
    List<OrderApply> listApply(@Param("transporterId")String tId,@Param("browseStatus")Integer browseStatus);
}