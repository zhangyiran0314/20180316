package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.PaymentTypeMapper;
import com.iflytransporter.api.service.PaymentTypeService;
import com.iflytransporter.common.bean.PaymentType;

@Service("paymentTypeService")
public class PaymentTypeServiceImpl implements PaymentTypeService{

	@Autowired
	private PaymentTypeMapper paymentTypeMapper;

	@Override
	public List<PaymentType> queryAll() {
		return paymentTypeMapper.queryAll();
	}

}
