package com.iflytransporter.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.CompanyMapper;
import com.iflytransporter.api.mapper.UserMapper;
import com.iflytransporter.api.service.CompanyService;
import com.iflytransporter.common.bean.Company;
import com.iflytransporter.common.bean.CompanyBO;
import com.iflytransporter.common.enums.Status;
import com.iflytransporter.common.utils.RedisUtil;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{
	@Autowired
    private RedisTemplate<String, String> redisTemplate;//注入redis缓存
	@Autowired
	private CompanyMapper companyMapper;

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int save(Company record,String userId) {
		int result = companyMapper.insert(record);
		if(result > 0){
			userMapper.updateCompany(userId, record.getId(),Status.Auth_Pending);
			deleteCache(userId);
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
		boolean flag = false;
		if(!companyTemp.getName().equals(record.getName())){
			flag = true;
		}
		if(!companyTemp.getCode().equals(record.getCode())){
			flag = true;
		}
		if(record.getAttachmentId1()!=null && !record.getAttachmentId1().equals(companyTemp.getAttachmentId1())){
			flag = true;
		}
		if(record.getAttachmentId2()!=null && !record.getAttachmentId2().equals(companyTemp.getAttachmentId2())){
			flag = true;
		}
		if(record.getAttachmentId3()!=null &&!record.getAttachmentId3().equals(companyTemp.getAttachmentId3())){
			flag = true;
		}
		if(flag){
			record.setStatus(Status.Auth_Pending);
			int result  = companyMapper.updateByPrimaryKeySelective(record);
			if(result > 0){
				userMapper.updateCompany(record.getUserId(), record.getId(),Status.Auth_Pending);
				deleteCache(record.getUserId());
			}
			return result;
		}
		return companyMapper.updateByPrimaryKeySelective(record);
	}
	//刷新用户缓存
	private void deleteCache(String userId){
		String key = RedisUtil.getUserBOKey(userId);
		redisTemplate.delete(key);
	}
}
