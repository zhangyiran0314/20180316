package com.iflytransporter.api.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class CommonParam {

	private String id;
	private String name;
	
	@JSONField(serialize=false)
	private String code;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
