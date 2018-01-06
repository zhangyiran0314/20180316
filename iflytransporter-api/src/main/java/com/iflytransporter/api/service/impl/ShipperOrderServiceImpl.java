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
import com.iflytransporter.common.bean.OrderApply;
import com.iflytransporter.common.bean.Waybill;
import com.iflytransporter.common.enums.Status;
import com.iflytransporter.common.utils.UUIDUtil;

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
	public int auditOk(String orderId,String applyId) {
		OrderApply oa = orderApplyMapper.selectByPrimaryKey(applyId);
		Order order = shipperOrderMapper.selectByPrimaryKey(orderId);
		Waybill wb = new Waybill();
		wb.setId(UUIDUtil.UUID());
		wb.setOrderId(order.getId());
		wb.setOrderNo(order.getOrderNo());
		wb.setShipperId(order.getShipperId());
		wb.setShipperCompanyId(order.getCompanyId());
		wb.setCosts(oa.getCosts());
		wb.setTransporterId(oa.getTransporterId());
		wb.setTransporterCompanyId(oa.getCompanyId());
		
		int result = waybillMapper.insert(wb);
		if(result > 0 ){
			orderApplyMapper.updateStatus(applyId, Status.Order_Audit_Yes);
			orderApplyMapper.updateOtherStatus(orderId, Status.Order_Audit_Cancel);
			shipperOrderMapper.updateStatus(orderId, Status.Order_Transfer);
		}
		return result;
	}

	@Override
	public Map<String, Object> detailTransporter(String applyId,String orderId, Integer applyStatus) {
		Map<String,Object> result  = shipperOrderMapper.detailTransporter(applyId, applyStatus,Status.Audit_Contact_Yes);
		if(result == null){
			return null;
		}
		orderApplyMapper.updateOtherContactStatus(applyId,orderId, Status.Audit_Contact_No);
		return result;
	}



}
