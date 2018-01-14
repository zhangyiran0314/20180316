package com.iflytransporter.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.UserBO;

public interface TransporterMapper {
	
	//查询用户详情
	public UserBO selectByPrimaryKeyBO(String id);
	
	//查看下级列表
	public List<Map<String,Object>> listDown(@Param("parentId")String parentId);
	
	//修改认证状态
	int updateAuthStatus(@Param("id")String id,@Param("authStatus")Integer authStatus,@Param("companyAuthStatus")Integer companyAuthStatus);
	
	//修改用户公司信息
	int updateCompany(@Param("id")String id,@Param("companyId")String companyId,@Param("companyAuthStatus")Integer companyAuthStatus);
	
	//删除下级
	int deleteDown(@Param("id")String id,@Param("parentId")String parentId);
}