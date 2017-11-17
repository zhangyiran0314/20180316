package com.iflytransporter.web.mapper;

import java.util.List;

import com.iflytransporter.common.bean.Shipper;
import com.iflytransporter.common.bean.ShipperBO;

public interface ShipperMapper {
	
	List<Shipper> queryAll();
	
	ShipperBO selectByPrimaryKeyBO(String id);
	
    Shipper selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Shipper record);

    int updateByPrimaryKey(Shipper record);
}