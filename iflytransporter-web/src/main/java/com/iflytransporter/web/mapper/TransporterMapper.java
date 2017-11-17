package com.iflytransporter.web.mapper;

import java.util.List;

import com.iflytransporter.common.bean.Transporter;
import com.iflytransporter.common.bean.TransporterBO;

public interface TransporterMapper {
	
	List<Transporter> queryAll();
	
	TransporterBO selectByPrimaryKeyBO(String id);
	
    int deleteByPrimaryKey(String id);

    int insert(Transporter record);

    int insertSelective(Transporter record);

    Transporter selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Transporter record);

    int updateByPrimaryKey(Transporter record);
}