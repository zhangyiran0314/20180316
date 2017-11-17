package com.iflytransporter.common.bean;

import com.alibaba.fastjson.JSONObject;
import com.iflytransporter.common.base.BaseEntity;

public class GoodsSource extends BaseEntity{
	private static final long serialVersionUID = 1L;

    private String provinceId;

    private String cityId;

    private String areaId;

    private Integer defaultStatus;

    private String transporterId;

    private String shipperId;


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

    public String getTransporterId() {
        return transporterId;
    }

    public void setTransporterId(String transporterId) {
        this.transporterId = transporterId == null ? null : transporterId.trim();
    }

    public String getShipperId() {
        return shipperId;
    }

    public void setShipperId(String shipperId) {
        this.shipperId = shipperId == null ? null : shipperId.trim();
    }
    
    @Override
  	public String toString() {
    	  return JSONObject.toJSONString(this).toString();
  	}
}