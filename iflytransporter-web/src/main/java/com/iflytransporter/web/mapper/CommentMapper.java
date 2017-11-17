package com.iflytransporter.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Comment;

public interface CommentMapper {
	
	List<Comment> queryAll(@Param("shipperId")String sId,@Param("transporterId")String tId,@Param("waybillId")String wId);
	
    int deleteByPrimaryKey(String id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}