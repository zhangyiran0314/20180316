package com.iflytransporter.common.enums;

public interface Enums {

	/**错误码定义*/
	//未知错误
	public static int Code_UnknownError = 1000;
	public static String Code_UnknownError_Value = "UnknownError";
	
	//重复获取验证码
	public static int Code_RepeatForCaptchaError=1001;
	//重复获取验证码
	public static int Code_VerifyCaptchaError=1002;
	
	//账户已经存在
	public static int Code_AccountsAlreadyExist = 1003;
	//账户密码不正确
	public static int Code_AccountOrPasswordError = 1004;
	
	//上级不存在
	public static int Code_NotUpError = 1005;
	
	public int getCode();
	public String getMessage();
}
