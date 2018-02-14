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
	//公司未认证
	public static int Code_CompanyNotAuth = 1007;
	//绑定错误-管理员不允许被绑定
	public static int Code_AdminCannotBind = 1008;
	//绑定错误-员工不允许被重复绑定
	public static int Code_StaffCannotRepeatBind = 1008;
	
	
	/**发货相关状态码*/
	//报价时,待审核报价申请不能超过五家
	public static int Code_OffersCannotMoreThanFive = 2001;
	//报价时,不能超过当前车辆数
	public static int Code_OffersCannotMoreThanCarAmount = 2002;
	//不能重复报价
	public static int Code_OffersCannotRepeat = 2003;
	
	//未审核当前申请详情时,其他申请不能被联系
	public static int Code_CannotContactOther = 2004;
	
	public int getCode();
	public String getMessage();
}
