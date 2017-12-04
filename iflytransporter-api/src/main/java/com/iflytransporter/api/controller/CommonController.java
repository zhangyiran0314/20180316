package com.iflytransporter.api.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.iflytransporter.api.conf.ConstantsConfig;
import com.iflytransporter.api.service.AreaService;
import com.iflytransporter.api.service.AttachmentService;
import com.iflytransporter.api.service.CarTypeService;
import com.iflytransporter.api.service.CityService;
import com.iflytransporter.api.service.GoodsUnitsService;
import com.iflytransporter.api.service.InsuranceService;
import com.iflytransporter.api.service.ProvinceService;
import com.iflytransporter.common.bean.Area;
import com.iflytransporter.common.bean.Attachment;
import com.iflytransporter.common.bean.CarType;
import com.iflytransporter.common.bean.City;
import com.iflytransporter.common.bean.GoodsUnits;
import com.iflytransporter.common.bean.Insurance;
import com.iflytransporter.common.bean.Province;
import com.iflytransporter.common.utils.ResponseUtil;
import com.iflytransporter.common.utils.UUIDUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Api(value = "common api",description="公用 Controller,所有基础数据接口")
@Controller
@RequestMapping("/common/{version}")
public class CommonController {
	
	@Autowired
	private ConstantsConfig constantsConfig;
	@Autowired
	private AttachmentService attachmentSerivce;
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private CityService cityService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private CarTypeService carTypeService;
	@Autowired
	private InsuranceService insuranceService;
	@Autowired
	private GoodsUnitsService goodsUnitsService;
	
	@ApiOperation(value="货物计量单位列表")
	@RequestMapping(value = "/getGoodsUnits", method = RequestMethod.GET)
	@ResponseBody 
	public Map<String,Object> getGoodsUnits() {
		List<GoodsUnits> list = goodsUnitsService.queryAll();
		return ResponseUtil.successResult(list);
	}
	@ApiOperation(value="保险列表")
	@RequestMapping(value = "/getInsurance", method = RequestMethod.GET)
	@ResponseBody 
	public Map<String,Object> getInsurance() {
		List<Insurance> list = insuranceService.queryAll();
		return ResponseUtil.successResult(list);
	}
	
	@ApiOperation(value="车辆类型列表")
	@RequestMapping(value = "/getCarType", method = RequestMethod.GET)
	@ResponseBody 
	public Map<String,Object> getCarType() {
		List<CarType> list = carTypeService.queryAll();
		return ResponseUtil.successResult(list);
	}
	
	@ApiOperation(value="省份列表")
	@RequestMapping(value = "/getProvince", method = RequestMethod.GET)
	@ResponseBody 
	public Map<String,Object> getProvince() {
		List<Province> list = provinceService.queryAll();
		return ResponseUtil.successResult(list);
	}
	
	@ApiOperation(value="城市列表")
	@RequestMapping(value = "/getCity", method = RequestMethod.POST)
	@ResponseBody 
	public Map<String,Object> getCity(@RequestBody @ApiParam(value="provinceId") Map<String,Object> requestMap) {
		String provinceId = (String) requestMap.get("provinceId");
		List<City> list = cityService.queryAll(provinceId);
		return ResponseUtil.successResult(list);
	}
	@ApiOperation(value="地区列表")
	@RequestMapping(value = "/getArea", method = RequestMethod.POST)
	@ResponseBody 
	public Map<String,Object> getArea(@RequestBody  @ApiParam(value="cityId")Map<String,Object> requestMap) {
		String cityId = (String) requestMap.get("cityId");
		List<Area> list = areaService.queryAll(cityId);
		return ResponseUtil.successResult(list);
	}
	/**
	 * 文件上传
	 * @param file
	 * @param request
	 * @param response
	 */
	@ApiOperation(value="文件上传")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody 
	public Map<String,Object> fileUpload(@RequestParam("uploadFile")MultipartFile file, MultipartHttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		if (file.isEmpty()) {
			msg = "File is Empty!";
			return ResponseUtil.failureResult(msg);
		}
		String fileName = file.getOriginalFilename();
		if(StringUtils.isBlank(fileName)){
			return ResponseUtil.failureResult(msg);
		}
		String suffix = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
		/**定义存放目录,目录分为两部分
		 * 1.配置文件目录
		 * 2.日期目录yyyy/MM/dd
		 * 文件名为对应此目录下uuid
		 * */
		String fileUploadPath = constantsConfig.getFilePath();//配置文件目录
		if (!new File(fileUploadPath).exists()) {
			new File(fileUploadPath).mkdirs();
		}
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); //日期存放目录
		String dateFilePath =  sdf.format(currentDate);
		String destDir = fileUploadPath+"/"+dateFilePath;
		if (!new File(destDir).exists()) {
			new File(destDir).mkdirs();
		}
		String fileId = UUIDUtil.UUID();
		String desFilePath = "/"+dateFilePath+"/"+fileId+"."+suffix;
		String finalFilePath = fileUploadPath + "/"+dateFilePath+"/"+fileId+"."+suffix;
		try {
			file.transferTo(new File(finalFilePath));
			//保存文件记录
			Attachment attachment = new Attachment();
			attachment.setId(fileId);
			attachment.setCreateDate(currentDate);
			attachment.setUpdateDate(currentDate);
			attachment.setAttachementLink(desFilePath);
			attachment.setAttachementName(fileName);
			int result  = attachmentSerivce.saveAttachment(attachment);
			if(result > 0){
				Map<String,Object> data = new HashMap<String,Object>();
				data.put("attachmentId", fileId);
				data.put("linkPath", ConstantsConfig.getLinkPath()+desFilePath);
				return  ResponseUtil.successResult(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return  ResponseUtil.failureResult();
		}
		return  ResponseUtil.failureResult();
	}
	/** 获取文件 */
	@ApiOperation(value="根据附件id获取附件信息")
	@RequestMapping(value = "/getAttachmentById", method =RequestMethod.POST)
	@ResponseBody 
	public Map<String,Object> getAttachmentById(HttpServletRequest request,HttpServletResponse response,
			@RequestBody @ApiParam(value="attachmentId")Map<String,Object> requestMap) {
		String attachmentId = (String) requestMap.get("attachmentId");
		if(StringUtils.isBlank(attachmentId)){
			return  ResponseUtil.failureResult();
		}
		Attachment attachment = attachmentSerivce.queryAttachment(attachmentId);
		return  ResponseUtil.successResult(attachment);
	}
	
}
