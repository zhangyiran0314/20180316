package com.iflytransporter.api.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iflytransporter.api.utils.ResponseUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("car")
public class CarController {
	
	@ApiOperation(value="查看车辆列表", notes="查看车辆列表")
    @ApiImplicitParam(name = "userId",value = "用户id",paramType = "form",dataType = "String",required=true)
	@RequestMapping(value="listCar", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  listCar(HttpServletRequest request, HttpServletResponse response){
		return ResponseUtil.successResult();
	}
	@ApiOperation(value="添加车辆", notes="添加车辆")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "userId",value = "用户id",paramType = "form",dataType = "String",required=true), 
    	@ApiImplicitParam(name = "name",value = "车辆名称",paramType = "form",dataType = "String",required=true), 
		@ApiImplicitParam(name = "code",value = "车牌号码",paramType = "form",dataType = "String",required=true), 
        @ApiImplicitParam(name = "attachmentId1",value = "认证图片1",paramType = "form",dataType = "String",required=true),
    	@ApiImplicitParam(name = "attachmentId1",value = "认证图片2",paramType = "form",dataType = "String",required=true),
    })
	@RequestMapping(value="addCar", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  addUser(HttpServletRequest request, HttpServletResponse response){
		return ResponseUtil.successResult();
	}
	
	@ApiOperation(value="车辆详情", notes="查看车辆详情")
	@ApiImplicitParams({
    	@ApiImplicitParam(name = "userId",value = "用户id",paramType = "form",dataType = "String",required=true), 
    	@ApiImplicitParam(name = "carId",value = "车辆id",paramType = "form",dataType = "String",required=true), 
    })
	@RequestMapping(value="detailCar", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  detailCar(HttpServletRequest request, HttpServletResponse response){
		String userId = (String) request.getAttribute("userId");
		System.out.println(userId);
		return ResponseUtil.successResult();
	}
	@ApiOperation(value="修改车辆", notes="根据用户ID修改用户资料")
	@ApiImplicitParams({
    	@ApiImplicitParam(name = "userId",value = "用户id",paramType = "form",dataType = "String",required=true), 
    	@ApiImplicitParam(name = "carId",value = "车辆id",paramType = "form",dataType = "String",required=true),
    	@ApiImplicitParam(name = "name",value = "车辆名称",paramType = "form",dataType = "String",required=true), 
		@ApiImplicitParam(name = "code",value = "车牌号码",paramType = "form",dataType = "String",required=true), 
        @ApiImplicitParam(name = "attachmentId1",value = "认证图片1",paramType = "form",dataType = "String",required=true),
    	@ApiImplicitParam(name = "attachmentId1",value = "认证图片2",paramType = "form",dataType = "String",required=true),
	})
	@RequestMapping(value="modifyCar", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  modifyCar(HttpServletRequest request, HttpServletResponse response){
		return ResponseUtil.successResult();
	}
	@ApiOperation(value="删除车辆", notes="根据车辆ID删除用户")
	@ApiImplicitParams({
    	@ApiImplicitParam(name = "userId",value = "用户id",paramType = "form",dataType = "String",required=true), 
    	@ApiImplicitParam(name = "carId",value = "删除车辆id",paramType = "form",dataType = "String",required=true), 
    })
	@RequestMapping(value="deleteCar", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  deleteCar(HttpServletRequest request, HttpServletResponse response){
		return ResponseUtil.successResult();
	}
}
