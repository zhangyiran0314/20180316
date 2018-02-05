package com.iflytransporter.api.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import com.iflytransporter.common.bean.CarDriveRest;
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

	@Override
	public int addCarDriveRest(CarDriveRest record) {
		return carManageMapper.insertCarDriveRest(record);
	}

	@Override
	public Map<String, Object> queryTransporterWaybill(String companyId) {
		return carManageMapper.queryTransporterWaybill(companyId);
	}

	@Override
	public Map<String, Object> queryDriverWaybill(String companyId, String driverId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> queryTransporterCarDailyInspection(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> queryTransporterCarDriveRest(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> queryDriverCarDriveRestDetail(String companyId, String driverId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> queryTransporterWaybillList(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> queryDriverWaybillList(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> indexDriver(String companyId,String driverId) {
		Date currentDate = new Date();
		//保险,路税,车检提醒
		Map<String,Object> result  = carManageMapper.queryIndexDriverCarNotice(companyId, driverId,currentDate);
		//1.我的运单
		Map<String,Object> waybill = carManageMapper.queryIndexDriverWaybill(companyId, driverId);
		result.put("waybill", waybill);
		//2.每日一检
		Map<String,Object> dailyInspenction = carManageMapper.queryIndexDriverCarDailyInspection(companyId, driverId, currentDate);
		result.put("dailyInspenction", dailyInspenction);
		//3.司机休息
		Map<String,Object> driverRest = carManageMapper.queryIndexDriverCarDriveRest(companyId, driverId);
		result.put("driverRest", driverRest);
		//保险,路税,车检提醒
	/*	Map<String,Object> carNotice = carManageMapper.queryIndexDriverCarNotice(companyId, driverId,currentDate);
		result.put("carNotice", carNotice);*/
		/*//5.路税提醒
		Map<String,Object> tax = carManageMapper.queryCarTaxList(companyId, driverId,currentDate);
		result.put("tax", tax);
		//6.车检提醒
		Map<String,Object> check = carManageMapper.queryCarCheckList(companyId, driverId,currentDate);
		result.put("check", check);*/
		return result;
	}

	@Override
	public Map<String, Object> queryDriverCarDailyInspection(String companyId, String driverId) {
		Date currentDate = new Date();
		return carManageMapper.queryDriverCarDailyInspection(companyId, driverId, currentDate);
	}

	@Override
	public Map<String, Object> detailCarAirCoolant(String id) {
		return carManageMapper.selectCarAirCoolant(id);
	}

	@Override
	public Map<String, Object> detailCarDocuments(String id) {
		return carManageMapper.selectCarDocuments(id);
	}

	@Override
	public Map<String, Object> detailCarEngineOil(String id) {
		return carManageMapper.selectCarEngineOil(id);
	}

	@Override
	public Map<String, Object> detailCarSafetyEquipment(String id) {
		return carManageMapper.selectCarSafetyEquipment(id);
	}

	@Override
	public Map<String, Object> detailCarSignalLight(String id) {
		return carManageMapper.selectCarSignalLight(id);
	}

	@Override
	public Map<String, Object> detailCarTyre(String id) {
		return carManageMapper.selectCarTyre(id);
	}

	@Override
	public Map<String, Object> indexTransporter(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> queryCarInsuranceDetail(String carId) {
		return carManageMapper.queryCarInsuranceDetail(carId);
	}

	@Override
	public Map<String, Object> queryCarTaxDetail(String carId) {
		return carManageMapper.queryCarTaxDetail(carId);
	}

	@Override
	public Map<String, Object> queryCarCheckDetail(String carId) {
		return carManageMapper.queryCarCheckDetail(carId);
	}

	
}
