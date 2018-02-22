package com.iflytransporter.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.iflytransporter.api.bean.TransporterWaybillResp;
import com.iflytransporter.api.service.AreaService;
import com.iflytransporter.api.service.CarTypeService;
import com.iflytransporter.api.service.CityService;
import com.iflytransporter.api.service.CommonService;
import com.iflytransporter.api.service.HandlingTypeService;
import com.iflytransporter.api.service.PaymentTypeService;
import com.iflytransporter.api.service.ProvinceService;
import com.iflytransporter.api.service.TransporterOrderService;
import com.iflytransporter.api.service.TransporterWaybillService;
import com.iflytransporter.api.service.UseTypeService;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.api.utils.RequestMapUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.api.utils.UUIDUtil;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.TransporterComment;
import com.iflytransporter.common.bean.TransporterComplaint;
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
	private CommonService commonService;
	
	@ApiOperation(value="queryPage", notes="分页列表",produces = "application/json",response = TransporterWaybillResp.class)
	@RequestMapping(value="queryPage", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPage(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1|2|3} 运单状态:0-待装车|待派单(管理员),1-运输中,2-已完结(status:2待确认3-已确认);pageNo:当前页数-默认(1);pageSize:分页数-默认(10)") 
			Map<String,Object> requestMap){
		String lang = request.getHeader("lang");
		Integer pageNo = RequestMapUtil.formatPageNo(requestMap);
		Integer pageSize = RequestMapUtil.formatPageSize(requestMap);
		Integer status = RequestMapUtil.formatStatus(requestMap);
		Integer dispenseStatus = (Integer) requestMap.get("dispenseStatus");//派单状态 0 -未派单,1-已派单
		String userId =  (String) request.getAttribute("userId");
		
		PageInfo<Waybill> page =null;
		User user = userService.detailByCache(userId);
		/**
		 * 司机已完结状态对应 货主端两种状态:待确认和已确认(货主端已完结状态),此处在通过sql查询判断 status查询为2时 定义 (status = 2 or status =3)查询
		 */
		if(Status.User_Level_Admin==user.getLevel().intValue()){
			page = transporterWaybillService.queryPage(pageNo,pageSize, null,user.getCompanyId(),status,dispenseStatus);
		}else if(status != null && Status.Waybill_For_Loading == status.intValue() && Status.Waybill_Dispense_No != status.intValue()){
			page = transporterWaybillService.queryPage(pageNo, pageSize, userId, null, status,Status.Waybill_Dispense_Yes);
		}
		if(page.getTotal()==0){
			return ResponseUtil.successPage(page.getTotal(),page.getPages(), null);
		}
		List<Waybill> list = page.getList();
		List<TransporterWaybillResp> result = new ArrayList<TransporterWaybillResp>();
		for(Waybill waybill:list){
			TransporterWaybillResp op =new TransporterWaybillResp(waybill);
			
			Order order = transporterOrderService.query(waybill.getOrderId());
			op.setOrder(order);
			op.setDepartureProvince(commonService.queryProvince(lang,order.getDepartureProvinceId()));
			op.setDepartureCity(commonService.queryCity(lang,order.getDepartureCityId()));
			op.setDepartureArea(commonService.queryArea(lang,order.getDepartureAreaId()));
			
			op.setDestinationProvince(commonService.queryProvince(lang,order.getDestinationProvinceId()));
			op.setDestinationCity(commonService.queryCity(lang,order.getDestinationCityId()));
			op.setDestinationArea(commonService.queryArea(lang,order.getDestinationAreaId()));
			
			op.setCarType(commonService.queryCarType(lang,order.getCarTypeId()));
			op.setHandlingType(commonService.queryHandlingType(lang,order.getHandlingTypeId()));
			op.setPaymentType(commonService.queryUseType(lang,order.getPaymentTypeId()));
			op.setUseType(commonService.queryUseType(lang,order.getUseTypeId()));
			
			//发货人
			op.setShipper(transporterWaybillService.detailShipper(waybill.getShipperId()));
			//管理员角色,已派单状态下,添加派单信息
			if(Status.User_Level_Admin==user.getLevel().intValue() && Status.Waybill_Dispense_Yes == waybill.getDispenseStatus()){
				op.setDriver(transporterWaybillService.detailDriver(waybill.getDriverId()));
			}
			result.add(op);
		}
		return ResponseUtil.successPage(page.getTotal(), page.getPages(), result);
	}
	
	@ApiOperation(value="list", notes="列表",produces = "application/json",response = TransporterWaybillResp.class)
	@RequestMapping(value="list", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{status:0|1|2|3} 运单状态:0-待装车,1-运输中,2-待确认,3-已完结") Map<String,Object> requestMap){
		String lang = request.getHeader("lang");
		Integer status = RequestMapUtil.formatStatus(requestMap);
		String userId =  (String) request.getAttribute("userId");
		Integer dispenseStatus = (Integer) requestMap.get("dispenseStatus");//派单状态 0 -未派单,1-已派单
		List<Waybill> list =null;
		User user = userService.detailByCache(userId);
		if(Status.User_Level_Admin==user.getLevel().intValue()){
			list = transporterWaybillService.list(null, user.getCompanyId(), status,dispenseStatus);
			//司机不能查询待派单运单
		}else if(status != null && Status.Waybill_For_Loading == status.intValue() && Status.Waybill_Dispense_No != status.intValue()){
			list = transporterWaybillService.list(userId,null,status,Status.Waybill_Dispense_Yes);
		}
		List<TransporterWaybillResp> result = new ArrayList<TransporterWaybillResp>();
		for(Waybill waybill:list){
			TransporterWaybillResp op =new TransporterWaybillResp(waybill);
			Order order = transporterOrderService.query(waybill.getOrderId());
			op.setOrder(order);
			op.setDepartureProvince(commonService.queryProvince(lang,order.getDepartureProvinceId()));
			op.setDepartureCity(commonService.queryCity(lang,order.getDepartureCityId()));
			op.setDepartureArea(commonService.queryArea(lang,order.getDepartureAreaId()));
			
			op.setDestinationProvince(commonService.queryProvince(lang,order.getDestinationProvinceId()));
			op.setDestinationCity(commonService.queryCity(lang,order.getDestinationCityId()));
			op.setDestinationArea(commonService.queryArea(lang,order.getDestinationAreaId()));
			
			op.setCarType(commonService.queryCarType(lang,order.getCarTypeId()));
			op.setHandlingType(commonService.queryHandlingType(lang,order.getHandlingTypeId()));
			op.setPaymentType(commonService.queryUseType(lang,order.getPaymentTypeId()));
			op.setUseType(commonService.queryUseType(lang,order.getUseTypeId()));
			
			//发货人
			op.setShipper(transporterWaybillService.detailShipper(waybill.getShipperId()));
			//管理员角色,已派单状态下,添加司机信息
			if(Status.User_Level_Admin==user.getLevel().intValue() && Status.Waybill_Dispense_Yes == waybill.getDispenseStatus()){
				op.setDriver(transporterWaybillService.detailDriver(waybill.getDriverId()));
			}
			result.add(op);
		}
		return ResponseUtil.successResult(result);
	}
	@ApiOperation(value="detail", notes="详情",produces = "application/json",response = TransporterWaybillResp.class)
	@RequestMapping(value="detail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{id:id}") Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String id = (String) requestMap.get("id");
		Waybill waybill = transporterWaybillService.query(id);
		
		Map<String,Object> result = new HashMap<String,Object>();
		//公司信息
		result.put("shipperCompany", transporterWaybillService.detailShipperCompany(waybill.getShipperCompanyId()));
		//已派单状态,派单信息
		if( Status.Waybill_Dispense_Yes == waybill.getDispenseStatus()){
			result.put("dispense", transporterWaybillService.detailDispense(waybill.getId()));
		}
		//大于待装车状态,查询收货凭证&&查询是否投诉
		if(waybill.getStatus() > Status.Waybill_For_Loading){
			result.put("takeAttachmentList", transporterWaybillService.takeAttachmentList(id));
			result.put("complaintFlag", transporterWaybillService.countComplaintByWaybill(waybill.getId(), userId));
		}
		//大于运输中状态,查询交货凭证
		if(waybill.getStatus() > Status.Waybill_In_Transit){
			result.put("deliverAttachmentList", transporterWaybillService.deliverAttachmentList(id));
		}
		//等于已完结状态,查询是否已经评价
		if(Status.Waybill_To_Confirm <= waybill.getStatus().intValue()){
			result.put("commentFlag",transporterWaybillService.countCommentByWaybill(waybill.getId()));
		}
		return ResponseUtil.successResult(result);
	}
	@ApiOperation(value="detailShipper", notes="货主详情",produces = "application/json")
	@RequestMapping(value="detailShipper", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailShipper(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{shipperId:shipperId}") Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String shipperId = (String) requestMap.get("shipperId");
		Map<String,Object> result = transporterWaybillService.detailShipperComment(shipperId);
		return ResponseUtil.successResult(result);
	}
	@ApiOperation(value="detailDispense", notes="车辆详情",produces = "application/json")
	@RequestMapping(value="detailDispense", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailDispense(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{driverId:driverId}") Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String driverId = (String) requestMap.get("driverId");
		Map<String,Object> result = transporterWaybillService.detailDispenseComment(driverId);
		return ResponseUtil.successResult(result);
	}
	@ApiOperation(value="listDriver", notes="司机列表",produces = "application/json")
	@RequestMapping(value="listDriver", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> listDriver(HttpServletRequest request, HttpServletResponse response){
		String userId = (String) request.getAttribute("userId");
		User user = userService.detailByCache(userId);
		if(Status.User_Level_Admin==user.getLevel().intValue()){
			List<Map<String,Object>>  result = transporterWaybillService.listDriver(user.getCompanyId(),Status.User_Level_Staff);
			return ResponseUtil.successResult(result);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="listCar", notes="车辆列表",produces = "application/json")
	@RequestMapping(value="listCar", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> listCar(HttpServletRequest request, HttpServletResponse response){
		String userId = (String) request.getAttribute("userId");
		User user = userService.detailByCache(userId);
		if(Status.User_Level_Admin==user.getLevel().intValue()){
			List<Map<String,Object>>  result = transporterWaybillService.listCar(user.getCompanyId());
			return ResponseUtil.successResult(result);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="dispense", notes="派单",produces = "application/json")
	@RequestMapping(value="dispense", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> dispense(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{id:id,driverId:司机id,carId:车辆id}") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		String driverId = (String) requestMap.get("driverId");
		String carId = (String) requestMap.get("carId");
		int result = transporterWaybillService.dispense(id, driverId, carId, Status.Waybill_Dispense_Yes);
		if(result > 0){
			return ResponseUtil.successResultId(id);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="loadingProof", notes="收货凭证",produces = "application/json")
	@RequestMapping(value="loadingProof", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> loadingProof(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{attachmentId1,attachmentId2:attachmentId3,attachmentId4}") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		String attachment1 = (String) requestMap.get("attachmentId1");
		String attachment2 = (String) requestMap.get("attachmentId2");
		String attachment3 = (String) requestMap.get("attachmentId3");
		String attachment4 = (String) requestMap.get("attachmentId4");
		String carId = (String) requestMap.get("carId");
		int result = transporterWaybillService.loadingProof(id, attachment1, attachment2, attachment3, attachment4);
		if(result > 0){
			return ResponseUtil.successResultId(id);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="deliverProof", notes="交货凭证",produces = "application/json")
	@RequestMapping(value="deliverProof", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deliverProof(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{attachmentId1,attachmentId2:attachmentId3,attachmentId4}") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		String attachment1 = (String) requestMap.get("attachmentId1");
		String attachment2 = (String) requestMap.get("attachmentId2");
		String attachment3 = (String) requestMap.get("attachmentId3");
		String attachment4 = (String) requestMap.get("attachmentId4");
		String carId = (String) requestMap.get("carId");
		int result = transporterWaybillService.deliverProof(id, attachment1, attachment2, attachment3, attachment4);
		if(result > 0){
			return ResponseUtil.successResultId(id);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="comment", notes="发布评论",produces = "application/json")
	@RequestMapping(value="comment", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> comment(HttpServletRequest request, HttpServletResponse response,
			@RequestBody TransporterComment comment){
		Waybill waybill = transporterWaybillService.query(comment.getWaybillId());
		comment.setId(UUIDUtil.UUID());
		comment.setOrderId(waybill.getOrderId());
		comment.setOrderNo(waybill.getOrderNo());
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
	@ApiOperation(value="commentDetail", notes="评论详情",produces = "application/json")
	@RequestMapping(value="commentDetail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> commentDetail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{id:id} id-运单id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		String userId = (String) request.getAttribute("userId");
		Map<String,Object> result = transporterWaybillService.queryCommentByWaybill(id);
		return ResponseUtil.successResult(result);
	}
	@ApiOperation(value="complaint", notes="提交投诉",produces = "application/json")
	@RequestMapping(value="complaint", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> complaint(HttpServletRequest request, HttpServletResponse response,
			@RequestBody TransporterComplaint complaint){
		Waybill waybill = transporterWaybillService.query(complaint.getWaybillId());
		complaint.setId(UUIDUtil.UUID());
		complaint.setOrderId(waybill.getOrderId());
		complaint.setOrderNo(waybill.getOrderNo());
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
	@ApiOperation(value="complaintDetail", notes="投诉详情",produces = "application/json")
	@RequestMapping(value="complaintDetail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> complaintDetail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{id:id} id-运单id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		String userId = (String) request.getAttribute("userId");
		Map<String,Object> result = transporterWaybillService.queryComplaintByWaybill(id);
		return ResponseUtil.successResult(result);
	}
}
