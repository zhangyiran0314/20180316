package com.iflytransporter.api.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Company;

public interface CompanyService  {
	//增删改查
	public int save(Company record);
	
	public Company query(String id);
	
	public int update(Company record);
	
	public int delete(String id);
	
	public List<Company> list(String userId);
	//分页查询
	PageInfo<Company> queryPage(Integer pageNo,Integer pageSize,String sId);
}
