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
    
    List<Waybill> queryAll(@Param("shipperId")String shipperId,@Param("transporterId")String transporterId,
    		@Param("shipperCompanyId")String shipperCompanyId,@Param("transporterCompanyId")String transporterCompanyId,
    		@Param("status")Integer status);
    
    List<WaybillBO> queryAllBO(@Param("shipperId")String shipperId,@Param("transporterId")String transporterId,
    		@Param("shipperCompanyId")String shipperCompanyId,@Param("transporterCompanyId")String transporterCompanyId,
    		@Param("status")Integer status);
    
    WaybillBO selectByPrimaryKeyBO(String id);
    
    Map<String, Object> detailCompany(String id);
    
    Map<String, Object> detailTransporter(String id);
}