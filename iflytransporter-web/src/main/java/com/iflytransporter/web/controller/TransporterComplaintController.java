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
import com.iflytransporter.web.service.TransporterComplaintService;

@Controller
@RequestMapping("transporter/complaint")
public class TransporterComplaintController {
	private static Logger logger = LoggerFactory.getLogger(TransporterComplaintController.class);
	@Autowired
	private TransporterComplaintService transporterComplaintService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("complaint/list");
		return "transporter/complaint/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,String orderNo,String tMobile,String sCompanyName,String sMobile,HttpServletRequest request){
		PageInfo<Map<String,Object>> result = transporterComplaintService.queryPage(page, limit, orderNo, tMobile, sCompanyName, sMobile);
		return ResponseUtil.successPage(result.getTotal(),result.getList());
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "transporter/complaint/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "transporter/complaint/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		Map<String,Object> obj = transporterComplaintService.queryDetail(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(Complaint obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
