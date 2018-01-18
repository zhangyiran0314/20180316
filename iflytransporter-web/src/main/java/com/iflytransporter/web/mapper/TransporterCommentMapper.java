package com.iflytransporter.web.mapper;

import com.iflytransporter.common.bean.TransporterComment;

public interface TransporterCommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(TransporterComment record);

    int insertSelective(TransporterComment record);

    TransporterComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TransporterComment record);

    int updateByPrimaryKey(TransporterComment record);
}