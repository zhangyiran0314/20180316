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
	
	
	//账号密码错误
	CanNotContactError(Code_CanNotContact, "CanNotContactError");
	
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
