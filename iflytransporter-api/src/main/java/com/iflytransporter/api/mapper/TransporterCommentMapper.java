package com.iflytransporter.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.TransporterComment;

public interface TransporterCommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(TransporterComment record);

    int insertSelective(TransporterComment record);

    TransporterComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TransporterComment record);

    int updateByPrimaryKey(TransporterComment record);
    
    List<Map<String,Object>> queryAllTransporter(@Param("transporterId")String transporterId,@Param("transporterCompanyId")String transporterCompanyId);
    
    List<Map<String,Object>> queryAllShipper(@Param("shipperId")String shipperId,@Param("shipperCompanyId")String shipperCompanyId);
    
    
    //运单查看当前货主是否评价此运单
  	Integer countByWaybill(@Param("waybillId")String waybillId,@Param("transporterId")String transporterId);
  	//运单查看当前货主评价详情
  	Map<String,Object> queryDetailByWaybill(@Param("waybillId")String waybillId,@Param("transporterId")String transporterId);
}