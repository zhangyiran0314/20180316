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
@RequestMapping("/complaint")
public class ComplaintController {
	private static Logger logger = LoggerFactory.getLogger(ComplaintController.class);
	@Autowired
	private ComplaintService complaintService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("complaint/list");
		return "complaint/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer pageNo,String sId,String tId,String wId,HttpServletRequest request){
		PageInfo<Complaint> page = complaintService.queryPage(pageNo, 10, sId, tId, wId);
		return ResponseUtil.successResult(page);
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "complaint/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "complaint/edit";
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
