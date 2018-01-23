package com.iflytransporter.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Waybill;

public interface WaybillMapper {
	
	List<Map<String,Object>> queryAll(Integer pageNo,Integer pageSize,@Param("orderNo")String orderNo,
			@Param("status")Integer stauts,@Param("dispenseStatus")Integer dispenseStatus,
			@Param("sCompanyName")String sCompanyName,@Param("sMobile")String sMobile,
			@Param("tCompanyName")String tCompanyName,@Param("tMobile")String tMobile,@Param("dMobile")String dMobile);
	
	Map<String,Object> queryDetail(String id);
	
	Map<String,Object> takeAttachmentList(String id);
	
	Map<String,Object> deliverAttachmentList(String id);
	
	
    int deleteByPrimaryKey(String id);

    int insert(Waybill record);

    int insertSelective(Waybill record);

    Waybill selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Waybill record);

    int updateByPrimaryKey(Waybill record);
}