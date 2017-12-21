package com.iflytransporter.api.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.OrderApplyMapper;
import com.iflytransporter.api.mapper.TransporterOrderMapper;
import com.iflytransporter.api.service.TransporterOrderService;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.OrderApply;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.utils.UUIDUtil;

@Service("transporterOrderService")
public class TransporterOrderServiceImpl implements TransporterOrderService{
	
	@Autowired
	private TransporterOrderMapper transporterOrderMapper;
	@Autowired
	private OrderApplyMapper orderApplyMapper;
	
	@Override
	public PageInfo<Order> queryPage(Integer pageNo, Integer pageSize, Integer status,Integer authStatus) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Order> list= transporterOrderMapper.queryAll(status);
		return new PageInfo<Order>(list);
	}
	@Override
	public List<Order> list(Integer status,Integer authStatus) {
		return transporterOrderMapper.queryAll(status);
	}

	@Override
	public List<Map<String, Object>> detailAudit(String id,Integer applyStatus) {
		return transporterOrderMapper.detailAudit(id,applyStatus);
	}

	@Override
	public int updateStatus(String id, Integer status) {
		return transporterOrderMapper.updateStatus(id, status);
	}
	@Override
	public Order query(String id) {
		return transporterOrderMapper.selectByPrimaryKey(id);
	}
	@Override
	public OrderApply apply(String orderId, Double costs,User user) {
//		Order order = transporterOrderMapper.selectByPrimaryKey(id);
		OrderApply oa = new OrderApply();
		oa.setId(UUIDUtil.UUID());
		oa.setCosts(costs);
		oa.setOrderId(orderId);
		oa.setTransporterId(user.getId());
		oa.setCompanyId(user.getCompanyId());
		int result = orderApplyMapper.insert(oa);
		if(result > 0){
			return oa;
		}
		return null;
	}



}
