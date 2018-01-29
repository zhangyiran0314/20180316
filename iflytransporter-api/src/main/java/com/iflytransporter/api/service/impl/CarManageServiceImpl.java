package com.iflytransporter.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytransporter.api.mapper.CarManageMapper;
import com.iflytransporter.api.service.CarManageService;
import com.iflytransporter.common.bean.CarAirCoolant;
import com.iflytransporter.common.bean.CarDocuments;
import com.iflytransporter.common.bean.CarEngineOil;
import com.iflytransporter.common.bean.CarSafetyEquipment;
import com.iflytransporter.common.bean.CarSignalLight;
import com.iflytransporter.common.bean.CarTyre;

@Service("carManageService")
public class CarManageServiceImpl implements CarManageService{

	@Autowired
	private CarManageMapper carManageMapper;
	@Override
	public int addCarAirCoolant(CarAirCoolant record) {
		return carManageMapper.insertCarAirCoolant(record);
	}

	@Override
	public int addCarDocuments(CarDocuments record) {
		return carManageMapper.insertCarDocuments(record);
	}

	@Override
	public int addCarEngineOil(CarEngineOil record) {
		return carManageMapper.insertCarEngineOil(record);
	}

	@Override
	public int addCarSafetyEquipment(CarSafetyEquipment record) {
		return carManageMapper.insertCarSafetyEquipment(record);
	}

	@Override
	public int addCarSignalLight(CarSignalLight record) {
		return carManageMapper.insertCarSignalLight(record);
	}

	@Override
	public int addCarTyre(CarTyre record) {
		return carManageMapper.insertCarTyre(record);
	}

}
