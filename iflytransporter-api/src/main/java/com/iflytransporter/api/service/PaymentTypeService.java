package com.iflytransporter.api.service;

import java.util.List;

import com.iflytransporter.common.bean.PaymentType;

public interface PaymentTypeService {
	
	List<PaymentType> queryAll();
	
}
