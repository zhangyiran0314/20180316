package com.iflytransporter.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.City;
import com.iflytransporter.common.bean.CityBO;

public interface CityMapper {
	
	List<City> queryAll();
	
	List<CityBO> queryAllBO(@Param("name")String name);
	
	CityBO selectByPrimaryKeyBO(String id);
	
    int deleteByPrimaryKey(String id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
    
}