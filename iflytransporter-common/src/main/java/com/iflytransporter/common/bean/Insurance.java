package com.iflytransporter.common.bean;

import com.iflytransporter.common.base.BaseEntity;

public class Insurance extends BaseEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

    private Integer costs;

    private Integer premium;

    private String detail;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCosts() {
        return costs;
    }

    public void setCosts(Integer costs) {
        this.costs = costs;
    }

    public Integer getPremium() {
        return premium;
    }

    public void setPremium(Integer premium) {
        this.premium = premium;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}