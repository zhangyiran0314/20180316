package com.iflytransporter.api.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iflytransporter.api.bean.CompanyResp;
import com.iflytransporter.api.service.CompanyService;
import com.iflytransporter.common.bean.Company;
import com.iflytransporter.common.bean.CompanyBO;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.utils.UUIDUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "company api",description="我的-公司操作 Controller")
@Controller
@RequestMapping("/company/{version}")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@ApiOperation(value="auth", notes="公司-认证",produces = "application/json",response=CompanyResp.class)
	@RequestMapping(value="auth", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> add(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="实体")Company company){
		String userId =  (String) request.getAttribute("userId");
		String id = UUIDUtil.UUID();
		company.setId(id);
		int result = companyService.save(company,userId);
		if(result > 0){
			return ResponseUtil.successResultId(id);
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="detail", notes="详情",produces = "application/json",response=CompanyResp.class)
	@RequestMapping(value="detail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{id:id} id:公司id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		CompanyBO company = companyService.query(id);
		return ResponseUtil.successResult(new CompanyResp(company));
	}
	
	@ApiOperation(value="modify", notes="修改",produces = "application/json",response= CompanyResp.class)
	@RequestMapping(value="modify", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modify(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="实体")Company company){
		int result = companyService.update(company);
		if(result > 0){
			return ResponseUtil.successResultId(company.getId());
		}
		return ResponseUtil.failureResult();
	}
}
