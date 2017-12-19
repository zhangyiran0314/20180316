package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.CarMapper;
import com.iflytransporter.api.service.CarService;
import com.iflytransporter.common.bean.Car;
import com.iflytransporter.common.bean.CarBO;

@Service("carService")
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarMapper carMapper;
	@Override
	public CarBO save(Car record,String companyId) {
		record.setCompanyId(companyId);
		int result  =  carMapper.insert(record);
		if(result > 0){
			return carMapper.selectByPrimaryKeyBO(record.getId());
		}
		return null;
	}

	@Override
	public CarBO query(String id) {
		return carMapper.selectByPrimaryKeyBO(id);
	}

	@Override
	public int update(Car record) {
		return carMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(String id) {
		return carMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PageInfo<CarBO> queryPage(Integer pageNo, Integer pageSize, String companyId) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<CarBO> list= carMapper.queryAllBO(companyId);
		return new PageInfo<CarBO>(list);
	}

	@Override
	public List<CarBO> listByCompany(String companyId) {
		return carMapper.queryAllBO(companyId);
	}

}
