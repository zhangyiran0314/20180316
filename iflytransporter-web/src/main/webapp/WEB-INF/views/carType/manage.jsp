<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
	<title>用户总数--layui后台管理模板</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css" media="all" />
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote news_search layui-form ">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<label class="layui-form-label">关键字</label>
		    	<div class="layui-input-block">
		    		<input type="text" value="" placeholder="请输入关键字" class="layui-input search_input">
		    	</div>
		    </div>
		</div>
		<div class="layui-inline">
		    <label class="layui-form-label">查询日期</label>
		    <div class="layui-input-block">
		    	<input type="text" value="" placeholder="请输入查询日期" lay-verify="required|date" onclick="layui.laydate({elem: this,max: laydate.now()})" class="layui-input userBirthday">
		    </div>
		</div>
		<a class="layui-btn search_btn">查询</a>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal dataAdd_btn">添加用户</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-danger batchDel">批量删除</a>
		</div>
	</blockquote>
	
	<table class="layui-hide" id="table" lay-filter="table"></table>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/layui/layui.js"></script>
<script type="text/javascript">
layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','laydate','table'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		laydate = layui.laydate,
		$ = layui.jquery;
		table = layui.table;
	
		table.render({
		    elem: '#table'
		    ,height: 315
		    ,url: '<%=request.getContextPath()%>/carType/queryPage' //数据接口
		    ,page: true //开启分页
		    ,cols: [[ //表头
		        {checkbox: true, fixed: true},
                {field: 'id', title: 'ID', width: '170', sort: true}, 
                {field:'name',title:'名称', width:'180'},
                {field:'code',title:'对应编码', width:'180'},
                {field:'createDate',title:'创建人', width:'180'},
                {field:'updateDate',title:'创建时间', width:'180'}
                
		    ]]
		  });
		 table.on('checkbox(table)', function(obj){
	           console.log(obj)
	     });
})
</script>
<script type="text/html" id="bar">
	  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
</script>	
</body>
</html>