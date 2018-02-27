package com.iflytransporter.api.utils;

import java.util.Date;
import java.util.Map;

public class RequestMapUtil {
	public static int pageNo = 1;
	public static int pageSize = 10;
	public static int status = 0;//初始化状态
	
	public static Integer formatPageNo(Map<String,Object> requestMap){
		if(requestMap.get("pageNo") == null){
			return pageNo;
		}
		Integer pn = (Integer) requestMap.get("pageNo");
		if(pn != null){
			return pn;
		}
		return pageNo;
	}
	public static Integer formatPageSize(Map<String,Object> requestMap){
		if(requestMap.get("pageSize") == null){
			return pageSize;
		}
		Integer pz = (Integer) requestMap.get("pageSize");
		if(pz != null){
			return pz;
		}
		return pageSize;
	}
	/**
	 * 所有格式化状态参数,如果不存在,则取默认值status为初始化值0,详细查看Enums对于不同业务状态码定义初始化值
	 * @param requestMap
	 * @return
	 */
	public static Integer formatStatus(Map<String,Object> requestMap){
		if(requestMap.get("status") == null){
			return null;
		}
		Integer st = (Integer) requestMap.get("status");
		if(st != null){
			return st;
		}
		return status;
	}
	/**
	 * 格式化最后创建日期参数 lastCreateDate
	 * @param requestMap
	 * @return
	 */
	public static Date formatLastCreateDate(Map<String,Object> requestMap){
		if(requestMap.get("lastCreateDate") == null){
			return null;
		}
		Long st = (Long) requestMap.get("lastCreateDate");
		if(st != null){
			return new Date(st);
		}
		return null;
	}
}
