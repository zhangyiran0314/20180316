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
import com.iflytransporter.api.bean.GoodsSourceResp;
import com.iflytransporter.api.bean.SubscribeSourceResp;
import com.iflytransporter.api.bean.TransporterOrderResp;
import com.iflytransporter.api.service.AreaService;
import com.iflytransporter.api.service.CarTypeService;
import com.iflytransporter.api.service.CityService;
import com.iflytransporter.api.service.HandlingTypeService;
import com.iflytransporter.api.service.OrderApplyService;
import com.iflytransporter.api.service.PaymentTypeService;
import com.iflytransporter.api.service.ProvinceService;
import com.iflytransporter.api.service.TransporterOrderService;
import com.iflytransporter.api.service.UseTypeService;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.api.utils.RequestMapUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.bean.GoodsSource;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.OrderApply;
import com.iflytransporter.common.bean.SubscribeSource;
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
	
	/**
	 * 添加订阅路线
	 */
	@ApiOperation(value="addSubscribe", notes="找货-添加订阅路线",produces = "application/json")
	@RequestMapping(value="addSubscribe", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addSubscribe(HttpServletRequest request, HttpServletResponse response,
			@RequestBody SubscribeSource ss){
		String userId =  (String) request.getAttribute("userId");
		String id = UUIDUtil.UUID();
		ss.setId(id);
		ss.setUserId(userId);
		int result = transporterOrderService.save(ss);
		if(result > 0){
			return ResponseUtil.successResultId(id);
		}
		return ResponseUtil.failureResult();
	}
	/**
	 * 查看订阅路线列表
	 */
	@ApiOperation(value="listSubscribe", notes="找货-订阅路线列表",produces = "application/json")
	@RequestMapping(value="listSubscribe", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> listSubscribe(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		List<SubscribeSource> list = transporterOrderService.listByUserId(userId);
		List<SubscribeSourceResp> result = new ArrayList<SubscribeSourceResp>();
		for(SubscribeSource source:list){
			SubscribeSourceResp op =new SubscribeSourceResp(source);
			op.setDepartureProvince(provinceService.queryCommonParam(source.getDepartureProvinceId()));
			op.setDepartureCity(cityService.queryCommonParam(source.getDepartureCityId()));
			op.setDepartureArea(areaService.queryCommonParam(source.getDepartureAreaId()));
			
			op.setDestinationProvince(provinceService.queryCommonParam(source.getDestinationProvinceId()));
			op.setDestinationCity(cityService.queryCommonParam(source.getDestinationCityId()));
			op.setDestinationArea(areaService.queryCommonParam(source.getDestinationAreaId()));
			
			op.setCarType(carTypeService.queryCommonParam(source.getCarTypeId()));
			op.setUseType(useTypeService.queryCommonParam(source.getUseTypeId()));
//			op.setGoodsUnits(goodsUnitsService.queryCommonParam(goodsSource.getGoodsUnits()));
			result.add(op);
		}
		return ResponseUtil.successResult(result);
	}
	/**
	 * 查看订阅路线详情
	 */
	@ApiOperation(value="detailSubscribe", notes="找货-订阅路线详情",produces = "application/json")
	@RequestMapping(value="detailSubscribe", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailSubscribe(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String subscribeId =  (String) requestMap.get("subscribeId");
		SubscribeSource source = transporterOrderService.querySubscribeSource(subscribeId);
		SubscribeSourceResp op =new SubscribeSourceResp(source);
		op.setDepartureProvince(provinceService.queryCommonParam(source.getDepartureProvinceId()));
		op.setDepartureCity(cityService.queryCommonParam(source.getDepartureCityId()));
		op.setDepartureArea(areaService.queryCommonParam(source.getDepartureAreaId()));
		
		op.setDestinationProvince(provinceService.queryCommonParam(source.getDestinationProvinceId()));
		op.setDestinationCity(cityService.queryCommonParam(source.getDestinationCityId()));
		op.setDestinationArea(areaService.queryCommonParam(source.getDestinationAreaId()));
		
		op.setCarType(carTypeService.queryCommonParam(source.getCarTypeId()));
		op.setUseType(useTypeService.queryCommonParam(source.getUseTypeId()));
		return ResponseUtil.successResult(op);
	}
	
	@ApiOperation(position=1,value="queryPage", notes="分页列表-找货",produces = "application/json")
	@RequestMapping(value="queryPage", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPage(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{pageNo:1,pageSize:10} 此列表只能看到已通过授权的数据;pageNo:当前页数-默认(1);pageSize:分页数-默认(10)") 
			Map<String,Object> requestMap){
		Integer pageNo = RequestMapUtil.formatPageNo(requestMap);
		Integer pageSize = RequestMapUtil.formatPageSize(requestMap);
		String userId =  (String) request.getAttribute("userId");
		PageInfo<Order> page = transporterOrderService.queryPage(pageNo,pageSize,Status.Order_Publish,Status.Order_Auth_Yes);
		if(page.getTotal()==0){
			return ResponseUtil.successPage(page.getTotal(),page.getPages(), null);
		}
		List<Order> list = page.getList();
		List<TransporterOrderResp> result = new ArrayList<TransporterOrderResp>();
		for(Order order:list){
			TransporterOrderResp op =new TransporterOrderResp(order);
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
			//添加货主详情
			op.setDetailShipper(transporterOrderService.detailShipper(order.getShipperId()));
			
			result.add(op);
		}
		return ResponseUtil.successPage(page.getTotal(), page.getPages(), result);
	}
	@ApiOperation(value="list", notes="列表-找货",produces = "application/json")
	@RequestMapping(value="list", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{} ,此列表只能看到已通过授权的数据") Map<String,Object> requestMap){
		Integer status = RequestMapUtil.formatStatus(requestMap);
		String userId =  (String) request.getAttribute("userId");
		if(status !=null && Status.Order_Publish!=status.intValue()){//非发布中状态查询已成交和已取消状态
			status = null;
		}
		List<Order> list = transporterOrderService.list(Status.Order_Publish,Status.Order_Auth_Yes);
		List<TransporterOrderResp> result = new ArrayList<TransporterOrderResp>();
		for(Order order:list){
			TransporterOrderResp op =new TransporterOrderResp(order);
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
			//添加货主详情
			op.setDetailShipper(transporterOrderService.detailShipper(order.getShipperId()));
			result.add(op);
		}
		return ResponseUtil.successResult(result);
	}

	@ApiOperation(value="detail", notes="详情",produces = "application/json",response = TransporterOrderResp.class)
	@RequestMapping(value="detail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="shipperId") Map<String,Object> requestMap){
		String shipperId = (String) requestMap.get("shipperId");
//		Order order = transporterOrderService.query(id);
		//订单内容有app端直接页面传递,此处只返回货主评论内容
		Map<String,Object> result = transporterOrderService.commentShipper(shipperId);
		return ResponseUtil.successResult(result);
	}
	
	
	@ApiOperation(value="apply", notes="找货-报价",produces = "application/json")
	@RequestMapping(value="apply", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> apply(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{id:id,costs:costs} id-订单id,costs-报价(使用字符串类型传值)") Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String id = (String) requestMap.get("id");
		String costss =  (String) requestMap.get("costs");
		Double costs = Double.parseDouble(costss);
		User user = userService.detailByCache(userId);
		Order order = transporterOrderService.query(id);
		OrderApply orderApply = new OrderApply();
		String applyId = UUIDUtil.UUID();
		orderApply.setId(applyId);
		orderApply.setCompanyId(user.getCompanyId());
		orderApply.setTransporterId(userId);
		orderApply.setOrderNo(order.getOrderNo());
		orderApply.setOrderId(order.getId());
		orderApply.setCosts(costs);
		int result = transporterOrderService.apply(orderApply);
		if(result > 0){
			return ResponseUtil.successResultId(applyId);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="applyList", notes="找货-我的报价",produces = "application/json")
	@RequestMapping(value="applyList", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> applyList(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		List<OrderApply> list = transporterOrderService.listApplyByUserId(userId);
		if(list != null && list.size() > 0){
			List<TransporterOrderResp> result = new ArrayList<TransporterOrderResp>();
			for(OrderApply orderApply: list){
				Order order = transporterOrderService.query(orderApply.getOrderId());
				TransporterOrderResp op =new TransporterOrderResp(order);
				op.setOrderApply(orderApply);
				
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
				//添加货主详情
				op.setDetailShipper(transporterOrderService.detailShipper(order.getShipperId()));
				result.add(op);
			}
			return ResponseUtil.successResult(result);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="applyListRecord", notes="找货-找货记录",produces = "application/json")
	@RequestMapping(value="applyListRecord", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> applyListRecord(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{recordStatus:recordStatus} status:1-浏览状态,2-通话记录") Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		Integer recordStatus =  (Integer) requestMap.get("recordStatus");
		List<OrderApply> list = transporterOrderService.listApplyRecord(userId, recordStatus);
		if(list != null && list.size() > 0){
			List<TransporterOrderResp> result = new ArrayList<TransporterOrderResp>();
			for(OrderApply orderApply: list){
				Order order = transporterOrderService.query(orderApply.getOrderId());
				TransporterOrderResp op =new TransporterOrderResp(order);
				op.setOrderApplyRecord(orderApply);
				
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
				//添加货主详情
				op.setDetailShipper(transporterOrderService.detailShipper(order.getShipperId()));
				result.add(op);
			}
			return ResponseUtil.successResult(result);
		}
		return ResponseUtil.successResult();
	}
	
}
