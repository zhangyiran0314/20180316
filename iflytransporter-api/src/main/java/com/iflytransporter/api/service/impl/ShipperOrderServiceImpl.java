package com.iflytransporter.api.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.OrderApplyMapper;
import com.iflytransporter.api.mapper.ShipperOrderMapper;
import com.iflytransporter.api.mapper.WaybillMapper;
import com.iflytransporter.api.service.ShipperOrderService;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.enums.Status;

@Service("shipperOrderService")
public class ShipperOrderServiceImpl implements ShipperOrderService{
	
	@Autowired
	private ShipperOrderMapper shipperOrderMapper;
	@Autowired
	private OrderApplyMapper orderApplyMapper;
	@Autowired
	private WaybillMapper waybillMapper;
	@Override
	public int save(Order order) {
		return  shipperOrderMapper.insert(order);
	}

	@Override
	public Order query(String id) {
		return shipperOrderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Order record) {
		return shipperOrderMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(String id) {
		return shipperOrderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PageInfo<Order> queryPage(Integer pageNo, Integer pageSize, String sId,Integer status,Integer authStatus) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Order> list= shipperOrderMapper.queryAll(sId,status);
		return new PageInfo<Order>(list);
	}
	@Override
	public List<Order> list(String sId, Integer status,Integer authStatus) {
		return shipperOrderMapper.queryAll(sId, status);
	}


	@Override
	public int cancel(String id) {
		return shipperOrderMapper.updateStatus(id,Status.Order_Cancel);
	}

	@Override
	public List<Map<String, Object>> detailAudit(String id,Integer applyStatus) {
		return shipperOrderMapper.detailAudit(id,applyStatus);
	}

	@Override
	@Transactional 
	public int auditOk(String orderId,String orderApplyId,String shipperId) {
		 int result = orderApplyMapper.updateStatus(orderApplyId, Status.Order_Audit_Yes);
		 if(result > 0 ){
			 orderApplyMapper.updateOtherStatus(orderId, Status.Order_Audit_Cancel);
			 shipperOrderMapper.updateStatus(orderId, Status.Order_Transfer);
			// waybillMapper.insert(record);
		 }
		return result;
	}



}
