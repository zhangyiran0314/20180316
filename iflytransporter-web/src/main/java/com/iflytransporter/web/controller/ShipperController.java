package com.iflytransporter.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;
import com.iflytransporter.common.enums.Status;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.UserService;

@Controller
@RequestMapping("/shipper/user")
public class ShipperController {
	private static Logger logger = LoggerFactory.getLogger(ShipperController.class);
	@Autowired
	private UserService userService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("shipper/list");
		return "shipper/user/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,String mobile,
			HttpServletRequest request){
		PageInfo<UserBO> result = userService.queryPage(page, limit, Status.Type_User_Shipper, mobile);
		return ResponseUtil.successPage(result.getTotal(), result.getList());
				
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		UserBO obj = userService.queryDetailBO(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "shipper/user/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "shipper/user/edit";
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(User obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
	@RequestMapping("toEditAuth")
	public String toEditAuth(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "shipper/user/editAuth";
	}
	@RequestMapping("editAuth")
	@ResponseBody
	public  Map<String,Object> editAuth(@RequestBody User obj,HttpServletRequest request){
		int result  = userService.updateUser(obj);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult(ResponseUtil.Msg_Data_Err);
	}
}
