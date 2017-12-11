package com.iflytransporter.api.bean;

import com.iflytransporter.common.bean.Order;

public class OrderParam extends Order{
	
	private static final long serialVersionUID = 1L;
	
	//添加到货源
	private boolean addGoodsSource;

	public boolean isAddGoodsSource() {
		return addGoodsSource;
	}

	public void setAddGoodsSource(boolean addGoodsSource) {
		this.addGoodsSource = addGoodsSource;
	}
	
}
