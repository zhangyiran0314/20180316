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
import com.iflytransporter.common.bean.Complaint;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.ComplaintService;

@Controller
@RequestMapping("shipper/complaint")
public class ShipperComplaintController {
	private static Logger logger = LoggerFactory.getLogger(ShipperComplaintController.class);
	@Autowired
	private ComplaintService complaintService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("complaint/list");
		return "shipper/complaint/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,String orderNo,String mobile,HttpServletRequest request){
		PageInfo<Map<String,Object>> result = complaintService.queryPage(page, limit,orderNo,mobile);
		return ResponseUtil.successPage(result.getTotal(),result.getList());
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "shipper/complaint/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "shipper/complaint/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		Complaint obj = complaintService.queryDetail(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(Complaint obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
