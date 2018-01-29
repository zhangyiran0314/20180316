package com.iflytransporter.web.mapper;

import com.iflytransporter.common.bean.CarEngineOil;

public interface CarEngineOilMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarEngineOil record);

    int insertSelective(CarEngineOil record);

    CarEngineOil selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarEngineOil record);

    int updateByPrimaryKey(CarEngineOil record);
}