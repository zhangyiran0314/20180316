package com.iflytransporter.api.bean.carmanage;


public class CarDailyInspectionReq {
	
	private String carId;
	
//	private CarAirCoolantReq airCoolant;
	
//	private CarDocumentsReq documents;
	
	private CarEngineOilReq engineOil;
	
	private CarSafetyEquipmentReq safetyEquipment;
	
//	private CarIndicatorLightReq IndicatorLight;
	
//	private CarTyreReq tyre;

	private CarAirPressureCoolantReq airePressureCoolant;
	
	private CarIndicatorLightReq indicatorLight;
	
	private CarTireReq tire;
	
	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

//	public CarAirCoolantReq getAirCoolant() {
//		return airCoolant;
//	}
//
//	public void setAirCoolant(CarAirCoolantReq airCoolant) {
//		this.airCoolant = airCoolant;
//	}
//
//	public CarDocumentsReq getDocuments() {
//		return documents;
//	}
//
//	public void setDocuments(CarDocumentsReq documents) {
//		this.documents = documents;
//	}

	public CarEngineOilReq getEngineOil() {
		return engineOil;
	}

	public void setEngineOil(CarEngineOilReq engineOil) {
		this.engineOil = engineOil;
	}

	public CarSafetyEquipmentReq getSafetyEquipment() {
		return safetyEquipment;
	}

	public void setSafetyEquipment(CarSafetyEquipmentReq safetyEquipment) {
		this.safetyEquipment = safetyEquipment;
	}

	public CarAirPressureCoolantReq getAirePressureCoolant() {
		return airePressureCoolant;
	}

	public void setAirePressureCoolant(CarAirPressureCoolantReq airePressureCoolant) {
		this.airePressureCoolant = airePressureCoolant;
	}

	public CarIndicatorLightReq getIndicatorLight() {
		return indicatorLight;
	}

	public void setIndicatorLight(CarIndicatorLightReq indicatorLight) {
		this.indicatorLight = indicatorLight;
	}

	public CarTireReq getTire() {
		return tire;
	}

	public void setTire(CarTireReq tire) {
		this.tire = tire;
	}

//	public CarIndicatorLightReq getIndicatorLight() {
//		return IndicatorLight;
//	}
//
//	public void setIndicatorLight(CarIndicatorLightReq IndicatorLight) {
//		this.IndicatorLight = IndicatorLight;
//	}
//
//	public CarTyreReq getTyre() {
//		return tyre;
//	}
//
//	public void setTyre(CarTyreReq tyre) {
//		this.tyre = tyre;
//	}
//	
	
}
