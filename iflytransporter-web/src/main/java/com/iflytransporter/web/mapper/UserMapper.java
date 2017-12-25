package com.iflytransporter.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<UserBO> queryAll(@Param("userType")Integer userType,@Param("mobile")String mobile);
	
    UserBO selectByPrimaryKeyBO(String id);
	
}