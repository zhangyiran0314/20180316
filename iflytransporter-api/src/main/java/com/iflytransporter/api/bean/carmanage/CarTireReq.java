package com.iflytransporter.api.bean.carmanage;

import java.util.Date;

public class CarTireReq {

    private Integer allTirePressureEnough;

    private Integer tireThreadCondition;

    private Integer nutWheelHubNoDefect;

    private Integer spareTireLockStrengthen;

    private String remark;

    public Integer getAllTirePressureEnough() {
        return allTirePressureEnough;
    }

    public void setAllTirePressureEnough(Integer allTirePressureEnough) {
        this.allTirePressureEnough = allTirePressureEnough;
    }

    public Integer getTireThreadCondition() {
        return tireThreadCondition;
    }

    public void setTireThreadCondition(Integer tireThreadCondition) {
        this.tireThreadCondition = tireThreadCondition;
    }

    public Integer getNutWheelHubNoDefect() {
        return nutWheelHubNoDefect;
    }

    public void setNutWheelHubNoDefect(Integer nutWheelHubNoDefect) {
        this.nutWheelHubNoDefect = nutWheelHubNoDefect;
    }

    public Integer getSpareTireLockStrengthen() {
        return spareTireLockStrengthen;
    }

    public void setSpareTireLockStrengthen(Integer spareTireLockStrengthen) {
        this.spareTireLockStrengthen = spareTireLockStrengthen;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}