package com.iflytransporter.api.utils;

public class RedisUtil {
	/**redis模块划分*/
	//验证码模块
	public static String Redis_Captcha ="captcha";
	public static String Redis_Position="position";
	
	/**获取key值*/
	public static String getCaptchaKey(String countryCode,String key){
		return Redis_Captcha+":"+countryCode+":"+key; 
	}
	/**获取key值*/
	public static String getPostionKey(String countryCode){
		return Redis_Position+":"+countryCode; 
	}
}
