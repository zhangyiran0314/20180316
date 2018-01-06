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
import com.iflytransporter.api.bean.WaybillResp;
import com.iflytransporter.api.service.AreaService;
import com.iflytransporter.api.service.CarTypeService;
import com.iflytransporter.api.service.CityService;
import com.iflytransporter.api.service.HandlingTypeService;
import com.iflytransporter.api.service.PaymentTypeService;
import com.iflytransporter.api.service.ProvinceService;
import com.iflytransporter.api.service.ShipperOrderService;
import com.iflytransporter.api.service.TransporterOrderService;
import com.iflytransporter.api.service.TransporterWaybillService;
import com.iflytransporter.api.service.UseTypeService;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.api.service.WaybillService;
import com.iflytransporter.api.utils.RequestMapUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.api.utils.UUIDUtil;
import com.iflytransporter.common.bean.Comment;
import com.iflytransporter.common.bean.Complaint;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.Waybill;
import com.iflytransporter.common.enums.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "transporter/waybill/",description="车主-运单操作 Controller")
@Controller
@RequestMapping("/transporter/waybill/{version}")
public class TransporterWaybillController {
	@Autowired
	private UserService userService;
	@Autowired
	private TransporterWaybillService transporterWaybillService;
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
		if(Status.User_Level_Admin==user.getLevel()){
			page = transporterWaybillService.queryPage(pageNo,pageSize, null,user.getCompanyId(),status);
		}else{
			page = transporterWaybillService.queryPage(pageNo, pageSize, userId, null, status);
		}
		if(page.getTotal()==0){
			return ResponseUtil.successPage(page.getTotal(),page.getPages(), null);
		}
		List<Waybill> list = page.getList();
		List<WaybillResp> result = new ArrayList<WaybillResp>();
		for(Waybill waybill:list){
			WaybillResp op =new WaybillResp(waybill);
			Order order = transporterOrderService.query(waybill.getOrderId());
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
		if(Status.User_Level_Admin==user.getLevel()){
			list = transporterWaybillService.list(null, user.getCompanyId(), status);
		}else{
			list = transporterWaybillService.list(userId,null,status);
		}
		List<WaybillResp> result = new ArrayList<WaybillResp>();
		for(Waybill waybill:list){
			WaybillResp op =new WaybillResp(waybill);
			Order order = transporterOrderService.query(waybill.getOrderId());
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
			@RequestBody @ApiParam(value="{id:id}") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		Waybill waybill = transporterWaybillService.query(id);
		WaybillResp op =new WaybillResp(waybill);
		Order order = transporterOrderService.query(waybill.getOrderId());
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
		op.setCompany(transporterWaybillService.detailCompany(id));
		//车主信息
		op.setTransporter(transporterWaybillService.detailShipper(id));
		//大于待装车状态,查询收货凭证&&查询是否投诉
		if(waybill.getStatus() > Status.Waybill_For_Loading){
			op.setTakeAttachmentList(transporterWaybillService.takeAttachmentList(id));
		}
		//大于运输中状态,查询交货凭证
		if(waybill.getStatus() > Status.Waybill_In_Transit){
			op.setDeliverAttachmentList(transporterWaybillService.deliverAttachmentList(id));
		}
		//等于已完结状态,查询是否已经评价
		if(Status.Waybill_Finish == waybill.getStatus().intValue()){
			
		}
		return ResponseUtil.successResult(op);
	}
	
	@ApiOperation(value="confirm", notes="确认收货",produces = "application/json")
	@RequestMapping(value="confirm", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> auditCancel(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{id:id} id-运单id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		int result = transporterWaybillService.updateStatus(id, Status.Waybill_Finish);
		if(result > 0){
			return ResponseUtil.successResultId(id);
		}
		return ResponseUtil.failureResult();
	}
	
	
	@ApiOperation(value="comment", notes="发布评论",produces = "application/json")
	@RequestMapping(value="comment", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> comment(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Comment comment){
		Waybill waybill = transporterWaybillService.query(comment.getWaybillId());
		comment.setId(UUIDUtil.UUID());
		comment.setShipperId(waybill.getShipperId());
		comment.setShipperCompanyId(waybill.getShipperCompanyId());
		comment.setTransporterCompanyId(waybill.getTransporterCompanyId());
		comment.setTransporterId(waybill.getTransporterId());
		int result = transporterWaybillService.addComment(comment);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="complaint", notes="提交投诉",produces = "application/json")
	@RequestMapping(value="complaint", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> complaint(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Complaint complaint){
		Waybill waybill = transporterWaybillService.query(complaint.getWaybillId());
		complaint.setId(UUIDUtil.UUID());
		complaint.setShipperId(waybill.getShipperId());
		complaint.setShipperCompanyId(waybill.getShipperCompanyId());
		complaint.setTransporterCompanyId(waybill.getTransporterCompanyId());
		complaint.setTransporterId(waybill.getTransporterId());
		int result = transporterWaybillService.addComplaint(complaint);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	
}
