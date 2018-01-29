package com.iflytransporter.web.mapper;

import com.iflytransporter.common.bean.CarAirCoolant;

public interface CarAirCoolantMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarAirCoolant record);

    int insertSelective(CarAirCoolant record);

    CarAirCoolant selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarAirCoolant record);

    int updateByPrimaryKey(CarAirCoolant record);
}