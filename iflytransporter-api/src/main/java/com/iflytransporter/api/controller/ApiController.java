package com.iflytransporter.api.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iflytransporter.api.bean.UserShipper;
import com.iflytransporter.api.common.enums.BuzExceptionEnums;
import com.iflytransporter.api.common.version.ApiVersion;
import com.iflytransporter.api.service.UserShipperService;
import com.iflytransporter.api.utils.CaptchaUtil;
import com.iflytransporter.api.utils.JwtUtil;
import com.iflytransporter.api.utils.JwtUtil.JwtUser;
import com.iflytransporter.api.utils.RedisUtil;
import com.iflytransporter.api.utils.ResponseUitl;
import com.iflytransporter.api.utils.UUIDUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "basic api",description="此controller接口无需token即可直接访问")
@Controller
@RequestMapping("/{version}/basic")
public class ApiController {
	
	@Autowired
	private UserShipperService userShipperService;
	
	@Autowired
    private RedisTemplate<String, String> redisTemplate;//注入redis缓存
	
	@ApiOperation(value="获取验证码", notes="根据用户手机获取验证码,默认十分钟有效,五分钟之内不允许重复请求")
	@ApiImplicitParam(name = "mobile",value = "手机号码",paramType = "form",required=true)
	@RequestMapping(value="getCaptcha2", method=RequestMethod.POST)
	@ApiVersion(2)
	@ResponseBody
	public String  getCaptcha2(HttpServletRequest request, HttpServletResponse response){
		return  ResponseUitl.successResult();
	}
	
	@ApiOperation(value="获取验证码", notes="根据用户手机获取验证码,默认十分钟有效,五分钟之内不允许重复请求")
	@ApiImplicitParam(name = "mobile",value = "手机号码",paramType = "form",required=true)
	@RequestMapping(value="getCaptcha", method=RequestMethod.POST)
	@ApiVersion(1)
	@ResponseBody
	public String  getCaptcha(HttpServletRequest request, HttpServletResponse response){
		String mobile = request.getParameter("mobile");
		if(StringUtils.isNotBlank(mobile)){
			try{
				String key = RedisUtil.getCaptchaKey(mobile);
				boolean hasKey = redisTemplate.hasKey(key);
				if(hasKey){
					Long ttl =redisTemplate.getExpire(key);
					//五分钟再次获取,当成重复获取
					if(ttl > 5*60){
						return ResponseUitl.failureResult(BuzExceptionEnums.RepeatForCaptchaError);
					 }
				}
				//生成验证码
				String captcha = CaptchaUtil.generateCaptcha();
				
				//调用短信接口发送短信
				// TODO Auto-generated method stub
				
				//存放到redis缓存
				ValueOperations<String, String> operations=redisTemplate.opsForValue();
				operations.set(key, captcha, 10, TimeUnit.MINUTES);//保存十分钟
				Map<String,Object> data =new HashMap<String,Object>();
				data.put("captcha", captcha);
				return ResponseUitl.successResult(data);
			}catch(Exception e){
				return ResponseUitl.failureResult(BuzExceptionEnums.UnknownError);
			}
		}
		return ResponseUitl.failureResult();
	}
	@ApiOperation(value="验证验证码", notes="根据用户手机和验证码验证")
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "mobile",value = "手机号码",paramType = "form",dataType = "String",required=true),
		 @ApiImplicitParam(name = "captcha",value = "验证码",paramType = "form",dataType = "String",required=true)
	})
	@RequestMapping(value="verifyCaptcha", method=RequestMethod.POST)
	@ResponseBody
	public String  verifyCaptcha(HttpServletRequest request, HttpServletResponse response){
		String mobile = request.getParameter("mobile");
		String captcha = request.getParameter("captcha");
		if(StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(captcha)){
			try{
				String key = RedisUtil.getCaptchaKey(mobile);
				boolean hasKey = redisTemplate.hasKey(key);
				if(hasKey){
					ValueOperations<String, String> operations=redisTemplate.opsForValue();
					String captchaCache = operations.get(key);
					if(captcha.equals(captchaCache)){
						return ResponseUitl.successResult(null);
					}
					return ResponseUitl.failureResult(BuzExceptionEnums.VerifyCaptchaError);
				}
			}catch(Exception e){
				return ResponseUitl.failureResult(BuzExceptionEnums.UnknownError);
			}
		}
		return ResponseUitl.failureResult();
	}
	@ApiOperation(value="注册用户货主", notes="根据用户名和密码注册用户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "mobile",value = "手机号码",paramType = "form",dataType = "String",required=true), 
        @ApiImplicitParam(name = "password",value = "用户密码",paramType = "form",dataType = "String",required=true)
    })
	@RequestMapping(value="registerShipper", method=RequestMethod.POST)
	@ResponseBody
	public String  registerShipper(HttpServletRequest request, HttpServletResponse response){
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		UserShipper checkUser = userShipperService.queryByMobile(mobile);
		if(null!=checkUser){
			return ResponseUitl.failureResult(BuzExceptionEnums.AccountsAlreadyExist);
		}
		UserShipper user = new UserShipper();
		user.setMobile(mobile);
		user.setPassword(password);
		user.setId(UUIDUtil.UUID());
		int result =  userShipperService.register(user);
		if(result > 0){
			Map<String,Object> data =new HashMap<String,Object>();
			data.put("user", user);
			return ResponseUitl.successResult(data);
		}
		return ResponseUitl.failureResult();
	}
	
	
	@ApiOperation(value="获取token", notes="根据用户名和密码验证当前用户登录信息,获取接口请求token")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "mobile",value = "手机号码",paramType = "form",dataType = "String",required=true), 
        @ApiImplicitParam(name = "password",value = "用户密码",paramType = "form",dataType = "String",required=true)
    })
	@RequestMapping(value="accessToken", method=RequestMethod.POST)
	@ApiVersion(1)
	@ResponseBody
	public String  accessToken(HttpServletRequest request, HttpServletResponse response){
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		Map<String,Object> data =new HashMap<String,Object>();
		/*if(!"admin".equals(username) || !"123456".equals(password)){
			try{
				throw new ServiceException(BuzExceptionEnums.AccountOrPasswordErr);  
			}catch(ServiceException se){  
			   System.out.println(se.getMessage());     
			   return ResultUitl.exceptionResult(se); //返回异常JSON  
			} 
		}*/
		if(StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(password)){
			UserShipper user = userShipperService.login(mobile, password);
			if(null == user){
				return ResponseUitl.failureResult(BuzExceptionEnums.AccountOrPasswordErr);
			}
			JwtUser jwtUser = new JwtUser(user.getId(),user.getMobile(),user.getPassword(),user.getLastLoginDevice());
			String token = JwtUtil.createJWT(jwtUser, JwtUtil.JWT_TTL);
			data.put("token", token);
			return ResponseUitl.successResult(data);
		}
		return ResponseUitl.failureResult();
	}
	
}
