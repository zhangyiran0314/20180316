<%@ include file="../../common.jsp"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>detail</title>
</head>
<style>
body{padding: 20px; /*overflow-y: scroll;*/}
</style>
<body class="childrenBody">
<input type="hidden" id ="objectId" name="objectId" value="${objectId}"/>
	<form class="layui-form" style="width:80%;">
		<div class="layui-form-item">
			<label class="layui-form-label">出发地</label>
			 <div class="layui-input-inline">
					<label class="layui-form-label">省份</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input departureProvince">
					</div>
			</div>
			 <div class="layui-input-inline">
					<label class="layui-form-label">城市</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input departureCity">
					</div>
			</div>
			 <div class="layui-input-inline">
					<label class="layui-form-label">地区</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input departureArea">
					</div>
			 </div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">目的地</label>
			<div class="layui-input-inline">
					<label class="layui-form-label">省份</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input destinationProvince">
					</div>
			</div>
			 <div class="layui-input-inline">
					<label class="layui-form-label">城市</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input destinationCity">
					</div>
			</div>
			 <div class="layui-input-inline">
					<label class="layui-form-label">地区</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input destinationArea">
					</div>
			 </div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用车类型</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input useType">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">车辆类型</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input carType">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">货物类型</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input goodsType">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">装卸类型</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input handlingType">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">支付类型</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input paymentType">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">重量</label>
			<div class="layui-input-inline">
				<label class="layui-form-label">数值</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input weight">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">单位</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input goodsUnits">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">其他</label>
			<div class="layui-input-inline">
				<label class="layui-form-label">长</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input length">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">宽</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input width">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">高</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input height">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">发货日期</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input deliverDate">
			</div>
		</div>
		<!-- <div class="layui-form-item">
			<label class="layui-form-label">是否重发</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input repeatFlag">
			</div>
		</div> -->
		
		<div class="layui-form-item">
			<label class="layui-form-label">货主</label>
			<div class="layui-input-inline">
				<label class="layui-form-label">姓</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input surname">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">名</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input name">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">货主电话</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input mobile">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">公司</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input companyName">
			</div>
		</div>
		
		<div class="layui-form-item">
		    <label class="layui-form-label">创建时间</label>
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
<script type="text/javascript">
layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','laydate'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		laydate = layui.laydate,
		$ = layui.jquery;
	
	//数据填充
	var objectId = $("#objectId").val();
	if(objectId!=""){
		$.ajax({
			url : "<%=request.getContextPath()%>/shipper/order/detail",
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
		$(".departureProvince").val(data.departureProvince.name);    
		$(".departureCity").val(data.departureCity.name);  
		$(".departureArea").val(data.departureArea.name);  
		
		$(".destinationProvince").val(data.destinationProvince.name);    
		$(".destinationCity").val(data.destinationCity.name);  
		$(".destinationArea").val(data.destinationArea.name);
		
		$(".useType").val(data.useType.name); 
		$(".carType").val(data.carType.name);     
		$(".goodsType").val(data.goodsType);  
		$(".handlingType").val(data.handlingType.name); 
		$(".paymentType").val(data.paymentType.name); 
		
		$(".length").val(data.length);  
		$(".height").val(data.height);  
		$(".width").val(data.width);  
		
		$(".weight").val(data.weight);    
		$(".goodsUnits").val(data.goodsUnits);    
		
		$(".deliverDate").val(data.deliverDate);   
		$(".remark").val(data.remark);   
		$(".repeatFlag").val(data.repeatFlag);   
		$(".createDate").val(data.createDate); 
		
		$(".surname").val(data.surname); 
		$(".name").val(data.name); 
		$(".mobile").val(data.mobile); 
		$(".companyName").val(data.companyName); 
	}
})
</script>
</body>
</html>