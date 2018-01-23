package com.iflytransporter.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.web.mapper.WaybillMapper;
import com.iflytransporter.web.service.WaybillService;

@Service("waybillService")
public class WaybillServiceImpl implements WaybillService{

	@Autowired
	private WaybillMapper waybillMapper;

	@Override
	public Map<String, Object> queryDetail(String id) {
		return waybillMapper.queryDetail(id);
	}

	@Override
	public PageInfo<Map<String, Object>> queryPage(Integer pageNo, Integer pageSize, String orderNo, Integer status,
			Integer dispenseStatus, String sCompanyName, String sMobile, String tCompanyName, String tMobile,
			String dMobile) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Map<String,Object>> list= waybillMapper.queryAll(pageNo, pageSize, orderNo, status, dispenseStatus, sCompanyName, sMobile, tCompanyName, tMobile, dMobile);
		return new PageInfo<Map<String,Object>>(list);
	}

	@Override
	public Map<String, Object> takeAttachmentList(String id) {
		return waybillMapper.takeAttachmentList(id);
	}

	@Override
	public Map<String, Object> deliverAttachmentList(String id) {
		return waybillMapper.deliverAttachmentList(id);
	}


}
