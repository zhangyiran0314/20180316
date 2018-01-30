package com.iflytransporter.api.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iflytransporter.api.bean.carmanage.CarAirCoolantReq;
import com.iflytransporter.api.bean.carmanage.CarDailyInspectionReq;
import com.iflytransporter.api.bean.carmanage.CarDocumentsReq;
import com.iflytransporter.api.bean.carmanage.CarEngineOilReq;
import com.iflytransporter.api.bean.carmanage.CarSafetyEquipmentReq;
import com.iflytransporter.api.bean.carmanage.CarSignalLightReq;
import com.iflytransporter.api.bean.carmanage.CarTyreReq;
import com.iflytransporter.api.mapper.CarManageMapper;
import com.iflytransporter.api.service.CarManageService;
import com.iflytransporter.api.utils.UUIDUtil;
import com.iflytransporter.common.bean.CarAirCoolant;
import com.iflytransporter.common.bean.CarDailyInspection;
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
	@Transactional
	public int addCarDailyInspection(CarDailyInspectionReq dailyInspectionReq,String companyId,String driverId) {
		String carId = dailyInspectionReq.getCarId();
		
		CarAirCoolantReq airCoolantReq = dailyInspectionReq.getAirCoolant();
		CarAirCoolant airCoolant = new CarAirCoolant();
		BeanUtils.copyProperties(airCoolantReq, airCoolant);
		String airCoolantId = UUIDUtil.UUID();
		airCoolant.setId(airCoolantId);
		airCoolant.setCompanyId(companyId);
		airCoolant.setDriverId(driverId);
		airCoolant.setCarId(carId);
		carManageMapper.insertCarAirCoolant(airCoolant);
		
		CarDocumentsReq documentsReq = dailyInspectionReq.getDocuments();
		CarDocuments documents = new CarDocuments();
		BeanUtils.copyProperties(documentsReq, documents);
		String documentsId = UUIDUtil.UUID();
		documents.setId(documentsId);
		documents.setCompanyId(companyId);
		documents.setDriverId(driverId);
		documents.setCarId(carId);
		carManageMapper.insertCarDocuments(documents);
		
		CarEngineOilReq engineOilReq = dailyInspectionReq.getEngineOil();
		CarEngineOil engineOil = new CarEngineOil();
		BeanUtils.copyProperties(engineOilReq, engineOil);
		String engineOilId = UUIDUtil.UUID();
		engineOil.setId(engineOilId);
		engineOil.setCompanyId(companyId);
		engineOil.setDriverId(driverId);
		engineOil.setCarId(carId);
		carManageMapper.insertCarEngineOil(engineOil);
		
		CarSafetyEquipmentReq safetyEquipmentReq = dailyInspectionReq.getSafetyEquipment();
		CarSafetyEquipment safetyEquipment = new CarSafetyEquipment();
		BeanUtils.copyProperties(safetyEquipmentReq, safetyEquipment);
		String safetyEquipmentId = UUIDUtil.UUID();
		safetyEquipment.setId(safetyEquipmentId);
		safetyEquipment.setCompanyId(companyId);
		safetyEquipment.setDriverId(driverId);
		safetyEquipment.setCarId(carId);
		carManageMapper.insertCarSafetyEquipment(safetyEquipment);
		

		CarSignalLightReq signalLightReq = dailyInspectionReq.getSignalLight();
		CarSignalLight signalLight = new CarSignalLight();
		BeanUtils.copyProperties(signalLightReq, signalLight);
		String signalLightId = UUIDUtil.UUID();
		signalLight.setId(signalLightId);
		signalLight.setCompanyId(companyId);
		signalLight.setDriverId(driverId);
		signalLight.setCarId(carId);
		carManageMapper.insertCarSignalLight(signalLight);
		
		CarTyreReq tyreReq = dailyInspectionReq.getTyre();
		CarTyre tyre = new CarTyre();
		BeanUtils.copyProperties(tyreReq, tyre);
		String tyreId = UUIDUtil.UUID();
		tyre.setId(tyreId);
		tyre.setCompanyId(companyId);
		tyre.setDriverId(driverId);
		tyre.setCarId(carId);
		carManageMapper.insertCarTyre(tyre);
		
		CarDailyInspection  dailyInspection = new CarDailyInspection();
		dailyInspection.setAirCoolantId(airCoolantId);
		dailyInspection.setAirCoolantCount(airCoolant.getCount());
		
		dailyInspection.setDocumentsId(documentsId);
		dailyInspection.setDocumentsCount(documents.getCount());
		
		dailyInspection.setEngineOilId(engineOilId);
		dailyInspection.setEngineOilCount(engineOil.getCount());
		
		dailyInspection.setSafetyEquipmentId(safetyEquipmentId);
		dailyInspection.setSafetyEquipmentCount(safetyEquipment.getCount());
		
		dailyInspection.setSignalLightId(signalLightId);
		dailyInspection.setSignalLightCount(signalLight.getCount());
		
		dailyInspection.setTyreId(tyreId);
		dailyInspection.setTyreCount(tyre.getCount());
		
		dailyInspection.setCarId(carId);
		dailyInspection.setCompanyId(companyId);
		dailyInspection.setDriverId(driverId);
		dailyInspection.setId(UUIDUtil.UUID());
		int result = carManageMapper.insertCarDailyInspection(dailyInspection);
		return result;
	}
	/*@Override
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
	}*/


}
