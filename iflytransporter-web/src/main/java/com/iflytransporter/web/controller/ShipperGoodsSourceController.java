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
import com.iflytransporter.common.bean.GoodsSource;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.bean.GoodsSourceResp;
import com.iflytransporter.web.service.CommonService;
import com.iflytransporter.web.service.GoodsSourceService;
import com.iflytransporter.web.service.UserService;

@Controller
@RequestMapping("shipper/goodsSource")
public class ShipperGoodsSourceController {
	private static Logger logger = LoggerFactory.getLogger(ShipperGoodsSourceController.class);
	@Autowired
	private GoodsSourceService goodsSourceService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private UserService userService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("goodsSource/list");
		return "shipper/goodsSource/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,String sId,String orderNo,String mobile,HttpServletRequest request){
		PageInfo<Map<String,Object>> result = goodsSourceService.queryPage(page, limit, orderNo, mobile);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(Map<String,Object> op: result.getList()){
			op.put("departureProvice",commonService.queryProvince((String)op.get("departureProviceId")));
			
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
		return "shipper/goodsSource/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "shipper/goodsSource/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		Map<String,Object> obj = goodsSourceService.queryDetail(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(GoodsSource obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
