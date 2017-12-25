package com.iflytransporter.web.mapper;

import java.util.List;

import com.iflytransporter.common.bean.PaymentType;

public interface PaymentTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(PaymentType record);

    int insertSelective(PaymentType record);

    PaymentType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PaymentType record);

    int updateByPrimaryKey(PaymentType record);
    
    List<PaymentType> queryAll();
}