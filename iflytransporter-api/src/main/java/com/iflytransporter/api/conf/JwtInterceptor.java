package com.iflytransporter.api.conf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.iflytransporter.api.utils.JwtUtil;
import com.iflytransporter.api.utils.ResponseUtil;

/**
 * jwt拦截器
 * 1.拦截token
 * 2.获取userId
 * @author zhangguan
 */
public class JwtInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("JwtInterceptor preHandle funcion .........");
		String auth = request.getHeader("Authorization");
		if ((auth != null) && (auth.length() > 7)) {
			String headStr = auth.substring(0, 6).toLowerCase();
			if (headStr.compareTo("bearer") == 0) {
				auth = auth.substring(7, auth.length());
				String userId = JwtUtil.parseJWTUserId(auth);
				if (userId !=null) {
					request.setAttribute("userId", userId);
					return true;
				}
			}
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().write(JSON.toJSONString(ResponseUtil.forbiddenResult()));
			return false;
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().write(JSON.toJSONString(ResponseUtil.unauthorizedResult()));
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
