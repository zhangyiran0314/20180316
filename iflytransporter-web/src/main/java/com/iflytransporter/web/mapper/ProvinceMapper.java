package com.iflytransporter.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Province;

public interface ProvinceMapper {
	
	List<Province> queryAll(@Param("name")String name);
	
    int deleteByPrimaryKey(String id);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}