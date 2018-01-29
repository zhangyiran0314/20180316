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

    private Integer safetyGoogle;

    private Integer safetyGlove;

    private Integer sealtBeltInGoodConditions;

    private Integer lorryIsConpleteJackKabin;

    private Integer equipmentInFullToolbox;

    private Integer firstAidBox;

    private Integer safetyCone;

    private Integer fireExtinguisterTool;

    private Integer fireExtinguisterTool1;

    private Integer torchLight;

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

    public Integer getSafetyGoogle() {
        return safetyGoogle;
    }

    public void setSafetyGoogle(Integer safetyGoogle) {
        this.safetyGoogle = safetyGoogle;
    }

    public Integer getSafetyGlove() {
        return safetyGlove;
    }

    public void setSafetyGlove(Integer safetyGlove) {
        this.safetyGlove = safetyGlove;
    }

    public Integer getSealtBeltInGoodConditions() {
        return sealtBeltInGoodConditions;
    }

    public void setSealtBeltInGoodConditions(Integer sealtBeltInGoodConditions) {
        this.sealtBeltInGoodConditions = sealtBeltInGoodConditions;
    }

    public Integer getLorryIsConpleteJackKabin() {
        return lorryIsConpleteJackKabin;
    }

    public void setLorryIsConpleteJackKabin(Integer lorryIsConpleteJackKabin) {
        this.lorryIsConpleteJackKabin = lorryIsConpleteJackKabin;
    }

    public Integer getEquipmentInFullToolbox() {
        return equipmentInFullToolbox;
    }

    public void setEquipmentInFullToolbox(Integer equipmentInFullToolbox) {
        this.equipmentInFullToolbox = equipmentInFullToolbox;
    }

    public Integer getFirstAidBox() {
        return firstAidBox;
    }

    public void setFirstAidBox(Integer firstAidBox) {
        this.firstAidBox = firstAidBox;
    }

    public Integer getSafetyCone() {
        return safetyCone;
    }

    public void setSafetyCone(Integer safetyCone) {
        this.safetyCone = safetyCone;
    }

    public Integer getFireExtinguisterTool() {
        return fireExtinguisterTool;
    }

    public void setFireExtinguisterTool(Integer fireExtinguisterTool) {
        this.fireExtinguisterTool = fireExtinguisterTool;
    }

    public Integer getFireExtinguisterTool1() {
        return fireExtinguisterTool1;
    }

    public void setFireExtinguisterTool1(Integer fireExtinguisterTool1) {
        this.fireExtinguisterTool1 = fireExtinguisterTool1;
    }

    public Integer getTorchLight() {
        return torchLight;
    }

    public void setTorchLight(Integer torchLight) {
        this.torchLight = torchLight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}