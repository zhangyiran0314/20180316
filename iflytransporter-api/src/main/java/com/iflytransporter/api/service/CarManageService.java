package com.iflytransporter.api.service;

import java.util.List;
import java.util.Map;

import com.iflytransporter.api.bean.carmanage.CarDailyInspectionReq;
import com.iflytransporter.api.bean.carmanage.CarMaintenanceReq;
import com.iflytransporter.common.bean.CarDriveRest;

public interface CarManageService {
	/**添加每日一检记录*/
	int addCarDailyInspection(CarDailyInspectionReq dailyInspection,String companyId,String driverId);
	/** 行车休息记录,类似打卡操作,开始-行车-休息-行车-休息-。。。结束 */
	int addCarDriveRest(CarDriveRest record);
	/**司机-首页查询*/
	Map<String,Object> indexDriver(String companyId,String driverId);
	//司机-我的运单
	Map<String,Object> queryDriverWaybill(String companyId,String driverId);

	//保险提醒
	Map<String,Object> queryCarInsuranceDetail(String carId);
	//路税提醒
	Map<String,Object> queryCarTaxDetail(String carId);
	//年检提醒
	Map<String,Object> queryCarCheckDetail(String carId);
	//行车休息  -详情
    List<Map<String,Object>> queryCarDriveRestDetail(String carId);
	
	/**车主-首页查询 */
	Map<String,Object> indexTransporter(String companyId);
	//车主-我的运单-列表
	List<Map<String,Object>> queryTransporterWaybillList(String companyId);
	//车主-我的运单-详情
	Map<String,Object> queryTransporterWaybill(String carId);
	//车主-每日一检-列表
	List<Map<String,Object>> queryTransporterCarDailyInspectionList(String companyId);
	//车主-司机休息-列表
	Map<String,Object> queryTransporterCarDriveRestList(String companyId);
	//车主-保险提醒-列表
	List<Map<String,Object>> queryCarInsuranceList(String companyId);
	//车主-路税提醒-列表
	List<Map<String,Object>> queryCarTaxList(String companyId);
	//车主-车检提醒-列表
	List<Map<String,Object>> queryCarCheckList(String companyId);
	
	/**每日一检查询**/
	Map<String,Object> queryCarDailyInspection(String carId);
	Map<String,Object> detailCarAirCoolant(String id);
	Map<String,Object> detailCarDocuments(String id);
	Map<String,Object> detailCarEngineOil(String id);
	Map<String,Object> detailCarSafetyEquipment(String id);
	Map<String,Object> detailCarSignalLight(String id);
	Map<String,Object> detailCarTyre(String id);
	
	/**车辆维修*/
	List<Map<String, Object>> listCarMaintenance(CarMaintenanceReq carMaintenaceReq);
}
