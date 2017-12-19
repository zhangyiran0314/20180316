package com.iflytransporter.api.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Car;
import com.iflytransporter.common.bean.CarBO;

public interface CarService  {
	//增删改查
	public CarBO save(Car record,String companyId);
	
	public CarBO query(String id);
	
	public int update(Car record);
	
	public int delete(String id);
	
	public List<CarBO> listByCompany(String companyId);
	//分页查询
	PageInfo<CarBO> queryPage(Integer pageNo,Integer pageSize,String companyId);
}
