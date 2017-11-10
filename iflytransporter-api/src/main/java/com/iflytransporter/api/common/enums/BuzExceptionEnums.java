package com.iflytransporter.api.common.enums;

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
	AccountOrPasswordErr(Code_AccountOrPasswordError, "AccountOrPasswordErr");
	
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
