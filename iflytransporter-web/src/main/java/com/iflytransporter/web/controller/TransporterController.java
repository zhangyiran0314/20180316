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
import com.iflytransporter.common.bean.Transporter;
import com.iflytransporter.common.bean.TransporterBO;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.TransporterService;

@Controller
@RequestMapping("/transporter")
public class TransporterController {
	private static Logger logger = LoggerFactory.getLogger(TransporterController.class);
	@Autowired
	private TransporterService transporterService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("transporter/list");
		return "transporter/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer pageNo,HttpServletRequest request){
		PageInfo<Transporter> page = transporterService.queryPage( pageNo, 10);
		return ResponseUtil.successResult(page);
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "transporter/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "transporter/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		TransporterBO obj = transporterService.queryDetailBO(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(Transporter obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
