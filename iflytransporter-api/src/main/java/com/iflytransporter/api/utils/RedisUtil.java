package com.iflytransporter.api.utils;

public class RedisUtil {
	/**redis模块划分*/
	public static String Redis_Captcha ="captcha";//验证码模块
	public static String Redis_User ="user";//用户模块
	public static String Redis_UserBO ="userBO";//用户模块
	public static String Redis_Position="position";//地理位置模块
	
	public static String Redis_Position_Province="province";//省份
	public static String Redis_Position_City="city";//城市
	public static String Redis_Position_Area="area";//地区
	
	
	public static String Redis_Type="type";//基础类型模块
	public static String Redis_UseType="useType";//用车类型
	public static String Redis_CarType="carType";//车辆类型
	public static String Redis_GoodsType="goodsType";//货物类型
	public static String Redis_HandlingType="handlingType";//装卸类型
	public static String Redis_PaymentType="paymentType";//支付类型
	/**获取key值*/
	public static String getCaptchaKey(String countryCode,String key){
		return Redis_Captcha+":"+countryCode+":"+key; 
	}
	/**获取key值*/
	public static String getPositionCountryKey(String countryCode){
		return Redis_Position+":"+countryCode; 
	}
	/**获取key值*/
	public static String getUserKey(String userId){
		return Redis_User+":"+userId; 
	}
	/**获取key值*/
	public static String getUserBOKey(String userId){
		return Redis_UserBO+":"+userId; 
	}
	/**获取key值*/
	public static String getPositionKey(String position,String id){
		return Redis_Position+":"+position+":"+id; 
	}
	/**获取key值*/
	public static String getTypeKey(String type,String id){
		if(id != null)
			return Redis_Type+":"+type+":"+id; 
		return 	Redis_Type+":"+type;
	}
}
