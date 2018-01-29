package com.iflytransporter.web.mapper;

import com.iflytransporter.common.bean.CarDocuments;

public interface CarDocumentsMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarDocuments record);

    int insertSelective(CarDocuments record);

    CarDocuments selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarDocuments record);

    int updateByPrimaryKey(CarDocuments record);
}