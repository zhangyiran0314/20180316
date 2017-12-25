package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.PaymentType;

public interface PaymentTypeService  {
	//详情查询
	PaymentType queryDetail(String id);
	//分页查询
	PageInfo<PaymentType> queryPage(Integer pageNo,Integer pageSize);
	
}
