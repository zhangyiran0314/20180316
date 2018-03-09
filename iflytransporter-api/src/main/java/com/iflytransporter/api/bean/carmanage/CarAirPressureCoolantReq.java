package com.iflytransporter.api.bean.carmanage;


public class CarAirPressureCoolantReq {

    private Integer airPressure;

    private Integer coolant;

    private Integer airTankReleaseMoisture;

    private String remark;

    public Integer getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(Integer airPressure) {
        this.airPressure = airPressure;
    }

    public Integer getCoolant() {
        return coolant;
    }

    public void setCoolant(Integer coolant) {
        this.coolant = coolant;
    }

    public Integer getAirTankReleaseMoisture() {
        return airTankReleaseMoisture;
    }

    public void setAirTankReleaseMoisture(Integer airTankReleaseMoisture) {
        this.airTankReleaseMoisture = airTankReleaseMoisture;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}