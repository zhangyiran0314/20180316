package com.iflytransporter.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.bean.OrderResp;
import com.iflytransporter.web.service.CommonService;
import com.iflytransporter.web.service.OrderService;
import com.iflytransporter.web.service.UserService;

@Controller
@RequestMapping("shipper/order")
public class ShipperOrderController {
	private static Logger logger = LoggerFactory.getLogger(ShipperOrderController.class);
	@Autowired
	private OrderService orderService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private UserService userService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("order/list");
		return "shipper/order/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,String orderNo,String mobile,String companyName,HttpServletRequest request){
		PageInfo<Map<String,Object>> result = orderService.queryPage(page, limit,orderNo,mobile,companyName);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(Map<String,Object> op: result.getList()){
			op.put("departureProvince",commonService.queryProvince((String)op.get("departureProvinceId")));
			
			//op.setDepartureCity(commonService.queryCity(order.getDepartureCityId()));
			op.put("departureCity",commonService.queryCity((String)op.get("departureCityId")));
//			op.setDepartureArea(commonService.queryArea(order.getDepartureAreaId()));
			op.put("departureArea",commonService.queryArea((String)op.get("departureAreaId")));
			
//			op.setDestinationProvince(commonService.queryProvince(order.getDestinationProvinceId()));
			op.put("destinationProvince",commonService.queryProvince((String)op.get("destinationProvinceId")));
//			op.setDestinationCity(commonService.queryCity(order.getDestinationCityId()));
			op.put("destinationCity",commonService.queryCity((String)op.get("destinationCityId")));
//			op.setDestinationArea(commonService.queryArea(order.getDestinationAreaId()));
			op.put("destinationArea",commonService.queryArea((String)op.get("destinationAreaId")));
		
//			op.setCarType(commonService.queryCarType(order.getCarTypeId()));
			op.put("carType",commonService.queryCarType((String)op.get("carTypeId")));
//			op.setHandlingType(commonService.queryHandlingType(order.getHandlingTypeId()));
			op.put("handlingType",commonService.queryHandlingType((String)op.get("handlingTypeId")));
//			op.setPaymentType(commonService.queryPaymentType(order.getPaymentTypeId()));
			op.put("paymentType",commonService.queryPaymentType((String)op.get("paymentTypeId")));
//			op.setUseType(commonService.queryUseType(order.getUseTypeId()));
			op.put("useType",commonService.queryUseType((String)op.get("useTypeId")));
			list.add(op);
		}
		return ResponseUtil.successPage(result.getTotal(), list);
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "shipper/order/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "shipper/order/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		Map<String,Object> obj = orderService.queryDetail(id);
		obj.put("departureProvince",commonService.queryProvince((String)obj.get("departureProvinceId")));
		
		obj.put("departureCity",commonService.queryCity((String)obj.get("departureCityId")));
		obj.put("departureArea",commonService.queryArea((String)obj.get("departureAreaId")));
		
		obj.put("destinationProvince",commonService.queryProvince((String)obj.get("destinationProvinceId")));
		obj.put("destinationCity",commonService.queryCity((String)obj.get("destinationCityId")));
		obj.put("destinationArea",commonService.queryArea((String)obj.get("destinationAreaId")));
	
		obj.put("carType",commonService.queryCarType((String)obj.get("carTypeId")));
		obj.put("handlingType",commonService.queryHandlingType((String)obj.get("handlingTypeId")));
		obj.put("paymentType",commonService.queryPaymentType((String)obj.get("paymentTypeId")));
		obj.put("useType",commonService.queryUseType((String)obj.get("useTypeId")));
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(Order obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
	
	
}
