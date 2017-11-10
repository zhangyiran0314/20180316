package com.iflytransporter.web.sys.mapper;

import java.util.List;
import java.util.Map;

import com.iflytransporter.web.sys.bean.UUser;
import com.iflytransporter.web.sys.bo.URoleBo;

public interface UUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UUser record);

    int insertSelective(UUser record);

    UUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UUser record);

    int updateByPrimaryKey(UUser record);

	UUser login(Map<String, Object> map);

	UUser findUserByEmail(String email);

	List<URoleBo> selectRoleByUserId(Long id);

	List<UUser> findAll();
	
}