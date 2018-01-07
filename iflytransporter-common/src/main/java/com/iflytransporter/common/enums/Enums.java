package com.iflytransporter.common.enums;

public interface Enums {

	/**错误码定义*/
	/**用户相关状态码*/
	public static int Code_UnknownError = 1000;//未知错误
	public static String Code_UnknownError_Value = "UnknownError";
	public static int Code_RepeatForCaptchaError=1001;//重复获取验证码
	//重复获取验证码
	public static int Code_VerifyCaptchaError=1002;
	
	//账户已经存在
	public static int Code_AccountsAlreadyExist = 1003;
	//账户密码不正确
	public static int Code_AccountOrPasswordError = 1004;
	//上级不存在
	public static int Code_NotUpError = 1005;
	//账户不存在
	public static int Code_AccountsNotExist = 1006;
	
	/**发布相关状态码*/
	public static int Code_CanNotContact = 2001;
	
	public int getCode();
	public String getMessage();
}
