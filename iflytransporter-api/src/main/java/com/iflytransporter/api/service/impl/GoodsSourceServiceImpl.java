package com.iflytransporter.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.GoodsSourceMapper;
import com.iflytransporter.api.mapper.ShipperOrderMapper;
import com.iflytransporter.api.service.GoodsSourceService;
import com.iflytransporter.common.bean.GoodsSource;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.utils.UUIDUtil;

@Service("goodsSourceService")
public class GoodsSourceServiceImpl implements GoodsSourceService{
	
	@Autowired
	private GoodsSourceMapper goodsSourceMapper;

	@Autowired
	private ShipperOrderMapper shipperOrderMapper;
	@Override
	public int save(GoodsSource record) {
		return goodsSourceMapper.insert(record);
	}

	@Override
	public GoodsSource query(String id) {
		return goodsSourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(GoodsSource record) {
		return goodsSourceMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(String id) {
		return goodsSourceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PageInfo<GoodsSource> queryPage(Integer pageNo, Integer pageSize, String sId) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<GoodsSource> list= goodsSourceMapper.queryAll(sId);
		return new PageInfo<GoodsSource>(list);
	}

	@Override
	public List<GoodsSource> list(String userId) {
		return goodsSourceMapper.queryAll(userId);
	}

	@Override
	public String  addByOrderId(String userId, String orderId) {
		Order order  = shipperOrderMapper.selectByPrimaryKey(orderId);
		GoodsSource gs = new GoodsSource(order);
		String id = UUIDUtil.UUID();
		gs.setId(id);
		gs.setUserId(userId);
		int result = goodsSourceMapper.insert(gs);
		if(result > 0){
			return id;
		}
		return null;
	}

}
