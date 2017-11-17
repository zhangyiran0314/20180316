package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Waybill;
import com.iflytransporter.web.mapper.WaybillMapper;
import com.iflytransporter.web.service.WaybillService;

@Service("waybillService")
public class WaybillServiceImpl implements WaybillService{

	@Autowired
	private WaybillMapper waybillMapper;

	@Override
	public Waybill queryDetail(String id) {
		return waybillMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<Waybill> queryPage(Integer pageNo, Integer pageSize,String sId,String tId,String oId) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Waybill> list= waybillMapper.queryAll(sId, tId, oId);
		return new PageInfo<Waybill>(list);
	}

}
