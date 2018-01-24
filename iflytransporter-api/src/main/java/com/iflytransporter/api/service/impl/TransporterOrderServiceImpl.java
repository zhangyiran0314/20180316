package com.iflytransporter.api.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.iflytransporter.api.bean.QueryOrderParam;
import com.iflytransporter.api.mapper.OrderApplyMapper;
import com.iflytransporter.api.mapper.SubscribeSourceMapper;
import com.iflytransporter.api.mapper.TransporterOrderMapper;
import com.iflytransporter.api.service.TransporterOrderService;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.OrderApply;
import com.iflytransporter.common.bean.SubscribeSource;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.utils.UUIDUtil;

@Service("transporterOrderService")
public class TransporterOrderServiceImpl implements TransporterOrderService{
	
	@Autowired
	private TransporterOrderMapper transporterOrderMapper;
	@Autowired
	private OrderApplyMapper orderApplyMapper;
	@Autowired
	private SubscribeSourceMapper subscribeSourceMapper;
	
	@Override
	public PageInfo<Order> queryPage(QueryOrderParam queryOrderParam) {
		Integer pageNo = queryOrderParam.getPageNo()==null ? 1: queryOrderParam.getPageNo();
		Integer pageSize = queryOrderParam.getPageSize()==null ? 10: queryOrderParam.getPageSize();
        PageHelper.startPage(pageNo, pageSize); 
        if(StringUtils.isNotBlank(queryOrderParam.getSubscribeSourceId())){
        	SubscribeSource ss = subscribeSourceMapper.selectByPrimaryKey(queryOrderParam.getSubscribeSourceId());
        	BeanUtils.copyProperties(ss, queryOrderParam);
        }
		List<Order> list= transporterOrderMapper.queryAll(queryOrderParam);
		return new PageInfo<Order>(list);
	}
	
	
	@Override
	public List<Order> list(QueryOrderParam queryOrderParam) {
		if(StringUtils.isNotBlank(queryOrderParam.getSubscribeSourceId())){
        	SubscribeSource ss = subscribeSourceMapper.selectByPrimaryKey(queryOrderParam.getSubscribeSourceId());
        	BeanUtils.copyProperties(ss, queryOrderParam);
	    }
		return transporterOrderMapper.queryAll(queryOrderParam);
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
	public int apply(OrderApply orderApply) {
//		Order order = transporterOrderMapper.selectByPrimaryKey(id);
		return orderApplyMapper.insert(orderApply);
	}
	@Override
	public int save(SubscribeSource record) {
		return subscribeSourceMapper.insert(record);
	}
	@Override
	public SubscribeSource querySubscribeSource(String id) {
		return subscribeSourceMapper.selectByPrimaryKey(id);
	}
	@Override
	public int update(SubscribeSource record) {
		return subscribeSourceMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public int delete(String id) {
		return subscribeSourceMapper.deleteByPrimaryKey(id);
	}
	@Override
	public List<SubscribeSource> listByUserId(String userId) {
		return subscribeSourceMapper.listByUserId(userId);
	}
	@Override
	public Map<String, Object> detailShipper(String shipperId) {
		return transporterOrderMapper.detailShipper(shipperId);
	}
	@Override
	public Map<String, Object> commentShipper(String shipperId) {
		return transporterOrderMapper.commentShipper(shipperId);
	}
	@Override
	public List<OrderApply> listApplyByUserId(String userId) {
		return orderApplyMapper.listApply(userId, null);
	}
	@Override
	public List<OrderApply> listApplyRecord(String userId,Integer browseStatus) {
		return orderApplyMapper.listApply(userId, browseStatus);
	}

}
