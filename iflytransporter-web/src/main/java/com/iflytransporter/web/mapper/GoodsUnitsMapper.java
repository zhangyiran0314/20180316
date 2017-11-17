package com.iflytransporter.web.mapper;

import java.util.List;

import com.iflytransporter.common.bean.GoodsUnits;

public interface GoodsUnitsMapper {
	
	List<GoodsUnits> queryAll();
	
    int deleteByPrimaryKey(String id);

    int insert(GoodsUnits record);

    int insertSelective(GoodsUnits record);

    GoodsUnits selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsUnits record);

    int updateByPrimaryKey(GoodsUnits record);
}