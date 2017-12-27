package com.iflytransporter.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.CompanyMapper;
import com.iflytransporter.api.mapper.UserMapper;
import com.iflytransporter.api.service.CompanyService;
import com.iflytransporter.common.bean.Company;
import com.iflytransporter.common.bean.CompanyBO;
import com.iflytransporter.common.enums.Status;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyMapper companyMapper;

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int save(Company record,String userId) {
		int result = companyMapper.insert(record);
		if(result > 0){
			userMapper.updateCompany(userId, record.getId(),Status.Auth_Pending);
			return result;
		}
		return 0;
	}

	@Override
	public CompanyBO query(String id) {
		return companyMapper.selectByPrimaryKeyBO(id);
	}

	@Override
	public int update(Company record) {
		return companyMapper.updateByPrimaryKeySelective(record);
	}

}
