package com.iflytransporter.api.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.api.mapper.InsuranceMapper;
import com.iflytransporter.api.service.InsuranceService;
import com.iflytransporter.common.bean.Insurance;

@Service("insuranceService")
public class InsuranceServiceImpl implements InsuranceService{

	@Autowired
	private InsuranceMapper insuranceMapper;

	@Override
	public List<Insurance> queryAll() {
		return insuranceMapper.queryAll();
	}
	@Override
	public CommonParam queryCommonParam(String id) {
		return insuranceMapper.queryCommonParam(id);
	}
	@Override
	public List<Map<String,Object>> listWaybillByUserId(String userId) {
		return insuranceMapper.listWaybillByUserId(userId);
	}
	@Override
	public int save(Insurance record) {
		return insuranceMapper.insert(record);
	}

}
