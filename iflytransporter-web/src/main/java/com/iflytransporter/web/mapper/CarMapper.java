package com.iflytransporter.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Car;
import com.iflytransporter.common.bean.CarBO;

public interface CarMapper {
	
	List<CarBO> queryAllBO(@Param("companyId")String cId);
	
	CarBO selectByPrimaryKeyBO(String cId);
	
    int deleteByPrimaryKey(String id);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
}