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
	
	//用户级别
	public static int User_Level_Visitor  = 0;
	public static int User_Level_Admin = 1;
	public static int User_Level_Staff =2;
	
	//用户认证状态
	public static int Auth_No = 0;//未认证
	public static int Auth_Pending = 1;//待审核
	public static int Auth_Yes  = 2;//成功
	/**数据有效*/
	public static int Status_Valid = 0;//有效
	public static int Status_Invalid = 1;//失效
	
	/**订单部分*/
	//订单状态
	public static int Order_Publish =0;//发布中-待审核
	public static int Order_Transfer =1;//已关闭-已转运单
	public static int Order_Cancel=2;//已关闭-已取消
	//授权状态
	public static int Order_Auth_No=0;//待授权
	public static int Order_Auth_Yes=1;//已授权
	public static int Order_Auth_Cancel=2;//取消授权
	//审核状态
	public static int Order_Audit_No=0;//待审核
	public static int Order_Audit_Yes=1;//已审核
	public static int Order_Audit_Cancel=2;//取消审核
	
	/**运单部分*/
	public static int Waybill_For_Loading = 0;//待装车
	public static int Waybill_In_Transit = 1;//运输中
	public static int Waybill_To_Confirm = 2;//待确认
	public static int Waybill_Finish = 3;//已完结
	
	
}
