package com.iflytransporter.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.Waybill;

public interface WaybillMapper {
	
	List<Waybill> queryAll(@Param("shipperId")String sId,@Param("transporterId") String tId,@Param("orderId")String oId);
	
    int deleteByPrimaryKey(String id);

    int insert(Waybill record);

    int insertSelective(Waybill record);

    Waybill selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Waybill record);

    int updateByPrimaryKey(Waybill record);
}