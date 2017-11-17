package com.iflytransporter.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.GoodsSource;

public interface GoodsSourceMapper {
	
	List<GoodsSource> queryAll(@Param("shipperId")String sId,@Param("transporterId")String tId);
	
    int deleteByPrimaryKey(String id);

    int insert(GoodsSource record);

    int insertSelective(GoodsSource record);

    GoodsSource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsSource record);

    int updateByPrimaryKey(GoodsSource record);
}