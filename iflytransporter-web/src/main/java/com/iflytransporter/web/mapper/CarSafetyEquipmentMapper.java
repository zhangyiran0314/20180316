package com.iflytransporter.web.mapper;

import com.iflytransporter.common.bean.CarSafetyEquipment;

public interface CarSafetyEquipmentMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarSafetyEquipment record);

    int insertSelective(CarSafetyEquipment record);

    CarSafetyEquipment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarSafetyEquipment record);

    int updateByPrimaryKey(CarSafetyEquipment record);
}