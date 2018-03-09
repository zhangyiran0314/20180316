package com.iflytransporter.web.mapper;

import com.iflytransporter.common.bean.CarAirPressureCoolant;

public interface CarAirPressureCoolantMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarAirPressureCoolant record);

    int insertSelective(CarAirPressureCoolant record);

    CarAirPressureCoolant selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarAirPressureCoolant record);

    int updateByPrimaryKey(CarAirPressureCoolant record);
}