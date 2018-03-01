package com.iflytransporter.web.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.CarMaintenance;

public interface CarMaintenanceService {
    
	PageInfo<Map<String,Object>> queryPage(Integer pageNo,Integer pageSize,String companyName);
	
	Map<String,Object> queryDetail(String id);
	
	int deleteByPrimaryKey(String id);

    int insert(CarMaintenance record);

    int insertSelective(CarMaintenance record);

    CarMaintenance selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarMaintenance record);

    int updateByPrimaryKey(CarMaintenance record);
}