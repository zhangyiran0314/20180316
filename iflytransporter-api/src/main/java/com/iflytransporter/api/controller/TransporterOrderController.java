package com.iflytransporter.api.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.iflytransporter.api.bean.OrderReq;
import com.iflytransporter.api.bean.OrderResp;
import com.iflytransporter.api.service.AreaService;
import com.iflytransporter.api.service.CarTypeService;
import com.iflytransporter.api.service.CityService;
import com.iflytransporter.api.service.GoodsSourceService;
import com.iflytransporter.api.service.HandlingTypeService;
import com.iflytransporter.api.service.OrderApplyService;
import com.iflytransporter.api.service.ShipperOrderService;
import com.iflytransporter.api.service.TransporterOrderService;
import com.iflytransporter.api.service.PaymentTypeService;
import com.iflytransporter.api.service.ProvinceService;
import com.iflytransporter.api.service.UseTypeService;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.api.utils.RequestMapUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.bean.GoodsSource;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.OrderApply;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.enums.Status;
import com.iflytransporter.common.utils.UUIDUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "transporter/order ",description="车主-找货操作 Controller")
@Controller
@RequestMapping("/transporter/order/{version}")
public class TransporterOrderController {
	@Autowired
	private UserService userService;
	@Autowired
	private TransporterOrderService transporterOrderService;
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
	@Autowired
	private OrderApplyService orderApplyService;
	
	
	@ApiOperation(position=1,value="queryPage", notes="分页列表-找货",produces = "application/json")
	@RequestMapping(value="queryPage", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPage(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{pageNo:1,pageSize:10} 此列表只能看到已通过授权的接口;pageNo:当前页数-默认(1);pageSize:分页数-默认(10)") 
			Map<String,Object> requestMap){
		Integer pageNo = RequestMapUtil.formatPageNo(requestMap);
		Integer pageSize = RequestMapUtil.formatPageSize(requestMap);
		String userId =  (String) request.getAttribute("userId");
		PageInfo<Order> page = transporterOrderService.queryPage(pageNo,pageSize,Status.Order_Publish,Status.Order_Auth_Yes);
		if(page.getTotal()==0){
			return ResponseUtil.successPage(page.getTotal(),page.getPages(), null);
		}
		List<Order> list = page.getList();
		List<OrderResp> result = new ArrayList<OrderResp>();
		for(Order order:list){
			OrderResp op =new OrderResp(order);
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
//			op.setGoodsUnits(goodsUnitsService.queryCommonParam(order.getGoodsUnitsId()));
			
			result.add(op);
		}
		return ResponseUtil.successPage(page.getTotal(), page.getPages(), result);
	}
	@ApiOperation(value="list", notes="列表-找货",produces = "application/json")
	@RequestMapping(value="list", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{} ,此列表只能看到已通过授权的接口;") Map<String,Object> requestMap){
		Integer status = RequestMapUtil.formatStatus(requestMap);
		String userId =  (String) request.getAttribute("userId");
		if(status !=null && Status.Order_Publish!=status.intValue()){//非发布中状态查询已成交和已取消状态
			status = null;
		}
		List<Order> list = transporterOrderService.list(Status.Order_Publish,Status.Order_Auth_Yes);
		List<OrderResp> result = new ArrayList<OrderResp>();
		for(Order order:list){
			OrderResp op =new OrderResp(order);
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
//			op.setGoodsUnits(goodsUnitsService.queryCommonParam(order.getGoodsUnitsId()));
			result.add(op);
		}
		return ResponseUtil.successResult(result);
	}

	@ApiOperation(value="detail", notes="详情",produces = "application/json",response = OrderResp.class)
	@RequestMapping(value="detail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		Order order = transporterOrderService.query(id);
		OrderResp op = new OrderResp(order);  
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
//		op.setGoodsUnits(goodsUnitsService.queryCommonParam(order.getGoodsUnitsId()));
		
		return ResponseUtil.successResult(op);
	}
	
	
	@ApiOperation(value="apply", notes="找货-申请",produces = "application/json")
	@RequestMapping(value="apply", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> apply(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{id:id,costs:costs} id-订单id,costs-报价(使用字符串类型传值)") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		String costss =  (String) requestMap.get("costs");
		Double costs = Double.parseDouble(costss);
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailByCache(userId);
		OrderApply result = transporterOrderService.apply(id, costs, user);
		if(result != null){
			return ResponseUtil.successResult(result);
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="detailAudit", notes="详情-待审核",produces = "application/json",response = OrderResp.class)
	@RequestMapping(value="detailAudit", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailAudit(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		Order order = transporterOrderService.query(id);
		OrderResp op = new OrderResp(order);  
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
//		op.setGoodsUnits(goodsUnitsService.queryCommonParam(order.getGoodsUnitsId()));
		
		
		op.setApplyList(transporterOrderService.detailAudit(id,Status.Order_Audit_No));
		return ResponseUtil.successResult(op);
	}
	@ApiOperation(value="auditCancel", notes="审核-取消",produces = "application/json")
	@RequestMapping(value="auditCancel", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> auditCancel(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{orderId:orderId,applyId:applyId} orderId:0-订单id,applyId:申请id") Map<String,Object> requestMap){
		String orderId = (String) requestMap.get("orderId");
		String applyId = (String) requestMap.get("applyId");
		int result =  orderApplyService.updateStatus(orderId,applyId, Status.Order_Audit_Cancel,null);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="auditOk", notes="审核-确认",produces = "application/json")
	@RequestMapping(value="auditOk", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> auditOk(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{orderId:orderId,applyId:applyId} orderId:0-订单id,applyId:申请id") Map<String,Object> requestMap){
		String orderId = (String) requestMap.get("orderId");
		String applyId = (String) requestMap.get("applyId");
		//修改一个申请状态,其他申请全部取消
		int result =  orderApplyService.updateStatus(orderId,applyId, Status.Order_Audit_Yes, Status.Order_Audit_Cancel);
		if(result > 0){
			transporterOrderService.updateStatus(orderId, Status.Order_Transfer);
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
}
