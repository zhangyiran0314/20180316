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

import com.iflytransporter.api.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "评价获取接口 ",description="评价获取 Controller")
@Controller
@RequestMapping("/comment/{version}")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@ApiOperation(value="queryPageTransporter", notes="车主评价列表",produces = "application/json")
	@RequestMapping(value="queryPage", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPageTransporter(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1,pageNo:1,pageSize:10}") Map<String,Object> requestMap){
		return null;
	}
	@ApiOperation(value="queryPageTransporterCompany", notes="车主评价列表",produces = "application/json")
	@RequestMapping(value="queryPageTransporterCompany", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPageTransporterCompany(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1,pageNo:1,pageSize:10}") Map<String,Object> requestMap){
		return null;
	}
	@ApiOperation(value="queryPageShipper", notes="车主评价列表",produces = "application/json")
	@RequestMapping(value="queryPageShipper", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPageShipper(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1,pageNo:1,pageSize:10}") Map<String,Object> requestMap){
		return null;
	}
	@ApiOperation(value="queryPageShipperCompany", notes="车主评价列表",produces = "application/json")
	@RequestMapping(value="queryPageShipperCompany", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPageShipperCompany(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1,pageNo:1,pageSize:10}") Map<String,Object> requestMap){
		return null;
	}
}
