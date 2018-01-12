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
import com.iflytransporter.common.bean.Area;
import com.iflytransporter.common.bean.AreaBO;
import com.iflytransporter.common.bean.CityBO;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.AreaService;

@Controller
@RequestMapping("/area")
public class AreaController {
	private static Logger logger = LoggerFactory.getLogger(AreaController.class);
	@Autowired
	private AreaService areaService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("area/list");
		return "area/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,String name,HttpServletRequest request){
		PageInfo<AreaBO> queryPage = areaService.queryPage( page, limit,name);
		return ResponseUtil.successPage(queryPage.getTotal(), queryPage.getList());
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "area/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "area/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		AreaBO obj = areaService.queryDetailBO(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(Area obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
