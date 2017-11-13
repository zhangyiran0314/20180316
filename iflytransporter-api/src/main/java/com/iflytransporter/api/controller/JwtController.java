package com.iflytransporter.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.iflytransporter.api.utils.JwtUtil;
import com.iflytransporter.api.utils.ResponseUtil;

import io.jsonwebtoken.Claims;

@Controller
@RequestMapping("/jwt")
public class JwtController {
	
	@RequestMapping("accessToken")
	@ResponseBody
	public Map<String,Object>  accessToken(String username,String password,HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> result =new HashMap<String,Object>();
		if(!"admin".equals(username) || !"123456".equals(password)){
			result.put("status",403);
			result.put("msg", "账号或者密码错误");
			return ResponseUtil.successResult(result);
		}
		String token = JwtUtil.createJWT(username, JwtUtil.JWT_TTL);
		String refreshToken = JwtUtil.createJWT(username, JwtUtil.JWT_REFRESH_TTL);
		JSONObject jo = new JSONObject();
		jo.put("token", token);
		jo.put("refreshToken", refreshToken);
		result.put("status",200);
		result.put("msg", "0");
		result.put("result", jo);
		return ResponseUtil.successResult(result);
	}
	@RequestMapping("refreshToken")
	@ResponseBody
	public Map<String,Object>  refreshToken(String token,HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> result =new HashMap<String,Object>();
		Claims claims = JwtUtil.parseJWT(token);
		if(claims==null){
			result.put("status",403);
			result.put("msg", "刷新token失败");
			return result;
		}
		String username = claims.getSubject();
		String newToken = JwtUtil.createJWT(username, JwtUtil.JWT_TTL);
		String refreshToken = JwtUtil.createJWT(username, JwtUtil.JWT_REFRESH_TTL);
		JSONObject jo = new JSONObject();
		jo.put("token", newToken);
		jo.put("refreshToken", refreshToken);
		result.put("status",200);
		result.put("msg", "0");
		result.put("result", jo);
		return result;
	}
}
