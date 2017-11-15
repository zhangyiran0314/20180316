package com.iflytransporter.web.mapper;

import com.iflytransporter.common.bean.GoodsSource;

public interface GoodsSourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(GoodsSource record);

    int insertSelective(GoodsSource record);

    GoodsSource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsSource record);

    int updateByPrimaryKey(GoodsSource record);
}