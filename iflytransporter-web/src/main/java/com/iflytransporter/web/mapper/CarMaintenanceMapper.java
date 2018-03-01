package com.iflytransporter.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.CarMaintenance;

public interface CarMaintenanceMapper {
   
	List<Map<String,Object>> queryAll(@Param("companyName")String companyName);
	
	Map<String,Object> queryDetail(String id);
	
	int deleteByPrimaryKey(String id);

    int insert(CarMaintenance record);

    int insertSelective(CarMaintenance record);

    CarMaintenance selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarMaintenance record);

    int updateByPrimaryKey(CarMaintenance record);
}