package com.iflytransporter.api.bean.carmanage;

public class CarSafetyEquipmentReq {
 
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