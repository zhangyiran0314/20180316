package com.iflytransporter.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Company;

public interface CompanyMapper {
	
	List<Map<String,Object>> queryAll(@Param("userType")Integer userType,@Param("name")String name);
	
	Map<String,Object> queryDetail(String id);
	
	int deleteByPrimaryKey(String id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}