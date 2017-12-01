package com.iflytransporter.common.bean;

import com.alibaba.fastjson.JSONObject;
import com.iflytransporter.common.base.BaseEntity;

public class GoodsSource extends BaseEntity{
	private static final long serialVersionUID = 1L;

    private String provinceId;

    private String cityId;

    private String areaId;

    private Integer defaultStatus;

    private String userId;


    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
  	public String toString() {
    	  return JSONObject.toJSONString(this).toString();
  	}
}