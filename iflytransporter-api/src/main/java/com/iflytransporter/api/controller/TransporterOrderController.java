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
import com.iflytransporter.api.bean.QueryOrderParam;
import com.iflytransporter.api.bean.SubscribeSourceResp;
import com.iflytransporter.api.bean.TransporterOrderResp;
import com.iflytransporter.api.service.CommonService;
import com.iflytransporter.api.service.TransporterOrderService;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.api.utils.AuthUtils;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.OrderApply;
import com.iflytransporter.common.bean.SubscribeSource;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.enums.BuzExceptionEnums;
import com.iflytransporter.common.exception.ServiceException;
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
	private CommonService commonService;
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
	 * 修改订阅路线
	 */
	@ApiOperation(value="modifySubscribe", notes="找货-修改订阅路线",produces = "application/json")
	@RequestMapping(value="modifySubscribe", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifySubscribe(HttpServletRequest request, HttpServletResponse response,
			@RequestBody SubscribeSource ss){
		String userId =  (String) request.getAttribute("userId");
		ss.setUserId(userId);
		int result = transporterOrderService.update(ss);
		if(result > 0){
			return ResponseUtil.successResultId(ss.getId());
		}
		return ResponseUtil.failureResult();
	}
	/**
	 * 删除订阅路线
	 */
	@ApiOperation(value="deleteSubscribe", notes="找货-删除订阅路线",produces = "application/json")
	@RequestMapping(value="deleteSubscribe", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteSubscribe(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String subscribeId =  (String) requestMap.get("subscribeId");
		int result = transporterOrderService.delete(subscribeId);
		if(result > 0){
			return ResponseUtil.successResult();
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
		String lang = request.getHeader("lang");
		String userId =  (String) request.getAttribute("userId");
		List<SubscribeSource> list = transporterOrderService.listByUserId(userId);
		List<SubscribeSourceResp> result = new ArrayList<SubscribeSourceResp>();
		for(SubscribeSource source:list){
			SubscribeSourceResp op =new SubscribeSourceResp(source);
			op.setDepartureProvince(commonService.queryProvince(lang,source.getDepartureProvinceId()));
			op.setDepartureCity(commonService.queryCity(lang,source.getDepartureCityId()));
			op.setDepartureArea(commonService.queryArea(lang,source.getDepartureAreaId()));
			
			op.setDestinationProvince(commonService.queryProvince(lang,source.getDestinationProvinceId()));
			op.setDestinationCity(commonService.queryCity(lang,source.getDestinationCityId()));
			op.setDestinationArea(commonService.queryArea(lang,source.getDestinationAreaId()));
			
			op.setCarType(commonService.queryCarType(lang,source.getCarTypeId()));
			op.setUseType(commonService.queryUseType(lang,source.getUseTypeId()));
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
		String lang = request.getHeader("lang");
		String userId =  (String) request.getAttribute("userId");
		String subscribeId =  (String) requestMap.get("subscribeId");
		SubscribeSource source = transporterOrderService.querySubscribeSource(subscribeId);
		SubscribeSourceResp op =new SubscribeSourceResp(source);
		op.setDepartureProvince(commonService.queryProvince(lang,source.getDepartureProvinceId()));
		op.setDepartureCity(commonService.queryCity(lang,source.getDepartureCityId()));
		op.setDepartureArea(commonService.queryArea(lang,source.getDepartureAreaId()));
		
		op.setDestinationProvince(commonService.queryProvince(lang,source.getDestinationProvinceId()));
		op.setDestinationCity(commonService.queryCity(lang,source.getDestinationCityId()));
		op.setDestinationArea(commonService.queryArea(lang,source.getDestinationAreaId()));
		
		op.setCarType(commonService.queryCarType(lang,source.getCarTypeId()));
		op.setUseType(commonService.queryUseType(lang,source.getUseTypeId()));
		return ResponseUtil.successResult(op);
	}
	
	@ApiOperation(position=1,value="queryPage", notes="分页列表-找货",produces = "application/json")
	@RequestMapping(value="queryPage", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPage(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{pageNo:1,pageSize:10} 此列表只能看到已通过授权的数据;pageNo:当前页数-默认(1);pageSize:分页数-默认(10)") 
			QueryOrderParam queryParam){
		String lang = request.getHeader("lang");
//		Integer pageNo = queryParam.getPageNo()==null ? 1: queryParam.getPageNo();
//		Integer pageSize = queryParam.getPageSize()==null ? 10: queryParam.getPageSize();
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailByCache(userId);
		//非管理员不能找货
		if(!AuthUtils.identificationTransporter(user)){
			return ResponseUtil.failureResult(BuzExceptionEnums.NoOperationPermission);
		}
		queryParam.setTransporterId(userId);
		PageInfo<Order> page = transporterOrderService.queryPage(queryParam);
		if(page.getTotal()==0){
			return ResponseUtil.successPage(page.getTotal(),page.getPages(), null);
		}
		List<Order> list = page.getList();
		List<TransporterOrderResp> result = new ArrayList<TransporterOrderResp>();
		for(Order order:list){
			TransporterOrderResp op =new TransporterOrderResp(order);
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
			//添加货主详情
			op.setShipper(transporterOrderService.detailShipper(order.getShipperId()));
			
			result.add(op);
		}
		return ResponseUtil.successPage(page.getTotal(), page.getPages(), result);
	}
	@ApiOperation(value="list", notes="列表-找货",produces = "application/json")
	@RequestMapping(value="list", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("{} ,此列表只能看到已通过授权的数据") QueryOrderParam queryParam){
//		Integer status = RequestMapUtil.formatStatus(requestMap);
		String lang = request.getHeader("lang");
		String userId =  (String) request.getAttribute("userId");
		User user = userService.detailByCache(userId);
		//非管理员不能找货
		if(!AuthUtils.identificationTransporter(user)){
			return ResponseUtil.failureResult(BuzExceptionEnums.NoOperationPermission);
		}
		queryParam.setTransporterId(userId);
		List<Order> list = transporterOrderService.list(queryParam);
		List<TransporterOrderResp> result = new ArrayList<TransporterOrderResp>();
		for(Order order:list){
			TransporterOrderResp op =new TransporterOrderResp(order);
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
			//添加货主详情
			op.setShipper(transporterOrderService.detailShipper(order.getShipperId()));
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
		if(!AuthUtils.identification(user)){
			return ResponseUtil.failureResult(BuzExceptionEnums.NotCertifited);
		}
		//非管理员不能报价
		if(!AuthUtils.identificationTransporter(user)){
			return ResponseUtil.failureResult(BuzExceptionEnums.NoOperationPermission);
		}
		Order order = transporterOrderService.query(id);
		OrderApply orderApply = new OrderApply();
		String applyId = UUIDUtil.UUID();
		orderApply.setId(applyId);
		orderApply.setCompanyId(user.getCompanyId());
		orderApply.setTransporterId(userId);
		orderApply.setOrderNo(order.getOrderNo());
		orderApply.setOrderId(order.getId());
		orderApply.setCosts(costs);
		try{
			int result = transporterOrderService.apply(orderApply);
			if(result > 0){
				return ResponseUtil.successResultId(applyId);
			}
		}catch(ServiceException e){
			return ResponseUtil.exceptionResult(e);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="applyList", notes="找货-我的报价",produces = "application/json")
	@RequestMapping(value="applyList", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> applyList(HttpServletRequest request, HttpServletResponse response){
		String lang = request.getHeader("lang");
		String userId =  (String) request.getAttribute("userId");
		List<OrderApply> list = transporterOrderService.listApplyByUserId(userId);
		List<TransporterOrderResp> result = new ArrayList<TransporterOrderResp>();
		if(list != null && list.size() > 0){
			for(OrderApply orderApply: list){
				Order order = transporterOrderService.query(orderApply.getOrderId());
				TransporterOrderResp op =new TransporterOrderResp(order);
				op.setOrderApply(orderApply);
				
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
				//添加货主详情
				op.setShipper(transporterOrderService.detailShipper(order.getShipperId()));
				result.add(op);
			}
		}
		return ResponseUtil.successResult(result);
	}
	@ApiOperation(value="applyListRecord", notes="找货-找货记录",produces = "application/json")
	@RequestMapping(value="applyListRecord", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> applyListRecord(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{recordStatus:recordStatus} status:1-浏览状态,2-通话记录") Map<String,Object> requestMap){
		
		String lang = request.getHeader("lang");
		String userId =  (String) request.getAttribute("userId");
		Integer recordStatus =  (Integer) requestMap.get("recordStatus");
		List<OrderApply> list = transporterOrderService.listApplyRecord(userId, recordStatus);
		if(list != null && list.size() > 0){
			List<TransporterOrderResp> result = new ArrayList<TransporterOrderResp>();
			for(OrderApply orderApply: list){
				Order order = transporterOrderService.query(orderApply.getOrderId());
				TransporterOrderResp op =new TransporterOrderResp(order);
				op.setOrderApplyRecord(orderApply);
				
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
				//添加货主详情
				op.setShipper(transporterOrderService.detailShipper(order.getShipperId()));
				result.add(op);
			}
			return ResponseUtil.successResult(result);
		}
		return ResponseUtil.successResult();
	}
	
}
