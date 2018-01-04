package com.iflytransporter.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.OrderApply;

public interface OrderApplyMapper {
	//查询数量
	int count(@Param("orderId")String orderId,@Param("status")Integer status);
	//修改当前审核状态
	int updateStatus(@Param("id")String id,@Param("status")Integer status);
	//当前审核成功,修改其他申请状态
	int updateOtherStatus(@Param("orderId")String orderId,@Param("status")Integer status);
	//修改是否联系状态
	int updateOtherContactStatus(@Param("id")String id,@Param("orderId")String orderId,@Param("contactStatus")Integer contactStatus);
	
	List<OrderApply> queryAll(@Param("transporterId")String tId,@Param("orderId")String oId);
	
    int deleteByPrimaryKey(String id);

    int insert(OrderApply record);

    int insertSelective(OrderApply record);

    OrderApply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderApply record);

    int updateByPrimaryKey(OrderApply record);
}