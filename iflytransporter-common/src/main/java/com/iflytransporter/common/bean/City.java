package com.iflytransporter.common.bean;

import com.alibaba.fastjson.JSONObject;
import com.iflytransporter.common.base.BaseEntity;

public class City extends BaseEntity{

	private static final long serialVersionUID = 5904079104785401632L;

	private String name;

    private String provinceId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }
    @Override
  	public String toString() {
    	  return JSONObject.toJSONString(this).toString();
  	}
}