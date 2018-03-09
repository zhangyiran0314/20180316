package com.iflytransporter.common.bean;

import java.util.Date;

public class CarTire {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private String companyId;

    private String driverId;

    private String carId;

    private Integer allTirePressureEnough;

    private Integer tireThreadCondition;

    private Integer nutWheelHubNoDefect;

    private Integer spareTireLockStrengthen;

    private String remark;
    /**统计当前对象是否故障*/
    public int getCount(){
    	return allTirePressureEnough+tireThreadCondition+nutWheelHubNoDefect+spareTireLockStrengthen;
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