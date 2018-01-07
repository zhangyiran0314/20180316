package com.iflytransporter.api.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.GoodsSource;

public interface GoodsSourceService  {
	//增删改查
	public int save(GoodsSource record);
	
	public GoodsSource query(String id);
	
	public int update(GoodsSource record);
	
	public int delete(String id);
	
	public List<GoodsSource> list(String userId);
	//分页查询
	PageInfo<GoodsSource> queryPage(Integer pageNo,Integer pageSize,String sId);
	//通过订单id新增货源
	String addByOrderId(String userId,String orderId);
}
