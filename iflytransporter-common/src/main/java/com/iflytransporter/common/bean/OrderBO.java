package com.iflytransporter.common.bean;

import java.util.List;

public class OrderBO extends Order{

	private static final long serialVersionUID = 1L;

	private CarType carType;//车型
	
	private List<OrderApply> applyList;

	public List<OrderApply> getApplyList() {
		return applyList;
	}

	public void setApplyList(List<OrderApply> applyList) {
		this.applyList = applyList;
	}
	
	
}
