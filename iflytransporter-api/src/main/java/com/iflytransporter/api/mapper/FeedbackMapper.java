package com.iflytransporter.api.mapper;

import com.iflytransporter.common.bean.Feedback;

public interface FeedbackMapper {
    int deleteByPrimaryKey(String id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);
}