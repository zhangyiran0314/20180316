package com.iflytransporter.web.mapper;

import com.iflytransporter.common.bean.CarTire;

public interface CarTireMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarTire record);

    int insertSelective(CarTire record);

    CarTire selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarTire record);

    int updateByPrimaryKey(CarTire record);
}