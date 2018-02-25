package com.iflytransporter.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.utils.RedisUtil;
import com.iflytransporter.web.mapper.UserMapper;
import com.iflytransporter.web.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
    private RedisTemplate<String, String> redisTemplate;//注入redis缓存
	
	@Autowired
	private UserMapper userMapper;


	@Override
	public PageInfo<Map<String,Object>> queryPage(Integer pageNo, Integer pageSize, Integer userType, String mobile) {
		if(pageNo!= null && pageSize!= null){  
            PageHelper.startPage(pageNo, pageSize);  
        }  
		List<Map<String,Object>> list= userMapper.queryAll(userType,mobile);
		return new PageInfo<Map<String,Object>>(list);
	}

	@Override
	public int updateUser(User user) {
		int result = userMapper.updateByPrimaryKeySelective(user);
		if(result >0){
			String keyBO = RedisUtil.getUserBOKey(user.getId());
			redisTemplate.delete(keyBO);
			String key = RedisUtil.getUserKey(user.getId());
			redisTemplate.delete(key);
		}
		return result;
	}


	@Override
	public User selectOne(String id) {
		return userMapper.selectByPrimaryKey(id);
	}


	@Override
	public Map<String, Object> queryDetail(String id) {
		return userMapper.queryDetail(id);
	}

}
