package com.iflytransporter.api.bean.carmanage;

public class CarTyreReq {

    private Integer allTyrePressureEnough;

    private Integer tyreFlowerNotBootRosak;

    private Integer nutHubTyreNoEffects;

    private Integer strengthenTyreSpareEnough;

    private String remark;

    public Integer getAllTyrePressureEnough() {
        return allTyrePressureEnough;
    }

    public void setAllTyrePressureEnough(Integer allTyrePressureEnough) {
        this.allTyrePressureEnough = allTyrePressureEnough;
    }

    public Integer getTyreFlowerNotBootRosak() {
        return tyreFlowerNotBootRosak;
    }

    public void setTyreFlowerNotBootRosak(Integer tyreFlowerNotBootRosak) {
        this.tyreFlowerNotBootRosak = tyreFlowerNotBootRosak;
    }

    public Integer getNutHubTyreNoEffects() {
        return nutHubTyreNoEffects;
    }

    public void setNutHubTyreNoEffects(Integer nutHubTyreNoEffects) {
        this.nutHubTyreNoEffects = nutHubTyreNoEffects;
    }

    public Integer getStrengthenTyreSpareEnough() {
        return strengthenTyreSpareEnough;
    }

    public void setStrengthenTyreSpareEnough(Integer strengthenTyreSpareEnough) {
        this.strengthenTyreSpareEnough = strengthenTyreSpareEnough;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}