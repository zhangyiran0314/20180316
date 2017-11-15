package com.iflytransporter.api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iflytransporter.api.service.ShipperService;
import com.iflytransporter.api.utils.HttpUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.bean.Shipper;
import com.iflytransporter.common.enums.BuzExceptionEnums;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户管理-货主端")
@Controller("shipper")
@RequestMapping("shipper/{version}/")
public class ShipperController {
	
	@Autowired
	private ShipperService userShipperService;
	
	@ApiOperation(value="登录", notes="根据手机号和密码登录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "mobile",value = "手机号码",paramType = "form",dataType = "String",required=true), 
        @ApiImplicitParam(name = "password",value = "用户密码",paramType = "form",dataType = "String",required=true)
    })
	@RequestMapping(value="login", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  login(Map<String,Object> map,HttpServletRequest request){
		String userId = request.getParameter("userId");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		Map<String,Object> data =new HashMap<String,Object>();
		if(StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(password)){
			Shipper user = userShipperService.login(mobile, password);
			if(null == user){
				return ResponseUtil.failureResult(BuzExceptionEnums.AccountOrPasswordErr);
			}
			String ip = HttpUtil.getRemoteIp(request);
			user.setLastLoginIp(ip);
			user.setLastLoginDate(new Date());
			
			userShipperService.updateLoginInfo(user);
			data.put("user", user);
			return ResponseUtil.successResult(data);
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="认证个人信息", notes="上传认证信息")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "userId",value = "用户id",paramType = "form",dataType = "String",required=true), 
    	@ApiImplicitParam(name = "user", value = "user内容", required = true, dataType = "UserShipper")
    })
	@RequestMapping(value="identifyUser", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  identifyUser(HttpServletRequest request, HttpServletResponse response){
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		Map<String,Object> data =new HashMap<String,Object>();
		if(StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(password)){
			Shipper user = userShipperService.login(mobile, password);
			if(null == user){
				return ResponseUtil.failureResult(BuzExceptionEnums.AccountOrPasswordErr);
			}
			String ip = HttpUtil.getRemoteIp(request);
			user.setLastLoginIp(ip);
			user.setLastLoginDate(new Date());
			
			userShipperService.updateLoginInfo(user);
			data.put("user", user);
			return ResponseUtil.successResult(data);
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="认证公司信息", notes="认证公司信息")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "userId",value = "用户id",paramType = "form",dataType = "String",required=true), 
    	@ApiImplicitParam(name = "company", value = "公司内容", required = true, dataType = "Company")
    })
	@RequestMapping(value="identifyCompany", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  identifyCompany(HttpServletRequest request, HttpServletResponse response){
		return ResponseUtil.successResult();
	}
	@ApiOperation(value="查看下级用户列表", notes="查看下级用户列表")
    @ApiImplicitParam(name = "userId",value = "用户id",paramType = "form",dataType = "String",required=true)
	@RequestMapping(value="listUser", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  listUser(HttpServletRequest request, HttpServletResponse response){
		return ResponseUtil.successResult();
	}
	@ApiOperation(value="添加下级用户", notes="添加下级用户")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "userId",value = "用户id",paramType = "form",dataType = "String",required=true), 
    	@ApiImplicitParam(name = "user", value = "user内容", required = true, dataType = "UserShipper")
    })
	@RequestMapping(value="addUser", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  addUser(HttpServletRequest request, HttpServletResponse response){
		return ResponseUtil.successResult();
	}
	
	@ApiOperation(value="用户详情", notes="根据用户ID查看用户详情,可以是查看自身,也可以是查看下级")
    @ApiImplicitParam(name = "userId",value = "用户id",paramType = "form",dataType = "String",required=true)
	@RequestMapping(value="detailUser", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  detailUser(HttpServletRequest request, HttpServletResponse response){
		return ResponseUtil.successResult();
	}
	@ApiOperation(value="修改用户", notes="根据用户ID修改用户资料")
	@ApiImplicitParams({
	    	@ApiImplicitParam(name = "userId",value = "用户id",paramType = "form",dataType = "String",required=true), 
	    	@ApiImplicitParam(name = "user", value = "user内容", required = true, dataType = "UserShipper")
	    })
	@RequestMapping(value="modifyUser", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  modifyUser(@RequestBody Shipper user,HttpServletRequest request, HttpServletResponse response){
		return ResponseUtil.successResult();
	}
	@ApiOperation(value="删除用户", notes="根据用户ID删除用户")
	@ApiImplicitParams({
    	@ApiImplicitParam(name = "userId",value = "用户id",paramType = "form",dataType = "String",required=true), 
    	@ApiImplicitParam(name = "deleteId",value = "删除用户id",paramType = "form",dataType = "String",required=true), 
    })
	@RequestMapping(value="deleteUser", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  deleteUser(HttpServletRequest request, HttpServletResponse response){
		return ResponseUtil.successResult();
	}
	
	@ApiOperation(value="查看上级", notes="查看上级")
	@ApiImplicitParam(name = "userId",value = "用户id",paramType = "form",dataType = "String",required=true)
	@RequestMapping(value="detailParent", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  detailParent(HttpServletRequest request, HttpServletResponse response){
		return ResponseUtil.successResult();
	}
	@ApiOperation(value="解除上级绑定", notes="解除上级绑定")
	@ApiImplicitParams({
    	@ApiImplicitParam(name = "userId",value = "用户id",paramType = "form",dataType = "String",required=true), 
    	@ApiImplicitParam(name = "parentId",value = "上级用户id",paramType = "form",dataType = "String",required=true), 
    })
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  deleteParent(HttpServletRequest request, HttpServletResponse response){
		return ResponseUtil.successResult();
	}
}
