package com.iflytransporter.api.service;

import com.iflytransporter.common.bean.Company;
import com.iflytransporter.common.bean.CompanyBO;

public interface CompanyService  {
	/**
	 * 1.添加公司信息
	 * 2.修改用户所属公司
	 * @param record
	 * @param userId
	 * @return
	 */
	public CompanyBO save(Company record,String userId);
	
	public CompanyBO query(String id);
	
	public CompanyBO update(Company record);
	
}
