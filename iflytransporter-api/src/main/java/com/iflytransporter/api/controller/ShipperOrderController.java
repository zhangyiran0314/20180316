package com.iflytransporter.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.bean.OrderRequestParam;
import com.iflytransporter.api.bean.OrderResponseParam;
import com.iflytransporter.api.service.AreaService;
import com.iflytransporter.api.service.CarTypeService;
import com.iflytransporter.api.service.CityService;
import com.iflytransporter.api.service.GoodsSourceService;
import com.iflytransporter.api.service.GoodsUnitsService;
import com.iflytransporter.api.service.HandlingTypeService;
import com.iflytransporter.api.service.OrderService;
import com.iflytransporter.api.service.PaymentTypeService;
import com.iflytransporter.api.service.ProvinceService;
import com.iflytransporter.api.service.UseTypeService;
import com.iflytransporter.api.utils.RequestMapUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.enums.Status;
import com.iflytransporter.common.utils.UUIDUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "order api",description="发货(订单)操作 Controller")
@Controller
@RequestMapping("/shipper/order/{version}")
public class ShipperOrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private CityService cityService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private GoodsSourceService goodsSourceService;
	@Autowired
	private CarTypeService carTypeService;
	@Autowired
	private HandlingTypeService handlingTypeService;
	@Autowired
	private PaymentTypeService paymentTypeService;
	@Autowired
	private UseTypeService useTypeService;
	@Autowired
	private GoodsUnitsService goodsUnitsService;
	
	@ApiOperation(value="queryPage", notes="分页列表-发布",produces = "application/json")
	@RequestMapping(value="queryPage", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPage(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1|2,pageNo:1,pageSize:10} 发布状态:0-发布中,1-已成交,2-已取消;pageNo:当前页数-默认(1);pageSize:分页数-默认(10)") 
			Map<String,Object> requestMap){
		Integer pageNo = RequestMapUtil.formatPageNo(requestMap);
		Integer pageSize = RequestMapUtil.formatPageSize(requestMap);
		Integer status = RequestMapUtil.formatStatus(requestMap);
		String userId =  (String) request.getAttribute("userId");
		PageInfo<Order> page = orderService.queryPage(pageNo,pageSize, userId,status,Status.Order_Check_Yes);
		return ResponseUtil.successResult(page);
	}
	@ApiOperation(value="queryPageCheck", notes="分页列表-授权",produces = "application/json")
	@RequestMapping(value="queryPageCheck", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPageCheck(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1|2,pageNo:1,pageSize:10} 授权状态:0-未授权,1-已授权;pageNo:当前页数-默认1;pageSize:分页数-默认(10)") Map<String,Object> requestMap){
		Integer pageNo = RequestMapUtil.formatPageNo(requestMap);
		Integer pageSize = RequestMapUtil.formatPageSize(requestMap);
		Integer status = RequestMapUtil.formatStatus(requestMap);
		String userId =  (String) request.getAttribute("userId");
		PageInfo<Order> page = orderService.queryPage(pageNo,pageSize, userId,Status.Order_Publish,status);
		return ResponseUtil.successResult(page);
	}
	@ApiOperation(value="list", notes="列表-发布",produces = "application/json")
	@RequestMapping(value="list", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1|2} 发布状态:0-发布中,1-已成交,2-已取消") Map<String,Object> requestMap){
		Integer status = RequestMapUtil.formatStatus(requestMap);
		String userId =  (String) request.getAttribute("userId");
		List<Order> list = orderService.list(userId,status,Status.Order_Check_Yes);
		List<OrderResponseParam> result = new ArrayList<OrderResponseParam>();
		for(Order order:list){
			OrderResponseParam op = (OrderResponseParam) order;
			op.setDepartureProvince(provinceService.queryCommonParam(order.getDepartureProvinceId()));
			op.setDepartureCity(cityService.queryCommonParam(order.getDepartureCityId()));
			op.setDepartureArea(areaService.queryCommonParam(order.getDepartureAreaId()));
			
			op.setDestinationProvince(provinceService.queryCommonParam(order.getDestinationProvinceId()));
			op.setDestinationCity(cityService.queryCommonParam(order.getDestinationCityId()));
			op.setDestinationArea(areaService.queryCommonParam(order.getDestinationAreaId()));
			
			op.setCarType(carTypeService.queryCommonParam(order.getCarTypeId()));
			op.setHandlingType(handlingTypeService.queryCommonParam(order.getHandlingTypeId()));
			op.setPaymentType(paymentTypeService.queryCommonParam(order.getPaymentTypeId()));
			op.setUseType(useTypeService.queryCommonParam(order.getUseTypeId()));
			op.setGoodsUnits(goodsUnitsService.queryCommonParam(order.getGoodsUnitsId()));
			result.add(op);
		}
		return ResponseUtil.successResult(result);
	}
	
	@ApiOperation(value="listCheck", notes="列表-授权",produces = "application/json")
	@RequestMapping(value="listCheck", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> listCheck(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1} 授权状态:0-未授权,1-已授权") 
			Map<String,Object> requestMap){
		Integer status = RequestMapUtil.formatStatus(requestMap);
		String userId =  (String) request.getAttribute("userId");
		List<Order> list = orderService.listCheck(userId,Status.Order_Publish,status);
		return ResponseUtil.successResult(list);
	}
	@ApiOperation(value="add", notes="新增",produces = "application/json")
	@RequestMapping(value="add", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> add(HttpServletRequest request, HttpServletResponse response,
			@RequestBody OrderRequestParam order){
		String userId =  (String) request.getAttribute("userId");
		String id = UUIDUtil.UUID();
		order.setId(id);
		if(StringUtils.isBlank(order.getShipperId())){
			order.setShipperId(userId);
		}
		int result = orderService.save(order);
		if(result > 0){
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("id", id);
			return ResponseUtil.successResult(data);
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="detail", notes="详情",produces = "application/json",response = OrderResponseParam.class)
	@RequestMapping(value="detail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		Order order = orderService.query(id);
		OrderResponseParam op = (OrderResponseParam) order;
		return ResponseUtil.successResult(op);
	}
	@ApiOperation(value="checkCancal", notes="授权-取消",produces = "application/json")
	@RequestMapping(value="cancelCheck", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> cancelCheck(HttpServletRequest request, HttpServletResponse response,
			@RequestBody OrderRequestParam order){
		return ResponseUtil.successResult();
	}
	@ApiOperation(value="checkOk", notes="授权-确认",produces = "application/json")
	@RequestMapping(value="checkOk", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> checkOk(HttpServletRequest request, HttpServletResponse response,
			@RequestBody OrderRequestParam order){
		return ResponseUtil.successResult();
	}
	@ApiOperation(value="applyDetail", notes="审核-详情",produces = "application/json",response = OrderResponseParam.class)
	@RequestMapping(value="applyDetail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> applyDetail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		Order order = orderService.query(id);
		OrderResponseParam op = (OrderResponseParam) order;
		return ResponseUtil.successResult(op);
	}
	
	@ApiOperation(value="applyCheckCancel", notes="审核-取消",produces = "application/json",response = OrderResponseParam.class)
	@RequestMapping(value="applyCheckCancel", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> applyCheckCancel(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		Order order = orderService.query(id);
		OrderResponseParam op = (OrderResponseParam) order;
		return ResponseUtil.successResult(op);
	}
	@ApiOperation(value="applyCheckOk", notes="审核-确认",produces = "application/json",response = OrderResponseParam.class)
	@RequestMapping(value="applyCheckOk", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> applyCheckOk(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		Order order = orderService.query(id);
		OrderResponseParam op = (OrderResponseParam) order;
		return ResponseUtil.successResult(op);
	}
	@ApiOperation(value="modify", notes="修改",produces = "application/json")
	@RequestMapping(value="modify", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modify(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Order order){
		int result = orderService.update(order);
		if(result > 0){
			Order data = orderService.query(order.getId());
			return ResponseUtil.successResult(data);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="cancel", notes="发货-取消",produces = "application/json")
	@RequestMapping(value="cancel", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> cancel(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		int result = orderService.delete(id);
		if(result > 0){
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("id", id);
			return ResponseUtil.successResult(data);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="delete", notes="删除",produces = "application/json")
	@RequestMapping(value="delete", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> delete(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		int result = orderService.delete(id);
		if(result > 0){
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("id", id);
			return ResponseUtil.successResult(data);
		}
		return ResponseUtil.failureResult();
	}
	
}
