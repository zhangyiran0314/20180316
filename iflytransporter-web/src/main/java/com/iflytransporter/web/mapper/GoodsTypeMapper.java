package com.iflytransporter.web.mapper;

import java.util.List;

import com.iflytransporter.common.bean.GoodsType;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
    
    List<GoodsType> queryAll();
}