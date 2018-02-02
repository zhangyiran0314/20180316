package com.iflytransporter.api.service;

import java.util.Map;

import com.iflytransporter.api.bean.carmanage.CarDailyInspectionReq;
import com.iflytransporter.common.bean.CarDriveRest;

public interface CarManageService {
	/*int addCarAirCoolant(CarAirCoolant record);
	
	int addCarDocuments(CarDocuments record);
	
	int addCarEngineOil(CarEngineOil record);
	
	int addCarSafetyEquipment(CarSafetyEquipment record);
	
	int addCarSignalLight(CarSignalLight record);
	
	int addCarTyre(CarTyre record);*/
	
	int addCarDailyInspection(CarDailyInspectionReq dailyInspection,String companyId,String driverId);
	
	/**
	 * 行车休息记录,类似打卡操作,开始-行车-休息-行车-休息-。。。结束
	 */
	int addCarDriveRest(CarDriveRest record);
	/**首页查询*/
	/**
	 * 车主-我的运单
	 * @param companyId
	 * @return 车辆总数,运单总数,待派单运单数
	 */
	Map<String,Object> queryTransporterWaybill(String companyId);
	/**
	 * -车主-我的运单-列表
	 * @param companyId
	 * @return 车牌,车辆运单数,待装车数量
	 */
	Map<String,Object> queryTransporterWaybillList(String companyId);
	
	
	//我的运单-司机
	Map<String,Object> queryDriverWaybill(String companyId,String driverId);
	//每日一检-车主
	Map<String,Object> queryTransporterCarDailyInspection(String companyId);
	//每日一检-司机
	Map<String,Object> queryDriverCarDailyInspection(String companyId,String driverId);
	//司机休息-车主
	Map<String,Object> queryTransporterCarDriveRest(String companyId);
	//司机休息-司机
	Map<String,Object> queryDriverCarDriveRest(String companyId,String driverId);
	
	//保险提醒
	Map<String,Object> queryCarInsurance(String companyId,String driverId);
	//路税提醒
	Map<String,Object> queryCarTax(String companyId,String driverId);
	//年检提醒
	Map<String,Object> queryCarCheck(String companyId,String driverId);
	
}
