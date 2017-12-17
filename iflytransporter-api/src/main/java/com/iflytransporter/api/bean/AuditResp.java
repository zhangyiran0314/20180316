package com.iflytransporter.api.bean;

import java.util.Date;

public class AuditResp {
	
	private String surname;

    private String name;
    
    private String attachment; 
    
    private String registerTime;
    
    private Integer orderNum;
    
    private String companyName;
    
    private Integer grade;
    
    private Integer costs;
    
    private Date applyDate;

	public String getSurname() {
		return surname;
	}

	public String getName() {
		return name;
	}

	public String getAttachment() {
		return attachment;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public String getCompanyName() {
		return companyName;
	}

	public Integer getGrade() {
		return grade;
	}

	public Integer getCosts() {
		return costs;
	}

	public Date getApplyDate() {
		return applyDate;
	}
    
    
}
