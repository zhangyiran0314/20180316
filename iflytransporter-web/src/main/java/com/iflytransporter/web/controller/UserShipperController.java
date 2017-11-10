package com.iflytransporter.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iflytransporter.web.service.UserShipperService;

@Controller
@RequestMapping("/userShipper")
public class UserShipperController {

	@Autowired
	private UserShipperService userShipperService;
	
	@RequestMapping("/")
	public String user(){
		return "userShipper/list";
	}
}
