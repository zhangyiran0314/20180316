package com.iflytransporter.web.mapper;

import com.iflytransporter.common.bean.CarIndicatorLight;

public interface CarIndicatorLightMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarIndicatorLight record);

    int insertSelective(CarIndicatorLight record);

    CarIndicatorLight selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarIndicatorLight record);

    int updateByPrimaryKey(CarIndicatorLight record);
}