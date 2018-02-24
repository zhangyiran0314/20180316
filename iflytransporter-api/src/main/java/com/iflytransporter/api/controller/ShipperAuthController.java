package com.iflytransporter.api.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.iflytransporter.api.bean.AuthResp;
import com.iflytransporter.api.bean.OrderUserResp;
import com.iflytransporter.api.service.CommonService;
import com.iflytransporter.api.service.ShipperAuthService;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.api.utils.RequestMapUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.enums.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "shipper/auth ",description="货主-授权操作 Controller")
@Controller
@RequestMapping("/shipper/auth/{version}")
public class ShipperAuthController {
	@Autowired
	private UserService userService;
	@Autowired
	private ShipperAuthService shipperAuthService;
	@Autowired
	private CommonService commonService;
	@ApiOperation(value="queryPage", notes="分页列表",produces = "application/json")
	@RequestMapping(value="queryPage", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPage(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1,pageNo:1,pageSize:10} 授权状态:0-未授权,1-已授权{1-已授权,2-授权取消};pageNo:当前页数-默认(1);pageSize:分页数-默认(10)") 
			Map<String,Object> requestMap){
		String lang = request.getHeader("lang");
		Integer pageNo = RequestMapUtil.formatPageNo(requestMap);
		Integer pageSize = RequestMapUtil.formatPageSize(requestMap);
		Integer status = RequestMapUtil.formatStatus(requestMap);
		String userId =  (String) request.getAttribute("userId");
		/*if(status !=null && Status.Order_Auth_No!=status.intValue()){//非带授权状态 查询已授权和授权取消状态
			status = null;
		}*/
		User user = userService.detailByCache(userId);
		PageInfo<Order> page = null;
		//如果是管理员,查询当前公司所有授权以及未授权记录
		if(user.getLevel()==Status.User_Level_Admin){
			page = shipperAuthService.queryPageByAdmin(pageNo,pageSize, user.getCompanyId(),userId,status);
		}else{//如果是员工,查询个人的记录
			page = shipperAuthService.queryPage(pageNo,pageSize, user.getCompanyId(),userId,null);
		}
		if(page.getTotal()== 0){
			return ResponseUtil.successPage(page.getTotal(),page.getPages(), null);
		}
		List<Order> list = page.getList();
		List<AuthResp> result = new ArrayList<AuthResp>();
		for(Order order:list){
			AuthResp op =new AuthResp(order);
			op.setDepartureProvince(commonService.queryProvince(lang,order.getDepartureProvinceId()));
			op.setDepartureCity(commonService.queryCity(lang,order.getDepartureCityId()));
			op.setDepartureArea(commonService.queryArea(lang,order.getDepartureAreaId()));
			
			op.setDestinationProvince(commonService.queryProvince(lang,order.getDestinationProvinceId()));
			op.setDestinationCity(commonService.queryCity(lang,order.getDestinationCityId()));
			op.setDestinationArea(commonService.queryArea(lang,order.getDestinationAreaId()));
			
			op.setCarType(commonService.queryCarType(lang,order.getCarTypeId()));
			op.setHandlingType(commonService.queryHandlingType(lang,order.getHandlingTypeId()));
			op.setPaymentType(commonService.queryPaymentType(lang,order.getPaymentTypeId()));
			op.setUseType(commonService.queryUseType(lang,order.getUseTypeId()));
//			op.setGoodsUnits(goodsUnitsService.queryCommonParam(order.getGoodsUnitsId()));
			if(Status.User_Level_Admin== user.getLevel().intValue()){//如果是管理员,查询当前申请授权用户
				op.setUser(new OrderUserResp(userService.detailBOByCache(order.getShipperId())));
			}
//			op.setUser(new OrderUserResp(userService.detailByCache(order.getShipperId())));
			result.add(op);
		}
		return ResponseUtil.successPage(page.getTotal(), page.getPages(), result);
	}
	
	@ApiOperation(value="list", notes="列表",produces = "application/json")
	@RequestMapping(value="list", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1} 授权状态:0-未授权,1-已授权{1-已授权,2-授权取消}") Map<String,Object> requestMap){
		String lang = request.getHeader("lang");
		Integer status = RequestMapUtil.formatStatus(requestMap);
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailByCache(userId);
		List<Order> list = null;
		/*if(status !=null && Status.Order_Auth_No!=status.intValue()){//非带授权状态 查询已授权和授权取消状态
			status = null;
		}*/
		if(Status.User_Level_Admin==user.getLevel().intValue()){
			list = shipperAuthService.listByAdmin(user.getCompanyId(),user.getId(),status);
		}else{
			list = shipperAuthService.list(user.getCompanyId(),userId,null);
		}
		List<AuthResp> result = new ArrayList<AuthResp>();
		for(Order order:list){
			AuthResp op =new AuthResp(order);
			op.setDepartureProvince(commonService.queryProvince(lang,order.getDepartureProvinceId()));
			op.setDepartureCity(commonService.queryCity(lang,order.getDepartureCityId()));
			op.setDepartureArea(commonService.queryArea(lang,order.getDepartureAreaId()));
			
			op.setDestinationProvince(commonService.queryProvince(lang,order.getDestinationProvinceId()));
			op.setDestinationCity(commonService.queryCity(lang,order.getDestinationCityId()));
			op.setDestinationArea(commonService.queryArea(lang,order.getDestinationAreaId()));
			
			op.setCarType(commonService.queryCarType(lang,order.getCarTypeId()));
			op.setHandlingType(commonService.queryHandlingType(lang,order.getHandlingTypeId()));
			op.setPaymentType(commonService.queryPaymentType(lang,order.getPaymentTypeId()));
			op.setUseType(commonService.queryUseType(lang,order.getUseTypeId()));
//			op.setGoodsUnits(goodsUnitsService.queryCommonParam(order.getGoodsUnitsId()));
			if(Status.User_Level_Admin==user.getLevel().intValue()){
				op.setUser(new OrderUserResp(userService.detailBOByCache(order.getShipperId())));
			}
//			op.setUser(new OrderUserResp(userService.detailByCache(order.getShipperId())));
			result.add(op);
		}
		return ResponseUtil.successResult(result);
	}
	
	@ApiOperation(value="detail", notes="详情",produces = "application/json",response = AuthResp.class)
	@RequestMapping(value="detail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String lang = request.getHeader("lang");
		String id = (String) requestMap.get("id");
		Order order = shipperAuthService.query(id);
		AuthResp op = new AuthResp(order);  
		op.setDepartureProvince(commonService.queryProvince(lang,order.getDepartureProvinceId()));
		op.setDepartureCity(commonService.queryCity(lang,order.getDepartureCityId()));
		op.setDepartureArea(commonService.queryArea(lang,order.getDepartureAreaId()));
		
		op.setDestinationProvince(commonService.queryProvince(lang,order.getDestinationProvinceId()));
		op.setDestinationCity(commonService.queryCity(lang,order.getDestinationCityId()));
		op.setDestinationArea(commonService.queryArea(lang,order.getDestinationAreaId()));
		
		op.setCarType(commonService.queryCarType(lang,order.getCarTypeId()));
		op.setHandlingType(commonService.queryHandlingType(lang,order.getHandlingTypeId()));
		op.setPaymentType(commonService.queryPaymentType(lang,order.getPaymentTypeId()));
		op.setUseType(commonService.queryUseType(lang,order.getUseTypeId()));
//		op.setGoodsUnits(goodsUnitsService.queryCommonParam(order.getGoodsUnitsId()));
		return ResponseUtil.successResult(op);
	}
	@ApiOperation(value="authCancel", notes="授权-取消",produces = "application/json")
	@RequestMapping(value="authCancel", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> authCancel(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		int result = shipperAuthService.updateAuthStatus(id,Status.Order_Auth_Cancel);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="authOk", notes="授权-确认",produces = "application/json")
	@RequestMapping(value="authOk", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> authOk(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		int result = shipperAuthService.updateAuthStatus(id,Status.Order_Auth_Yes);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	
}
