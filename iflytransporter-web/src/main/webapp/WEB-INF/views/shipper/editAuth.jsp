<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<input type="hidden" id ="objectId" name="objectId" value="${objectId}"/>
	<form class="layui-form" style="width:80%;">
		<div class="layui-form-item">
			<label class="layui-form-label">mobile</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input mobile" name="mobile">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">姓</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input surname" name="surname">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">名</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input name" name="name">
			</div>
		</div>
	     <div class="layui-form-item">
		    <label class="layui-form-label">审核状态</label>
		    <div class="layui-input-block">
		      <input type="checkbox" name="authStatus" lay-skin="switch" value="2">
		    </div>
		  </div>
	    <div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="save">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
                url: "<%=request.getContextPath()%>/shipper/editAuth",
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
			url : "<%=request.getContextPath()%>/shipper/detail",
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
	}
})
</script>
</body>
</html>