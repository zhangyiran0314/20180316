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
			<label class="layui-form-label">名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input name">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">工商注册码</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input code">
			</div>
		</div>
			<label class="layui-form-label">用户</label>
			<div class="layui-input-inline">
					<label class="layui-form-label">姓</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input userSurname">
					</div>
			</div>
			 <div class="layui-input-inline">
					<label class="layui-form-label">名</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input userName">
					</div>
			</div>
			 <div class="layui-input-inline">
					<label class="layui-form-label">手机</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input mobile">
					</div>
			 </div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">创建时间</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input createDate">
			</div>
		</div>
		<div class="layui-form-item div_attachment1" style="display:none">
			<label class="layui-form-label">营业执照</label>
			<div class="layui-input-block attachment1">
			</div>
		</div>
		<div class="layui-form-item div_attachment2" style="display:none">
			<label class="layui-form-label">SPAD照</label>
			<div class="layui-input-block attachment2">
			</div>
		</div>
		<div class="layui-form-item div_attachment3" style="display:none">
			<label class="layui-form-label">公司保单</label>
			<div class="layui-input-block attachment3">
			</div>
		</div>
	      <div class="layui-form-item">
		    <label class="layui-form-label">审核</label>
		    <div class="layui-input-block">
		      
		      <input type="radio" name="status" value="0" title="未认证">
		      <input type="radio" name="status" value="1" title="待审核">
		      <input type="radio" name="status" value="2" title="审核通过" checked>
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
	<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/user/editUser.js"></script> --%>
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
                url: "<%=request.getContextPath()%>/transporter/company/editAuth",
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
			url : "<%=request.getContextPath()%>/transporter/company/detail",
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
		$(".name").val(data.name);
		$(".code").val(data.code);  
		$(".createDate").val(data.createDate); 
		$(".userSurname").val(data.userSurname); 
		$(".userName").val(data.userSurname); 
		$(".mobile").val(data.mobile); 
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
	}
})
</script>
</body>
</html>