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
import com.iflytransporter.api.service.PaymentTypeService;
import com.iflytransporter.api.service.ProvinceService;
import com.iflytransporter.api.service.UseTypeService;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.api.utils.RequestMapUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.bean.GoodsSource;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.enums.BuzExceptionEnums;
import com.iflytransporter.common.enums.Status;
import com.iflytransporter.common.utils.MethodUtil;
import com.iflytransporter.common.utils.UUIDUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "shipper/order/",description="货主-发货(订单)操作 Controller")
@Controller
@RequestMapping("/shipper/order/{version}")
public class ShipperOrderController {
	@Autowired
	private UserService userService;
	@Autowired
	private ShipperOrderService shipperOrderService;
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
	private OrderApplyService orderApplyService;
	
	
	@ApiOperation(position=1,value="queryPage", notes="分页列表-发布",produces = "application/json")
	@RequestMapping(value="queryPage", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPage(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1,pageNo:1,pageSize:10} 发布状态:0-发布中,{1-已成交,2-已取消},此列表只能看到已通过授权的接口;pageNo:当前页数-默认(1);pageSize:分页数-默认(10)") 
			Map<String,Object> requestMap){
		Integer pageNo = RequestMapUtil.formatPageNo(requestMap);
		Integer pageSize = RequestMapUtil.formatPageSize(requestMap);
		Integer status = RequestMapUtil.formatStatus(requestMap);
		String userId =  (String) request.getAttribute("userId");
		if(status !=null && Status.Order_Publish!=status.intValue()){//非发布中状态查询已成交和已取消状态
			status = null;
		}
		PageInfo<Order> page = shipperOrderService.queryPage(pageNo,pageSize, userId,status,Status.Order_Auth_Yes);
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
			
			//待审核申请
			if(Status.Order_Publish==order.getStatus()){
				op.setApplyTotal(orderApplyService.count(order.getId(),Status.Order_Audit_No));
			}
			//已成交状态订单,添加对应的applyDetail信息
			if(Status.Order_Transfer==order.getStatus().intValue()){
				List<Map<String,Object>> applyDetail = shipperOrderService.detailAudit(order.getId(),Status.Order_Audit_Yes);
				if(applyDetail!=null && applyDetail.size() == 1){
					op.setApplyDetail(applyDetail.get(0));
				}
			}
			result.add(op);
		}
		return ResponseUtil.successPage(page.getTotal(), page.getPages(), result);
	}
	@ApiOperation(value="list", notes="列表-发布",produces = "application/json")
	@RequestMapping(value="list", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1,pageNo:1,pageSize:10} 发布状态:0-发布中,{1-已成交,2-已取消},此列表只能看到已通过授权的接口;") Map<String,Object> requestMap){
		Integer status = RequestMapUtil.formatStatus(requestMap);
		String userId =  (String) request.getAttribute("userId");
		if(status !=null && Status.Order_Publish!=status.intValue()){//非发布中状态查询已成交和已取消状态
			status = null;
		}
		List<Order> list = shipperOrderService.list(userId,status,Status.Order_Auth_Yes);
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
			//待审核申请
			if(Status.Order_Publish==order.getStatus().intValue()){
				op.setApplyTotal(orderApplyService.count(order.getId(),Status.Order_Audit_No));
			}
			//已成交状态订单,添加对应的applyDetail信息
			if(Status.Order_Transfer==order.getStatus().intValue()){
				List<Map<String,Object>> applyDetail = shipperOrderService.detailAudit(order.getId(),Status.Order_Audit_Yes);
				if(applyDetail!=null && applyDetail.size() == 1){
					op.setApplyDetail(applyDetail.get(0));
				}
			}
			result.add(op);
		}
		return ResponseUtil.successResult(result);
	}

	@ApiOperation(value="add", notes="新增",produces = "application/json")
	@RequestMapping(value="add", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> add(HttpServletRequest request, HttpServletResponse response,
			@RequestBody OrderReq order){
		String userId =  (String) request.getAttribute("userId");
		String id = UUIDUtil.UUID();
		order.setId(id);
		if(StringUtils.isBlank(order.getShipperId())){
			order.setShipperId(userId);
		}
		if(order.getStatus()==null){
			order.setStatus(Status.Order_Publish);
		}
		User user = userService.detailByCache(userId);
		order.setCompanyId(user.getCompanyId());
		if(Status.User_Level_Admin==user.getLevel()){
			order.setAuthDate(new Date());
			order.setAuthStatus(Status.Order_Auth_Yes);
		}else{
			order.setAuthStatus(Status.Order_Auth_No);
		}
		order.setOrderNo(MethodUtil.genOrderNum(userId));
		int result = shipperOrderService.save(order);
		if(result > 0){
			if(order.isAddGoodsSource()){
				GoodsSource gs = new GoodsSource(order);
				gs.setId(UUIDUtil.UUID());
				goodsSourceService.save(gs);
			}
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("id", id);
			return ResponseUtil.successResult(data);
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="detail", notes="详情",produces = "application/json",response = OrderResp.class)
	@RequestMapping(value="detail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		Order order = shipperOrderService.query(id);
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
		//审核申请通过详情
		if(Status.Order_Transfer==order.getStatus().intValue()){
			List<Map<String,Object>> applyDetail = shipperOrderService.detailAudit(id,Status.Order_Audit_Yes);
			if(applyDetail!=null && applyDetail.size() == 1){
				op.setApplyDetail(applyDetail.get(0));
			}
		}
		return ResponseUtil.successResult(op);
	}
	
	@ApiOperation(value="modify", notes="修改",produces = "application/json")
	@RequestMapping(value="modify", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modify(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Order order){
		int result = shipperOrderService.update(order);
		if(result > 0){
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("id", order.getId());
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
		int result = shipperOrderService.cancel(id);
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
		int result = shipperOrderService.delete(id);
		if(result > 0){
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("id", id);
			return ResponseUtil.successResult(data);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="detailAudit", notes="详情-待审核",produces = "application/json",response = OrderResp.class)
	@RequestMapping(value="detailAudit", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailAudit(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		List<Map<String,Object>> result = shipperOrderService.detailAudit(id,Status.Order_Audit_No);
		return ResponseUtil.successResult(result);
	}
	/**
	 * 联系车主操作之后,其他申请不可再联系,contactStatus修改为不可联系状态
	 * */
	@ApiOperation(value="contactTransporter", notes="详情-联系车主",produces = "application/json",response = OrderResp.class)
	@RequestMapping(value="contactTransporter", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> contactTransporter(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{id:orderId,applyId:applyId}") Map<String,Object> requestMap){
		String applyId = (String) requestMap.get("applyId");
		String orderId = (String) requestMap.get("orderId");
		Map<String,Object> result = shipperOrderService.detailTransporter(applyId,orderId,Status.Order_Audit_No);
		if(result == null){
			return ResponseUtil.failureResult(BuzExceptionEnums.CanNotContactError);
		}
		return ResponseUtil.successResult(result);
	}
	@ApiOperation(value="contactTransporterRecord", notes="详情-联系车主-电话记录",produces = "application/json",response = OrderResp.class)
	@RequestMapping(value="contactTransporterRecord", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> contactTransporterRecord(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{applyId:applyId}") Map<String,Object> requestMap){
		String applyId = (String) requestMap.get("applyId");
//		String orderId = (String) requestMap.get("orderId");
		int result = shipperOrderService.contactTransporterRecord(applyId, Status.Apply_Browse_Contact);
		if(result > 0 ){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	/**
	 * 申请取消情况下,其他申请可被联系,contactStatus修改为可联系状态
	 * */
	@ApiOperation(value="auditCancel", notes="审核-取消",produces = "application/json")
	@RequestMapping(value="auditCancel", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> auditCancel(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{orderId:orderId,applyId:applyId} orderId:0-订单id,applyId:申请id") Map<String,Object> requestMap){
		String orderId = (String) requestMap.get("orderId");
		String applyId = (String) requestMap.get("applyId");
		int result =  orderApplyService.updateStatus(orderId,applyId, Status.Order_Audit_Cancel,null);
		if(result > 0){
			return ResponseUtil.successResultId(orderId);
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
		int result = shipperOrderService.auditOk(orderId, applyId);
		if(result > 0){
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("id", orderId);
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
}
