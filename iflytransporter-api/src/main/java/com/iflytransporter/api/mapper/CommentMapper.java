package com.iflytransporter.api.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
    
    List<Map<String,Object>> queryAllTransporter(@Param("transporterId")String transporterId,@Param("transporterCompanyId")String transporterCompanyId,
    		@Param("lastCreateDate")Date lastCreateDate,@Param("than")String than);
    
    List<Map<String,Object>> queryAllShipper(@Param("shipperId")String shipperId,@Param("shipperCompanyId")String shipperCompanyId,
    		@Param("lastCreateDate")Date lastCreateDate,@Param("than")String than);
    
    
    //运单查看当前货主是否评价此运单
  	Integer countByWaybill(@Param("waybillId")String waybillId,@Param("shipperId")String shipperId);
  	//运单查看当前货主评价详情
  	Map<String,Object> queryDetailByWaybill(@Param("waybillId")String waybillId,@Param("shipperId")String shipperId);
}