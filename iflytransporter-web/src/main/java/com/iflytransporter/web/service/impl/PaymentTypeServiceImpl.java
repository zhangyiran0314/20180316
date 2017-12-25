package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.PaymentType;
import com.iflytransporter.web.mapper.PaymentTypeMapper;
import com.iflytransporter.web.service.PaymentTypeService;

@Service("paymentTypeService")
public class PaymentTypeServiceImpl implements PaymentTypeService{

	@Autowired
	private PaymentTypeMapper paymentTypeMapper;


	@Override
	public PageInfo<PaymentType> queryPage(Integer pageNo, Integer pageSize) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<PaymentType> list= paymentTypeMapper.queryAll();
		return new PageInfo<PaymentType>(list);
	}

	@Override
	public PaymentType queryDetail(String id) {
		return paymentTypeMapper.selectByPrimaryKey(id);
	}
}
