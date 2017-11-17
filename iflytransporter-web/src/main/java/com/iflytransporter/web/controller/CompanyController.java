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
import com.iflytransporter.common.bean.Company;
import com.iflytransporter.common.bean.CompanyBO;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {
	private static Logger logger = LoggerFactory.getLogger(CompanyController.class);
	@Autowired
	private CompanyService companyService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("company/list");
		return "company/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer pageNo,HttpServletRequest request){
		PageInfo<Company> page = companyService.queryPage( pageNo, 10);
		return ResponseUtil.successResult(page);
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "company/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "company/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		CompanyBO obj = companyService.queryDetailBO(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(Company obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
