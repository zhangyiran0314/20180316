package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Complaint;

public interface ComplaintService  {
	//详情查询
	Complaint queryDetail(String id);
	//分页查询
	PageInfo<Complaint> queryPage(Integer pageNo,Integer pageSize,String sId,String tId,String wId);
	
}
