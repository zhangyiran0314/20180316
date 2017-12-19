package com.iflytransporter.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Api(value = "shipper/waybill/",description="货主-运单操作 Controller")
@Controller
@RequestMapping("/shipper/waybill/{version}")
public class ShipperWaybillController {

}
