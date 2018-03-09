package com.iflytransporter.api.bean.carmanage;

import java.util.Date;

public class CarEngineOilReq {

    private Integer engineOil;

    private Integer gearOil;

    private Integer brakeFluid;

    private String remark;

    public Integer getEngineOil() {
        return engineOil;
    }

    public void setEngineOil(Integer engineOil) {
        this.engineOil = engineOil;
    }

    public Integer getGearOil() {
        return gearOil;
    }

    public void setGearOil(Integer gearOil) {
        this.gearOil = gearOil;
    }

    public Integer getBrakeFluid() {
        return brakeFluid;
    }

    public void setBrakeFluid(Integer brakeFluid) {
        this.brakeFluid = brakeFluid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}