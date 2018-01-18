package com.iflytransporter.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Complaint;

public interface ComplaintMapper {
	
	List<Map<String,Object>> queryAll(@Param("orderNo")String orderNo,@Param("shipperMobile")String sMobile,
			@Param("transporterCompanyName")String tCompanyName,@Param("transporterMobile")String tMobile,
			@Param("driverMobile")String dMobile);
	
	Map<String,Object> queryDetail(String id);
	
    int deleteByPrimaryKey(String id);

    int insert(Complaint record);

    int insertSelective(Complaint record);

    Complaint selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Complaint record);

    int updateByPrimaryKey(Complaint record);
}