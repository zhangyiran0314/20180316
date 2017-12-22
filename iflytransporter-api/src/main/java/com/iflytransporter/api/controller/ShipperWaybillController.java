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
import com.iflytransporter.api.bean.OrderResp;
import com.iflytransporter.api.bean.WaybillResp;
import com.iflytransporter.api.service.AreaService;
import com.iflytransporter.api.service.CarTypeService;
import com.iflytransporter.api.service.CityService;
import com.iflytransporter.api.service.HandlingTypeService;
import com.iflytransporter.api.service.PaymentTypeService;
import com.iflytransporter.api.service.ProvinceService;
import com.iflytransporter.api.service.ShipperOrderService;
import com.iflytransporter.api.service.UseTypeService;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.api.service.WaybillService;
import com.iflytransporter.api.utils.RequestMapUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.Waybill;
import com.iflytransporter.common.bean.WaybillBO;
import com.iflytransporter.common.enums.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "shipper/waybill/",description="货主-运单操作 Controller")
@Controller
@RequestMapping("/shipper/waybill/{version}")
public class ShipperWaybillController {
	@Autowired
	private UserService userService;
	@Autowired
	private WaybillService waybillService;
	@Autowired
	private ShipperOrderService shipperOrderService;
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private CityService cityService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private CarTypeService carTypeService;
	@Autowired
	private HandlingTypeService handlingTypeService;
	@Autowired
	private PaymentTypeService paymentTypeService;
	@Autowired
	private UseTypeService useTypeService;
	
	@ApiOperation(value="queryPage", notes="分页列表",produces = "application/json",response = WaybillResp.class)
	@RequestMapping(value="queryPage", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPage(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1|2|3} 运单状态:0-待装车,1-运输中,2-待确认,3-已完结;pageNo:当前页数-默认(1);pageSize:分页数-默认(10)") 
			Map<String,Object> requestMap){
		Integer pageNo = RequestMapUtil.formatPageNo(requestMap);
		Integer pageSize = RequestMapUtil.formatPageSize(requestMap);
		Integer status = RequestMapUtil.formatStatus(requestMap);
		String userId =  (String) request.getAttribute("userId");
		
		PageInfo<Waybill> page =null;
		User user = userService.detailByCache(userId);
		if(Status.User_Admin==user.getLevel()){
			page = waybillService.queryPage(pageNo,pageSize, null,user.getCompanyId(),status);
		}else{
			page = waybillService.queryPage(pageNo, pageSize, userId, null, status);
		}
		if(page.getTotal()==0){
			return ResponseUtil.successPage(page.getTotal(),page.getPages(), null);
		}
		List<Waybill> list = page.getList();
		List<WaybillResp> result = new ArrayList<WaybillResp>();
		for(Waybill waybill:list){
			WaybillResp op =new WaybillResp(waybill);
			Order order = shipperOrderService.query(waybill.getOrderId());
			op.setOrder(order);
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
			result.add(op);
		}
		return ResponseUtil.successPage(page.getTotal(), page.getPages(), result);
	}
	
	@ApiOperation(value="list", notes="列表",produces = "application/json",response = WaybillResp.class)
	@RequestMapping(value="list", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1|2|3} 运单状态:0-待装车,1-运输中,2-待确认,3-已完结") Map<String,Object> requestMap){
		Integer status = RequestMapUtil.formatStatus(requestMap);
		String userId =  (String) request.getAttribute("userId");
		
		List<Waybill> list =null;
		User user = userService.detailByCache(userId);
		if(Status.User_Admin==user.getLevel()){
			list = waybillService.list(null, user.getCompanyId(), status);
		}else{
			list = waybillService.list(userId,null,status);
		}
		List<WaybillResp> result = new ArrayList<WaybillResp>();
		for(Waybill waybill:list){
			WaybillResp op =new WaybillResp(waybill);
			Order order = shipperOrderService.query(waybill.getOrderId());
			op.setOrder(order);
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
			result.add(op);
		}
		return ResponseUtil.successResult(result);
	}
	@ApiOperation(value="detail", notes="详情",produces = "application/json",response = WaybillResp.class)
	@RequestMapping(value="detail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		WaybillBO waybill = waybillService.query(id);
		WaybillResp op =new WaybillResp(waybill);
		Order order = shipperOrderService.query(waybill.getOrderId());
		op.setOrder(order);
		
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
		//公司信息
		op.setCompany(waybillService.detailCompany(id));
		//车主信息
		op.setTransporter(waybillService.detailTransporter(id));
		//司机及车辆信息
		return ResponseUtil.successResult(op);
	}
	/*@ApiOperation(value="auditCancel", notes="审核-取消",produces = "application/json")
	@RequestMapping(value="auditCancel", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> auditCancel(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{orderId:orderId,applyId:applyId} orderId:0-订单id,applyId:申请id") Map<String,Object> requestMap){
		String orderId = (String) requestMap.get("orderId");
		String applyId = (String) requestMap.get("applyId");
		int result =  waybillService.
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}*/
	
}
