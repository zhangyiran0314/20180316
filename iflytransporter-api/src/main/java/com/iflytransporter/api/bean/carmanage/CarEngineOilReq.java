package com.iflytransporter.api.bean.carmanage;

public class CarEngineOilReq {
  
    private Integer engineOilEnough;

    private Integer oilClutchEnough;

    private Integer oilBreakEnough;

    private String remark;

    public Integer getEngineOilEnough() {
        return engineOilEnough;
    }

    public void setEngineOilEnough(Integer engineOilEnough) {
        this.engineOilEnough = engineOilEnough;
    }

    public Integer getOilClutchEnough() {
        return oilClutchEnough;
    }

    public void setOilClutchEnough(Integer oilClutchEnough) {
        this.oilClutchEnough = oilClutchEnough;
    }

    public Integer getOilBreakEnough() {
        return oilBreakEnough;
    }

    public void setOilBreakEnough(Integer oilBreakEnough) {
        this.oilBreakEnough = oilBreakEnough;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}