package com.iflytransporter.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Insurance;

public interface InsuranceMapper {
	
	List<Map<String,Object>> queryAll(@Param("policyholderCompany")String policyholderCompany,@Param("policyholderMobile")String policyholderMobile,@Param("policyholderName") String policyholderName);
	
    int deleteByPrimaryKey(String id);

    int insert(Insurance record);

    int insertSelective(Insurance record);

    Insurance selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Insurance record);

    int updateByPrimaryKeyWithBLOBs(Insurance record);

    int updateByPrimaryKey(Insurance record);
}