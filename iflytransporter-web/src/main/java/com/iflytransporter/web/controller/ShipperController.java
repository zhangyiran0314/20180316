package com.iflytransporter.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.iflytransporter.web.service.UserShipperService;
import com.iflytransporter.web.sys.bean.UUser;

@Controller
@RequestMapping("/shipper")
public class ShipperController {
	@Autowired
	private UserShipperService userShipperService;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/")
	public String index(){
		System.out.println("shipper/list");
		return "shipper/list";
	}
}
