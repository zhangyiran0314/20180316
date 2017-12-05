package com.iflytransporter.api.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iflytransporter.api.service.UserService;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.utils.ResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "user api",description="我的-用户相关操作 Controller")
@Controller
@RequestMapping("/user/{version}")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**上级操作 start*/
	@ApiOperation(value="detailUp", notes="上级-详情",produces = "application/json")
	@RequestMapping(value="detailUp", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailUp(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		return ResponseUtil.successResult();
	}
	@ApiOperation(value="deleteUp", notes="上级-解除绑定",produces = "application/json")
	@RequestMapping(value="deleteUp", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteUp(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="上级用户id:upId")Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		return ResponseUtil.successResult();
	}
	/**下级操作 start*/
	@ApiOperation(value="deleteDown", notes="下级-删除",produces = "application/json")
	@RequestMapping(value="deleteDown", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteDown(HttpServletRequest request, HttpServletResponse response,
			@RequestBody  @ApiParam(value="下级用户id:downId") Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		return ResponseUtil.successResult();
	}
	
	@ApiOperation(value="modifyDown", notes="下级-修改",produces = "application/json")
	@RequestMapping(value="modifyDown", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifyDown(HttpServletRequest request, HttpServletResponse response,
			@RequestBody  @ApiParam(value="下级用户实体") User user){
		String userId =  (String) request.getAttribute("userId");
		return ResponseUtil.successResult();
	}
	
	@ApiOperation(value="detailDown", notes="下级-详情",produces = "application/json")
	@RequestMapping(value="detailDown", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailDown(HttpServletRequest request, HttpServletResponse response,
			@RequestBody  @ApiParam(value="下级用户id:downId")Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String  downId = (String) requestMap.get("downId");
		if(downId==null){
			return ResponseUtil.failureResult();
		}
		User result  = userService.queryBO(downId);
		return ResponseUtil.successResult(result);
	}
	
	
	@ApiOperation(value="addDown", notes="下级-添加",produces = "application/json")
	@RequestMapping(value="addDown", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addDown(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="下级用户实体") User user){
		String userId =  (String) request.getAttribute("userId");
		return ResponseUtil.successResult();
	}
	
	@ApiOperation(value="listDown", notes="下级-列表",produces = "application/json")
	@RequestMapping(value="listDown", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> listDown(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		List<User> result = userService.listDown(userId);
		return ResponseUtil.successResult(result);
	}
	
	/** 用户操作  start*/
	@ApiOperation(value="auth", notes="认证个人",produces = "application/json")
	@RequestMapping(value="auth", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> auth(HttpServletRequest request, HttpServletResponse response,
			@RequestBody  @ApiParam(value="用户实体") User user ){
		String userId =  (String) request.getAttribute("userId");
		if(user ==null || !userId.equals(user.getId())){
			return ResponseUtil.failureResult();
		}
		User result  = userService.auth(user);
		if(result != null){
			return ResponseUtil.successResult(result);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="detail", notes="详情",produces = "application/json")
	@RequestMapping(value="detail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detail(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		User result  = userService.queryBO(userId);
		return ResponseUtil.successResult(result);
	}
	@ApiOperation(value="modify", notes="修改",produces = "application/json")
	@RequestMapping(value="modify", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modify(HttpServletRequest request, HttpServletResponse response,
			@RequestBody User user){
		String userId =  (String) request.getAttribute("userId");
		if(user ==null || !userId.equals(user.getId())){
			return ResponseUtil.failureResult();
		}
		User result  = userService.update(user);
		if(result != null){
			return ResponseUtil.successResult(result);
		}
		return ResponseUtil.failureResult();
	}
}
