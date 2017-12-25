package com.iflytransporter.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.CarType;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.CarTypeService;

@Controller
@RequestMapping("/carType")
public class CarTypeController {
	private static Logger logger = LoggerFactory.getLogger(CarTypeController.class);
	@Autowired
	private CarTypeService carTypeService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("carType/list");
		return "carType/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,HttpServletRequest request){
		PageInfo<CarType> queryPage = carTypeService.queryPage(page, limit);
		return ResponseUtil.successPage(queryPage.getTotal(),queryPage.getList());
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "carType/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "carType/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		CarType obj = carTypeService.queryDetail(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(CarType obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
	@RequestMapping("delete")
	@ResponseBody
	public  Map<String,Object> delete(String id,HttpServletRequest request){
		
		return ResponseUtil.successResult();
	}
}
