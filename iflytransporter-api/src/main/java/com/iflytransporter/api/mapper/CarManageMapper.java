package com.iflytransporter.api.mapper;

import java.util.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	
	Map<String,Object> selectCarAirCoolant(String id);
	
	Map<String,Object> selectCarDocuments(String id);
	
	Map<String,Object> selectCarEngineOil(String id);
	
	Map<String,Object> selectCarSafetyEquipment(String id);
	
	Map<String,Object> selectCarSignalLight(String id);
	
	Map<String,Object> selectCarTyre(String id);
	
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
	
	
	//司机-我的运单
	Map<String,Object> queryIndexDriverWaybill(@Param("companyId")String companyId,@Param("driverId")String driverId);
	//司机-每日一检
	Map<String,Object> queryIndexDriverCarDailyInspection(@Param("companyId")String companyId,@Param("driverId")String driverId,@Param("currentDate")Date currentDate);
	Map<String,Object> queryDriverCarDailyInspection(@Param("companyId")String companyId,@Param("driverId")String driverId,@Param("currentDate")Date currentDate);
	//司机-司机休息
	Map<String,Object> queryIndexDriverCarDriveRest(@Param("companyId")String companyId,@Param("driverId")String driverId);
	//司机-保险,路税,车检提醒
	Map<String,Object> queryIndexDriverCarNotice(@Param("companyId")String companyId,@Param("driverId")String driverId,@Param("currentDate")Date currentDate);
	
	
	//保险提醒
	Map<String,Object> queryCarInsurance(@Param("companyId")String companyId,@Param("driverId")String driverId,@Param("currentDate")Date currentDate);
	Map<String,Object> queryCarInsuranceList(@Param("companyId")String companyId,@Param("driverId")String driverId,@Param("currentDate")Date currentDate);
	Map<String,Object> queryCarInsuranceDetail(@Param("carId")String carId);
	//路税提醒
	Map<String,Object> queryCarTax(@Param("companyId")String companyId,@Param("driverId")String driverId,@Param("currentDate")Date currentDate);
	Map<String,Object> queryCarTaxList(@Param("companyId")String companyId,@Param("driverId")String driverId,@Param("currentDate")Date currentDate);
	Map<String,Object> queryCarTaxDetail(String carId);
	//年检提醒
	Map<String,Object> queryCarCheck(@Param("companyId")String companyId,@Param("driverId")String driverId,@Param("currentDate")Date currentDate);
	Map<String,Object> queryCarCheckList(@Param("companyId")String companyId,@Param("driverId")String driverId,@Param("currentDate")Date currentDate);
	Map<String,Object> queryCarCheckDetail(@Param("carId")String carId);
}
