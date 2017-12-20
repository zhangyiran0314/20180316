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
import com.iflytransporter.api.service.GoodsSourceService;
import com.iflytransporter.api.service.GoodsUnitsService;
import com.iflytransporter.api.service.HandlingTypeService;
import com.iflytransporter.api.service.PaymentTypeService;
import com.iflytransporter.api.service.ProvinceService;
import com.iflytransporter.api.service.UseTypeService;
import com.iflytransporter.api.utils.RequestMapUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.bean.GoodsSource;
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
	private ProvinceService provinceService;
	@Autowired
	private CityService cityService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private CarTypeService carTypeService;
	@Autowired
	private HandlingTypeService handlingTypeService;
	@Autowired
	private PaymentTypeService paymentTypeService;
	@Autowired
	private UseTypeService useTypeService;
	@Autowired
	private GoodsUnitsService goodsUnitsService;
	
	@ApiOperation(value="queryPage", notes="分页列表",produces = "application/json")
	@RequestMapping(value="queryPage", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPage(HttpServletRequest request, HttpServletResponse response,
			@RequestBody   @ApiParam(value="{pageNo:1,pageSize:10}pageNo:当前页数-默认(1);pageSize:分页数-默认(10)")  Map<String,Object> requestMap){
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
			op.setDepartureProvince(provinceService.queryCommonParam(goodsSource.getDepartureProvinceId()));
			op.setDepartureCity(cityService.queryCommonParam(goodsSource.getDepartureCityId()));
			op.setDepartureArea(areaService.queryCommonParam(goodsSource.getDepartureAreaId()));
			
			op.setDestinationProvince(provinceService.queryCommonParam(goodsSource.getDestinationProvinceId()));
			op.setDestinationCity(cityService.queryCommonParam(goodsSource.getDestinationCityId()));
			op.setDestinationArea(areaService.queryCommonParam(goodsSource.getDestinationAreaId()));
			
			op.setCarType(carTypeService.queryCommonParam(goodsSource.getCarTypeId()));
			op.setHandlingType(handlingTypeService.queryCommonParam(goodsSource.getHandlingTypeId()));
			op.setPaymentType(paymentTypeService.queryCommonParam(goodsSource.getPaymentTypeId()));
			op.setUseType(useTypeService.queryCommonParam(goodsSource.getUseTypeId()));
			op.setGoodsUnits(goodsUnitsService.queryCommonParam(goodsSource.getGoodsUnits()));
			result.add(op);
		}
		return ResponseUtil.successPage(page.getTotal(), page.getPages(), result);
	}
	@ApiOperation(value="list", notes="列表",produces = "application/json")
	@RequestMapping(value="list", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, HttpServletResponse response,
			@RequestBody  Map<String,Object> requestMap){
		String userId =  (String) request.getAttribute("userId");
		List<GoodsSource> list = goodsSourceService.list(userId);
		List<GoodsSourceResp> result = new ArrayList<GoodsSourceResp>();
		for(GoodsSource goodsSource:list){
			GoodsSourceResp op =new GoodsSourceResp(goodsSource);
			op.setDepartureProvince(provinceService.queryCommonParam(goodsSource.getDepartureProvinceId()));
			op.setDepartureCity(cityService.queryCommonParam(goodsSource.getDepartureCityId()));
			op.setDepartureArea(areaService.queryCommonParam(goodsSource.getDepartureAreaId()));
			
			op.setDestinationProvince(provinceService.queryCommonParam(goodsSource.getDestinationProvinceId()));
			op.setDestinationCity(cityService.queryCommonParam(goodsSource.getDestinationCityId()));
			op.setDestinationArea(areaService.queryCommonParam(goodsSource.getDestinationAreaId()));
			
			op.setCarType(carTypeService.queryCommonParam(goodsSource.getCarTypeId()));
			op.setHandlingType(handlingTypeService.queryCommonParam(goodsSource.getHandlingTypeId()));
			op.setPaymentType(paymentTypeService.queryCommonParam(goodsSource.getPaymentTypeId()));
			op.setUseType(useTypeService.queryCommonParam(goodsSource.getUseTypeId()));
			op.setGoodsUnits(goodsUnitsService.queryCommonParam(goodsSource.getGoodsUnits()));
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
	
	@ApiOperation(value="detail", notes="详情",produces = "application/json")
	@RequestMapping(value="detail", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detail(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		GoodsSource goodsSource = goodsSourceService.query(id);
		
		GoodsSourceResp op =new GoodsSourceResp(goodsSource);
		op.setDepartureProvince(provinceService.queryCommonParam(goodsSource.getDepartureProvinceId()));
		op.setDepartureCity(cityService.queryCommonParam(goodsSource.getDepartureCityId()));
		op.setDepartureArea(areaService.queryCommonParam(goodsSource.getDepartureAreaId()));
		
		op.setDestinationProvince(provinceService.queryCommonParam(goodsSource.getDestinationProvinceId()));
		op.setDestinationCity(cityService.queryCommonParam(goodsSource.getDestinationCityId()));
		op.setDestinationArea(areaService.queryCommonParam(goodsSource.getDestinationAreaId()));
		
		op.setCarType(carTypeService.queryCommonParam(goodsSource.getCarTypeId()));
		op.setHandlingType(handlingTypeService.queryCommonParam(goodsSource.getHandlingTypeId()));
		op.setPaymentType(paymentTypeService.queryCommonParam(goodsSource.getPaymentTypeId()));
		op.setUseType(useTypeService.queryCommonParam(goodsSource.getUseTypeId()));
		op.setGoodsUnits(goodsUnitsService.queryCommonParam(goodsSource.getGoodsUnits()));
		return ResponseUtil.successResult(op);
	}
	@ApiOperation(value="modify", notes="修改",produces = "application/json")
	@RequestMapping(value="modify", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modify(HttpServletRequest request, HttpServletResponse response,
			@RequestBody GoodsSource goodsSource){
		int result = goodsSourceService.update(goodsSource);
		if(result > 0){
			GoodsSource data = goodsSourceService.query(goodsSource.getId());
			return ResponseUtil.successResult(data);
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
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("id", id);
			return ResponseUtil.successResult(data);
		}
		return ResponseUtil.failureResult();
	}
}
