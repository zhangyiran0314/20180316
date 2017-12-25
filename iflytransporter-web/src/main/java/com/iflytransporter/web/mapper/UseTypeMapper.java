package com.iflytransporter.web.mapper;

import java.util.List;

import com.iflytransporter.common.bean.UseType;

public interface UseTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(UseType record);

    int insertSelective(UseType record);

    UseType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UseType record);

    int updateByPrimaryKey(UseType record);
    
    List<UseType> queryAll();
}