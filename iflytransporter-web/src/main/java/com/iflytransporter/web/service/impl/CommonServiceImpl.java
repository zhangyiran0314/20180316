package com.iflytransporter.web.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.web.mapper.CommonMapper;
import com.iflytransporter.web.service.CommonService;

@Service("commonService")
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonMapper commenMapper;
	@Override
	public Map<String, Object> queryProvince(String id) {
		return commenMapper.queryProvince(id);
	}

	@Override
	public Map<String, Object> queryCity(String id) {
		return commenMapper.queryCity(id);
	}

	@Override
	public Map<String, Object> queryArea(String id) {
		return commenMapper.queryArea(id);
	}

	@Override
	public Map<String, Object> queryCarType(String id) {
		return commenMapper.queryCarType(id);
	}

	@Override
	public Map<String, Object> queryHandlingType(String id) {
		return commenMapper.queryHandlingType(id);
	}

	@Override
	public Map<String, Object> queryPaymentType(String id) {
		return commenMapper.queryPaymentType(id);
	}

	@Override
	public Map<String, Object> queryUseType(String id) {
		return commenMapper.queryUseType(id);
	}


}
