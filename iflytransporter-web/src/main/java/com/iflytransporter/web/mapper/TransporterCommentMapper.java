package com.iflytransporter.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.TransporterComment;

public interface TransporterCommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(TransporterComment record);

    int insertSelective(TransporterComment record);

    TransporterComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TransporterComment record);

    int updateByPrimaryKey(TransporterComment record);
    
    List<Map<String,Object>> queryAll(@Param("orderNo")String orderNo,@Param("transporterMobile")String tMobile,
			@Param("shipperCompanyName")String sCompanyName,@Param("shipperMobile")String sMobile);
	
	Map<String,Object> queryDetail(String id);
}