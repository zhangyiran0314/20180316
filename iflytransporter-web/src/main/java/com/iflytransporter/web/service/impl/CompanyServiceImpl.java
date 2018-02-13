package com.iflytransporter.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Company;
import com.iflytransporter.common.bean.CompanyBO;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.enums.Status;
import com.iflytransporter.web.mapper.CompanyMapper;
import com.iflytransporter.web.mapper.UserMapper;
import com.iflytransporter.web.service.CompanyService;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Map<String,Object> queryDetail(String id) {
		return companyMapper.queryDetail(id);
	}

	@Override
	public PageInfo<Map<String,Object>> queryPage(Integer pageNo, Integer pageSize,Integer userType,String name) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Map<String,Object>> list= companyMapper.queryAll(userType,name);
		return new PageInfo<Map<String,Object>>(list);
	}

	@Override
	public int update(Company record) {
		return companyMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int auth(Company record) {
		Company company = companyMapper.selectByPrimaryKey(record.getId());
		User user = userMapper.selectByPrimaryKey(company.getUserId());
		if(Status.Auth_Yes == record.getStatus().intValue()){
			user.setLevel(Status.User_Level_Admin);
		}
		user.setCompanyAuthStatus(record.getStatus());
		company.setStatus(record.getStatus());
		int result = companyMapper.updateByPrimaryKeySelective(company);
		if(result > 0){
			userMapper.updateByPrimaryKeySelective(user);
		}
		return result;
	}
}
