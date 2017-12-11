package com.iflytransporter.common.bean;

import com.alibaba.fastjson.JSONObject;
import com.iflytransporter.common.base.BaseEntity;

public class GoodsSource extends BaseEntity{
	private static final long serialVersionUID = 1L;

    private String departureProvinceId;

    private String departureCityId;

    private String departureAreaId;

    private String destinationProvinceId;

    private String destinationCityId;

    private String destinationAreaId;

    private Integer defaultStatus;

    private String userId;

	public String getDepartureProvinceId() {
		return departureProvinceId;
	}



	public void setDepartureProvinceId(String departureProvinceId) {
		this.departureProvinceId = departureProvinceId;
	}



	public String getDepartureCityId() {
		return departureCityId;
	}



	public void setDepartureCityId(String departureCityId) {
		this.departureCityId = departureCityId;
	}



	public String getDepartureAreaId() {
		return departureAreaId;
	}



	public void setDepartureAreaId(String departureAreaId) {
		this.departureAreaId = departureAreaId;
	}



	public String getDestinationProvinceId() {
		return destinationProvinceId;
	}



	public void setDestinationProvinceId(String destinationProvinceId) {
		this.destinationProvinceId = destinationProvinceId;
	}



	public String getDestinationCityId() {
		return destinationCityId;
	}



	public void setDestinationCityId(String destinationCityId) {
		this.destinationCityId = destinationCityId;
	}



	public String getDestinationAreaId() {
		return destinationAreaId;
	}



	public void setDestinationAreaId(String destinationAreaId) {
		this.destinationAreaId = destinationAreaId;
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