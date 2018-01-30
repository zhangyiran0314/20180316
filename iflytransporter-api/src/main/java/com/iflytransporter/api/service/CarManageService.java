package com.iflytransporter.api.service;

import com.iflytransporter.api.bean.carmanage.CarDailyInspectionReq;

public interface CarManageService {
	/*int addCarAirCoolant(CarAirCoolant record);
	
	int addCarDocuments(CarDocuments record);
	
	int addCarEngineOil(CarEngineOil record);
	
	int addCarSafetyEquipment(CarSafetyEquipment record);
	
	int addCarSignalLight(CarSignalLight record);
	
	int addCarTyre(CarTyre record);*/
	
	int addCarDailyInspection(CarDailyInspectionReq dailyInspection,String companyId,String driverId);
	
	/**
	 * 行车休息记录,只保留当前提交数据,如果存在新的提交操作,则覆盖之前的操作
	 */
	
	
	
}
