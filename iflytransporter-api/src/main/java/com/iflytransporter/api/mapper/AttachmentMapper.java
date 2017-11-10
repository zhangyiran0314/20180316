package com.iflytransporter.api.mapper;

import com.iflytransporter.api.bean.Attachment;

public interface AttachmentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    Attachment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKey(Attachment record);
}