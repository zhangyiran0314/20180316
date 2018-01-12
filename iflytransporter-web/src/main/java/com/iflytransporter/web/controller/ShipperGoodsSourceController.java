package com.iflytransporter.web.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.iflytransporter.web.bean.GoodsSourceResp;
import com.iflytransporter.web.service.CommonService;
import com.iflytransporter.web.service.GoodsSourceService;
import com.iflytransporter.web.service.UserService;

@Controller
@RequestMapping("shipper/goodsSource")
public class ShipperGoodsSourceController {
	private static Logger logger = LoggerFactory.getLogger(ShipperGoodsSourceController.class);
	@Autowired
	private GoodsSourceService goodsSourceService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private UserService userService;

	@RequestMapping("/manage")
	public String index(){
		logger.info("goodsSource/list");
		return "shipper/goodsSource/manage";
	}
	@RequestMapping("queryPage")
	@ResponseBody
	public Map<String,Object> queryPage(Integer page,Integer limit,String sId,String tId,String wId,HttpServletRequest request){
		PageInfo<GoodsSource> result = goodsSourceService.queryPage(page, limit,sId,tId);
		List<GoodsSourceResp> list = new ArrayList<GoodsSourceResp>();
		for(GoodsSource gs:result.getList()){
			GoodsSourceResp op =new GoodsSourceResp(gs);
			op.setDepartureProvince(commonService.queryProvince(gs.getDepartureProvinceId()));
			op.setDepartureCity(commonService.queryCity(gs.getDepartureCityId()));
			op.setDepartureArea(commonService.queryArea(gs.getDepartureAreaId()));
			
			op.setDestinationProvince(commonService.queryProvince(gs.getDestinationProvinceId()));
			op.setDestinationCity(commonService.queryCity(gs.getDestinationCityId()));
			op.setDestinationArea(commonService.queryArea(gs.getDestinationAreaId()));
			
			op.setCarType(commonService.queryCarType(gs.getCarTypeId()));
			op.setHandlingType(commonService.queryHandlingType(gs.getHandlingTypeId()));
			op.setPaymentType(commonService.queryPaymentType(gs.getPaymentTypeId()));
			op.setUseType(commonService.queryUseType(gs.getUseTypeId()));
			//添加用户
			op.setMobile(userService.queryDetail(gs.getUserId()).getMobile());
			list.add(op);
		}
		return ResponseUtil.successPage(result.getTotal(), list);
	}
	@RequestMapping("toDetail")
	public String toDetail(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "shipper/goodsSource/detail";
	}
	@RequestMapping("toEdit")
	public String toEdit(String id,HttpServletRequest request){
		request.setAttribute("objectId", id);
		return "shipper/goodsSource/edit";
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
