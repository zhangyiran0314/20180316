package com.iflytransporter.api.mapper;

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
    
    List<Map<String,Object>> queryAllTransporter(@Param("transporterId")String transporterId,@Param("transporterCompanyId")String transporterCompanyId);
    
    List<Map<String,Object>> queryAllShipper(@Param("shipperId")String shipperId,@Param("shipperCompanyId")String shipperCompanyId);
}