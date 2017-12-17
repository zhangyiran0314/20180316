package com.iflytransporter.api.bean;

import com.iflytransporter.common.bean.Order;

public class OrderReq extends Order{
	
	//添加到货源
	private boolean addGoodsSource;
	
	public boolean isAddGoodsSource() {
		return addGoodsSource;
	}

	public void setAddGoodsSource(boolean addGoodsSource) {
		this.addGoodsSource = addGoodsSource;
	}
	
}
