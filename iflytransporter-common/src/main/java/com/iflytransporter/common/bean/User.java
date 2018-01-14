package com.iflytransporter.common.bean;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.iflytransporter.common.base.BaseEntity;

public class User extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	private String countryCode;
	
	private String mobile;

	@JSONField(serialize=false)
    private String password;

    private String nickname;

    private String lastLoginIp;
    
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastLoginDate;

    private Integer status;

    private String lastLoginDevice;

    private String companyId;

    private String parentId;

    private String attachmentId1;

    private String attachmentId2;

    private String attachmentId3;
    
    private String surname;

    private String name;
    
    private String cardNo;
    
    private String email;
    
    private Integer userType;
    
    private Integer level;
    
    private Integer authStatus;
    
    private Integer companyAuthStatus;
    
    private String drivingLicenseNo;
    private String attachmentId4;
    private String gdl;
    private String attachmentId5;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLastLoginDevice() {
        return lastLoginDevice;
    }

    public void setLastLoginDevice(String lastLoginDevice) {
        this.lastLoginDevice = lastLoginDevice == null ? null : lastLoginDevice.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getAttachmentId1() {
        return attachmentId1;
    }

    public void setAttachmentId1(String attachmentId1) {
        this.attachmentId1 = attachmentId1 == null ? null : attachmentId1.trim();
    }

    public String getAttachmentId2() {
        return attachmentId2;
    }

    public void setAttachmentId2(String attachmentId2) {
        this.attachmentId2 = attachmentId2 == null ? null : attachmentId2.trim();
    }

    public String getAttachmentId3() {
        return attachmentId3;
    }

    public void setAttachmentId3(String attachmentId3) {
        this.attachmentId3 = attachmentId3 == null ? null : attachmentId3.trim();
    }

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public Integer getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(Integer authStatus) {
		this.authStatus = authStatus;
	}

	public Integer getCompanyAuthStatus() {
		return companyAuthStatus;
	}

	public void setCompanyAuthStatus(Integer companyAuthStatus) {
		this.companyAuthStatus = companyAuthStatus;
	}

	public String getDrivingLicenseNo() {
		return drivingLicenseNo;
	}

	public void setDrivingLicenseNo(String drivingLicenseNo) {
		this.drivingLicenseNo = drivingLicenseNo;
	}

	public String getAttachmentId4() {
		return attachmentId4;
	}

	public void setAttachmentId4(String attachmentId4) {
		this.attachmentId4 = attachmentId4;
	}

	public String getGdl() {
		return gdl;
	}

	public void setGdl(String gdl) {
		this.gdl = gdl;
	}

	public String getAttachmentId5() {
		return attachmentId5;
	}

	public void setAttachmentId5(String attachmentId5) {
		this.attachmentId5 = attachmentId5;
	}

	@Override
  	public String toString() {
    	  return JSONObject.toJSONString(this).toString();
  	}
}