package com.iflytransporter.web.mapper;

import java.util.List;

import com.iflytransporter.common.bean.HandlingType;

public interface HandlingTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(HandlingType record);

    int insertSelective(HandlingType record);

    HandlingType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HandlingType record);

    int updateByPrimaryKey(HandlingType record);
    
    List<HandlingType> queryAll();
}