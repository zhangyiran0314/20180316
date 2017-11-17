<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
	<title>会员添加--layui后台管理模板</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css" media="all" />
	<style type="text/css">
		.layui-form-item .layui-inline{ width:33.333%; float:left; margin-right:0; }
		@media(max-width:1240px){
			.layui-form-item .layui-inline{ width:100%; float:none; }
		}
	</style>
</head>
<body class="childrenBody">
<input type="hidden" id ="objectId" name="objectId" value="${objectId}"/>
	<form class="layui-form" style="width:80%;">
		<div class="layui-form-item">
			<label class="layui-form-label">出发地</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input departure">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">目的地</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input destination">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">车辆类型</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input carTypeValue">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">货物类型</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input goodsTypeValue">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">计量单位</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input goodsUnitValue">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">发货日期</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input deliverDate">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">是否重发</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input repeatFlag">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">货主</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input shipperId">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">保险</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input insuranceId">
			</div>
		</div>
		
		<div class="layui-form-item">
		    <label class="layui-form-label">createDate</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input createDate">
			</div>
	    </div>
		
		<div class="layui-form-item">
		    <label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input remark">
			</div>
	    </div>
	</form>
	<script type="text/javascript" src="<%=request.getContextPath()%>/layui/layui.js"></script>
	<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/user/editUser.js"></script> --%>
<script type="text/javascript">
layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		laydate = layui.laydate,
		$ = layui.jquery;
	
	//数据填充
	var objectId = $("#objectId").val();
	if(objectId!=""){
		$.ajax({
			url : "/waybill/detail",
			type : "get",
			data:{id:objectId},
			dataType : "json",
			success : function(result){
				fillData(result.data);
			}
		})
	}
	//填充数据方法
	function fillData(data){
		$(".departure").val(data.departure);     
		$(".destination").val(data.destination);     
		$(".carTypeValue").val(data.carTypeValue);     
		$(".goodsTypeValue").val(data.goodsTypeValue);  
		$(".goodsUnitValue").val(data.goodsUnitValue);    
		$(".deliverDate").val(data.deliverDate);   
		$(".remark").val(data.remark);   
		$(".repeatFlag").val(data.repeatFlag);   
		$(".shipperId").val(data.shipperId); 
		$(".insuranceId").val(data.insuranceId); 
		$(".createDate").val(data.createDate); 
	}
})
</script>
</body>
</html>