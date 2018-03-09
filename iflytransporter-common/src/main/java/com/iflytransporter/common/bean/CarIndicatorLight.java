package com.iflytransporter.common.bean;

import java.util.Date;

public class CarIndicatorLight {
    private String id;

    private Date createDate;

    private Date updateDate;

    private Short dataStatus;

    private String desp;

    private String companyId;

    private String driverId;

    private String carId;

    private Integer signalLamp;

    private Integer headLamp;

    private Integer sideMirror;

    private Integer temperatureMeter;

    private Integer doubleSignal;

    private Integer tachometer;

    private Integer odometer;

    private Integer fuelMeter;

    private Integer beaconLampFunction;

    private Integer horn;

    private Integer wiperCondition;

    private Integer handBrake;

    private Integer steering;

    private String remark;
    /**统计当前对象是否故障*/
    public int getCount(){
    	return signalLamp+headLamp+sideMirror+temperatureMeter+doubleSignal
    			+tachometer+odometer+fuelMeter+beaconLampFunction+horn+wiperCondition+handBrake+steering;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Short getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Short dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp == null ? null : desp.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public Integer getSignalLamp() {
        return signalLamp;
    }

    public void setSignalLamp(Integer signalLamp) {
        this.signalLamp = signalLamp;
    }

    public Integer getHeadLamp() {
        return headLamp;
    }

    public void setHeadLamp(Integer headLamp) {
        this.headLamp = headLamp;
    }

    public Integer getSideMirror() {
        return sideMirror;
    }

    public void setSideMirror(Integer sideMirror) {
        this.sideMirror = sideMirror;
    }


    public Integer getTemperatureMeter() {
		return temperatureMeter;
	}

	public void setTemperatureMeter(Integer temperatureMeter) {
		this.temperatureMeter = temperatureMeter;
	}

	public Integer getDoubleSignal() {
        return doubleSignal;
    }

    public void setDoubleSignal(Integer doubleSignal) {
        this.doubleSignal = doubleSignal;
    }

    public Integer getTachometer() {
        return tachometer;
    }

    public void setTachometer(Integer tachometer) {
        this.tachometer = tachometer;
    }

    public Integer getOdometer() {
        return odometer;
    }

    public void setOdometer(Integer odometer) {
        this.odometer = odometer;
    }

    public Integer getFuelMeter() {
        return fuelMeter;
    }

    public void setFuelMeter(Integer fuelMeter) {
        this.fuelMeter = fuelMeter;
    }

    public Integer getBeaconLampFunction() {
        return beaconLampFunction;
    }

    public void setBeaconLampFunction(Integer beaconLampFunction) {
        this.beaconLampFunction = beaconLampFunction;
    }

    public Integer getHorn() {
        return horn;
    }

    public void setHorn(Integer horn) {
        this.horn = horn;
    }

    public Integer getWiperCondition() {
        return wiperCondition;
    }

    public void setWiperCondition(Integer wiperCondition) {
        this.wiperCondition = wiperCondition;
    }

    public Integer getHandBrake() {
        return handBrake;
    }

    public void setHandBrake(Integer handBrake) {
        this.handBrake = handBrake;
    }

    public Integer getSteering() {
        return steering;
    }

    public void setSteering(Integer steering) {
        this.steering = steering;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}