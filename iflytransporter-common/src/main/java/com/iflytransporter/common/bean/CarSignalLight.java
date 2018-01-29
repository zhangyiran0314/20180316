package com.iflytransporter.common.bean;

import java.util.Date;

public class CarSignalLight {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private String companyId;

    private String driverId;

    private String carId;

    private Integer signalLightLamp;

    private Integer greatLight;

    private Integer sideMirror;

    private String temperatureInGoodCondition;

    private Integer doubleSignal;

    private Integer goodPlateNumber;

    private Integer takometerWorking;

    private Integer odometerWorking;

    private Integer levelMeterWorking;

    private Integer windsTankRemoveWaterOilMud;

    private Integer beaconLampFunction;

    private Integer honFunction;

    private Integer wiperInAGoodCondition;

    private Integer breakHand;

    private Integer stereng;

    private Integer colderHeater;

    private Integer lightSticker;

    private Integer stickerLimited;

    private String remark;

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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public Integer getSignalLightLamp() {
        return signalLightLamp;
    }

    public void setSignalLightLamp(Integer signalLightLamp) {
        this.signalLightLamp = signalLightLamp;
    }

    public Integer getGreatLight() {
        return greatLight;
    }

    public void setGreatLight(Integer greatLight) {
        this.greatLight = greatLight;
    }

    public Integer getSideMirror() {
        return sideMirror;
    }

    public void setSideMirror(Integer sideMirror) {
        this.sideMirror = sideMirror;
    }

    public String getTemperatureInGoodCondition() {
        return temperatureInGoodCondition;
    }

    public void setTemperatureInGoodCondition(String temperatureInGoodCondition) {
        this.temperatureInGoodCondition = temperatureInGoodCondition == null ? null : temperatureInGoodCondition.trim();
    }

    public Integer getDoubleSignal() {
        return doubleSignal;
    }

    public void setDoubleSignal(Integer doubleSignal) {
        this.doubleSignal = doubleSignal;
    }

    public Integer getGoodPlateNumber() {
        return goodPlateNumber;
    }

    public void setGoodPlateNumber(Integer goodPlateNumber) {
        this.goodPlateNumber = goodPlateNumber;
    }

    public Integer getTakometerWorking() {
        return takometerWorking;
    }

    public void setTakometerWorking(Integer takometerWorking) {
        this.takometerWorking = takometerWorking;
    }

    public Integer getOdometerWorking() {
        return odometerWorking;
    }

    public void setOdometerWorking(Integer odometerWorking) {
        this.odometerWorking = odometerWorking;
    }

    public Integer getLevelMeterWorking() {
        return levelMeterWorking;
    }

    public void setLevelMeterWorking(Integer levelMeterWorking) {
        this.levelMeterWorking = levelMeterWorking;
    }

    public Integer getWindsTankRemoveWaterOilMud() {
        return windsTankRemoveWaterOilMud;
    }

    public void setWindsTankRemoveWaterOilMud(Integer windsTankRemoveWaterOilMud) {
        this.windsTankRemoveWaterOilMud = windsTankRemoveWaterOilMud;
    }

    public Integer getBeaconLampFunction() {
        return beaconLampFunction;
    }

    public void setBeaconLampFunction(Integer beaconLampFunction) {
        this.beaconLampFunction = beaconLampFunction;
    }

    public Integer getHonFunction() {
        return honFunction;
    }

    public void setHonFunction(Integer honFunction) {
        this.honFunction = honFunction;
    }

    public Integer getWiperInAGoodCondition() {
        return wiperInAGoodCondition;
    }

    public void setWiperInAGoodCondition(Integer wiperInAGoodCondition) {
        this.wiperInAGoodCondition = wiperInAGoodCondition;
    }

    public Integer getBreakHand() {
        return breakHand;
    }

    public void setBreakHand(Integer breakHand) {
        this.breakHand = breakHand;
    }

    public Integer getStereng() {
        return stereng;
    }

    public void setStereng(Integer stereng) {
        this.stereng = stereng;
    }

    public Integer getColderHeater() {
        return colderHeater;
    }

    public void setColderHeater(Integer colderHeater) {
        this.colderHeater = colderHeater;
    }

    public Integer getLightSticker() {
        return lightSticker;
    }

    public void setLightSticker(Integer lightSticker) {
        this.lightSticker = lightSticker;
    }

    public Integer getStickerLimited() {
        return stickerLimited;
    }

    public void setStickerLimited(Integer stickerLimited) {
        this.stickerLimited = stickerLimited;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}