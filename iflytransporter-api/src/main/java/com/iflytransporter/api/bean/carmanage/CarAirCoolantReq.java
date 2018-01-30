package com.iflytransporter.api.bean.carmanage;

public class CarAirCoolantReq {

    private Integer airCoolantEnough;

    private String remark;

    public Integer getAirCoolantEnough() {
        return airCoolantEnough;
    }

    public void setAirCoolantEnough(Integer airCoolantEnough) {
        this.airCoolantEnough = airCoolantEnough;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}