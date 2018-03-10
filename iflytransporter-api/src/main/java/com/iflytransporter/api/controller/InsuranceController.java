package com.iflytransporter.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.iflytransporter.api.bean.response.InsuranceWaybillResp;
import com.iflytransporter.api.service.CommonService;
import com.iflytransporter.api.service.InsuranceService;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.common.bean.Insurance;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.common.utils.UUIDUtil;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/insurance/{version}")
public class InsuranceController {
	@Autowired
	private InsuranceService insuranceSerivce;
	@Autowired
	private UserService userService;
	@Autowired
	private CommonService commonService;
	/**当前用户查询待装车运单列表*/
	@RequestMapping(value="listWaybill", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> listWaybill(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		UserBO user = userService.detailBOByCache(userId);
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("policyholderName", user.getSurname()+" "+user.getName());
		result.put("policyholderCompany", user.getCompanyName());
		result.put("policyholderMobile", user.getMobile());
		String lang = request.getHeader("lang");
		List<Map<String,Object>>  list = insuranceSerivce.listWaybillByUserId(userId);
		if(list==null || list.isEmpty()){
			ResponseUtil.successResult();
		}
		List<InsuranceWaybillResp> resultWaybillList = new ArrayList<InsuranceWaybillResp>();
		for(Map<String,Object> map :list){
			InsuranceWaybillResp op = new InsuranceWaybillResp(map);
			op.setDepartureProvince(commonService.queryProvince(lang,(String)map.get("departureProvinceId")));
			op.setDepartureCity(commonService.queryCity(lang,(String)map.get("departureCityId")));
			op.setDepartureArea(commonService.queryArea(lang,(String)map.get("departureAreaId")));
			
			op.setDestinationProvince(commonService.queryProvince(lang,(String)map.get("destinationProvinceId")));
			op.setDestinationCity(commonService.queryCity(lang,(String)map.get("destinationCityId")));
			op.setDestinationArea(commonService.queryArea(lang,(String)map.get("destinationAreaId")));
			resultWaybillList.add(op);
		}
		result.put("waybillList", resultWaybillList);
		return ResponseUtil.successResult(result);
	}
	/**保险货物名称列表*/
	@ApiOperation(value="listGoodsName", notes="保险货物名称列表",produces = "application/json")
	@RequestMapping(value="listGoodsName", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> listGoodsName(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		List<Map<String,Object>> list = insuranceSerivce.listGoodsName();
		return ResponseUtil.successResult(list);
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
