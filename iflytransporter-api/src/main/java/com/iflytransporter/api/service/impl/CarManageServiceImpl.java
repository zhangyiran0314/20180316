package com.iflytransporter.api.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iflytransporter.api.bean.carmanage.CarAirPressureCoolantReq;
import com.iflytransporter.api.bean.carmanage.CarDailyInspectionReq;
import com.iflytransporter.api.bean.carmanage.CarEngineOilReq;
import com.iflytransporter.api.bean.carmanage.CarIndicatorLightReq;
import com.iflytransporter.api.bean.carmanage.CarMaintenanceReq;
import com.iflytransporter.api.bean.carmanage.CarSafetyEquipmentReq;
import com.iflytransporter.api.bean.carmanage.CarTireReq;
import com.iflytransporter.api.mapper.CarManageMapper;
import com.iflytransporter.api.service.CarManageService;
import com.iflytransporter.api.utils.UUIDUtil;
import com.iflytransporter.common.bean.CarAirPressureCoolant;
import com.iflytransporter.common.bean.CarDailyInspection;
import com.iflytransporter.common.bean.CarDriveRest;
import com.iflytransporter.common.bean.CarEngineOil;
import com.iflytransporter.common.bean.CarIndicatorLight;
import com.iflytransporter.common.bean.CarSafetyEquipment;
import com.iflytransporter.common.bean.CarTire;
import com.iflytransporter.common.enums.Status;

@Service("carManageService")
public class CarManageServiceImpl implements CarManageService{

	@Autowired
	private CarManageMapper carManageMapper;
	
	@Override
	@Transactional
	public int addCarDailyInspection(CarDailyInspectionReq dailyInspectionReq,String companyId,String driverId) {
		String carId = dailyInspectionReq.getCarId();
		
		CarAirPressureCoolantReq airPressureCoolantReq = dailyInspectionReq.getAirePressureCoolant();
		CarAirPressureCoolant airPressureCoolant = new CarAirPressureCoolant();
		BeanUtils.copyProperties(airPressureCoolantReq, airPressureCoolant);
		String airPressureCoolantId = UUIDUtil.UUID();
		airPressureCoolant.setId(airPressureCoolantId);
		airPressureCoolant.setCompanyId(companyId);
		airPressureCoolant.setDriverId(driverId);
		airPressureCoolant.setCarId(carId);
		carManageMapper.insertCarAirPressureCoolant(airPressureCoolant);
		
		/*CarDocumentsReq documentsReq = dailyInspectionReq.getDocuments();
		CarDocuments documents = new CarDocuments();
		BeanUtils.copyProperties(documentsReq, documents);
		String documentsId = UUIDUtil.UUID();
		documents.setId(documentsId);
		documents.setCompanyId(companyId);
		documents.setDriverId(driverId);
		documents.setCarId(carId);
		carManageMapper.insertCarDocuments(documents);*/
		
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
		

		/*CarIndicatorLightReq IndicatorLightReq = dailyInspectionReq.getIndicatorLight();
		CarIndicatorLight IndicatorLight = new CarIndicatorLight();
		BeanUtils.copyProperties(IndicatorLightReq, IndicatorLight);
		String IndicatorLightId = UUIDUtil.UUID();
		IndicatorLight.setId(IndicatorLightId);
		IndicatorLight.setCompanyId(companyId);
		IndicatorLight.setDriverId(driverId);
		IndicatorLight.setCarId(carId);
		carManageMapper.insertCarIndicatorLight(IndicatorLight);*/
		
		/*CarTireReq tireReq = dailyInspectionReq.getTire();
		CarTire tire = new CarTire();
		BeanUtils.copyProperties(tireReq, tire);
		String tireId = UUIDUtil.UUID();
		tire.setId(tireId);
		tire.setCompanyId(companyId);
		tire.setDriverId(driverId);
		tire.setCarId(carId);
		carManageMapper.insertCarTire(tire);*/
		
		CarIndicatorLightReq IndicatorLightReq = dailyInspectionReq.getIndicatorLight();
		CarIndicatorLight IndicatorLight = new CarIndicatorLight();
		BeanUtils.copyProperties(IndicatorLightReq, IndicatorLight);
		String IndicatorLightId = UUIDUtil.UUID();
		IndicatorLight.setId(IndicatorLightId);
		IndicatorLight.setCompanyId(companyId);
		IndicatorLight.setDriverId(driverId);
		IndicatorLight.setCarId(carId);
		carManageMapper.insertCarIndicatorLight(IndicatorLight);
		
		CarTireReq tireReq = dailyInspectionReq.getTire();
		CarTire tire = new CarTire();
		BeanUtils.copyProperties(tireReq, tire);
		String tireId = UUIDUtil.UUID();
		tire.setId(tireId);
		tire.setCompanyId(companyId);
		tire.setDriverId(driverId);
		tire.setCarId(carId);
		carManageMapper.insertCarTire(tire);
		
		CarDailyInspection  dailyInspection = new CarDailyInspection();
		dailyInspection.setAirPressureCoolantId(airPressureCoolantId);
		dailyInspection.setAirPressureCoolantCount(airPressureCoolant.getCount());
		
		/*dailyInspection.setDocumentsId(documentsId);
		dailyInspection.setDocumentsCount(documents.getCount());*/
		
		dailyInspection.setEngineOilId(engineOilId);
		dailyInspection.setEngineOilCount(engineOil.getCount());
		
		dailyInspection.setSafetyEquipmentId(safetyEquipmentId);
		dailyInspection.setSafetyEquipmentCount(safetyEquipment.getCount());
		
		dailyInspection.setIndicatorLightId(IndicatorLightId);
		dailyInspection.setIndicatorLightCount(IndicatorLight.getCount());
		
		dailyInspection.setTireId(tireId);
		dailyInspection.setTireCount(tire.getCount());
		
		dailyInspection.setCarId(carId);
		dailyInspection.setCompanyId(companyId);
		dailyInspection.setDriverId(driverId);
		dailyInspection.setId(UUIDUtil.UUID());
		int result = carManageMapper.insertCarDailyInspection(dailyInspection);
		return result;
	}

	@Override
	public int addCarDriveRest(CarDriveRest record) {
		if(Status.CarManage_Type_End == record.getType()){
			return carManageMapper.deleteCarDriveRest(record.getCarId());
		}
		if(Status.CarManage_Type_Start == record.getType()){
			carManageMapper.deleteCarDriveRest(record.getCarId());
		}
		return carManageMapper.insertCarDriveRest(record);
	}

	@Override
	public List<Map<String, Object>> queryTransporterWaybillList(String companyId) {
		return carManageMapper.queryTransporterWaybillList(companyId);
	}

	@Override
	public Map<String, Object> queryDriverWaybill(String companyId, String driverId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  List<Map<String, Object>> queryTransporterCarDailyInspectionList(String companyId) {
		Date currentDate = new Date();
		return carManageMapper.queryTransporterCarDailyInspectionList(companyId,currentDate);
	}
	@Override
	public Map<String, Object> queryTransporterCarDriveRestList(String companyId) {
		Date currentDate = new Date();
		Map<String,Object> result = carManageMapper.queryTransporterCarDriveRestListCount(companyId,currentDate);
		if(result !=null){
			List<Map<String,Object>> resultList = carManageMapper.queryTransporterCarDriveRestList(companyId,currentDate);
			result.put("list", resultList);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> queryCarDriveRestDetail(String carId) {
		return carManageMapper.queryCarDriveRestDetail(carId);
	}

	@Override
	public Map<String, Object> indexDriver(String companyId,String driverId) {
		Map<String,Object> result = new HashMap<String,Object>();
		Date currentDate = new Date();
		//保险,路税,车检提醒
		Map<String,Object> carNotice  = carManageMapper.queryIndexDriverCarNotice(companyId, driverId,currentDate);
		if(carNotice!=null)
			result.putAll(carNotice);
		//1.我的运单
		Map<String,Object> waybill = carManageMapper.queryIndexDriverWaybill(companyId, driverId);
		if(waybill !=null)
			result.putAll(waybill);
		//2.每日一检
		Map<String,Object> dailyInspenction = carManageMapper.queryIndexDriverCarDailyInspection(companyId, driverId, currentDate);
		if(dailyInspenction != null)
		result.putAll(dailyInspenction);
		//3.司机休息
		Map<String,Object> driveRest = carManageMapper.queryIndexDriverCarDriveRest(companyId, driverId,currentDate);
		if(driveRest != null){
			result.putAll(driveRest);
		}
		return result;
	}
	@Override
	public Map<String, Object> indexTransporter(String companyId) {
		Date currentDate = new Date();
		//保险,路税,车检提醒
		Map<String,Object> result = carManageMapper.queryIndexTransporterCarNotice(companyId, currentDate);
		//我的运单
		Map<String,Object> waybill = carManageMapper.queryIndexTransporterWaybill(companyId);
		if(waybill !=null)
		  result.putAll(waybill);
		//每日一检
		Map<String,Object> dailyInspenction = carManageMapper.queryIndexTransporterDailyInspection(companyId, currentDate);
		if(dailyInspenction != null)
		result.putAll(dailyInspenction);
		//行车休息
		Map<String,Object> driveRest = carManageMapper.queryIndexTransporterCarDriveRest(companyId);
		if(driveRest != null){
			result.putAll(driveRest);
		}
		return result;
	}

	@Override
	public Map<String, Object> detailCarAirPressureCoolant(String id) {
		return carManageMapper.selectCarAirPressureCoolant(id);
	}

//	@Override
//	public Map<String, Object> detailCarDocuments(String id) {
//		return carManageMapper.selectCarDocuments(id);
//	}

	@Override
	public Map<String, Object> detailCarEngineOil(String id) {
		return carManageMapper.selectCarEngineOil(id);
	}

	@Override
	public Map<String, Object> detailCarSafetyEquipment(String id) {
		return carManageMapper.selectCarSafetyEquipment(id);
	}

	@Override
	public Map<String, Object> detailCarIndicatorLight(String id) {
		return carManageMapper.selectCarIndicatorLight(id);
	}

	@Override
	public Map<String, Object> detailCarTire(String id) {
		return carManageMapper.selectCarTire(id);
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

	@Override
	public List<Map<String, Object>> queryCarInsuranceList(String companyId) {
		Date currentDate = new Date();
		return carManageMapper.queryCarInsuranceList(companyId, currentDate);
	}

	@Override
	public List<Map<String, Object>> queryCarTaxList(String companyId) {
		Date currentDate = new Date();
		return carManageMapper.queryCarTaxList(companyId, currentDate);
	}

	@Override
	public List<Map<String, Object>> queryCarCheckList(String companyId) {
		Date currentDate = new Date();
		return carManageMapper.queryCarCheckList(companyId, currentDate);
	}

	@Override
	public Map<String, Object> queryTransporterWaybill(String carId) {
		return carManageMapper.queryTransporterWaybill(carId);
	}

	@Override
	public Map<String, Object> queryCarDailyInspection(String carId) {
		Date currentDate = new Date();
		return carManageMapper.queryCarDailyInspection(carId, currentDate);
	}

	@Override
	public List<Map<String, Object>> listCarMaintenance(CarMaintenanceReq carMaintenaceReq) {
		return carManageMapper.queryCarMaintenanceList(carMaintenaceReq);
	}

	
}
