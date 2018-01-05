package com.iflytransporter.web.mapper;

import java.util.List;

import com.iflytransporter.common.bean.Area;
import com.iflytransporter.common.bean.AreaBO;

public interface AreaMapper {
	
	List<AreaBO> queryAllBO();
	
	AreaBO selectByPrimaryKeyBO(String id);
	
    int deleteByPrimaryKey(String id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
    
}