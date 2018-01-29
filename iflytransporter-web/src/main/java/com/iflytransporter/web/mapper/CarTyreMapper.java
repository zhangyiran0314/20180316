package com.iflytransporter.web.mapper;

import com.iflytransporter.common.bean.CarTyre;

public interface CarTyreMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarTyre record);

    int insertSelective(CarTyre record);

    CarTyre selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarTyre record);

    int updateByPrimaryKey(CarTyre record);
}