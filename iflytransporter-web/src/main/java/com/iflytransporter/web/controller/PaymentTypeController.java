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
import com.iflytransporter.common.bean.PaymentType;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.PaymentTypeService;

@Controller
@RequestMapping("/paymentType")
public class PaymentTypeController {
	private static Logger logger = LoggerFactory.getLogger(PaymentTypeController.class);
	@Autowired
	private PaymentTypeService paymentTypeService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("paymentType/list");
		return "paymentType/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,HttpServletRequest request){
		PageInfo<PaymentType> queryPage = paymentTypeService.queryPage(page, limit);
		return ResponseUtil.successPage(queryPage.getTotal(),queryPage.getList());
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "paymentType/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "paymentType/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		PaymentType obj = paymentTypeService.queryDetail(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(PaymentType obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
	@RequestMapping("delete")
	@ResponseBody
	public  Map<String,Object> delete(String id,HttpServletRequest request){
		
		return ResponseUtil.successResult();
	}
}
