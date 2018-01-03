package com.iflytransporter.web.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.shiro.TokenManager;
import com.iflytransporter.web.sys.service.PermissionService;

@Controller
@RequestMapping("menu")
@RequiresPermissions("user")
public class MenuController {
	
	private static Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
    public Environment env;//当前环境的application.properties的 配置
	
	@Autowired
	PermissionService permissionService;
	
	private int Level_Parent= 1;
	private int Level_leaf = 0;
	//查询当前用户的所有权限
	@RequestMapping("findMenus")
	@ResponseBody
	public Map<String,Object> findMenus(HttpServletRequest request){
		Long userId = TokenManager.getUserId();
		 
		List<Map<String,Object>> menus = permissionService.findMenusByUserId(userId);
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		if(menus!=null && menus.size() > 0){
			String path = env.getProperty("server.context-path");
			for(Map<String,Object> map :menus){
				Integer level = (Integer) map.get("level");
				Long id = (Long) map.get("id");
				Long parentId = (Long) map.get("parentId");
				if(level != null && Level_leaf == level.intValue() && parentId!=null){
					continue;
				}
				if(level != null && Level_Parent == level.intValue()){
					List<Map<String,Object>> children = permissionService.findMenusByParentId(id);
					for(Map<String,Object> childrenMap :children){
						childrenMap.put("href", path+childrenMap.get("href").toString());
					}
					map.put("children", children);
				}else{
					map.put("href", path+map.get("href").toString());
				}
				resultList.add(map);
			}
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("list",resultList);
		result.put("status", 200);
		return result;
	}
}
