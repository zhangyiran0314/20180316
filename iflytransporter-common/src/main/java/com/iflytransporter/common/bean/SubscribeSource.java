package com.iflytransporter.common.bean;

import java.util.Date;

public class SubscribeSource {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private Integer defaultStatus;

    private String userId;

    private String departureProvinceId;

    private String departureCityId;

    private String departureAreaId;

    private String destinationProvinceId;

    private String destinationCityId;

    private String destinationAreaId;

    private String carTypeId;

    private String tyreNo;

    private Integer carLength;

    private String useTypeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Short getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Short dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp == null ? null : desp.trim();
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
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDepartureProvinceId() {
        return departureProvinceId;
    }

    public void setDepartureProvinceId(String departureProvinceId) {
        this.departureProvinceId = departureProvinceId == null ? null : departureProvinceId.trim();
    }

    public String getDepartureCityId() {
        return departureCityId;
    }

    public void setDepartureCityId(String departureCityId) {
        this.departureCityId = departureCityId == null ? null : departureCityId.trim();
    }

    public String getDepartureAreaId() {
        return departureAreaId;
    }

    public void setDepartureAreaId(String departureAreaId) {
        this.departureAreaId = departureAreaId == null ? null : departureAreaId.trim();
    }

    public String getDestinationProvinceId() {
        return destinationProvinceId;
    }

    public void setDestinationProvinceId(String destinationProvinceId) {
        this.destinationProvinceId = destinationProvinceId == null ? null : destinationProvinceId.trim();
    }

    public String getDestinationCityId() {
        return destinationCityId;
    }

    public void setDestinationCityId(String destinationCityId) {
        this.destinationCityId = destinationCityId == null ? null : destinationCityId.trim();
    }

    public String getDestinationAreaId() {
        return destinationAreaId;
    }

    public void setDestinationAreaId(String destinationAreaId) {
        this.destinationAreaId = destinationAreaId == null ? null : destinationAreaId.trim();
    }

    public String getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(String carTypeId) {
        this.carTypeId = carTypeId == null ? null : carTypeId.trim();
    }

    public String getTyreNo() {
        return tyreNo;
    }

    public void setTyreNo(String tyreNo) {
        this.tyreNo = tyreNo == null ? null : tyreNo.trim();
    }

    public Integer getCarLength() {
        return carLength;
    }

    public void setCarLength(Integer carLength) {
        this.carLength = carLength;
    }

    public String getUseTypeId() {
        return useTypeId;
    }

    public void setUseTypeId(String useTypeId) {
        this.useTypeId = useTypeId == null ? null : useTypeId.trim();
    }
}