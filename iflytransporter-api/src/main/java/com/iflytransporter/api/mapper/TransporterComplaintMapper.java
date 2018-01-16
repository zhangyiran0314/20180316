package com.iflytransporter.api.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.TransporterComplaint;

public interface TransporterComplaintMapper {
    int deleteByPrimaryKey(String id);

    int insert(TransporterComplaint record);

    int insertSelective(TransporterComplaint record);

    TransporterComplaint selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TransporterComplaint record);

    int updateByPrimaryKey(TransporterComplaint record);
    
    //运单查看当前货主是否投诉此运单
  	Integer countByWaybill(@Param("waybillId")String waybillId,@Param("shipperId")String shipperId);
  	//运单查看当前货主投诉详情
  	Map<String,Object> queryDetailByWaybill(@Param("waybillId")String waybillId,@Param("shipperId")String shipperId);
}