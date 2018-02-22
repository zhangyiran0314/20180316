package com.iflytransporter.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.api.bean.GoodsSourceResp;
import com.iflytransporter.api.service.AreaService;
import com.iflytransporter.api.service.CarTypeService;
import com.iflytransporter.api.service.CityService;
import com.iflytransporter.api.service.CommonService;
import com.iflytransporter.api.service.GoodsSourceService;
import com.iflytransporter.api.service.GoodsUnitsService;
import com.iflytransporter.api.service.HandlingTypeService;
import com.iflytransporter.api.service.PaymentTypeService;
import com.iflytransporter.api.service.ProvinceService;
import com.iflytransporter.api.service.ShipperOrderService;
import com.iflytransporter.api.service.UseTypeService;
import com.iflytransporter.api.utils.RequestMapUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.bean.GoodsSource;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.utils.UUIDUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "goodsSource api",description="货源操作 Controller")
@Controller
@RequestMapping("/goodsSource/{version}")
public class GoodsSourceController {
	
	@Autowired
	private GoodsSourceService goodsSourceService;
	@Autowired
	private CommonService commonService;
	
	@ApiOperation(value="queryPage", notes="分页列表",produces = "application/json",response=GoodsSourceResp.class)
	@RequestMapping(value="queryPage", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPage(HttpServletRequest request, HttpServletResponse response,
			@RequestBody   @ApiParam(value="{pageNo:1,pageSize:10}pageNo:当前页数-默认(1);pageSize:分页数-默认(10)")  Map<String,Object> requestMap){
		String lang = request.getHeader("lang");
		Integer pageNo = RequestMapUtil.formatPageNo(requestMap);
		Integer pageSize = RequestMapUtil.formatPageSize(requestMap);
		String userId =  (String) request.getAttribute("userId");
		PageInfo<GoodsSource> page = goodsSourceService.queryPage(pageNo,pageSize, userId);
		if(page.getTotal()==0){
			return ResponseUtil.successPage(page.getTotal(),page.getPages(), null);
		}
		List<GoodsSource> list = page.getList();
		List<GoodsSourceResp> result = new ArrayList<GoodsSourceResp>();
		for(GoodsSource goodsSource:list){
			GoodsSourceResp op =new GoodsSourceResp(goodsSource);
			op.setDepartureProvince(commonService.queryProvince(lang,goodsSource.getDepartureProvinceId()));
			op.setDepartureCity(commonService.queryCity(lang,goodsSource.getDepartureCityId()));
			op.setDepartureArea(commonService.queryArea(lang,goodsSource.getDepartureAreaId()));
			
			op.setDestinationProvince(commonService.queryProvince(lang,goodsSource.getDestinationProvinceId()));
			op.setDestinationCity(commonService.queryCity(lang,goodsSource.getDestinationCityId()));
			op.setDestinationArea(commonService.queryArea(lang,goodsSource.getDestinationAreaId()));
			
			op.setCarType(commonService.queryCarType(lang,goodsSource.getCarTypeId()));
			op.setHandlingType(commonService.queryHandlingType(lang,goodsSource.getHandlingTypeId()));
			op.setPaymentType(commonService.queryUseType(lang,goodsSource.getPaymentTypeId()));
			op.setUseType(commonService.queryUseType(lang,goodsSource.getUseTypeId()));
//			op.setGoodsUnits(goodsUnitsService.queryCommonParam(goodsSource.getGoodsUnits()));
			result.add(op);
		}
		return ResponseUtil.successPage(page.getTotal(), page.getPages(), result);
	}
	@ApiOperation(value="list", notes="列表",produces = "application/json",response=GoodsSourceResp.class)
	@RequestMapping(value="list", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, HttpServletResponse response){
		String lang = request.getHeader("lang");
		String userId =  (String) request.getAttribute("userId");
		List<GoodsSource> list = goodsSourceService.list(userId);
		List<GoodsSourceResp> result = new ArrayList<GoodsSourceResp>();
		for(GoodsSource goodsSource:list){
			GoodsSourceResp op =new GoodsSourceResp(goodsSource);
			op.setDepartureProvince(commonService.queryProvince(lang,goodsSource.getDepartureProvinceId()));
			op.setDepartureCity(commonService.queryCity(lang,goodsSource.getDepartureCityId()));
			op.setDepartureArea(commonService.queryArea(lang,goodsSource.getDepartureAreaId()));
			
			op.setDestinationProvince(commonService.queryProvince(lang,goodsSource.getDestinationProvinceId()));
			op.setDestinationCity(commonService.queryCity(lang,goodsSource.getDestinationCityId()));
			op.setDestinationArea(commonService.queryArea(lang,goodsSource.getDestinationAreaId()));
			
			op.setCarType(commonService.queryCarType(lang,goodsSource.getCarTypeId()));
			op.setHandlingType(commonService.queryHandlingType(lang,goodsSource.getHandlingTypeId()));
			op.setPaymentType(commonService.queryUseType(lang,goodsSource.getPaymentTypeId()));
			op.setUseType(commonService.queryUseType(lang,goodsSource.getUseTypeId()));
//			op.setGoodsUnits(goodsUnitsService.queryCommonParam(goodsSource.getGoodsUnits()));
			result.add(op);
		}
		return ResponseUtil.successResult(result);
	}
	@ApiOperation(value="add", notes="新增",produces = "application/json")
	@RequestMapping(value="add", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> add(HttpServletRequest request, HttpServletResponse response,
			@RequestBody GoodsSource goodsSource){
		String userId =  (String) request.getAttribute("userId");
		String id = UUIDUtil.UUID();
		goodsSource.setId(id);
		goodsSource.setUserId(userId);
		int result = goodsSourceService.save(goodsSource);
		if(result > 0){
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("id", id);
			return ResponseUtil.successResult(data);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="addByOrderId", notes="新增-通过orderId",produces = "application/json")
	@RequestMapping(value="addByOrderId", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addByOrderId(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="{orderId：orderId}") Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		String orderId = (String) requestMap.get("orderId");
		String id = goodsSourceService.addByOrderId(userId, orderId);
		if(id !=null){
			return ResponseUtil.successResultId(id);
		}
		return ResponseUtil.failureResult();
	}
	@ApiOperation(value="detail", notes="详情",produces = "application/json",response=GoodsSourceResp.class)
	@RequestMapping(value="detail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String lang = request.getHeader("lang");
		String id = (String) requestMap.get("id");
		GoodsSource goodsSource = goodsSourceService.query(id);
		
		GoodsSourceResp op =new GoodsSourceResp(goodsSource);
		op.setDepartureProvince(commonService.queryProvince(lang,goodsSource.getDepartureProvinceId()));
		op.setDepartureCity(commonService.queryCity(lang,goodsSource.getDepartureCityId()));
		op.setDepartureArea(commonService.queryArea(lang,goodsSource.getDepartureAreaId()));
		
		op.setDestinationProvince(commonService.queryProvince(lang,goodsSource.getDestinationProvinceId()));
		op.setDestinationCity(commonService.queryCity(lang,goodsSource.getDestinationCityId()));
		op.setDestinationArea(commonService.queryArea(lang,goodsSource.getDestinationAreaId()));
		
		op.setCarType(commonService.queryCarType(lang,goodsSource.getCarTypeId()));
		op.setHandlingType(commonService.queryHandlingType(lang,goodsSource.getHandlingTypeId()));
		op.setPaymentType(commonService.queryUseType(lang,goodsSource.getPaymentTypeId()));
		op.setUseType(commonService.queryUseType(lang,goodsSource.getUseTypeId()));
//		op.setGoodsUnits(goodsUnitsService.queryCommonParam(goodsSource.getGoodsUnits()));
		return ResponseUtil.successResult(op);
	}
	@ApiOperation(value="modify", notes="修改",produces = "application/json",response=GoodsSourceResp.class)
	@RequestMapping(value="modify", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modify(HttpServletRequest request, HttpServletResponse response,
			@RequestBody GoodsSource goodsSource){
		int result = goodsSourceService.update(goodsSource);
		if(result > 0){
			return ResponseUtil.successResultId(goodsSource.getId());
		}
		return ResponseUtil.failureResult();
	}
	
	@ApiOperation(value="delete", notes="删除",produces = "application/json")
	@RequestMapping(value="delete", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> delete(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		int result = goodsSourceService.delete(id);
		if(result > 0){
			return ResponseUtil.successResult();
		}
		return ResponseUtil.failureResult();
	}
}
