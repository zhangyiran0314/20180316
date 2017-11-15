package com.iflytransporter.common.enums;

public interface Enums {
	/**状态定义*/
	//用户部分
	public static  int Status_UserRegister = 0;//用户注册
	public static int Status_UserIdentify = 1;//用户认证
	public static int Status_UserEnable  = 2;//用户激活
	
	/**数据有效*/
	public static int Status_Valid = 0;//有效
	public static int Status_Invalid = 1;//失效
	
	
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
	
	public int getCode();
	public String getMessage();
}
