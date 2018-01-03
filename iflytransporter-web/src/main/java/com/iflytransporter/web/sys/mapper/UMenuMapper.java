package com.iflytransporter.web.sys.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.iflytransporter.web.sys.bean.UMenu;
import com.iflytransporter.web.sys.bo.UMenuBo;

public interface UMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UMenu record);

    int insertSelective(UMenu record);

    UMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UMenu record);

    int updateByPrimaryKey(UMenu record);

	List<UMenuBo> selectPermissionById(Long id);
	//根据用户ID获取权限的Set集合
	Set<String> findPermissionByUserId(Long id);
	
	List<Map<String,Object>>  findMenusByUserId(Long userId);
	
	List<Map<String,Object>>  findMenusByParentId(Long parentId);
}