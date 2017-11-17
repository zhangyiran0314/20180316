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
import com.iflytransporter.common.bean.City;
import com.iflytransporter.common.bean.CityBO;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController {
	private static Logger logger = LoggerFactory.getLogger(CityController.class);
	@Autowired
	private CityService cityService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("city/list");
		return "city/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer pageNo,HttpServletRequest request){
		PageInfo<CityBO> page = cityService.queryPage( pageNo, 10);
		return ResponseUtil.successResult(page);
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "city/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "city/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		CityBO obj = cityService.queryDetailBO(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(City obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
