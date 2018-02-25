package com.iflytransporter.common.enums;

public enum BuzExceptionEnums implements Enums{
	//未知错误
	UnknownError(Code_UnknownError,"UnknownError"),
	//重复获取验证码
	RepeatForCaptchaError(Code_RepeatForCaptchaError,"RepeatForCaptchaError"),
	//验证验证码错误
	VerifyCaptchaError(Code_VerifyCaptchaError,"VerifyCaptchaError"),
	//账户已经注册
	AccountsAlreadyRegister(Code_AccountsAlreadyExist,"AccountsAlreadyRegister"),
	//账号密码错误
	AccountOrPasswordErr(Code_AccountOrPasswordError, "AccountOrPasswordErr"),
	//账号密码错误
	NotUpError(Code_NotUpError, "NotUpError"),
	//账户不存在
	AccountsNotExist(Code_AccountsNotExist,"AccountsNotExist"),
	//公司未认证
	CompanyNotAuth(Code_CompanyNotAuth,"CompanyNotAuth"),
	//绑定错误-管理员不允许被绑定
	AdminCannotBind(Code_AdminCannotBind,"AdminCannotBind"),
	//绑定错误-员工已经被绑定
	StaffAlreadyBind(Code_StaffAlreadyBind,"StafAlreadyBind"),
	//绑定错误-员工不允许被重复绑定
	StaffCannotRepeatBind(Code_StaffCannotRepeatBind,"StaffCannotBindRepeat"),
	
	//报价时,待审核报价申请不能超过五家
	OffersCannotRepeat(Code_OffersCannotRepeat,"This call quotation repeat,please check your quotation record"),
	
	//报价时,待审核报价申请不能超过五家
	OffersCannotMoreThanFive(Code_OffersCannotMoreThanFive,"This call quotation is closed, may you review others"),
	//报价时,不能超过当前车辆数
	OffersCannotMoreThanCarAmount(Code_OffersCannotMoreThanCarAmount,"This call quotation more than your car amount"),
	//未审核当前申请详情时,其他申请不能被联系
	CanNotContactError(Code_CannotContactOther, "CanNotContactError");
	
	public int code;
	public String message;
	
    private BuzExceptionEnums(int code, String message){  
        this.code = code;  
        this.message = message;  
    }  
	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
