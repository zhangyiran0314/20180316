package com.iflytransporter.api.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Car;
import com.iflytransporter.common.bean.CarBO;

public interface CarService  {
	//增删改查
	public int save(Car record,String companyId);
	
	public CarBO query(String id);
	
	public int update(Car record);
	
	public int delete(String id);
	
	public List<CarBO> list(String companyId,String userId);
	
	//分页查询
	PageInfo<CarBO> queryPage(Integer pageNo,Integer pageSize,String companyId,String userId);
	
	//绑定车辆
	public int bindCar(String id,String driverId);
	//解除绑定车辆
	public int unbindCar(String id,String driverId);
	//根据用户id查询绑定车辆
	public Map<String,Object> queryByUserId(String userId);
}
