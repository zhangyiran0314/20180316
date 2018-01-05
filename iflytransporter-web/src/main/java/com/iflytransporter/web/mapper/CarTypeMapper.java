package com.iflytransporter.web.mapper;

import java.util.List;

import com.iflytransporter.common.bean.CarType;

public interface CarTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarType record);

    int insertSelective(CarType record);

    CarType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarType record);

    int updateByPrimaryKey(CarType record);
    
    List<CarType> queryAll();
    
}