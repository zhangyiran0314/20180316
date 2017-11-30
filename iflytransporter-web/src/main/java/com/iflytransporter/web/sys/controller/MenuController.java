package com.iflytransporter.web.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	
	//查询当前用户的所有权限
	@RequestMapping("findMenus")
	@ResponseBody
	public Map<String,Object> findMenus(HttpServletRequest request){
		Long userId = TokenManager.getUserId();
		 
		List<Map<String,Object>> menus = permissionService.findMenusByUserId(userId);
		if(menus!=null && menus.size() > 0){
			String path = env.getProperty("server.context-path");
			for(Map<String,Object> map :menus){
				map.put("href", path+map.get("href").toString());
			}
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("list",menus);
		result.put("status", 200);
		return result;
	}
}
