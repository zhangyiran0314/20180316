package com.iflytransporter.api.controller;

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
import com.iflytransporter.api.bean.OrderParam;
import com.iflytransporter.api.service.GoodsSourceService;
import com.iflytransporter.api.service.OrderService;
import com.iflytransporter.api.utils.RequestMapUtil;
import com.iflytransporter.api.utils.ResponseUtil;
import com.iflytransporter.common.bean.GoodsSource;
import com.iflytransporter.common.bean.Order;
import com.iflytransporter.common.bean.OrderBO;
import com.iflytransporter.common.utils.UUIDUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "order api",description="发货(订单)操作 Controller")
@Controller
@RequestMapping("/shipper/order/{version}")
public class ShipperOrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private GoodsSourceService goodsSourceService;
	
	@ApiOperation(value="queryPage", notes="分页列表-已关闭",produces = "application/json")
	@RequestMapping(value="queryPage", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryPage(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("status:发货状态,0-发布中(默认),1-已关闭;pageNo:分页参数-当前页数,默认(1);pageSize:分页参数-分页数,默认(10)") Map<String,Object> requestMap){
		Integer pageNo = RequestMapUtil.formatPageNo(requestMap);
		Integer pageSize = RequestMapUtil.formatPageSize(requestMap);
		Integer status = RequestMapUtil.formatStatus(requestMap);
		String userId =  (String) request.getAttribute("userId");
		PageInfo<Order> page = orderService.queryPage(pageNo,pageSize, userId,status);
		return ResponseUtil.successResult(page);
	}
	@ApiOperation(value="list", notes="列表",produces = "application/json")
	@RequestMapping(value="list", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam("status:发货状态,0-发布中(默认),1-已关闭") Map<String,Object> requestMap){
		Integer status = RequestMapUtil.formatStatus(requestMap);
		String userId =  (String) request.getAttribute("userId");
		List<Order> list = orderService.list(userId,status);
		return ResponseUtil.successResult(list);
	}
	
	/*@ApiOperation(value="add", notes="新增",produces = "application/json")
	@RequestMapping(value="add", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> add(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Order order){
		String id = UUIDUtil.UUID();
		order.setId(id);
		int result = orderService.save(order);
		if(result > 0){
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("id", id);
			return ResponseUtil.successResult(data);
		}
		return ResponseUtil.failureResult();
	}*/
	@ApiOperation(value="add", notes="新增",produces = "application/json")
	@RequestMapping(value="add", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> add(HttpServletRequest request, HttpServletResponse response,
			@RequestBody OrderParam order){
		String userId =  (String) request.getAttribute("userId");
		String id = UUIDUtil.UUID();
		order.setId(id);
		int result = orderService.save(order);
		if(result > 0){
			if(order.isAddGoodsSource()){
				GoodsSource gs = new GoodsSource();
				gs.setDepartureProvinceId(order.getDepartureProvinceId());
				gs.setDepartureCityId(order.getDepartureCityId());
				gs.setDepartureAreaId(order.getDepartureAreaId());
				gs.setDestinationProvinceId(order.getDestinationProvinceId());
				gs.setDestinationCityId(order.getDestinationCityId());
				gs.setDestinationAreaId(order.getDestinationAreaId());
				gs.setUserId(userId);
				goodsSourceService.save(gs);
			}
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
		Order order = orderService.query(id);
		return ResponseUtil.successResult(order);
	}
	@ApiOperation(value="detailBO", notes="详情-审核关联",produces = "application/json")
	@RequestMapping(value="detailBO", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> detailBO(HttpServletRequest request, HttpServletResponse response,
			@RequestBody @ApiParam(value="id") Map<String,Object> requestMap){
		String id = (String) requestMap.get("id");
		OrderBO order = orderService.queryBO(id);
		return ResponseUtil.successResult(order);
	}
	@ApiOperation(value="modify", notes="修改",produces = "application/json")
	@RequestMapping(value="modify", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modify(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Order order){
		int result = orderService.update(order);
		if(result > 0){
			Order data = orderService.query(order.getId());
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
		int result = orderService.delete(id);
		if(result > 0){
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("id", id);
			return ResponseUtil.successResult(data);
		}
		return ResponseUtil.failureResult();
	}
	
}
