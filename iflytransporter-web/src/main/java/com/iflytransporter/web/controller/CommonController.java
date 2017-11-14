package com.iflytransporter.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.web.service.CommonService;

@Controller
@RequestMapping("common")
public class CommonController {
	private static Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/")
	public String index(){
		logger.info("CommonController index method!");
		return "common/list";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer pageNo,HttpServletRequest request){
		logger.info("CommonController queryPage method!");
		PageInfo<Object> page = commonService.queryPage(pageNo, 10);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("page", page);
		return result;
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> info(String id,HttpServletRequest request){
		logger.info("CommonController queryPage method!");
		Object user = commonService.queryDetail(id);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", user);
		return result;
	}
}
