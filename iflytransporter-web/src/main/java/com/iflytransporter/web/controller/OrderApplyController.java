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
import com.iflytransporter.common.bean.OrderApply;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.OrderApplyService;

@Controller
@RequestMapping("/orderApply")
public class OrderApplyController {
	private static Logger logger = LoggerFactory.getLogger(OrderApplyController.class);
	@Autowired
	private OrderApplyService orderApplyService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("orderApply/list");
		return "orderApply/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer pageNo,String tId,String oId,HttpServletRequest request){
		PageInfo<OrderApply> page = orderApplyService.queryPage(pageNo, 10, tId,oId);
		return ResponseUtil.successResult(page);
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "orderApply/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "orderApply/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		OrderApply obj = orderApplyService.queryDetail(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(OrderApply obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
