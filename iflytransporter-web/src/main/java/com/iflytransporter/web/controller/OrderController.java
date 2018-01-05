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

@Controller
@RequestMapping("/order")
public class OrderController {
	private static Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private OrderService orderService;
	@Autowired
	private CommonService commonService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("order/list");
		return "order/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,String sId,HttpServletRequest request){
		PageInfo<Order> result = orderService.queryPage(page, limit);
		List<OrderResp> list = new ArrayList<OrderResp>();
		for(Order order:result.getList()){
			OrderResp op =new OrderResp(order);
			op.setDepartureProvince(commonService.queryProvince(order.getDepartureProvinceId()));
			op.setDepartureCity(commonService.queryCity(order.getDepartureCityId()));
			op.setDepartureArea(commonService.queryArea(order.getDepartureAreaId()));
			
			op.setDestinationProvince(commonService.queryProvince(order.getDestinationProvinceId()));
			op.setDestinationCity(commonService.queryCity(order.getDestinationCityId()));
			op.setDestinationArea(commonService.queryArea(order.getDestinationAreaId()));
			
			op.setCarType(commonService.queryCarType(order.getCarTypeId()));
			op.setHandlingType(commonService.queryHandlingType(order.getHandlingTypeId()));
			op.setPaymentType(commonService.queryPaymentType(order.getPaymentTypeId()));
			op.setUseType(commonService.queryUseType(order.getUseTypeId()));
			list.add(op);
		}
		return ResponseUtil.successPage(result.getTotal(), list);
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "order/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "order/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		Order obj = orderService.queryDetail(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(Order obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
	
	
}
