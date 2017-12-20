package com.iflytransporter.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Waybill;
import com.iflytransporter.common.bean.WaybillBO;

public interface WaybillMapper {
    int deleteByPrimaryKey(String id);

    int insert(Waybill record);

    int insertSelective(Waybill record);

    Waybill selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Waybill record);

    int updateByPrimaryKey(Waybill record);
    
    List<WaybillBO> queryAllBO(@Param("shipperId")String shipperId,@Param("transporterId")String transporterId,@Param("status")Integer status);
    
    WaybillBO selectByPrimaryKeyBO(String id);
    
    Map<String, Object> detailCompany(String id);
    
    Map<String, Object> detailTransporter(String id);
}