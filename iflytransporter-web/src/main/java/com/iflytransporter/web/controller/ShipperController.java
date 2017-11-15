package com.iflytransporter.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Shipper;
import com.iflytransporter.common.bean.ShipperBO;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.ShipperService;
import com.iflytransporter.web.sys.bean.UUser;

@Controller
@RequestMapping("/shipper")
public class ShipperController {
	private static Logger logger = LoggerFactory.getLogger(ShipperController.class);
	@Autowired
	private ShipperService shipperService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("shipper/list");
		return "shipper/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer pageNo,HttpServletRequest request){
		PageInfo<Shipper> page = shipperService.queryPage( pageNo, 10);
		return ResponseUtil.successResult(page);
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "shipper/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "shipper/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		ShipperBO obj = shipperService.queryDetailBO(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(Shipper obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
