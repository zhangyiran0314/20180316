package com.iflytransporter.common.enums;

public enum BuzExceptionEnums implements Enums{
	//未知错误
	UnknownError(Code_UnknownError,"UnknownError"),
	//重复获取验证码
	RepeatForCaptchaError(Code_RepeatForCaptchaError,"RepeatForCaptchaError"),
	//验证验证码错误
	VerifyCaptchaError(Code_VerifyCaptchaError,"VerifyCaptchaError"),
	//账户已经注册
	AccountsAlreadyExist(Code_AccountsAlreadyExist,"AccountsAlreadyExist"),
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
	//绑定错误-员工不允许被重复绑定
	StaffCannotRepeatBind(Code_StaffCannotRepeatBind,"StaffCannotBindRepeat"),
	//账号密码错误
	CanNotContactError(Code_CannotContact, "CanNotContactError");
	
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
