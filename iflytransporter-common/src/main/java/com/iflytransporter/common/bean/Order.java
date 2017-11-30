package com.iflytransporter.common.bean;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.iflytransporter.common.base.BaseEntity;

public class Order extends BaseEntity{
	private static final long serialVersionUID = 1L;

    private String departure;

    private String destination;

    private Date deliverDate;

    private Integer costs;

    private String remark;

    private Short status;

    private String shipperId;

    private String insuranceId;
    
    private String carTypeId;

    private String goodsTypeId;

    private String goodsUnitId;

    private Integer repeatFlag;


    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure == null ? null : departure.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }


    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Integer getCosts() {
        return costs;
    }

    public void setCosts(Integer costs) {
        this.costs = costs;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getShipperId() {
        return shipperId;
    }

    public void setShipperId(String shipperId) {
        this.shipperId = shipperId == null ? null : shipperId.trim();
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId == null ? null : insuranceId.trim();
    }
    
    public String getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(String carTypeId) {
		this.carTypeId = carTypeId;
	}

	public String getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getGoodsUnitId() {
		return goodsUnitId;
	}

	public void setGoodsUnitId(String goodsUnitId) {
		this.goodsUnitId = goodsUnitId;
	}


	public Integer getRepeatFlag() {
		return repeatFlag;
	}

	public void setRepeatFlag(Integer repeatFlag) {
		this.repeatFlag = repeatFlag;
	}

	@Override
  	public String toString() {
    	  return JSONObject.toJSONString(this).toString();
  	}
}