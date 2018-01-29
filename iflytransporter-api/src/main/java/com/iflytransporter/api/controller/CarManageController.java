package com.iflytransporter.api.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iflytransporter.api.bean.CarResp;
import com.iflytransporter.api.service.CarManageService;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.bean.CarAirCoolant;
import com.iflytransporter.common.bean.CarDocuments;
import com.iflytransporter.common.bean.CarEngineOil;
import com.iflytransporter.common.bean.CarSafetyEquipment;
import com.iflytransporter.common.bean.CarSignalLight;
import com.iflytransporter.common.bean.CarTyre;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.utils.UUIDUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "carManage api",description="车辆操作 Controller")
@Controller
@RequestMapping("/carManage/{version}")
public class CarManageController {
	
	@Autowired
	private CarManageService carManageService;
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="addCarAirCoolant", notes="新增",produces = "application/json")
	@RequestMapping(value="addCarAirCoolant", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addCarAirCoolant(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CarAirCoolant obj){
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailUserByCache(userId);
		String id = UUIDUtil.UUID();
		obj.setId(id);
		obj.setCompanyId(user.getCompanyId());
		obj.setDriverId(userId);
		int result = carManageService.addCarAirCoolant(obj);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="addCarDocuments", notes="新增",produces = "application/json")
	@RequestMapping(value="addCarDocuments", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addCarDocuments(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CarDocuments obj){
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailUserByCache(userId);
		String id = UUIDUtil.UUID();
		obj.setId(id);
		obj.setCompanyId(user.getCompanyId());
		obj.setDriverId(userId);
		int result = carManageService.addCarDocuments(obj);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="addCarEngineOil", notes="新增",produces = "application/json")
	@RequestMapping(value="addCarEngineOil", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addCarEngineOil(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CarEngineOil obj){
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailUserByCache(userId);
		String id = UUIDUtil.UUID();
		obj.setId(id);
		obj.setCompanyId(user.getCompanyId());
		obj.setDriverId(userId);
		int result = carManageService.addCarEngineOil(obj);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="addCarSafetyEquipment", notes="新增",produces = "application/json")
	@RequestMapping(value="addCarSafetyEquipment", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addCarSafetyEquipment(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CarSafetyEquipment obj){
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailUserByCache(userId);
		String id = UUIDUtil.UUID();
		obj.setId(id);
		obj.setCompanyId(user.getCompanyId());
		obj.setDriverId(userId);
		int result = carManageService.addCarSafetyEquipment(obj);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="addCarSignalLight", notes="新增",produces = "application/json")
	@RequestMapping(value="addCarSignalLight", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addCarSignalLight(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CarSignalLight obj){
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailUserByCache(userId);
		String id = UUIDUtil.UUID();
		obj.setId(id);
		obj.setCompanyId(user.getCompanyId());
		obj.setDriverId(userId);
		int result = carManageService.addCarSignalLight(obj);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="addCarTyre", notes="新增",produces = "application/json")
	@RequestMapping(value="addCarTyre", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addCarTyre(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CarTyre obj){
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailUserByCache(userId);
		String id = UUIDUtil.UUID();
		obj.setId(id);
		obj.setCompanyId(user.getCompanyId());
		obj.setDriverId(userId);
		int result = carManageService.addCarTyre(obj);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	
}
