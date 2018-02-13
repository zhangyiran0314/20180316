<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>detail</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css"/>
</head>
<style>
body{padding: 20px; /*overflow-y: scroll;*/}
</style>
<body>
	<form class="layui-form" style="width:80%;">
	<input type="hidden" id ="objectId" name="id" value="${objectId}"/>
		<div class="layui-form-item">
		    <div class="layui-input-inline">
				<label class="layui-form-label">车主公司</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input companyName">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">车主姓</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input transporterSurname">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">车主名</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input transporterName">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">车主电话</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input transporterMobile">
				</div>
			</div>
		</div>
		
	   <div class="layui-form-item">
			<div class="layui-input-inline">
				<label class="layui-form-label">车辆名称</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input name">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">车牌号码</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input code">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">车牌</label>
			<div class="layui-input-block attachment1">
			</div>
		</div>
		
		 <div class="layui-form-item">
				<label class="layui-form-label">登记号码</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input registerNo">
				</div>
		</div>
		<div class="layui-form-item" >
			<label class="layui-form-label">车辆登记证</label>
			<div class="layui-input-block attachment2">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">保险</label>
			<div class="layui-input-inline">
				<label class="layui-form-label">开始时间</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input insuranceStartDate">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">结束时间</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input insuranceEndDate">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">保险照</label>
			<div class="layui-input-block attachment3">
			</div>
		</div>
		
			
		<div class="layui-form-item">
			<label class="layui-form-label">路税</label>
			<div class="layui-input-inline">
				<label class="layui-form-label">开始时间</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input taxStartDate">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">结束时间</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input taxEndDate">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">路税照</label>
			<div class="layui-input-block attachment4">
			</div>
		</div>
		
			
		<div class="layui-form-item">
			<label class="layui-form-label">车检</label>
			<div class="layui-input-inline">
				<label class="layui-form-label">开始时间</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input checkStartDate">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">结束时间</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input checkEndDate">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">车检照</label>
			<div class="layui-input-block attachment5">
			</div>
		</div>
		
		<div class="layui-form-item div_driver" style="display:none">
			<div class="layui-input-inline">
				<label class="layui-form-label">司机姓</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input driverSurname">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">司机名</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input driverName">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">司机电话</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input driverMobile">
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="<%=request.getContextPath()%>/layui/layui.js"></script>
<script type="text/javascript">
layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','laydate'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		laydate = layui.laydate,
		$ = layui.jquery;
		 //监听提交
		  form.on('submit(save)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    
		    $.ajax({  
                url: "<%=request.getContextPath()%>/transporter/car/editAuth",
                type: "post",
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(data.field),
                //contentType: "application/json",
                success: function (data) {
                	if(data.code ==0){
                		parent.layer.closeAll();
                		parent.location.reload();
                	}else{
                		layer.alert(data.msg, {
							title: '提示信息'
						}); 
                	}
                },  
                error: function(XMLHttpRequest, textStatus, errorThrown) {  
	                if(textStatus=="parsererror"){
	                	window.location.href = "<%=request.getContextPath()%>/login";
	                }else{
	                	//alert("request error....");
	                } 	                
	            }  
			});    
		    return false;
		  });
	//数据填充
	var objectId = $("#objectId").val();
	if(objectId!=""){
		$.ajax({
			url : "<%=request.getContextPath()%>/transporter/car/detail",
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
		$(".companyName").val(data.companyName);  
		$(".transporterSurname").val(data.transporterSurname);  
		$(".transporterName").val(data.transporterName);  
		$(".transporterMobile").val(data.transporterMobile); 
		
		if(data.driverMobile !=undefined){
			$(".div_driver").show();
			$(".driverSurname").val(data.driverSurname);  
			$(".driverName").val(data.driverName);  
			$(".driverMobile").val(data.driverMobile); 
		}
		
		$(".code").val(data.code);  
		$(".name").val(data.name);  
		
		$(".registerNo").val(data.registerNo); 
		
		$(".insuranceStartDate").val(data.insuranceStartDate); 
		$(".insuranceEndDate").val(data.insuranceEndDate);
		
		$(".taxStartDate").val(data.taxStartDate); 
		$(".taxEndDate").val(data.taxEndDate);
		
		$(".checkStartDate").val(data.checkStartDate); 
		$(".checkEndDate").val(data.checkEndDate);
		
		if(data.attachmentId1Link!=undefined){
			$(".attachment1").append("<img src="+data.attachmentId1Link+">");
		}
		if(data.attachmentId2Link!=undefined){
			$(".attachment2").append("<img src="+data.attachmentId2Link+">");
		}
		if(data.attachmentId3Link!=undefined){
			$(".attachment3").append("<img src="+data.attachmentId3Link+">");
		}
		if(data.attachmentId4Link!=undefined){
			$(".attachment4").append("<img src="+data.attachmentId4Link+">");
		}
		if(data.attachmentId5Link!=undefined){
			$(".attachment5").append("<img src="+data.attachmentId5Link+">");
		}
	}
})
</script>
</body>
</html>