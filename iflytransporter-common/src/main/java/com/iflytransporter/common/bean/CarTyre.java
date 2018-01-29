package com.iflytransporter.common.bean;

import java.util.Date;

public class CarTyre {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private String companyId;

    private String driverId;

    private String carId;

    private Integer allTyrePressureEnough;

    private Integer tyreFlowerNotBootRosak;

    private Integer nutHubTyreNoEffects;

    private Integer strengthenTyreSpareEnough;

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