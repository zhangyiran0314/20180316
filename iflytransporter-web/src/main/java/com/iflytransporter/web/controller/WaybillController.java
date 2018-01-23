package com.iflytransporter.web.controller;

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
import com.iflytransporter.common.bean.Waybill;
import com.iflytransporter.common.enums.Status;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.CommonService;
import com.iflytransporter.web.service.WaybillService;

@Controller
@RequestMapping("/waybill")
public class WaybillController {
	private static Logger logger = LoggerFactory.getLogger(WaybillController.class);
	@Autowired
	private WaybillService waybillService;
	@Autowired
	private CommonService commonService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("waybill/list");
		return "waybill/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,String orderNo,Integer status, Integer dispenseStatus,String sCompanyName, String sMobile, String tCompanyName, String tMobile, String dMobile,HttpServletRequest request){
		PageInfo<Map<String,Object>> result = waybillService.queryPage(page, limit, orderNo, status, dispenseStatus, sCompanyName, sMobile, tCompanyName, tMobile, dMobile);
		return ResponseUtil.successPage(result.getTotal(),result.getList());
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "waybill/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "waybill/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		Map<String,Object> op = waybillService.queryDetail(id);
		
		op.put("departureProvince",commonService.queryProvince((String)op.get("departureProvinceId")));
		
		op.put("departureCity",commonService.queryCity((String)op.get("departureCityId")));
		op.put("departureArea",commonService.queryArea((String)op.get("departureAreaId")));
		op.put("destinationProvince",commonService.queryProvince((String)op.get("destinationProvinceId")));
		op.put("destinationCity",commonService.queryCity((String)op.get("destinationCityId")));
		op.put("destinationArea",commonService.queryArea((String)op.get("destinationAreaId")));
	
		op.put("carType",commonService.queryCarType((String)op.get("carTypeId")));
		op.put("handlingType",commonService.queryHandlingType((String)op.get("handlingTypeId")));
		op.put("paymentType",commonService.queryPaymentType((String)op.get("paymentTypeId")));
		op.put("useType",commonService.queryUseType((String)op.get("useTypeId")));
		
		//大于待装车状态,查询收货凭证
		if((Integer)op.get("status") > Status.Waybill_For_Loading){
			op.put("takeAttachmentList", waybillService.takeAttachmentList(id));
		}
		//大于运输中状态,查询交货凭证
		if((Integer)op.get("status") > Status.Waybill_In_Transit){
			op.put("deliverAttachmentList",waybillService.deliverAttachmentList(id));
		}
		return ResponseUtil.successResult(op);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(Waybill obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
