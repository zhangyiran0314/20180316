package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.bean.OrderRequestParam;
import com.iflytransporter.api.bean.OrderResponseParam;
import com.iflytransporter.api.mapper.AreaMapper;
import com.iflytransporter.api.mapper.CarTypeMapper;
import com.iflytransporter.api.mapper.CityMapper;
import com.iflytransporter.api.mapper.GoodsSourceMapper;
import com.iflytransporter.api.mapper.GoodsUnitsMapper;
import com.iflytransporter.api.mapper.HandlingTypeMapper;
import com.iflytransporter.api.mapper.OrderMapper;
import com.iflytransporter.api.mapper.PaymentTypeMapper;
import com.iflytransporter.api.mapper.ProvinceMapper;
import com.iflytransporter.api.mapper.UseTypeMapper;
import com.iflytransporter.api.service.OrderService;
import com.iflytransporter.common.bean.GoodsSource;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.OrderBO;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private ProvinceMapper provinceMapper;
	@Autowired
	private CityMapper cityMapper;
	@Autowired
	private AreaMapper areaMapper;
	@Autowired
	private GoodsSourceMapper goodsSourceMapper;
	@Autowired
	private CarTypeMapper carTypeMapper;
	@Autowired
	private HandlingTypeMapper handlingTypeMapper;
	@Autowired
	private PaymentTypeMapper paymentTypeMapper;
	@Autowired
	private UseTypeMapper useTypeMapper;
	@Autowired
	private GoodsUnitsMapper goodsUnitsMapper;
	
	@Override
	public int save(Order order) {
		OrderRequestParam op = (OrderRequestParam) order;
		int result = orderMapper.insert(order);
		if(op.isAddGoodsSource()){
			GoodsSource gs = new GoodsSource();
			gs.setDepartureProvinceId(order.getDepartureProvinceId());
			gs.setDepartureCityId(order.getDepartureCityId());
			gs.setDepartureAreaId(order.getDepartureAreaId());
			gs.setDestinationProvinceId(order.getDestinationProvinceId());
			gs.setDestinationCityId(order.getDestinationCityId());
			gs.setDestinationAreaId(order.getDestinationAreaId());
			gs.setUserId(op.getShipperId());
			goodsSourceMapper.insert(gs);
		}
		return result;
	}

	@Override
	public Order query(String id) {
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Order record) {
		return orderMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(String id) {
		return orderMapper.invalidByPrimaryKey(id);
	}

	@Override
	public PageInfo<Order> queryPage(Integer pageNo, Integer pageSize, String sId,Integer status,Integer checkStatus) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Order> list= orderMapper.queryAll(sId,status,checkStatus);
		return new PageInfo<Order>(list);
	}

	@Override
	public OrderBO queryBO(String id) {
		return orderMapper.queryBO(id);
	}

	@Override
	public List<Order> list(String sId, Integer status,Integer checkStatus) {
		return orderMapper.queryAll(sId, status,checkStatus);
	}

	@Override
	public List<Order> listCheck(String userId, Integer status,Integer checkStatus) {
		// TODO Auto-generated method stub
		return null;
	}

}
