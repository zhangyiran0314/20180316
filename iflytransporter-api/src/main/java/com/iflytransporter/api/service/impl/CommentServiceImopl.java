package com.iflytransporter.api.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.mapper.CommentMapper;
import com.iflytransporter.api.service.CommentService;
import com.iflytransporter.common.bean.Comment;

@Service("commentService")
public class CommentServiceImopl implements CommentService{

	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public int add(Comment record) {
		return commentMapper.insert(record);
	}

	@Override
	public PageInfo<Map<String, Object>> queryPageTransporter(Integer pageNo, Integer pageSize,
			String transporterId, String transporterCompanyId,Date lastCreateDate,String than) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Map<String,Object>> list= commentMapper.queryAllTransporter(transporterId, transporterCompanyId,lastCreateDate,than);
		return new PageInfo<Map<String,Object>>(list);
	}

	@Override
	public PageInfo<Map<String, Object>> queryPageShipper(Integer pageNo, Integer pageSize, 
			String shipperId,String shipperCompanyId,Date lastCreateDate,String than) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }
		List<Map<String,Object>> list= commentMapper.queryAllShipper(shipperId, shipperCompanyId,lastCreateDate,than);
		return new PageInfo<Map<String,Object>>(list);
	}

}
