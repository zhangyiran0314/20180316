package com.iflytransporter.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iflytransporter.api.bean.UserResp;
import com.iflytransporter.api.service.CompanyService;
import com.iflytransporter.api.service.FeedbackService;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.common.bean.CompanyBO;
import com.iflytransporter.common.bean.Feedback;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;
import com.iflytransporter.common.enums.BuzExceptionEnums;
import com.iflytransporter.common.enums.Status;
import com.iflytransporter.api.utils.RedisUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.utils.UUIDUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "user api",description="我的-用户相关操作 Controller")
@Controller
@RequestMapping("/user/{version}")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private FeedbackService feedbackService;
	@Autowired
    private RedisTemplate<String, String> redisTemplate;//注入redis缓存
	/**反馈意见*/
	@ApiOperation(value="我的-反馈意见", notes="我的-反馈意见",produces = "application/json")
	@RequestMapping(value="feedback", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> feedback(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Feedback feedback){
		String userId =  (String) request.getAttribute("userId");
		feedback.setUserId(userId);
		feedback.setId(UUIDUtil.UUID());
		int result = feedbackService.sava(feedback);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	/**设置*/
	@ApiOperation(value="我的-更改密码", notes="我的-更改密码",produces = "application/json")
	@RequestMapping(value="modifyPwd", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifyPwd(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{pwd:pwd}") Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String countryCode = (String)  requestMap.get("countryCode");
		String mobile = (String) requestMap.get("mobile");
		String captcha = (String) requestMap.get("captcha");
		if(StringUtils.isBlank(captcha)){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		String key = RedisUtil.getCaptchaKey(countryCode,mobile);
		boolean hasKey = redisTemplate.hasKey(key);
		if(!hasKey){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		ValueOperations<String, String> operations=redisTemplate.opsForValue();
		String captchaCache = operations.get(key);
		if(!captcha.equals(captchaCache)){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		String pwd = (String) requestMap.get("pwd");
		String newPwd = (String) requestMap.get("newPwd");
		//判断原密码是否正确
		User user = userService.queryBO(userId);
		if(pwd==null || !pwd.equals(user.getPassword())){
			return ResponseUtil.failureResult(BuzExceptionEnums.AccountOrPasswordErr);
		}
		int result = userService.updatePwdOrMobileOrEmail(userId, newPwd, null, null);
		if(result > 0){
			redisTemplate.delete(key);//验证通过返回之前删除当前验证码
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="我的-更改手机号码", notes="我的-更改手机号码",produces = "application/json")
	@RequestMapping(value="modifyMobile", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifyMobile(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{mobile:mobile}") Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String countryCode = (String)  requestMap.get("countryCode");
		String mobile = (String) requestMap.get("mobile");
		String captcha = (String) requestMap.get("captcha");
		if(StringUtils.isBlank(captcha)){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		String key = RedisUtil.getCaptchaKey(countryCode,mobile);
		boolean hasKey = redisTemplate.hasKey(key);
		if(!hasKey){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		ValueOperations<String, String> operations=redisTemplate.opsForValue();
		String captchaCache = operations.get(key);
		if(!captcha.equals(captchaCache)){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		
		String newMobile = (String) requestMap.get("newMobile");
		String newCaptcha = (String) requestMap.get("newCaptcha");
		if(StringUtils.isBlank(captcha)){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		String newKey = RedisUtil.getCaptchaKey(countryCode,newMobile);
		boolean newHasKey = redisTemplate.hasKey(newKey);
		if(!newHasKey){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		String newCaptchaCache = operations.get(newKey);
		if(!newCaptcha.equals(newCaptchaCache)){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		int result = userService.updatePwdOrMobileOrEmail(userId, null, newMobile, null);
		if(result > 0){
			redisTemplate.delete(key);//验证通过返回之前删除当前验证码
			redisTemplate.delete(newKey);//验证通过返回之前删除当前验证码
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="我的-更改邮箱", notes="我的-更改邮箱",produces = "application/json")
	@RequestMapping(value="modifyEmail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifyEmail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{email:email}") Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String email = (String) requestMap.get("email");
		String countryCode = (String)  requestMap.get("countryCode");
		String mobile = (String) requestMap.get("mobile");
		String captcha = (String) requestMap.get("captcha");
		if(StringUtils.isBlank(captcha)){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		String key = RedisUtil.getCaptchaKey(countryCode,mobile);
		boolean hasKey = redisTemplate.hasKey(key);
		if(!hasKey){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		ValueOperations<String, String> operations=redisTemplate.opsForValue();
		String captchaCache = operations.get(key);
		if(!captcha.equals(captchaCache)){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		int result = userService.updatePwdOrMobileOrEmail(userId, null, null, email);
		if(result > 0){
			redisTemplate.delete(key);//验证通过返回之前删除当前验证码
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	
	/**上级操作 start*/
	@ApiOperation(value="上级-详情", notes="上级-详情",produces = "application/json")
	@RequestMapping(value="detailUp", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailUp(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		User result = userService.detailUp(userId);
		if(result==null){
		      return ResponseUtil.failureResult(BuzExceptionEnums.NotUpError);
		}
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("surname", result.getSurname());
		data.put("name", result.getName());
		data.put("mobile", result.getMobile());
		data.put("id", result.getId());
		return ResponseUtil.successResult(data);
	}
	@ApiOperation(value="上级-解除绑定", notes="上级-解除绑定",produces = "application/json")
	@RequestMapping(value="deleteUp", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteUp(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{upId:upId} upId:上级用户id") Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String upId = (String) requestMap.get("upId");
		int result = userService.deleteUp(userId, upId);
		if(result > 0){
		      return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	/**下级操作 start*/
	@ApiOperation(value="下级-删除", notes="下级-删除",produces = "application/json")
	@RequestMapping(value="deleteDown", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteDown(HttpServletRequest request, HttpServletResponse response,
			@RequestBody  @ApiParam(value="{downId:downId} downId:下级用户id") Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String downId = (String) requestMap.get("downId");
		int result = userService.deleteDown(userId, downId);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="下级-修改", notes="下级-修改",produces = "application/json")
	@RequestMapping(value="modifyDown", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifyDown(HttpServletRequest request, HttpServletResponse response,
			@RequestBody  @ApiParam(value="下级用户实体") User user){
		String userId =  (String) request.getAttribute("userId");
		int result = userService.updateDown(userId,user);
		if(result  > 0){
			return ResponseUtil.successResultId(user.getId());
		}
		return ResponseUtil.successResult();
	}
	
	@ApiOperation(value="下级-详情", notes="下级-详情",produces = "application/json")
	@RequestMapping(value="detailDown", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailDown(HttpServletRequest request, HttpServletResponse response,
			@RequestBody  @ApiParam(value="{downId:downId} downId:下级用户id")Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String  downId = (String) requestMap.get("downId");
		if(downId==null){
			return ResponseUtil.failureResult();
		}
		UserBO result  = userService.queryBO(downId);
		/*if(result ==null || result.getParentId() == null || !result.getParentId().equals(userId)){
			return ResponseUtil.failureResult();
		}*/
		return ResponseUtil.successResult(new UserResp(result));
	}
	
	@ApiOperation(value="下级-添加信息", notes="下级-添加信息",produces = "application/json")
	@RequestMapping(value="addDownDetail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addDownDetail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="下级用户实体") User user){
		String userId =  (String) request.getAttribute("userId");
		user.setParentId(userId);
		int result  = userService.auth(user);
		if(result >0 ){
			return ResponseUtil.successResultId(user.getId());
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="下级-添加", notes="下级-添加",produces = "application/json")
	@RequestMapping(value="addDown", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addDown(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="下级用户实体") User user){
		String userId =  (String) request.getAttribute("userId");
		User parentUser = userService.detailByCache(userId);
		user.setParentId(userId);
		user.setCompanyId(parentUser.getCompanyId());
		String  result  = userService.addDown(user);
		if(result !=null ){
			return ResponseUtil.successResultId(result);
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="下级-列表", notes="下级-列表",produces = "application/json")
	@RequestMapping(value="listDown", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> listDown(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		List<User> result = userService.listDown(userId);
		
		return ResponseUtil.successResult(result);
	}
	
	/** 用户操作  start*/
	@ApiOperation(value="个人-认证", notes="个人-认证",produces = "application/json",response=UserResp.class)
	@RequestMapping(value="auth", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> auth(HttpServletRequest request, HttpServletResponse response,
			@RequestBody  @ApiParam(value="用户实体") User user ){
		String userId =  (String) request.getAttribute("userId");
		user.setId(userId);
		int result  = userService.auth(user);
		if(result > 0){
			return ResponseUtil.successResultId(userId);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="个人-详情", notes="个人-详情",produces = "application/json",response=UserResp.class)
	@RequestMapping(value="detail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detail(HttpServletRequest request, HttpServletResponse response){
		String userId =  (String) request.getAttribute("userId");
		UserBO user  = userService.queryBO(userId);
		UserResp userResp = new UserResp(user);
		if(user.getCompanyAuthStatus() != null && user.getCompanyId() !=null && Status.Auth_No !=user.getCompanyAuthStatus().intValue()){
			CompanyBO company =companyService.query(user.getCompanyId());
			userResp.setCompanyName(company==null?null:company.getName());
		}
		return ResponseUtil.successResult(userResp);
	}
	@ApiOperation(value="个人-修改", notes="个人-修改",produces = "application/json",response=UserResp.class)
	@RequestMapping(value="modify", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modify(HttpServletRequest request, HttpServletResponse response,
			@RequestBody User user){
		String userId =  (String) request.getAttribute("userId");
		user.setId(userId);
		int result  = userService.update(user);
		if(result > 0){
			return ResponseUtil.successResultId(userId);
		}
		return ResponseUtil.failureResult();
	}
}
