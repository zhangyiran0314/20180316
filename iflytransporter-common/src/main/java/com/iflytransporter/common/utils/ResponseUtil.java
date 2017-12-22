package com.iflytransporter.common.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iflytransporter.common.enums.BuzExceptionEnums;
import com.iflytransporter.common.exception.ServiceException;

public class ResponseUtil {
	//返回值
	public static String Code_Key = "code";//成功
	public static int Code_Success = 0;//成功
	public static int Code_Failure =1;//失败
	public static int Code_Unauthorized = 401;//没有授权
	public static int Code_Forbidden = 403;//token无效,限制访问
	
	public static String Msg_Key="msg";
	public static String Msg_Success ="success";
	public static String Msg_Failure ="failure";
	public static String Msg_Unauthorized ="Unauthorized";
	public static String Msg_Forbidden ="Forbidden";
	
	public static String Data_Key="data";
	
	public static Map<String,Object> successResult(Object data){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put(Code_Key,Code_Success);
		result.put(Msg_Key, Msg_Success);
		result.put(Data_Key, data);
		return result;
	}
	public static Map<String,Object> successResult(){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put(Code_Key,Code_Success);
		result.put(Msg_Key, Msg_Success);
		result.put(Data_Key, null);
		return result;
	}
	public static Map<String,Object> failureResult(){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put(Code_Key,Code_Failure);
		result.put(Msg_Key, Msg_Failure);
		result.put(Data_Key, null);
		return result;
	}
	public static Map<String,Object> failureResult(String msg){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put(Code_Key,Code_Failure);
		result.put(Msg_Key, msg);
		result.put(Data_Key, null);
		return result;
	}
	public static Map<String,Object> failureResult(BuzExceptionEnums e){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put(Code_Key,e.getCode());
		result.put(Msg_Key, e.getMessage());
		result.put(Data_Key, null);
		return result;
	}
	public static Map<String,Object> exceptionResult(ServiceException e){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put(Code_Key,e.getCode());
		result.put(Msg_Key, e.getMessage());
		return result;
	}
	public static Map<String,Object> unauthorizedResult(){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put(Code_Key,Code_Unauthorized);
		result.put(Msg_Key, Msg_Unauthorized);
		return result;
	}
	public static Map<String,Object> forbiddenResult(){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put(Code_Key,Code_Forbidden);
		result.put(Msg_Key, Msg_Forbidden);
		return result;
	}
	
	//for web queryPage
	static String Count_Key ="count";
	@SuppressWarnings("rawtypes")
	public static Map<String,Object> successPage(Long total,List data){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put(Code_Key,Code_Success);
		result.put(Msg_Key, Msg_Success);
		result.put(Count_Key, total);
		result.put(Data_Key, data);
		return result;
	}
}
