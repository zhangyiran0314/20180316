package com.iflytransporter.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.TransporterComplaint;

public interface TransporterComplaintMapper {
    int deleteByPrimaryKey(String id);

    int insert(TransporterComplaint record);

    int insertSelective(TransporterComplaint record);

    TransporterComplaint selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TransporterComplaint record);

    int updateByPrimaryKey(TransporterComplaint record);
    
	List<Map<String,Object>> queryAll(@Param("orderNo")String orderNo,@Param("transporterMobile")String tMobile,
			@Param("shipperCompanyName")String sCompanyName,@Param("shipperMobile")String sMobile);
	Map<String,Object> queryDetail(String id);
}