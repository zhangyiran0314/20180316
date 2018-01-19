package com.iflytransporter.web.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;

public interface TransporterComplaintService  {
	//详情查询
	Map<String,Object> queryDetail(String id);
	//分页查询
	PageInfo<Map<String,Object>> queryPage(Integer pageNo,Integer pageSize,String orderNo,String tMobile,String sCompanyName,String sMobile);
}
