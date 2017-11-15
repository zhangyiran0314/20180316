package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Shipper;
import com.iflytransporter.common.bean.ShipperBO;

public interface ShipperService  {
	//详情查询
	Shipper queryDetail(String id);
	ShipperBO queryDetailBO(String id);
	//分页查询
	PageInfo<Shipper> queryPage(Integer pageNo,Integer pageSize);
	
}
