package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.OrderApplyMapper;
import com.iflytransporter.api.service.OrderApplyService;
import com.iflytransporter.common.bean.OrderApply;

@Service("orderApplyService")
public class OrderApplyServiceImpl implements OrderApplyService{

	@Autowired
	private OrderApplyMapper orderApplyMapper;

	@Override
	public OrderApply queryDetail(String id) {
		return orderApplyMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<OrderApply> queryPage(Integer pageNo, Integer pageSize,String tId,String oId) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<OrderApply> list= orderApplyMapper.queryAll(tId,oId);
		return new PageInfo<OrderApply>(list);
	}


	@Override
	public Integer count(String orderId, Integer status) {
		return orderApplyMapper.count(orderId, status);
	}

	@Override
	@Transactional
	public int updateStatus(String orderId,String id, Integer status,Integer otherStatus) {
		 int result = orderApplyMapper.updateStatus(id, status);
		 if(result > 0 && otherStatus!= null){
			 orderApplyMapper.updateOtherStatus(orderId, otherStatus);
		 }
		 return result;
	}

}
