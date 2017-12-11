package com.iflytransporter.common.bean;

import com.alibaba.fastjson.JSONObject;
import com.iflytransporter.common.base.BaseEntity;

public class PaymentType extends BaseEntity{
	private static final long serialVersionUID = 1L;

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
    @Override
  	public String toString() {
    	  return JSONObject.toJSONString(this).toString();
  	}
}