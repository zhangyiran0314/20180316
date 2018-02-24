package com.iflytransporter.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.GoodsSource;

public interface GoodsSourceMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(GoodsSource record);

    int insertSelective(GoodsSource record);

    GoodsSource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsSource record);

    int updateByPrimaryKey(GoodsSource record);
    
    List<GoodsSource> queryAll(@Param("userId")String userId);

    /**
     * 查询货源是否已经存在,如果存在则不添加
     */
    int selectByRecord(GoodsSource record);
}