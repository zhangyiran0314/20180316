package com.iflytransporter.api.common.exception;

import com.iflytransporter.api.common.enums.Enums;

public class ServiceException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private Enums exceptionEnums;
	
	public ServiceException(Enums exceptionEnums){  
        this.exceptionEnums = exceptionEnums;  
	}  
	
	public Enums getExceptionEnums() {
		return exceptionEnums;
	}

	public void setExceptionEnums(Enums exceptionEnums) {
		this.exceptionEnums = exceptionEnums;
	}
	public int getCode(){
		if(exceptionEnums!=null) return exceptionEnums.getCode();
		return Enums.Code_UnknownError;
	}
	public String getMessage(){
		if(exceptionEnums!=null)  return exceptionEnums.getMessage();
		return Enums.Code_UnknownError_Value;
	}
}
