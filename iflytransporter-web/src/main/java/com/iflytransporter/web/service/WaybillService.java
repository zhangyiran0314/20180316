package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Waybill;

public interface WaybillService  {
	//详情查询
	Waybill queryDetail(String id);
	//分页查询
	PageInfo<Waybill> queryPage(Integer pageNo,Integer pageSize,String sId,String tId,String oId);
	
}
