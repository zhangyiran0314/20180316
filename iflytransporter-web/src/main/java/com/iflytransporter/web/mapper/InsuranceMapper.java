package com.iflytransporter.web.mapper;

import java.util.List;

import com.iflytransporter.common.bean.Insurance;

public interface InsuranceMapper {
	
	List<Insurance> queryAll();
	
	
    int deleteByPrimaryKey(String id);

    int insert(Insurance record);

    int insertSelective(Insurance record);

    Insurance selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Insurance record);

    int updateByPrimaryKeyWithBLOBs(Insurance record);

    int updateByPrimaryKey(Insurance record);
}