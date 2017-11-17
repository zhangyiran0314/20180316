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
import com.iflytransporter.common.bean.GoodsUnits;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.GoodsUnitsService;

@Controller
@RequestMapping("/goodsUnits")
public class GoodsUnitsController {
	private static Logger logger = LoggerFactory.getLogger(GoodsUnitsController.class);
	@Autowired
	private GoodsUnitsService goodsUnitsService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("goodsUnits/list");
		return "goodsUnits/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer pageNo,HttpServletRequest request){
		PageInfo<GoodsUnits> page = goodsUnitsService.queryPage( pageNo, 10);
		return ResponseUtil.successResult(page);
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "goodsUnits/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "goodsUnits/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		GoodsUnits obj = goodsUnitsService.queryDetail(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(GoodsUnits obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
