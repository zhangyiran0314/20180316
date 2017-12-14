package com.iflytransporter.common.enums;

public class Status {
	/**用户类型定义*/
	public static int Type_User_Shipper =0;//货主
	public static int Type_User_Transporter = 1; //车主
	/**状态定义*/
	//用户部分
	public static int User_Register = 0;//用户注册
	public static int User_Identify = 1;//用户认证
	public static int User_Enable  = 2;//用户激活
	
	/**数据有效*/
	public static int Status_Valid = 0;//有效
	public static int Status_Invalid = 1;//失效
	
	/**订单部分*/
	//订单状态
	public static int Order_Publish =0;//待审核
	public static int Order_Transfer =1;//已关闭
	public static int Order_Cancel=2;//已取消
	//审核状态
	public static int Order_Check_No=0;//未授权
	public static int Order_Check_Yes=1;//已授权
	
}
