package com.iflytransporter.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Company;
import com.iflytransporter.common.bean.CompanyBO;
import com.iflytransporter.common.enums.Status;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.CompanyService;

@Controller
@RequestMapping("/transporter/company")
public class TransporterCompanyController {
	private static Logger logger = LoggerFactory.getLogger(TransporterCompanyController.class);
	@Autowired
	private CompanyService companyService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("company/list");
		return "transporter/company/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,String name,HttpServletRequest request){
		PageInfo<Company> result = companyService.queryPage( page, limit,Status.Type_User_Transporter,name);
		return ResponseUtil.successPage(result.getTotal(), result.getList());
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "transporter/company/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "transporter/company/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		Map<String,Object> obj = companyService.queryDetail(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(Company obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
	@RequestMapping("toEditAuth")
	public String toEditAuth(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "transporter/company/editAuth";
	}
	@RequestMapping("editAuth")
	@ResponseBody
	public  Map<String,Object> editAuth(@RequestBody Company obj,HttpServletRequest request){
		int result = companyService.auth(obj);
		if(result > 0 ){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult(ResponseUtil.Msg_Data_Err);
	}
}
