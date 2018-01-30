package com.iflytransporter.common.bean;

import java.util.Date;

public class CarDailyInspection {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private String companyId;

    private String driverId;

    private String carId;

    private Date inspectionDate;

    private String engineOilId;

    private Integer engineOilCount;

    private String airCoolantId;

    private Integer airCoolantCount;

    private String tyreId;

    private Integer tyreCount;

    private String signalLightId;

    private Integer signalLightCount;

    private String safetyEquipmentId;

    private Integer safetyEquipmentCount;

    private String documentsId;

    private Integer documentsCount;

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

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getEngineOilId() {
        return engineOilId;
    }

    public void setEngineOilId(String engineOilId) {
        this.engineOilId = engineOilId == null ? null : engineOilId.trim();
    }

    public Integer getEngineOilCount() {
        return engineOilCount;
    }

    public void setEngineOilCount(Integer engineOilCount) {
        this.engineOilCount = engineOilCount;
    }

    public String getAirCoolantId() {
        return airCoolantId;
    }

    public void setAirCoolantId(String airCoolantId) {
        this.airCoolantId = airCoolantId == null ? null : airCoolantId.trim();
    }

    public Integer getAirCoolantCount() {
        return airCoolantCount;
    }

    public void setAirCoolantCount(Integer airCoolantCount) {
        this.airCoolantCount = airCoolantCount;
    }

    public String getTyreId() {
        return tyreId;
    }

    public void setTyreId(String tyreId) {
        this.tyreId = tyreId == null ? null : tyreId.trim();
    }

    public Integer getTyreCount() {
        return tyreCount;
    }

    public void setTyreCount(Integer tyreCount) {
        this.tyreCount = tyreCount;
    }

    public String getSignalLightId() {
        return signalLightId;
    }

    public void setSignalLightId(String signalLightId) {
        this.signalLightId = signalLightId == null ? null : signalLightId.trim();
    }

    public Integer getSignalLightCount() {
        return signalLightCount;
    }

    public void setSignalLightCount(Integer signalLightCount) {
        this.signalLightCount = signalLightCount;
    }

    public String getSafetyEquipmentId() {
        return safetyEquipmentId;
    }

    public void setSafetyEquipmentId(String safetyEquipmentId) {
        this.safetyEquipmentId = safetyEquipmentId == null ? null : safetyEquipmentId.trim();
    }

    public Integer getSafetyEquipmentCount() {
        return safetyEquipmentCount;
    }

    public void setSafetyEquipmentCount(Integer safetyEquipmentCount) {
        this.safetyEquipmentCount = safetyEquipmentCount;
    }

    public String getDocumentsId() {
        return documentsId;
    }

    public void setDocumentsId(String documentsId) {
        this.documentsId = documentsId == null ? null : documentsId.trim();
    }

    public Integer getDocumentsCount() {
        return documentsCount;
    }

    public void setDocumentsCount(Integer documentsCount) {
        this.documentsCount = documentsCount;
    }
}