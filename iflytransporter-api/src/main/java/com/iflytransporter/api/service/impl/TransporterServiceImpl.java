package com.iflytransporter.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.TransporterMapper;
import com.iflytransporter.api.service.TransporterService;
import com.iflytransporter.common.bean.Transporter;

@Service("transporterService")
public class TransporterServiceImpl implements TransporterService{

	@Autowired
	private TransporterMapper transporterMapper;
	
	@Override
	public Transporter queryByMobile(String countryCode,String mobile) {
		return transporterMapper.selectByMobile(countryCode,mobile);
	}

	@Override
	public int register(Transporter record) {
		return transporterMapper.insert(record);
	}

	@Override
	public int updateLoginInfo(Transporter record) {
		return transporterMapper.updateLoginInfo(record);
	}

	@Override
	public Transporter login(String countryCode,String mobile, String password) {
		return transporterMapper.selectByMobileAndPassword(countryCode,mobile, password);
	}

}
