package com.iflytransporter.api.mapper;

import com.iflytransporter.common.bean.Complaint;

public interface ComplaintMapper {
    int deleteByPrimaryKey(String id);

    int insert(Complaint record);

    int insertSelective(Complaint record);

    Complaint selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Complaint record);

    int updateByPrimaryKey(Complaint record);
}