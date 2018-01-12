package com.iflytransporter.web.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Transporter;
import com.iflytransporter.common.bean.TransporterBO;

public interface TransporterService  {
	//详情查询
	Transporter queryDetail(String id);
	
	TransporterBO queryDetailBO(String id);
	//分页查询
	PageInfo<Map<String,Object>> queryPage(Integer pageNo,Integer pageSize);
	
}
