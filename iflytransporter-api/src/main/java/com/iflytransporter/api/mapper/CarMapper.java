package com.iflytransporter.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Car;
import com.iflytransporter.common.bean.CarBO;

public interface CarMapper {
	
	CarBO selectByPrimaryKeyBO(String id);
	
    int deleteByPrimaryKey(String id);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
    
    List<CarBO> queryAllBO(@Param("companyId")String companyId,@Param("userId")String userId);
    
    List<Car> queryAll(@Param("companyId")String companyId,@Param("userId")String userId);
    
    int bindCar(@Param("id")String id,@Param("driverId")String driverId);
    
    int unbindCar(@Param("id")String id,@Param("driverId")String driverId);
}