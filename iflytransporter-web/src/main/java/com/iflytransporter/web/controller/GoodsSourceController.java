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
import com.iflytransporter.common.bean.GoodsSource;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.web.service.GoodsSourceService;

@Controller
@RequestMapping("/goodsSource")
public class GoodsSourceController {
	private static Logger logger = LoggerFactory.getLogger(GoodsSourceController.class);
	@Autowired
	private GoodsSourceService goodsSourceService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("goodsSource/list");
		return "goodsSource/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer pageNo,String sId,String tId,String wId,HttpServletRequest request){
		PageInfo<GoodsSource> page = goodsSourceService.queryPage(pageNo, 10, sId, tId);
		return ResponseUtil.successResult(page);
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "goodsSource/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "goodsSource/edit";
	}
	@RequestMapping("detail")
	@ResponseBody
	public Map<String,Object> detail(String id,HttpServletRequest request){
		GoodsSource obj = goodsSourceService.queryDetail(id);
		return ResponseUtil.successResult(obj);
	}
	@RequestMapping("edit")
	@ResponseBody
	public  Map<String,Object> edit(GoodsSource obj,HttpServletRequest request){
		return ResponseUtil.successResult();
	}
}
