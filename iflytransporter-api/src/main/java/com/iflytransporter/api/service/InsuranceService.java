package com.iflytransporter.api.service;

import java.util.List;
import java.util.Map;

import com.iflytransporter.api.bean.CommonParam;
import com.iflytransporter.common.bean.Insurance;

public interface InsuranceService  {
	
	/**查询待装车运单列表 */
	List<Map<String,Object>> listWaybillByUserId(String userId);
	
	/**添加保险*/
	int save(Insurance record);
	
	List<Insurance> queryAll();
	
	CommonParam queryCommonParam(String id);
}
