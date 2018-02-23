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
		Company companyTemp = companyMapper.selectByPrimaryKey(record.getId());
		if(!companyTemp.getName().equals(record.getName())){
			record.setStatus(Status.Auth_Pending);
		}
		if(!companyTemp.getCode().equals(record.getCode())){
			record.setStatus(Status.Auth_Pending);
		}
		if(record.getAttachmentId1()!=null && !record.getAttachmentId1().equals(companyTemp.getAttachmentId1())){
			record.setStatus(Status.Auth_Pending);
		}
		if(record.getAttachmentId2()!=null && !record.getAttachmentId2().equals(companyTemp.getAttachmentId2())){
			record.setStatus(Status.Auth_Pending);
		}
		if(record.getAttachmentId3()!=null &&!record.getAttachmentId3().equals(companyTemp.getAttachmentId3())){
			record.setStatus(Status.Auth_Pending);
		}
		return companyMapper.updateByPrimaryKeySelective(record);
	}

}
