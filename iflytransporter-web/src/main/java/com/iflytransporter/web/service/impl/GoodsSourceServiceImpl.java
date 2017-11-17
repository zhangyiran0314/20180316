package com.iflytransporter.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.GoodsSource;
import com.iflytransporter.web.mapper.GoodsSourceMapper;
import com.iflytransporter.web.service.GoodsSourceService;

@Service("goodsSourceService")
public class GoodsSourceServiceImpl implements GoodsSourceService{

	@Autowired
	private GoodsSourceMapper goodsSourceMapper;

	@Override
	public GoodsSource queryDetail(String id) {
		return goodsSourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<GoodsSource> queryPage(Integer pageNo, Integer pageSize,String sId,String tId) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<GoodsSource> list= goodsSourceMapper.queryAll(sId, tId);
		return new PageInfo<GoodsSource>(list);
	}

}
