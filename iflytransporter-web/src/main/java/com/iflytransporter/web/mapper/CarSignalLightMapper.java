package com.iflytransporter.web.mapper;

import com.iflytransporter.common.bean.CarSignalLight;

public interface CarSignalLightMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarSignalLight record);

    int insertSelective(CarSignalLight record);

    CarSignalLight selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarSignalLight record);

    int updateByPrimaryKey(CarSignalLight record);
}