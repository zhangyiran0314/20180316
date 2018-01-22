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
			<label class="layui-form-label">订单号</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input orderNo">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">服务评分</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input serveGrade">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">装车评分</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input loadingGrade">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">货物评分</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input goodsGrade">
			</div>
		</div>
		
		
		<div class="layui-form-item">
	    	<label class="layui-form-label">车主手机</label>
	    	<div class="layui-input-block">
	    		<input type="text"  class="layui-input tMobile">
	    	</div>
	    </div>
	     <div class="layui-form-item">
	    	<label class="layui-form-label">货主公司</label>
	    	<div class="layui-input-block">
	    		<input type="text" class="layui-input sCompanyName">
	    	</div>
	    </div>
	     <div class="layui-form-item">
	    	<label class="layui-form-label">货主手机</label>
	    	<div class="layui-input-block">
	    		<input type="text" class="layui-input sMobile">
	    	</div>
	    </div>
		
		<div class="layui-form-item">
		    <label class="layui-form-label">createDate</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input createDate">
			</div>
	    </div>
		
		<div class="layui-form-item">
		    <label class="layui-form-label">content</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input content">
			</div>
	    </div>
	</form>
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
			url : "/comment/detail",
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
		$(".grade").val(data.grade);     
		$(".shipperId").val(data.shipperId);     
		$(".transporterId").val(data.transporterId);     
		$(".waybillId").val(data.waybillId);  
		$(".content").val(data.content);    
		$(".createDate").val(data.createDate); 
	}
})
</script>
</body>
</html>