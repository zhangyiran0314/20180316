package com.iflytransporter.common.bean;

import com.alibaba.fastjson.JSONObject;

public class AreaBO extends Area {

	private static final long serialVersionUID = 1L;

	private String cityIdName;
	
	private String provinceIdName;
	
	public String getCityIdName() {
		return cityIdName;
	}

	public void setCityIdName(String cityIdName) {
		this.cityIdName = cityIdName;
	}


	public String getProvinceIdName() {
		return provinceIdName;
	}


	public void setProvinceIdName(String provinceIdName) {
		this.provinceIdName = provinceIdName;
	}


	@Override
  	public String toString() {
    	  return JSONObject.toJSONString(this).toString();
  	}
}
