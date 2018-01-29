package com.iflytransporter.api.service;

import com.iflytransporter.common.bean.CarAirCoolant;
import com.iflytransporter.common.bean.CarDocuments;
import com.iflytransporter.common.bean.CarEngineOil;
import com.iflytransporter.common.bean.CarSafetyEquipment;
import com.iflytransporter.common.bean.CarSignalLight;
import com.iflytransporter.common.bean.CarTyre;

public interface CarManageService {
	int addCarAirCoolant(CarAirCoolant record);
	
	int addCarDocuments(CarDocuments record);
	
	int addCarEngineOil(CarEngineOil record);
	
	int addCarSafetyEquipment(CarSafetyEquipment record);
	
	int addCarSignalLight(CarSignalLight record);
	
	int addCarTyre(CarTyre record);
}
