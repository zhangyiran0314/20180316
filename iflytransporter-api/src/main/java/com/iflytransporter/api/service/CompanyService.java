package com.iflytransporter.api.service;

import com.iflytransporter.common.bean.Company;
import com.iflytransporter.common.bean.CompanyBO;

public interface CompanyService  {
	//增删改查
	public int save(Company record,String userId);
	
	public CompanyBO query(String id);
	
	public int update(Company record);
	
}
