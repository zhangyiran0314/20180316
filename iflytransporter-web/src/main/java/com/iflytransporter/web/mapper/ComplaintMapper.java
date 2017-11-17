package com.iflytransporter.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.Complaint;

public interface ComplaintMapper {
	
	List<Complaint> queryAll(@Param("shipperId")String sId,@Param("transporterId")String tId,@Param("waybillId")String wId);
	
    int deleteByPrimaryKey(String id);

    int insert(Complaint record);

    int insertSelective(Complaint record);

    Complaint selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Complaint record);

    int updateByPrimaryKey(Complaint record);
}