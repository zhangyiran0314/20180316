package com.iflytransporter.web.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Complaint;

public interface ComplaintService  {
	//详情查询
	Complaint queryDetail(String id);
	//分页查询
	PageInfo<Map<String,Object>> queryPage(Integer pageNo, Integer pageSize,String orderNo,String mobile);
	
}
