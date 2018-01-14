package com.iflytransporter.api.mapper;

import com.iflytransporter.common.bean.SubscribeSource;

public interface SubscribeSourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(SubscribeSource record);

    int insertSelective(SubscribeSource record);

    SubscribeSource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SubscribeSource record);

    int updateByPrimaryKey(SubscribeSource record);
}