package com.iflytransporter.web.service;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.GoodsSource;

public interface GoodsSourceService  {
	//详情查询
	GoodsSource queryDetail(String id);
	//分页查询
	PageInfo<GoodsSource> queryPage(Integer pageNo,Integer pageSize,String sId,String tId);
	
}
