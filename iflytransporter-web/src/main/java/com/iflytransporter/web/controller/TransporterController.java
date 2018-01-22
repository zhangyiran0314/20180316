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
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;
import com.iflytransporter.common.enums.Status;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.UserService;

@Controller
@RequestMapping("/transporter/user")
public class TransporterController {
	private static Logger logger = LoggerFactory.getLogger(TransporterController.class);
	@Autowired
	private UserService userService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("user/list");
		return "transporter/user/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,String mobile,HttpServletRequest request){
		PageInfo<User> result = userService.queryPage(page, limit, Status.Type_User_Transporter, mobile);
		return ResponseUtil.successPage(result.getTotal(),result.getList());
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "transporter/user/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "transporter/user/edit";
	}
	@RequestMapping("toEditAuth")
	public String toEditAuth(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "transporter/user/editAuth";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		Map<String,Object> obj = userService.queryDetail(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(User obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
