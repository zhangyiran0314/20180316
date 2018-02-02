package com.iflytransporter.api.mapper;

import java.util.Date;
import java.util.Map;

import com.iflytransporter.common.bean.CarAirCoolant;
import com.iflytransporter.common.bean.CarDailyInspection;
import com.iflytransporter.common.bean.CarDocuments;
import com.iflytransporter.common.bean.CarDriveRest;
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
	
	int insertCarDriveRest(CarDriveRest record);
	
	
	//车主-我的运单
	Map<String,Object> queryTransporterWaybill(String companyId);
	//车主-我的运单-列表
	Map<String,Object> queryTransporterWaybillList(String companyId);
	//车主-每日一检
	Map<String,Object> queryTransporterCarDailyInspection(String companyId,Date currentDate);
	//车主-每日一检-列表
	Map<String,Object> queryTransporterCarDailyInspectionList(String companyId,Date currentDate);
	//车主-司机休息
	Map<String,Object> queryTransporterCarDriveRest(String companyId);
	
	
	//我的运单-司机
	Map<String,Object> queryDriverWaybill(String companyId,String driverId);
	//每日一检-司机
	Map<String,Object> queryDriverCarDailyInspection(String companyId,String driverId,Date currentDate);
	//司机休息-司机
	Map<String,Object> queryDriverCarDriveRest(String companyId,String driverId);
	
	
	//保险提醒
	Map<String,Object> queryCarInsurance(String companyId,String driverId);
	Map<String,Object> queryCarInsuranceList(String companyId,String driverId);
	Map<String,Object> queryCarInsuranceDetail(String carId);
	//路税提醒
	Map<String,Object> queryCarTax(String companyId,String driverId);
	Map<String,Object> queryCarTaxList(String companyId,String driverId);
	Map<String,Object> queryCarTaxDetail(String carId);
	//年检提醒
	Map<String,Object> queryCarCheck(String companyId,String driverId);
	Map<String,Object> queryCarCheckList(String companyId,String driverId);
	Map<String,Object> queryCarCheckDetail(String carId);
}
