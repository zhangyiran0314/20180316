package com.iflytransporter.api.controller;

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

import com.iflytransporter.api.bean.carmanage.CarDailyInspectionReq;
import com.iflytransporter.api.service.CarManageService;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.api.utils.UUIDUtil;
import com.iflytransporter.common.bean.CarDriveRest;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.enums.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "carManage api",description="车辆管理操作 Controller")
@Controller
@RequestMapping("/carManage/{version}")
public class CarManageController {
	
	@Autowired
	private CarManageService carManageService;
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="addCarDailyInspection", notes="新增-每日一检",produces = "application/json")
	@RequestMapping(value="addCarDailyInspection", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addCarDailyInspection(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CarDailyInspectionReq dailyInspection){
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailUserByCache(userId);
		String companyId = user.getCompanyId();
		
		int result = carManageService.addCarDailyInspection(dailyInspection, companyId, userId);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="index", notes="车辆管理-主页",produces = "application/json")
	@RequestMapping(value="index", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> index(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		
		User user = userService.detailUserByCache(userId);
		String companyId = user.getCompanyId();
		Map<String,Object> result  = new HashMap<String,Object>();
	
		//管理员首页
		if(Status.User_Level_Admin == user.getLevel()){
			//1.查询我的运单
			//2.每日一检
			//3.司机休息
			//4.保险提醒
			//5.路税提醒
			//6.车检提醒
			// TODO
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="listDailyInspection", notes="车辆管理-每日一检列表",produces = "application/json")
	@RequestMapping(value="listDailyInspection", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> listDailyInspection(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailUserByCache(userId);
		if(Status.User_Level_Admin == user.getLevel()){
			// TODO
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="dailyInspection", notes="车辆管理-每日一检",produces = "application/json")
	@RequestMapping(value="dailyInspection", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> dailyInspection(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailUserByCache(userId);
		String carId = (String) requestMap.get("carId");
		if(Status.User_Level_Admin == user.getLevel() && StringUtils.isNotBlank(carId)){
			// TODO
			return ResponseUtil.successResult();
		}else if(Status.User_Level_Admin != user.getLevel()){
			// TODO
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	/*@ApiOperation(value="addCarAirCoolant", notes="新增",produces = "application/json")
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
	*/
	@ApiOperation(value="addCarDriveRest", notes="新增-行车休息",produces = "application/json")
	@RequestMapping(value="addCarDriveRest", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addCarDriveRest(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String carId = (String) requestMap.get("carId");
		Integer type = (Integer) requestMap.get("type");
		User user = userService.detailUserByCache(userId);
		String companyId = user.getCompanyId();
		CarDriveRest cdr = new CarDriveRest();
		cdr.setCarId(carId);
		cdr.setCompanyId(companyId);
		cdr.setDriverId(userId);
		cdr.setType(type);
		cdr.setId(UUIDUtil.UUID());
		int result = carManageService.addCarDriveRest(cdr);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
}
