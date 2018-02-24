<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>manage</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css"/>
</head>
<style>
body{padding: 20px; /*overflow-y: scroll;*/}
</style>
<body>
	<form class="layui-form" style="width:80%;">
	<input type="hidden" id ="objectId" name="id" value="${objectId}"/>
		<div class="layui-form-item">
			<label class="layui-form-label">手机号码</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input mobile">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">姓</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input surname">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">名</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input name">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">邮箱</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input email">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">身份证</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input cardNo">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">驾驶证</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input drivingLicenseNo">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">GDL</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input gdl">
			</div>
		</div>
		<div class="layui-form-item div_attachment2" style="display:none">
			<label class="layui-form-label">身份证</label>
			<div class="layui-input-block attachment2">
			</div>
		</div>
		<div class="layui-form-item  div_attachment3" style="display:none">
			<label class="layui-form-label">确认书/授权书</label>
			<div class="layui-input-block attachment3">
			</div>
		</div>
		<div class="layui-form-item  div_attachment1" style="display:none">
			<label class="layui-form-label">名片照</label>
			<div class="layui-input-block attachment1">
			</div>
		</div>
		<div class="layui-form-item  div_attachment4" style="display:none">
			<label class="layui-form-label">驾驶证照</label>
			<div class="layui-input-block attachment4">
			</div>
		</div>
		<div class="layui-form-item  div_attachment5" style="display:none">
			<label class="layui-form-label">GDL照</label>
			<div class="layui-input-block attachment5">
			</div>
		</div>
	     <div class="layui-form-item">
		    <label class="layui-form-label">审核状态</label>
		    <div class="layui-input-block">
		     <!--  <input type="checkbox" name="authStatus" lay-skin="switch" value="2"> -->
		      	  <input type="radio" name="authStatus" value="0" title="未认证">
			      <input type="radio" name="authStatus" value="1" title="待审核">
			      <input type="radio" name="authStatus" value="2" title="审核通过" checked>
		    </div>
		  </div>
	    <div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="save">立即提交</button>
				<!-- <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
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
                url: "<%=request.getContextPath()%>/transporter/user/editAuth",
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
			url : "<%=request.getContextPath()%>/transporter/user/detail",
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
		$(".mobile").val(data.mobile);     
		$(".surname").val(data.surname);  
		$(".name").val(data.name);  
		$(".email").val(data.email);
		$(".cardNo").val(data.cardNo);  
		$(".drivingLicenseNo").val(data.drivingLicenseNo);  
		$(".gdl").val(data.gdl);  
		if(data.attachmentId1Link!=undefined){
			$(".div_attachment1").show();
			$(".attachment1").append("<img src="+data.attachmentId1Link+" height='300' width='300'>");
		}
		if(data.attachmentId2Link!=undefined){
			$(".div_attachment2").show();
			$(".attachment2").append("<img src="+data.attachmentId2Link+" height='300' width='300'>");
		}
		if(data.attachmentId3Link!=undefined){
			$(".div_attachment3").show();
			$(".attachment3").append("<img src="+data.attachmentId3Link+" height='300' width='300'>");
		}
		if(data.attachmentId4Link!=undefined){
			$(".div_attachment4").show();
			$(".attachment4").append("<img src="+data.attachmentId4Link+" height='300' width='300'>");
		}
		if(data.attachmentId5Link!=undefined){
			$(".div_attachment5").show();
			$(".attachment5").append("<img src="+data.attachmentId5Link+" height='300' width='300'>");
		}
	}
})
</script>
</body>
</html>