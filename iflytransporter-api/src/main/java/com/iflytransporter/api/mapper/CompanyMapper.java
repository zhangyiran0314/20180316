package com.iflytransporter.api.mapper;

import java.util.List;

import com.iflytransporter.common.bean.Company;
import com.iflytransporter.common.bean.CompanyBO;

public interface CompanyMapper {
	
	List<Company> queryAll();
	
	CompanyBO selectByPrimaryKeyBO(String id);
	
	
	int deleteByPrimaryKey(String id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}