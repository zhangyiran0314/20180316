package com.iflytransporter.api.service;

import java.util.List;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.common.bean.PaymentType;

public interface PaymentTypeService {
	
	List<PaymentType> queryAll();
	
	CommonParam queryCommonParam(String id);
}
