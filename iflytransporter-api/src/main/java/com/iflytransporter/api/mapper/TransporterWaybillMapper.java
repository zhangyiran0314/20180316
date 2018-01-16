package com.iflytransporter.api.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TransporterWaybillMapper {
	
	Map<String, Object> detailShipperCompany(String id);
	
	Map<String, Object> detailShipperComment(String id);
	
	Map<String,Object> listDriver(@Param("companyId")String companyId,@Param("level")Integer level);
	    
    Map<String,Object> listCar(String companyId);
    
    int dispense(@Param("id")String id,@Param("driverId")String driverId,@Param("carId")String carId,@Param("dispenseStatus")Integer dispenseStatus);
    
    /** 派单司机以及车辆信息 */
	Map<String,Object> detailDispense(String id);
}