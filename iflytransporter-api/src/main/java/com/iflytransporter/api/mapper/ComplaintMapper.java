package com.iflytransporter.api.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Complaint;

public interface ComplaintMapper {
    int deleteByPrimaryKey(String id);

    int insert(Complaint record);

    int insertSelective(Complaint record);

    Complaint selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Complaint record);

    int updateByPrimaryKey(Complaint record);
    
    //运单查看当前货主是否投诉此运单
  	Integer countByWaybill(@Param("waybillId")String waybillId,@Param("shipperId")String shipperId);
  	//运单查看当前货主投诉详情
  	Map<String,Object> queryDetailByWaybill(@Param("waybillId")String waybillId,@Param("shipperId")String shipperId);
}