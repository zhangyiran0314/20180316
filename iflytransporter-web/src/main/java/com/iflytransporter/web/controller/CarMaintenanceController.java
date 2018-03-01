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
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.CarMaintenanceService;

@Controller
@RequestMapping("/carMaintenance")
public class CarMaintenanceController {
	private static Logger logger = LoggerFactory.getLogger(CarMaintenanceController.class);
	@Autowired
	private CarMaintenanceService carMaintenanceService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("carMaintenance/list");
		return "carMaintenance/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,String companyName,
			HttpServletRequest request){
		PageInfo<Map<String,Object>> result = carMaintenanceService.queryPage(page, limit, companyName);
		return ResponseUtil.successPage(result.getTotal(), result.getList());
				
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		Map<String,Object> obj = carMaintenanceService.queryDetail(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "carMaintenance/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "carMaintenance/edit";
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(User obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
