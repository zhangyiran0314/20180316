package com.iflytransporter.api.mapper;

import java.util.List;
import java.util.Map;

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
    
    List<CarBO> queryAllNotBind(@Param("companyId")String companyId,@Param("userId")String userId);
    
    List<Car> queryAll(@Param("companyId")String companyId,@Param("userId")String userId);
    
    int bindCar(@Param("id")String id,@Param("driverId")String driverId);
    
    int unbindCar(@Param("id")String id,@Param("driverId")String driverId);
    //车主公司车辆数查询
    int countByTransporterCompany(@Param("companyId")String companyId);
    
    Map<String,Object> queryByUserId(@Param("driverId")String driverId);
}