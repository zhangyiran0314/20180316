package com.iflytransporter.common.bean;

import java.util.Date;

public class CarDocuments {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private String companyId;

    private String driverId;

    private String carId;

    private Integer roadTaxPrimeMoverTrailer;

    private Integer puspakomPrimeMoverTrailer;

    private Integer premitSpad;

    private Integer lesenPengendalianSpad;

    private Integer lesenPrekhidmatanSpad;

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

    public Integer getRoadTaxPrimeMoverTrailer() {
        return roadTaxPrimeMoverTrailer;
    }

    public void setRoadTaxPrimeMoverTrailer(Integer roadTaxPrimeMoverTrailer) {
        this.roadTaxPrimeMoverTrailer = roadTaxPrimeMoverTrailer;
    }

    public Integer getPuspakomPrimeMoverTrailer() {
        return puspakomPrimeMoverTrailer;
    }

    public void setPuspakomPrimeMoverTrailer(Integer puspakomPrimeMoverTrailer) {
        this.puspakomPrimeMoverTrailer = puspakomPrimeMoverTrailer;
    }

    public Integer getPremitSpad() {
        return premitSpad;
    }

    public void setPremitSpad(Integer premitSpad) {
        this.premitSpad = premitSpad;
    }

    public Integer getLesenPengendalianSpad() {
        return lesenPengendalianSpad;
    }

    public void setLesenPengendalianSpad(Integer lesenPengendalianSpad) {
        this.lesenPengendalianSpad = lesenPengendalianSpad;
    }

    public Integer getLesenPrekhidmatanSpad() {
        return lesenPrekhidmatanSpad;
    }

    public void setLesenPrekhidmatanSpad(Integer lesenPrekhidmatanSpad) {
        this.lesenPrekhidmatanSpad = lesenPrekhidmatanSpad;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    /**统计当前对象是否故障*/
    public int getCount(){
    	return roadTaxPrimeMoverTrailer+puspakomPrimeMoverTrailer+premitSpad+lesenPengendalianSpad+lesenPrekhidmatanSpad;
    }
}