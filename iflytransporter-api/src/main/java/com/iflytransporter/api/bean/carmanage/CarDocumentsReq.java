package com.iflytransporter.api.bean.carmanage;

public class CarDocumentsReq {

    private Integer roadTaxPrimeMoverTrailer;

    private Integer puspakomPrimeMoverTrailer;

    private Integer premitSpad;

    private Integer lesenPengendalianSpad;

    private Integer lesenPrekhidmatanSpad;

    private String remark;


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
}