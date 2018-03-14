package com.iflytransporter.api.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iflytransporter.api.bean.carmanage.CarMaintenanceReq;
import com.iflytransporter.common.bean.CarAirPressureCoolant;
import com.iflytransporter.common.bean.CarDailyInspection;
import com.iflytransporter.common.bean.CarDocuments;
import com.iflytransporter.common.bean.CarDriveRest;
import com.iflytransporter.common.bean.CarEngineOil;
import com.iflytransporter.common.bean.CarIndicatorLight;
import com.iflytransporter.common.bean.CarSafetyEquipment;
import com.iflytransporter.common.bean.CarTire;

public interface CarManageMapper {
//	int insertCarAirCoolant(CarAirCoolant record);
	int insertCarAirPressureCoolant(CarAirPressureCoolant record);
	int insertCarDocuments(CarDocuments record);
	
	int insertCarEngineOil(CarEngineOil record);
	
	int insertCarSafetyEquipment(CarSafetyEquipment record);
	
//	int insertCarSignalLight(CarSignalLight record);
	int insertCarIndicatorLight(CarIndicatorLight record);
//	int insertCarTyre(CarTyre record);
	int insertCarTire(CarTire record);
	
	Map<String,Object> selectCarAirPressureCoolant(String id);
	
	Map<String,Object> selectCarDocuments(String id);
	
	Map<String,Object> selectCarEngineOil(String id);
	
	Map<String,Object> selectCarSafetyEquipment(String id);
	
	Map<String,Object> selectCarIndicatorLight(String id);
	
//	Map<String,Object> selectCarTyre(String id);
	Map<String,Object> selectCarTire(String id);
	
	int insertCarDailyInspection(CarDailyInspection record);
	
	int insertCarDriveRest(CarDriveRest record);
	
	int deleteCarDriveRest(@Param("carId")String carId);
	
	//车主-首页-我的运单
	Map<String,Object> queryIndexTransporterWaybill(@Param("companyId")String companyId);
	//车主-首页-保险,路税,车检提醒
	Map<String,Object> queryIndexTransporterCarNotice(@Param("companyId")String companyId,@Param("currentDate")Date currentDate);
	//车主-首页-每日一检
	Map<String,Object> queryIndexTransporterDailyInspection(@Param("companyId")String companyId,@Param("currentDate")Date currentDate);
	//车主-首页-行车休息
	Map<String,Object> queryIndexTransporterCarDriveRest(@Param("companyId")String companyId);
	
	//车主-我的运单-列表
	List<Map<String,Object>> queryTransporterWaybillList(@Param("companyId")String companyId);
	//车主-我的运单-详情
	Map<String,Object> queryTransporterWaybill(@Param("carId")String carId);
	//车主-每日一检-列表
	List<Map<String,Object>> queryTransporterCarDailyInspectionList(@Param("companyId")String companyId,@Param("currentDate")Date currentDate);
	//车主-司机休息-列表-统计
	Map<String,Object> queryTransporterCarDriveRestListCount(@Param("companyId")String companyId,@Param("currentDate")Date currentDate);
	//车主-司机休息-列表-数据列表
	List<Map<String,Object>> queryTransporterCarDriveRestList(@Param("companyId")String companyId,@Param("currentDate")Date currentDate);
	
	
	//司机-首页-我的运单
	Map<String,Object> queryIndexDriverWaybill(@Param("companyId")String companyId,@Param("driverId")String driverId);
	//司机-首页-每日一检
	Map<String,Object> queryIndexDriverCarDailyInspection(@Param("companyId")String companyId,@Param("driverId")String driverId,@Param("currentDate")Date currentDate);
	//司机-首页-司机休息
	Map<String,Object> queryIndexDriverCarDriveRest(@Param("companyId")String companyId,@Param("driverId")String driverId,@Param("currentDate")Date currentDate);
	//司机-首页-保险,路税,车检提醒
	Map<String,Object> queryIndexDriverCarNotice(@Param("companyId")String companyId,@Param("driverId")String driverId,@Param("currentDate")Date currentDate);
	
	//行车休息-详情
	List<Map<String,Object>> queryCarDriveRestDetail(@Param("carId")String carId);
	//每日一检-详情
	Map<String,Object> queryCarDailyInspection(@Param("carId")String carId,@Param("currentDate")Date currentDate);
	//保险
	List<Map<String,Object>> queryCarInsuranceList(@Param("companyId")String companyId,@Param("currentDate")Date currentDate);
	Map<String,Object> queryCarInsuranceDetail(@Param("carId")String carId);
	//路税
	List<Map<String,Object>> queryCarTaxList(@Param("companyId")String companyId,@Param("currentDate")Date currentDate);
	Map<String,Object> queryCarTaxDetail(String carId);
	//年检
	List<Map<String,Object>> queryCarCheckList(@Param("companyId")String companyId,@Param("currentDate")Date currentDate);
	Map<String,Object> queryCarCheckDetail(@Param("carId")String carId);
	
	//车辆维修
	List<Map<String,Object>> queryCarMaintenanceList(CarMaintenanceReq carMaintenaceReq);
}
