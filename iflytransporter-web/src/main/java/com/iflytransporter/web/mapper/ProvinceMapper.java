package com.iflytransporter.web.mapper;

import com.iflytransporter.common.bean.Province;

public interface ProvinceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}