package com.iflytransporter.api.bean.carmanage;

public class CarDailyInspectionReq {
	
	private String carId;
	
	private CarAirCoolantReq airCoolant;
	
	private CarDocumentsReq documents;
	
	private CarEngineOilReq engineOil;
	
	private CarSafetyEquipmentReq safetyEquipment;
	
	private CarSignalLightReq signalLight;
	
	private CarTyreReq tyre;

	
	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public CarAirCoolantReq getAirCoolant() {
		return airCoolant;
	}

	public void setAirCoolant(CarAirCoolantReq airCoolant) {
		this.airCoolant = airCoolant;
	}

	public CarDocumentsReq getDocuments() {
		return documents;
	}

	public void setDocuments(CarDocumentsReq documents) {
		this.documents = documents;
	}

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

	public CarSignalLightReq getSignalLight() {
		return signalLight;
	}

	public void setSignalLight(CarSignalLightReq signalLight) {
		this.signalLight = signalLight;
	}

	public CarTyreReq getTyre() {
		return tyre;
	}

	public void setTyre(CarTyreReq tyre) {
		this.tyre = tyre;
	}
	
	
}
