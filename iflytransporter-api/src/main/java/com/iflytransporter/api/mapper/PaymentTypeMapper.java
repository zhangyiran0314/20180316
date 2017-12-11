package com.iflytransporter.api.mapper;

import java.util.List;

import com.iflytransporter.common.bean.PaymentType;

public interface PaymentTypeMapper {
	
	List<PaymentType> queryAll();
	
}