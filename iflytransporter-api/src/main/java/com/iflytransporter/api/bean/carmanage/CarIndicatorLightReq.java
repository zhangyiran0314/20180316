package com.iflytransporter.api.bean.carmanage;

import java.util.Date;

public class CarIndicatorLightReq {

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