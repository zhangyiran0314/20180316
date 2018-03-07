package com.iflytransporter.api.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Waybill;

public interface TransporterWaybillMapper {
	
	 List<Waybill> queryAll(@Param("shipperId")String shipperId,@Param("transporterId")String transporterId,
	    		@Param("shipperCompanyId")String shipperCompanyId,@Param("transporterCompanyId")String transporterCompanyId,
	    		@Param("status")Integer status,@Param("dispenseStatus")Integer dispenseStatus,
	    		@Param("lastCreateDate")Date lastCreateDate,@Param("than")String than); 
	
    Map<String, Object> detailShipper(String shipperId);
    
	Map<String, Object> detailShipperCompany(String id);
	
	Map<String, Object> detailShipperComment(String id);
	
	List<Map<String,Object>> listDriver(@Param("companyId")String companyId,@Param("level")Integer level);
	    
	List<Map<String,Object>> listCar(String companyId);
    
    int dispense(@Param("id")String id,@Param("driverId")String driverId,@Param("carId")String carId,@Param("dispenseStatus")Integer dispenseStatus);
    
    /** 司机信息 */
	Map<String,Object> detailDriver(String driverId);
    
    /** 派单司机以及车辆信息 */
	Map<String,Object> detailDispense(String id);
	/** 车辆详情*/
	Map<String,Object> detailDispenseComment(String driverId);
	
	/**收货凭证 */
	int loadingProof(@Param("id")String id,@Param("takeAttachmentId1")String attachment1,@Param("takeAttachmentId2")String attachment2,
			@Param("takeAttachmentId3")String attachment3,@Param("takeAttachmentId4")String attachment4,@Param("status")Integer status);
	/**交货凭证 */
	int deliverProof(@Param("id")String id,@Param("deliverAttachmentId1")String attachment1,@Param("deliverAttachmentId2")String attachment2,
			@Param("deliverAttachmentId3")String attachment3,@Param("deliverAttachmentId4")String attachment4,@Param("status")Integer status);
}