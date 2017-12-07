package com.iflytransporter.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.service.CarService;
import com.iflytransporter.api.utils.RequestMapUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.bean.Car;
import com.iflytransporter.common.utils.UUIDUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "car api",description="我的-车辆操作 Controller")
@Controller
@RequestMapping("/car/{version}")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@ApiOperation(value="queryPage", notes="分页列表",produces = "application/json")
	@RequestMapping(value="queryPage", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPage(HttpServletRequest request, HttpServletResponse response,
			@RequestBody   @ApiParam(value="pageNo,pageSize")  Map<String,Object> requestMap){
		Integer pageNo = RequestMapUtil.formatPageNo(requestMap);
		Integer pageSize = RequestMapUtil.formatPageSize(requestMap);
		String userId =  (String) request.getAttribute("userId");
		PageInfo<Car> page = carService.queryPage(pageNo,pageSize, userId);
		return ResponseUtil.successResult(page);
	}
	@ApiOperation(value="list", notes="列表",produces = "application/json")
	@RequestMapping(value="list", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, HttpServletResponse response,
			@RequestBody  Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		List<Car> page = carService.list(userId);
		return ResponseUtil.successResult(page);
	}
	@ApiOperation(value="add", notes="新增",produces = "application/json")
	@RequestMapping(value="add", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> add(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Car car){
		String userId =  (String) request.getAttribute("userId");
		String id = UUIDUtil.UUID();
		car.setId(id);
		Car result = carService.save(car,userId);
		if(result != null){
			return ResponseUtil.successResult(result);
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="detail", notes="详情",produces = "application/json")
	@RequestMapping(value="detail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		Car car = carService.query(id);
		return ResponseUtil.successResult(car);
	}
	@ApiOperation(value="modify", notes="修改",produces = "application/json")
	@RequestMapping(value="modify", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modify(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Car car){
		int result = carService.update(car);
		if(result > 0){
			Car data = carService.query(car.getId());
			return ResponseUtil.successResult(data);
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="delete", notes="删除",produces = "application/json")
	@RequestMapping(value="delete", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> delete(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		int result = carService.delete(id);
		if(result > 0){
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("id", id);
			return ResponseUtil.successResult(data);
		}
		return ResponseUtil.failureResult();
	}
}
