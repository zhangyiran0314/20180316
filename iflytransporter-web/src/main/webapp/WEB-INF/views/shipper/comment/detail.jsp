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
	    	<label class="layui-form-label">车主公司</label>
	    	<div class="layui-input-block">
	    		<input type="text" class="layui-input transporterCompanyName">
	    	</div>
	    </div>
	    <div class="layui-form-item">
	    	<label class="layui-form-label">车主手机</label>
	    	<div class="layui-input-block">
	    		<input type="text"  class="layui-input transporterMobile">
	    	</div>
	    </div>
	    <div class="layui-form-item">
	    	<label class="layui-form-label">司机手机</label>
	    	<div class="layui-input-block">
	    		<input type="text"  class="layui-input driverMobile">
	    	</div>
	    </div>
	     <div class="layui-form-item">
	    	<label class="layui-form-label">货主手机</label>
	    	<div class="layui-input-block">
	    		<input type="text" class="layui-input shipperMobile">
	    	</div>
	    </div>
		
		<div class="layui-form-item">
		    <label class="layui-form-label">内容</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input content">
			</div>
	    </div>
	    
	    <div class="layui-form-item div_attachment1" style="display:none">
			<label class="layui-form-label">图片1</label>
			<div class="layui-input-block attachment1">
			</div>
		</div>
		<div class="layui-form-item  div_attachment2" style="display:none">
			<label class="layui-form-label">图片2</label>
			<div class="layui-input-block attachment2">
			</div>
		</div>
		<div class="layui-form-item  div_attachment3" style="display:none">
			<label class="layui-form-label">图片3</label>
			<div class="layui-input-block attachment3">
			</div>
		</div>
		<div class="layui-form-item  div_attachment4" style="display:none">
			<label class="layui-form-label">图片4</label>
			<div class="layui-input-block attachment4">
			</div>
		</div>
		
	    <div class="layui-form-item">
		    <label class="layui-form-label">创建时间</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input createDate">
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
			url : "<%=request.getContextPath()%>/shipper/comment/detail",
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
		$(".orderNo").val(data.orderNo);   
		$(".serveGrade").val(data.serveGrade);    
		$(".loadingGrade").val(data.loadingGrade);     
		$(".goodsGrade").val(data.goodsGrade); 
		
		$(".transporterCompanyName").val(data.transporterCompanyName); 
		$(".transporterMobile").val(data.transporterMobile); 
		$(".driverMobile").val(data.driverMobile); 
		$(".shipperMobile").val(data.shipperMobile); 
		
		$(".content").val(data.content);    
		$(".createDate").val(data.createDate); 
		
		if(data.attachmentId1Link!=undefined){
			$(".div_attachment1").show();
			$(".attachment1").append("<img src="+data.attachmentId1Link+">");
		}
		if(data.attachmentId2Link!=undefined){
			$(".div_attachment2").show();
			$(".attachment2").append("<img src="+data.attachmentId2Link+">");
		}
		if(data.attachmentId3Link!=undefined){
			$(".div_attachment3").show();
			$(".attachment3").append("<img src="+data.attachmentId3Link+">");
		}
		if(data.attachmentId4Link!=undefined){
			$(".div_attachment4").show();
			$(".attachment4").append("<img src="+data.attachmentId4Link+">");
		}
	}
})
</script>
</body>
</html>