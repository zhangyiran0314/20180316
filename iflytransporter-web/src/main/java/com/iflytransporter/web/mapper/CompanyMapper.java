package com.iflytransporter.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Company;
import com.iflytransporter.common.bean.CompanyBO;

public interface CompanyMapper {
	
	List<CompanyBO> queryAllBO(@Param("name")String name);
	
	CompanyBO selectByPrimaryKeyBO(String id);
	
	
	int deleteByPrimaryKey(String id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}