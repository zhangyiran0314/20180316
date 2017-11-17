package com.iflytransporter.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Car;
import com.iflytransporter.common.bean.CarBO;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {
	private static Logger logger = LoggerFactory.getLogger(CarController.class);
	@Autowired
	private CarService carService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("car/list");
		return "car/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(@Param("companyId")String cId,Integer pageNo,HttpServletRequest request){
		PageInfo<CarBO> page = carService.queryPage(cId,pageNo, 10);
		return ResponseUtil.successResult(page);
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "car/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "car/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		CarBO obj = carService.queryDetailBO(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(Car obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
