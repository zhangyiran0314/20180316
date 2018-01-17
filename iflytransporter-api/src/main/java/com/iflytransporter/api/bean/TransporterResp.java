package com.iflytransporter.api.bean;

import java.util.Date;

import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.bean.UserBO;

public class TransporterResp {
	
	private String id;
	
	private String countryCode;
	
	private String mobile;

    private String nickname;

    private String lastLoginIp;
    
    private Date lastLoginDate;

    private String lastLoginDevice;
    
    private String surname;

    private String name;
    
    private String cardNo;
    
    private String email;
    
    private Integer level;
    
    private Integer authStatus;
    
    private Integer companyAuthStatus;
    
    private String attachmentId1;

    private String attachmentId2;

    private String attachmentId3;
    
	private String attachmentId1Link;

    private String attachmentId2Link;

    private String attachmentId3Link;
    
    private String companyName;
    
    private String drivingLicenseNo;
    private String attachmentId4;
    private String gdl;
    private String attachmentId5;
	private String attachmentId4Link;

    private String attachmentId5Link;

	public TransporterResp(UserBO user) {
		this.id = user.getId();
		this.countryCode = user.getCountryCode();
		this.mobile = user.getMobile();
		this.nickname = user.getNickname();
		this.lastLoginIp = user.getLastLoginIp();
		this.lastLoginDate = user.getLastLoginDate();
		this.lastLoginDevice = user.getLastLoginDevice();
		this.surname = user.getSurname();
		this.name = user.getName();
		this.cardNo = user.getCardNo();
		this.email = user.getEmail();
		this.level = user.getLevel();
		this.authStatus = user.getAuthStatus();
		this.companyAuthStatus = user.getCompanyAuthStatus();
		this.attachmentId1 = user.getAttachmentId1();
		this.attachmentId2 = user.getAttachmentId2();
		this.attachmentId3 = user.getAttachmentId3();
		this.attachmentId1Link = user.getAttachmentId1Link();
		this.attachmentId2Link = user.getAttachmentId2Link();
		this.attachmentId3Link = user.getAttachmentId3Link();
		this.drivingLicenseNo = user.getDrivingLicenseNo();
		this.attachmentId4=user.getAttachmentId4();
		this.attachmentId4Link = user.getAttachmentId4Link();
		this.gdl =user.getGdl();
		this.attachmentId5=user.getAttachmentId5();
		this.attachmentId5Link = user.getAttachmentId5Link();
		
	}
	public TransporterResp(User user) {
		this.id = user.getId();
		this.countryCode = user.getCountryCode();
		this.mobile = user.getMobile();
		this.nickname = user.getNickname();
		this.lastLoginIp = user.getLastLoginIp();
		this.lastLoginDate = user.getLastLoginDate();
		this.lastLoginDevice = user.getLastLoginDevice();
		this.surname = user.getSurname();
		this.name = user.getName();
		this.cardNo = user.getCardNo();
		this.email = user.getEmail();
		this.level = user.getLevel();
		this.authStatus = user.getAuthStatus();
		this.companyAuthStatus = user.getCompanyAuthStatus();

	}
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastLoginDevice() {
		return lastLoginDevice;
	}

	public void setLastLoginDevice(String lastLoginDevice) {
		this.lastLoginDevice = lastLoginDevice;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getAttachmentId1() {
		return attachmentId1;
	}

	public void setAttachmentId1(String attachmentId1) {
		this.attachmentId1 = attachmentId1;
	}

	public String getAttachmentId2() {
		return attachmentId2;
	}

	public void setAttachmentId2(String attachmentId2) {
		this.attachmentId2 = attachmentId2;
	}

	public String getAttachmentId3() {
		return attachmentId3;
	}

	public void setAttachmentId3(String attachmentId3) {
		this.attachmentId3 = attachmentId3;
	}

	public String getAttachmentId1Link() {
		return attachmentId1Link;
	}

	public void setAttachmentId1Link(String attachmentId1Link) {
		this.attachmentId1Link = attachmentId1Link;
	}

	public String getAttachmentId2Link() {
		return attachmentId2Link;
	}

	public void setAttachmentId2Link(String attachmentId2Link) {
		this.attachmentId2Link = attachmentId2Link;
	}

	public String getAttachmentId3Link() {
		return attachmentId3Link;
	}

	public void setAttachmentId3Link(String attachmentId3Link) {
		this.attachmentId3Link = attachmentId3Link;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDrivingLicenseNo() {
		return drivingLicenseNo;
	}
	public void setDrivingLicenseNo(String drivingLicenseNo) {
		this.drivingLicenseNo = drivingLicenseNo;
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
	public String getAttachmentId4Link() {
		return attachmentId4Link;
	}
	public void setAttachmentId4Link(String attachmentId4Link) {
		this.attachmentId4Link = attachmentId4Link;
	}
	public String getAttachmentId5Link() {
		return attachmentId5Link;
	}
	public void setAttachmentId5Link(String attachmentId5Link) {
		this.attachmentId5Link = attachmentId5Link;
	}
	public String getAttachmentId4() {
		return attachmentId4;
	}
	public void setAttachmentId4(String attachmentId4) {
		this.attachmentId4 = attachmentId4;
	}
    
}
