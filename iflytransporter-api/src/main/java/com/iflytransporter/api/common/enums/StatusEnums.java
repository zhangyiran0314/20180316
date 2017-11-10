package com.iflytransporter.api.common.enums;

public enum StatusEnums implements Enums{
	
	UserRegister(Status_UserRegister,"UserRegister"),
	
	UserIdentify(Status_UserIdentify,"UserIdentify"),
	
	UserEnable(Status_UserEnable,"UserEnable");
	
	public int code;
	public String message;
	
	private StatusEnums(int code, String message){  
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
