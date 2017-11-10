package com.iflytransporter.api.utils;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.iflytransporter.api.common.enums.BuzExceptionEnums;
import com.iflytransporter.api.common.exception.ServiceException;

public class ResponseUitl {
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
	
	public static String successResult(Map<String,Object> data){
		JSONObject jsonResult = new JSONObject();
		jsonResult.put(Code_Key,Code_Success);
		jsonResult.put(Msg_Key, Msg_Success);
		jsonResult.put(Data_Key, data);
		return jsonResult.toJSONString();
	}
	public static String successResult(){
		JSONObject jsonResult = new JSONObject();
		jsonResult.put(Code_Key,Code_Success);
		jsonResult.put(Msg_Key, Msg_Success);
		jsonResult.put(Data_Key, null);
		return jsonResult.toJSONString();
	}
	public static String failureResult(){
		JSONObject jsonResult = new JSONObject();
		jsonResult.put(Code_Key,Code_Failure);
		jsonResult.put(Msg_Key, Msg_Failure);
		jsonResult.put(Data_Key, null);
		return jsonResult.toJSONString();
	}
	public static String failureResult(String msg){
		JSONObject jsonResult = new JSONObject();
		jsonResult.put(Code_Key,Code_Failure);
		jsonResult.put(Msg_Key, msg);
		jsonResult.put(Data_Key, null);
		return jsonResult.toJSONString();
	}
	public static String failureResult(BuzExceptionEnums e){
		JSONObject jsonResult = new JSONObject();
		jsonResult.put(Code_Key,e.getCode());
		jsonResult.put(Msg_Key, e.getMessage());
		jsonResult.put(Data_Key, null);
		return jsonResult.toJSONString();
	}
	public static String exceptionResult(ServiceException e){
		JSONObject jsonResult = new JSONObject();
		jsonResult.put(Code_Key,e.getCode());
		jsonResult.put(Msg_Key, e.getMessage());
		return jsonResult.toJSONString();
	}
	public static String unauthorizedResult(){
		JSONObject jsonResult = new JSONObject();
		jsonResult.put(Code_Key,Code_Unauthorized);
		jsonResult.put(Msg_Key, Msg_Unauthorized);
		return jsonResult.toJSONString();
	}
	public static String forbiddenResult(){
		JSONObject jsonResult = new JSONObject();
		jsonResult.put(Code_Key,Code_Forbidden);
		jsonResult.put(Msg_Key, Msg_Forbidden);
		return jsonResult.toJSONString();
	}
}
