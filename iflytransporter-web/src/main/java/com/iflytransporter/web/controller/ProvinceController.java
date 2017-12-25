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
import com.iflytransporter.common.bean.Province;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.ProvinceService;

@Controller
@RequestMapping("/province")
public class ProvinceController {
	private static Logger logger = LoggerFactory.getLogger(ProvinceController.class);
	@Autowired
	private ProvinceService provinceService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("province/list");
		return "province/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,HttpServletRequest request){
		PageInfo<Province> queryPage = provinceService.queryPage( page, limit);
		return ResponseUtil.successPage(queryPage.getTotal(), queryPage.getList());
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "province/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "province/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		Province obj = provinceService.queryDetail(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(Province obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
