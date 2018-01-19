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
import com.iflytransporter.common.bean.Car;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.TransporterCarService;

@Controller
@RequestMapping("transporter/car")
public class TransporterCarController {
	private static Logger logger = LoggerFactory.getLogger(TransporterCarController.class);
	@Autowired
	private TransporterCarService transporterCarService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("car/list");
		return "transporter/car/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,String code,String companyName,String transporterMobile,String driverMobile,HttpServletRequest request){
		PageInfo<Map<String, Object>> result = transporterCarService.queryPage(page, limit, code, companyName, transporterMobile,driverMobile);
		return ResponseUtil.successPage(result.getTotal(),result.getList());
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "transporter/car/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "transporter/car/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		Map<String,Object> obj = transporterCarService.queryDetail(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(Car obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
