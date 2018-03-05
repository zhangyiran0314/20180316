package com.iflytransporter.api.utils;

import com.iflytransporter.common.bean.User;
import com.iflytransporter.common.enums.Status;

public class AuthUtils {
	public static boolean identification(User user){
		if(user == null){
			return false;
		}
		if(Status.Auth_Yes != user.getAuthStatus() || Status.Auth_Yes != user.getCompanyAuthStatus()){
			return false;
		}
		return true;
	}
}
