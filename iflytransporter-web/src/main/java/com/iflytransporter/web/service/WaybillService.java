package com.iflytransporter.web.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;

public interface WaybillService  {
	//详情查询
	Map<String,Object> queryDetail(String id);
	//分页查询
	PageInfo<Map<String,Object>> queryPage(Integer pageNo,Integer pageSize,String orderNo,
			Integer status,Integer dispenseStuts,
			String sCompanyName,String sMobile,
			String tCompanyName,String tMobile,String dMobile);
	
	Map<String,Object> takeAttachmentList(String id);
	
	Map<String,Object> deliverAttachmentList(String id);
	
}
