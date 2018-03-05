package com.iflytransporter.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iflytransporter.api.bean.request.InsuranceReq;
import com.iflytransporter.api.bean.request.InsuranceWaybillResp;
import com.iflytransporter.api.service.CommonService;
import com.iflytransporter.api.service.InsuranceService;
import com.iflytransporter.common.bean.Insurance;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.common.utils.UUIDUtil;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/insurance/{version}")
public class InsuranceController {
	@Autowired
	private InsuranceService insuranceSerivce;
	
	@Autowired
	private CommonService commonService;
	/**当前用户查询待装车运单列表*/
	@RequestMapping(value="listWaybill", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> listWaybill(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		String lang = request.getHeader("lang");
		List<Map<String,Object>>  list = insuranceSerivce.listWaybillByUserId(userId);
		if(list==null || list.isEmpty()){
			ResponseUtil.successResult();
		}
		List<InsuranceWaybillResp> result = new ArrayList<InsuranceWaybillResp>();
		for(Map<String,Object> map :list){
			InsuranceWaybillResp op = new InsuranceWaybillResp(map);
			op.setDepartureProvince(commonService.queryProvince(lang,(String)map.get("departureProvinceId")));
			op.setDepartureCity(commonService.queryCity(lang,(String)map.get("departureCityId")));
			op.setDepartureArea(commonService.queryArea(lang,(String)map.get("departureAreaId")));
			
			op.setDestinationProvince(commonService.queryProvince(lang,(String)map.get("destinationProvinceId")));
			op.setDestinationCity(commonService.queryCity(lang,(String)map.get("destinationCityId")));
			op.setDestinationArea(commonService.queryArea(lang,(String)map.get("destinationAreaId")));
			result.add(op);
		}
		return ResponseUtil.successResult(result);
	}
	/**添加保险信息*/
	@ApiOperation(value="add", notes="新增",produces = "application/json")
	@RequestMapping(value="add", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> add(HttpServletRequest request, HttpServletResponse response,
			@RequestBody InsuranceReq insuranceReq){
		String userId =  (String) request.getAttribute("userId");
		String costsStr = insuranceReq.getCostsStr();
		String goodsValueStr = insuranceReq.getGoodsValueStr();
		Double goodsValue = Double.parseDouble(goodsValueStr);
		Double costs = Double.parseDouble(costsStr);
		Insurance insurance = new Insurance();
		BeanUtils.copyProperties(insuranceReq, insurance);
		insurance.setId(UUIDUtil.UUID());
		insurance.setCosts(costs);
		insurance.setGoodsValue(goodsValue);
		insurance.setUserId(userId);
		int result = insuranceSerivce.save(insurance);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
}
