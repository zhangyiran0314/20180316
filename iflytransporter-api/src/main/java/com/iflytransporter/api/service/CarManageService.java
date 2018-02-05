package com.iflytransporter.api.service;

import java.util.Map;

import com.iflytransporter.api.bean.carmanage.CarDailyInspectionReq;
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
	//司机-每日一检
	Map<String,Object> queryDriverCarDailyInspection(String companyId,String driverId);
	//司机-司机休息
	Map<String,Object> queryDriverCarDriveRestDetail(String companyId,String driverId);
	
	//保险提醒
	Map<String,Object> queryCarInsuranceDetail(String carId);
	//路税提醒
	Map<String,Object> queryCarTaxDetail(String carId);
	//年检提醒
	Map<String,Object> queryCarCheckDetail(String carId);
	
	/**车主-首页查询 */
	Map<String,Object> indexTransporter(String companyId);
	
	Map<String,Object> queryTransporterWaybill(String companyId);
	/**
	 * -车主-我的运单-列表
	 * @param companyId
	 * @return 车牌,车辆运单数,待装车数量
	 */
	Map<String,Object> queryTransporterWaybillList(String companyId);
	//车主-我的运单-列表
	Map<String,Object> queryDriverWaybillList(String companyId);
	//车主-每日一检
	Map<String,Object> queryTransporterCarDailyInspection(String companyId);
	//司机休息-车主
	Map<String,Object> queryTransporterCarDriveRest(String companyId);
	
	/**公用单项查询**/
	Map<String,Object> detailCarAirCoolant(String id);
	Map<String,Object> detailCarDocuments(String id);
	Map<String,Object> detailCarEngineOil(String id);
	Map<String,Object> detailCarSafetyEquipment(String id);
	Map<String,Object> detailCarSignalLight(String id);
	Map<String,Object> detailCarTyre(String id);
}
