package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Company;
import com.iflytransporter.common.bean.CompanyBO;
import com.iflytransporter.web.mapper.CompanyMapper;
import com.iflytransporter.web.service.CompanyService;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyMapper companyMapper;
	
	@Override
	public Company queryDetail(String id) {
		return companyMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<CompanyBO> queryPage(Integer pageNo, Integer pageSize,String name) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<CompanyBO> list= companyMapper.queryAllBO(name);
		return new PageInfo<CompanyBO>(list);
	}
	@Override
	public CompanyBO queryDetailBO(String id) {
		return companyMapper.selectByPrimaryKeyBO(id);
	}
}
