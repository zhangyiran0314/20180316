package com.iflytransporter.api.utils;

import java.util.Map;

public class RequestMapUtil {
	public static int pageNo = 1;
	public static int pageSize = 10;
	
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
}
