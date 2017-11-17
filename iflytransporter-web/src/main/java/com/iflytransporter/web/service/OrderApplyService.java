package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.OrderApply;

public interface OrderApplyService  {
	//详情查询
	OrderApply queryDetail(String id);
	//分页查询
	PageInfo<OrderApply> queryPage(Integer pageNo,Integer pageSize,String sId,String tId);
	
}
