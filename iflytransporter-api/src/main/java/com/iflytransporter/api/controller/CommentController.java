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

import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.service.CommentService;
import com.iflytransporter.api.utils.RequestMapUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.bean.Order;

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
			@RequestBody Map<String,Object> requestMap){
		Integer pageNo = RequestMapUtil.formatPageNo(requestMap);
		Integer pageSize = RequestMapUtil.formatPageSize(requestMap);
		String transporterId = (String) requestMap.get("tranporterId");
		PageInfo<Map<String,Object>> page = commentService.queryPageTransporter(pageNo, pageSize, transporterId, null);
		return ResponseUtil.successPage(page.getTotal(), page.getPages(), page.getList());
	}
	@ApiOperation(value="queryPageTransporterCompany", notes="车主公司评价列表",produces = "application/json")
	@RequestMapping(value="queryPageTransporterCompany", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPageTransporterCompany(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		Integer pageNo = RequestMapUtil.formatPageNo(requestMap);
		Integer pageSize = RequestMapUtil.formatPageSize(requestMap);
		String transporterCompanyId = (String) requestMap.get("transporterCompanyId");
		PageInfo<Map<String,Object>> page = commentService.queryPageTransporter(pageNo, pageSize, null, transporterCompanyId);
		return ResponseUtil.successPage(page.getTotal(), page.getPages(), page.getList());
	}
	@ApiOperation(value="queryPageShipper", notes="货主评价列表",produces = "application/json")
	@RequestMapping(value="queryPageShipper", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPageShipper(HttpServletRequest request, HttpServletResponse response,
			@RequestBody  Map<String,Object> requestMap){
		Integer pageNo = RequestMapUtil.formatPageNo(requestMap);
		Integer pageSize = RequestMapUtil.formatPageSize(requestMap);
		String shipperId = (String) requestMap.get("shipperId");
		PageInfo<Map<String,Object>> page = commentService.queryPageShipper(pageNo, pageSize, shipperId, null);
		return ResponseUtil.successPage(page.getTotal(), page.getPages(), page.getList());
	}
	@ApiOperation(value="queryPageShipperCompany", notes="货主公司评价列表",produces = "application/json")
	@RequestMapping(value="queryPageShipperCompany", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPageShipperCompany(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		Integer pageNo = RequestMapUtil.formatPageNo(requestMap);
		Integer pageSize = RequestMapUtil.formatPageSize(requestMap);
		String shipperCompanyId = (String) requestMap.get("shipperId");
		PageInfo<Map<String,Object>> page = commentService.queryPageShipper(pageNo, pageSize, null, shipperCompanyId);
		return ResponseUtil.successPage(page.getTotal(), page.getPages(), page.getList());
	}
}
