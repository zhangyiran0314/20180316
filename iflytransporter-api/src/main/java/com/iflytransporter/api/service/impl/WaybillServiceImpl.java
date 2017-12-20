package com.iflytransporter.api.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.WaybillMapper;
import com.iflytransporter.api.service.WaybillService;
import com.iflytransporter.common.bean.WaybillBO;

@Service("waybillService")
public class WaybillServiceImpl implements WaybillService {

	@Autowired
	private WaybillMapper waybillMapper;
	
	@Override
	public PageInfo<WaybillBO> queryPage(Integer pageNo, Integer pageSize, String userId, Integer status) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<WaybillBO> list= waybillMapper.queryAllBO(userId,null,status);
		return new PageInfo<WaybillBO>(list);
	}

	@Override
	public List<WaybillBO> list(String userId, Integer status) {
		return waybillMapper.queryAllBO(userId, null,status);
	}

	@Override
	public WaybillBO query(String id) {
		return waybillMapper.selectByPrimaryKeyBO(id);
	}

	@Override
	public Map<String, Object> detailCompany(String id) {
		return waybillMapper.detailCompany(id);
	}

	@Override
	public Map<String, Object> detailTransporter(String id) {
		return waybillMapper.detailTransporter(id);
	}

}
