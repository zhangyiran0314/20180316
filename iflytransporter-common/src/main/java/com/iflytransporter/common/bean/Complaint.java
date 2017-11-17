package com.iflytransporter.common.bean;

import java.util.Date;

import com.iflytransporter.common.base.BaseEntity;

public class Complaint extends BaseEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String content;

    private String waybillId;

    private String shipperId;

    private String transporterId;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId == null ? null : waybillId.trim();
    }

    public String getShipperId() {
        return shipperId;
    }

    public void setShipperId(String shipperId) {
        this.shipperId = shipperId == null ? null : shipperId.trim();
    }

    public String getTransporterId() {
        return transporterId;
    }

    public void setTransporterId(String transporterId) {
        this.transporterId = transporterId == null ? null : transporterId.trim();
    }
}