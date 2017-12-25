<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>修改</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css"/>
</head>
<body>
<input type="hidden" id ="objectId" name="objectId" value="${objectId}"/>
	<form class="layui-form" style="width:80%;">
		<div class="layui-form-item">
			<label class="layui-form-label">名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input name">
			</div>
		</div>
		<!-- <div class="layui-form-item">
			<label class="layui-form-label">status</label>
			<div class="layui-input-block">
				<select name="status" class="status" lay-filter="status">
					<option value="0">已注册</option>
					<option value="1">已认证</option>
			        <option value="2">已激活</option>
			    </select>
			</div>
		</div>  -->
	    <div class="layui-form-item">
		    <label class="layui-form-label">对应编码</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input code">
			</div>
	    </div>
		<div class="layui-form-item">
		    <label class="layui-form-label">createDate</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input createDate">
			</div>
	    </div>
	    <div class="layui-form-item">
		    <label class="layui-form-label">updateDate</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input updateDate">
			</div>
	    </div>
	    <div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addUser">提交</button>
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
	
	//数据填充
	var objectId = $("#objectId").val();
	if(objectId!=""){
		$.ajax({
			url : "<%=request.getContextPath()%>/carType/detail",
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
		$(".updateDate").val(data.updateDate);   
	}
})
</script>
</body>
</html>