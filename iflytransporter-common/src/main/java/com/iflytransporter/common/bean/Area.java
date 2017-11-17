package com.iflytransporter.common.bean;

import com.alibaba.fastjson.JSONObject;
import com.iflytransporter.common.base.BaseEntity;

public class Area extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	private String name;

    private String cityId;
    
    private String provinceId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	@Override
  	public String toString() {
    	  return JSONObject.toJSONString(this).toString();
  	}
}