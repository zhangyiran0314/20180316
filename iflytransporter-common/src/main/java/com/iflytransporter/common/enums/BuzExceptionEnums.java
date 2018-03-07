package com.iflytransporter.common.enums;

public enum BuzExceptionEnums implements Enums{
	//未知错误
	UnknownError(Code_UnknownError,"Unknown Error"),
	//未通过审核用户不能操作
	NotCertifited(Code_NotCertifited,"You are not certifited"),
	
	//重复获取验证码
	RepeatForCaptchaError(Code_RepeatForCaptchaError,"Repeat to get the Verification Code"),
	//验证验证码错误
	VerifyCaptchaError(Code_VerifyCaptchaError,"Incorrect Verification Code"),
	//账户已经注册
	AccountsAlreadyRegister(Code_AccountsAlreadyExist,"That Account is taken. Try another"),
	//账号密码错误
	AccountOrPasswordErr(Code_AccountOrPasswordError, "Incorrect Account or Password, Try again"),
	//上级不存在
	NotUpError(Code_NotUpError, "The Administrator does not exist"),
	//账户不存在
	AccountsNotExist(Code_AccountsNotExist,"Account Does Not Exist"),
	//公司未认证
	CompanyNotAuth(Code_CompanyNotAuth,"You have not completed Company Info"),
	//绑定错误-管理员不允许被绑定
	AdminCannotBind(Code_AdminCannotBind,"Invaild, You Cannot Add another Admin"),
	//绑定错误-员工已经被绑定
	StaffAlreadyBind(Code_StaffAlreadyBind,"Invalid. This account has been added"),
	//绑定错误-员工不允许被重复绑定
	StaffCannotRepeatBind(Code_StaffCannotRepeatBind,"Invalid. You cannot add this account more than once"),
	
	//报价时,不能重复报价
	OffersCannotRepeat(Code_OffersCannotRepeat,"This call quotation repeat,please check your quotation record"),
	
	//报价时,因为时间差的原因,货主审核通过了其他报价,当前订单已经转为运单,则不在接受其他报价
	OffersAlreadyDealed(Code_OffersAlreadyDealed,"Order has been dealed, please try others ! "),
	//报价时,待审核报价申请不能超过五家
	OffersCannotMoreThanFive(Code_OffersCannotMoreThanFive,"Shipper has received 5 offers. Please try other orders"),
	//报价时,不能超过当前车辆数
	OffersCannotMoreThanCarAmount(Code_OffersCannotMoreThanCarAmount,"You cannot make more offers due to limited number of lorries"),
	//没有操作权限
	NoOperationPermission(Code_NoOperationPermission,"No operation permission."),
	//未审核当前申请详情时,其他申请不能被联系
	CanNotContactError(Code_CannotContactOther, "You cannot view other offer details when one's under review");
	
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
