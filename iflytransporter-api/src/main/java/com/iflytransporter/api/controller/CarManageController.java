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
	@ApiOperation(value="index", notes="车辆管理-主页",produces = "application/json")
	@RequestMapping(value="index", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> index(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailUserByCache(userId);
		String companyId = user.getCompanyId();
	
		//管理员首页
		if(Status.User_Level_Admin == user.getLevel()){
			//1.我的运单
			//2.每日一检
			//3.司机休息
			//4.保险提醒
			//5.路税提醒
			//6.车检提醒
			// TODO
		}else{
			//1.我的运单
			//2.每日一检
			//3.司机休息
			//4.保险提醒
			//5.路税提醒
			//6.车检提醒
			Map<String,Object> result = carManageService.indexDriver(companyId, userId);
			result.put("surname", user.getSurname());
			result.put("name", user.getName());
			return ResponseUtil.successResult(result);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="driverCarDailyInspection", notes="司机-每日一检",produces = "application/json")
	@RequestMapping(value="driverCarDailyInspection", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> dailyInspection(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailUserByCache(userId);
		Map<String,Object> result = carManageService.queryDriverCarDailyInspection(user.getCompanyId(), userId);
		return ResponseUtil.successResult(result);
	}
	//司机-我的运单-运单统计
	@ApiOperation(value="driverWaybill", notes="司机-我的运单-运单统计",produces = "application/json")
	@RequestMapping(value="driverWaybill", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> driverWaybill(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailUserByCache(userId);
		Map<String,Object> result = carManageService.queryDriverCarDailyInspection(user.getCompanyId(), userId);
		return ResponseUtil.successResult(result);
	}
	@ApiOperation(value="dailyInspectionList", notes="车辆管理-每日一检-列表",produces = "application/json")
	@RequestMapping(value="dailyInspectionList", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> dailyInspectionList(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailUserByCache(userId);
		if(Status.User_Level_Admin == user.getLevel()){
			// TODO
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	/**保险路税车检详情查询*/
	@ApiOperation(value="detailInsurance", notes="详情",produces = "application/json")
	@RequestMapping(value="detailInsurance", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailInsurance(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String carId = (String) requestMap.get("carId");
		Map<String,Object> result = carManageService.queryCarInsuranceDetail(carId);
		return ResponseUtil.successResult(result);
	}
	@ApiOperation(value="detailTax", notes="详情",produces = "application/json")
	@RequestMapping(value="detailTax", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailTax(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String carId = (String) requestMap.get("carId");
		Map<String,Object> result = carManageService.queryCarTaxDetail(carId);
		return ResponseUtil.successResult(result);
	}
	@ApiOperation(value="detailCheck", notes="详情",produces = "application/json")
	@RequestMapping(value="detailCheck", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailCheck(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String carId = (String) requestMap.get("carId");
		Map<String,Object> result = carManageService.queryCarCheckDetail(carId);
		return ResponseUtil.successResult(result);
	}
	/**每日一检-公用详情查询*/
	@ApiOperation(value="detailCarAirCoolant", notes="详情",produces = "application/json")
	@RequestMapping(value="detailCarAirCoolant", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailCarAirCoolant(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String id = (String) requestMap.get("id");
		Map<String,Object> result = carManageService.detailCarAirCoolant(id);
		return ResponseUtil.successResult(result);
	}
	@ApiOperation(value="detailCarDocuments", notes="新增",produces = "application/json")
	@RequestMapping(value="detailCarDocuments", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailCarDocuments(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String id = (String) requestMap.get("id");
		Map<String,Object> result = carManageService.detailCarDocuments(id);
		return ResponseUtil.successResult(result);
	}
	
	@ApiOperation(value="detailCarEngineOil", notes="新增",produces = "application/json")
	@RequestMapping(value="detailCarEngineOil", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailCarEngineOil(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String id = (String) requestMap.get("id");
		Map<String,Object> result = carManageService.detailCarEngineOil(id);
		return ResponseUtil.successResult(result);
	}
	
	@ApiOperation(value="detailCarSafetyEquipment", notes="新增",produces = "application/json")
	@RequestMapping(value="detailCarSafetyEquipment", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailCarSafetyEquipment(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String id = (String) requestMap.get("id");
		Map<String,Object> result = carManageService.detailCarSafetyEquipment(id);
		return ResponseUtil.successResult(result);
	}
	
	@ApiOperation(value="detailCarSignalLight", notes="新增",produces = "application/json")
	@RequestMapping(value="detailCarSignalLight", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailCarSignalLight(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String id = (String) requestMap.get("id");
		Map<String,Object> result = carManageService.detailCarSignalLight(id);
		return ResponseUtil.successResult(result);
	}
	
	@ApiOperation(value="detailCarTyre", notes="新增",produces = "application/json")
	@RequestMapping(value="detailCarTyre", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailCarTyre(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String id = (String) requestMap.get("id");
		Map<String,Object> result = carManageService.detailCarTyre(id);
		return ResponseUtil.successResult(result);
	}
	/**---------------司机提交操作 start --------------*/
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
}
