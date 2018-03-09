package com.iflytransporter.common.bean;

import java.util.Date;

public class CarSafetyEquipment {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private String companyId;

    private String driverId;

    private String carId;

    private Integer safetyHelmet;

    private Integer safetyShoes;

    private Integer safetyGoggle;

    private Integer safetyGlove;

    private Integer seatBeltCondition;

    private Integer cabinJack;

    private Integer firstAidKit;

    private Integer safetyCone;

    private Integer fireExtinguisher;

    private Integer torchLight;

    private Integer lightReflectSticker;

    private Integer speedLimitSticker;

    private Integer numberPlate;

    private String remark;

    /**统计当前对象是否故障*/
    public int getCount(){
    	return safetyHelmet+safetyShoes+safetyGlove+seatBeltCondition+cabinJack
    			+firstAidKit+safetyCone+fireExtinguisher+torchLight+lightReflectSticker+speedLimitSticker+numberPlate+safetyGoggle;
    }
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

    public Integer getSafetyHelmet() {
        return safetyHelmet;
    }

    public void setSafetyHelmet(Integer safetyHelmet) {
        this.safetyHelmet = safetyHelmet;
    }

    public Integer getSafetyShoes() {
        return safetyShoes;
    }

    public void setSafetyShoes(Integer safetyShoes) {
        this.safetyShoes = safetyShoes;
    }

    public Integer getSafetyGoggle() {
        return safetyGoggle;
    }

    public void setSafetyGoggle(Integer safetyGoggle) {
        this.safetyGoggle = safetyGoggle;
    }

    public Integer getSafetyGlove() {
        return safetyGlove;
    }

    public void setSafetyGlove(Integer safetyGlove) {
        this.safetyGlove = safetyGlove;
    }

    public Integer getSeatBeltCondition() {
        return seatBeltCondition;
    }

    public void setSeatBeltCondition(Integer seatBeltCondition) {
        this.seatBeltCondition = seatBeltCondition;
    }

    public Integer getCabinJack() {
        return cabinJack;
    }

    public void setCabinJack(Integer cabinJack) {
        this.cabinJack = cabinJack;
    }

    public Integer getFirstAidKit() {
        return firstAidKit;
    }

    public void setFirstAidKit(Integer firstAidKit) {
        this.firstAidKit = firstAidKit;
    }

    public Integer getSafetyCone() {
        return safetyCone;
    }

    public void setSafetyCone(Integer safetyCone) {
        this.safetyCone = safetyCone;
    }

    public Integer getFireExtinguisher() {
        return fireExtinguisher;
    }

    public void setFireExtinguisher(Integer fireExtinguisher) {
        this.fireExtinguisher = fireExtinguisher;
    }

    public Integer getTorchLight() {
        return torchLight;
    }

    public void setTorchLight(Integer torchLight) {
        this.torchLight = torchLight;
    }

    public Integer getLightReflectSticker() {
        return lightReflectSticker;
    }

    public void setLightReflectSticker(Integer lightReflectSticker) {
        this.lightReflectSticker = lightReflectSticker;
    }

    public Integer getSpeedLimitSticker() {
        return speedLimitSticker;
    }

    public void setSpeedLimitSticker(Integer speedLimitSticker) {
        this.speedLimitSticker = speedLimitSticker;
    }

    public Integer getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(Integer numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}