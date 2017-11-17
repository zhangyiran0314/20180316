package com.iflytransporter.common.bean;

import com.alibaba.fastjson.JSONObject;

public class CityBO extends City{
	
	private static final long serialVersionUID = 1L;

    private String provinceIdName;

    public String getProvinceIdName() {
        return provinceIdName;
    }

    public void setProvinceIdName(String provinceIdName) {
        this.provinceIdName = provinceIdName == null ? null : provinceIdName.trim();
    }
    @Override
  	public String toString() {
    	  return JSONObject.toJSONString(this).toString();
  	}
}