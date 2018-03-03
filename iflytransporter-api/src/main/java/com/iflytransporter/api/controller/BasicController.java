package com.iflytransporter.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

import com.iflytransporter.api.conf.ConstantsConfig;
import com.iflytransporter.api.service.UserService;
import com.iflytransporter.api.utils.CaptchaUtil;
import com.iflytransporter.api.utils.HttpUtil;
import com.iflytransporter.api.utils.JwtUtil;
import com.iflytransporter.api.utils.JwtUtil.JwtUser;
import com.iflytransporter.api.utils.MessageUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.api.utils.UUIDUtil;
import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.enums.BuzExceptionEnums;
import com.iflytransporter.common.enums.Status;
import com.iflytransporter.common.utils.RedisUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "basic api",description="此Controller接口无需token即可直接访问")
@Controller
@RequestMapping("/basic/{version}")
public class BasicController {
	
	@Autowired
	private UserService userService;
	@Autowired
    private RedisTemplate<String, String> redisTemplate;//注入redis缓存
	
	
	@ApiOperation(value="获取支持国家列表")
	@RequestMapping(value="getSupportCountries", method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object>  getSupportCountries(HttpServletRequest request, HttpServletResponse response){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> china = new HashMap<String,String>();
		china.put("country_name", "China");
		china.put("country_code", "+86");
		china.put("country_flag", "");
		list.add(china);
		Map<String,String> mal = new HashMap<String,String>();
		mal.put("country_name", "Malaysia");
		mal.put("country_code", "+60");
		mal.put("country_flag", "");
		list.add(mal);
		return  ResponseUtil.successResult(list);
	}
	
	@ApiOperation(value="获取验证码", notes="根据用户手机获取验证码,默认十分钟有效,两分钟之内不允许重复请求",produces = "application/json")
	@RequestMapping(value="getCaptcha", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  getCaptcha(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="countryCode,mobile,register,userType")Map<String,Object> requestMap){
		
		String mobile = (String) requestMap.get("mobile");
		String countryCode = (String)  requestMap.get("countryCode");
//		Integer register = (Integer) requestMap.get("register");
		Integer userType = (Integer)requestMap.get("userType");
		if(StringUtils.isNotBlank(mobile) && requestMap.get("register") != null){
			Integer register = (Integer) requestMap.get("register");//register:0|1 0-不做处理,1注册时获取验证码
			if(1==register){
				Integer count = userService.queryRegisterByMobile(countryCode, userType, mobile);
				if(count > 0 ){
					return ResponseUtil.failureResult(BuzExceptionEnums.AccountsAlreadyRegister);
				}
			}
		}
		
		if(StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(countryCode)){
			try{
				String key = RedisUtil.getCaptchaKey(countryCode,userType,mobile);
				boolean hasKey = redisTemplate.hasKey(key);
				if(hasKey){
					Long ttl =redisTemplate.getExpire(key);
					//两分钟再次获取,当成重复获取
					if(ttl > 8*60){
						return ResponseUtil.failureResult(BuzExceptionEnums.RepeatForCaptchaError);
					 }
				}
				//生成验证码
				String captcha = CaptchaUtil.generateCaptcha();
				
				if(ConstantsConfig.isMessageSendFlag()){
				//调用短信接口发送短信
					String msg= "The Captcha is "+captcha;
					MessageUtil.sendMessage(countryCode, mobile, msg);
				}
				//存放到redis缓存
				ValueOperations<String, String> operations=redisTemplate.opsForValue();
				operations.set(key, captcha, 10, TimeUnit.MINUTES);//保存十分钟
				Map<String,Object> data =new HashMap<String,Object>();
				data.put("captcha", captcha);
				return ResponseUtil.successResult(data);
			}catch(Exception e){
				return ResponseUtil.failureResult(BuzExceptionEnums.UnknownError);
			}
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="验证验证码", produces = "application/json",notes="根据用户手机和验证码验证 ")
	@RequestMapping(value="verifyCaptcha", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  verifyCaptcha(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="countryCode,mobile,captcha")Map<String,Object> requestMap){
		String mobile = (String) requestMap.get("mobile");
		String countryCode = (String)  requestMap.get("countryCode");
		String captcha = (String) requestMap.get("captcha");
		Integer userType = Integer.parseInt(request.getHeader("userType"));
		if(StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(captcha)){
			try{
				String key = RedisUtil.getCaptchaKey(countryCode,userType,mobile);
				boolean hasKey = redisTemplate.hasKey(key);
				if(hasKey){
					ValueOperations<String, String> operations=redisTemplate.opsForValue();
					String captchaCache = operations.get(key);
					if(captcha.equals(captchaCache)){
						redisTemplate.delete(key);//验证通过之后删除当前验证码
						return ResponseUtil.successResult();
					}
					return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
				}
			}catch(Exception e){
				return ResponseUtil.failureResult(BuzExceptionEnums.UnknownError);
			}
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="注册", notes="根据用户名和密码注册用户",produces = "application/json")
	@RequestMapping(value="register", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  register(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="countryCode,mobile,password,email,userType-0表示货主,1表示车主")Map<String,Object> requestMap){
		String mobile = (String) requestMap.get("mobile");
		String email = (String) requestMap.get("email");
		String countryCode = (String)  requestMap.get("countryCode");
		String password = (String) requestMap.get("password");
		Integer userType = (Integer)requestMap.get("userType");
		
		String captcha = (String) requestMap.get("captcha");
		if(StringUtils.isBlank(captcha)){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		String key = RedisUtil.getCaptchaKey(countryCode,userType,mobile);
		boolean hasKey = redisTemplate.hasKey(key);
		if(!hasKey){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		ValueOperations<String, String> operations=redisTemplate.opsForValue();
		String captchaCache = operations.get(key);
		if(!captcha.equals(captchaCache)){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		if(StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(password)&& userType!=null){
			User checkUser = userService.queryByMobile(countryCode, userType, mobile);
			if(null!=checkUser ){
				if(StringUtils.isNotBlank(checkUser.getParentId())){//被上级注册过
					userService.updatePwdOrMobileOrEmail(checkUser.getId(), password, null, email);
					JwtUser jwtUser = new JwtUser(checkUser.getId(),checkUser.getCountryCode(),checkUser.getMobile(),checkUser.getPassword(),checkUser.getLastLoginDevice());
					String token = JwtUtil.createJWT(jwtUser, JwtUtil.JWT_TTL);
					Map<String,Object> data =new HashMap<String,Object>();
					data.put("token", token);
					data.put("authStatus", checkUser.getAuthStatus());
					data.put("companyAuthStatus", checkUser.getCompanyAuthStatus());
					data.put("level", checkUser.getLevel());
					redisTemplate.delete(key);//验证通过之后删除当前验证码
					return ResponseUtil.successResult(data);
				}
				redisTemplate.delete(key);//验证通过之后删除当前验证码
				//已经注册,需要登录
				return ResponseUtil.failureResult(BuzExceptionEnums.AccountsAlreadyRegister);
			}
			User user = new User();
			Date currentDate = new Date();
			user.setCreateDate(currentDate);
			user.setUpdateDate(currentDate);
			user.setCountryCode(countryCode);
			user.setMobile(mobile);
			user.setEmail(email);
			user.setPassword(password);
			user.setId(UUIDUtil.UUID());
			user.setUserType(userType);
			user.setStatus(Status.User_Register);
			user.setLevel(Status.User_Level_Visitor);
			user.setAuthStatus(Status.Auth_No);
			user.setCompanyAuthStatus(Status.Auth_No);
			int result =  userService.register(user);
			if(result > 0){
				Map<String,Object> data =new HashMap<String,Object>();
				JwtUser jwtUser = new JwtUser(user.getId(),user.getCountryCode(),user.getMobile(),user.getPassword(),user.getLastLoginDevice());
				String token = JwtUtil.createJWT(jwtUser, JwtUtil.JWT_TTL);
				data.put("token", token);
				redisTemplate.delete(key);//验证通过之后删除当前验证码
				return ResponseUtil.successResult(data);
			}
		}
		return ResponseUtil.failureResult();
	}
	
	
	@ApiOperation(value="登录", notes="根据用户名和密码验证当前用户登录信息,获取接口请求token")
	@RequestMapping(value="login", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  login(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="countryCode,mobile,password,clientId,userType-0表示货主,1表示车主")Map<String,Object> requestMap){
		String countryCode = (String)  requestMap.get("countryCode");
		String mobile = (String) requestMap.get("mobile");
		String password = (String) requestMap.get("password");
		String clientId = (String) requestMap.get("clientId");
		Integer userType = (Integer)requestMap.get("userType");
		if(StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(password)
				&&StringUtils.isNotBlank(countryCode)&& userType!=null){
			User user = userService.login(countryCode,userType,mobile, password);
			if(null == user){
				return ResponseUtil.failureResult(BuzExceptionEnums.AccountOrPasswordErr);
			}
			user.setLastLoginDevice(clientId);
			user.setLastLoginIp(HttpUtil.getRemoteIp(request));
			user.setLastLoginDate(new Date());
			userService.updateLoginInfo(user);
			
			JwtUser jwtUser = new JwtUser(user.getId(),user.getCountryCode(),user.getMobile(),user.getPassword(),user.getLastLoginDevice());
			String token = JwtUtil.createJWT(jwtUser, JwtUtil.JWT_TTL);
			Map<String,Object> data =new HashMap<String,Object>();
			data.put("token", token);
			data.put("authStatus", user.getAuthStatus());
			data.put("companyAuthStatus", user.getCompanyAuthStatus());
			data.put("level", user.getLevel());
			return ResponseUtil.successResult(data);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="忘记密码")
	@RequestMapping(value="forgetPwd", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> forgetPwd(HttpServletRequest request, HttpServletResponse response,
			@RequestBody  Map<String,Object> requestMap){
		String countryCode = (String)  requestMap.get("countryCode");
		String mobile = (String) requestMap.get("mobile");
		String password = (String) requestMap.get("password");
		Integer userType = Integer.parseInt(request.getHeader("userType"));
		String captcha = (String) requestMap.get("captcha");
		if(StringUtils.isBlank(captcha)){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		String key = RedisUtil.getCaptchaKey(countryCode,userType,mobile);
		boolean hasKey = redisTemplate.hasKey(key);
		if(!hasKey){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		ValueOperations<String, String> operations=redisTemplate.opsForValue();
		String captchaCache = operations.get(key);
		if(!captcha.equals(captchaCache)){
			return ResponseUtil.failureResult(BuzExceptionEnums.VerifyCaptchaError);
		}
		User checkUser = userService.queryByMobile(countryCode, userType, mobile);
		if(checkUser ==null){
			return ResponseUtil.failureResult(BuzExceptionEnums.AccountsNotExist);
		}
		int result = userService.updatePwdOrMobileOrEmail(checkUser.getId(), password, null, null);
		if(result > 0){
			redisTemplate.delete(key);//验证通过返回之前删除当前验证码
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
}
