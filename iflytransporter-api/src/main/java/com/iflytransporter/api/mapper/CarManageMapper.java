package com.iflytransporter.api.mapper;

import com.iflytransporter.common.bean.CarAirCoolant;
import com.iflytransporter.common.bean.CarDailyInspection;
import com.iflytransporter.common.bean.CarDocuments;
import com.iflytransporter.common.bean.CarEngineOil;
import com.iflytransporter.common.bean.CarSafetyEquipment;
import com.iflytransporter.common.bean.CarSignalLight;
import com.iflytransporter.common.bean.CarTyre;

public interface CarManageMapper {
	int insertCarAirCoolant(CarAirCoolant record);
	
	int insertCarDocuments(CarDocuments record);
	
	int insertCarEngineOil(CarEngineOil record);
	
	int insertCarSafetyEquipment(CarSafetyEquipment record);
	
	int insertCarSignalLight(CarSignalLight record);
	
	int insertCarTyre(CarTyre record);
	
	int insertCarDailyInspection(CarDailyInspection record);
}
