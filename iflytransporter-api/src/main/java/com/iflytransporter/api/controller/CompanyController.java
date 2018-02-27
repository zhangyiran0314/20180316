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
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.common.bean.Company;
import com.iflytransporter.common.bean.CompanyBO;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.enums.BuzExceptionEnums;
import com.iflytransporter.common.enums.Status;
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
	private UserService userService;
	@Autowired
	private CompanyService companyService;
	
	@ApiOperation(value="auth", notes="公司-认证",produces = "application/json",response=CompanyResp.class)
	@RequestMapping(value="auth", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> add(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="实体")Company company){
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailByCache(userId);
		String id = UUIDUtil.UUID();
		company.setId(id);
		company.setUserId(userId);
		company.setUserType(user.getUserType());//添加用户类型对应公司
		int result = companyService.save(company,userId);
		if(result > 0){
			return ResponseUtil.successResultId(id);
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="detail", notes="详情",produces = "application/json",response=CompanyResp.class)
	@RequestMapping(value="detail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detail(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailByCache(userId);
		if(user.getCompanyAuthStatus() != null && user.getCompanyId() !=null && Status.Auth_No !=user.getCompanyAuthStatus().intValue()){
			CompanyBO company = companyService.query(user.getCompanyId());
			return ResponseUtil.successResult(new CompanyResp(company));
		}
		return ResponseUtil.failureResult(BuzExceptionEnums.CompanyNotAuth);
	}
	
	@ApiOperation(value="modify", notes="修改",produces = "application/json",response= CompanyResp.class)
	@RequestMapping(value="modify", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modify(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="实体")Company company){
		String userId =  (String) request.getAttribute("userId");
		company.setUserId(userId);
		int result = companyService.update(company);
		if(result > 0){
			return ResponseUtil.successResultId(company.getId());
		}
		return ResponseUtil.failureResult();
	}
}
