<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
	<title>用户总数--layui后台管理模板</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../../layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="../../css/user.css" media="all" />
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
	<div class="layui-form data_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="50">
				<col>
				<col width="12%">
				<col width="15%">
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
					<th>name</th>
					<th>createDate</th>
					<th>operation</th>
				</tr> 
		    </thead>
		    <tbody class="data_content"></tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" src="<%=request.getContextPath()%>/layui/layui.js"></script>
	<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/user/list.js"></script> --%>
<script type="text/javascript">
layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		laydate = layui.laydate,
		$ = layui.jquery;
		//分页参数设置 这些全局变量关系到分页的功能
	    var currPageNo = 1; //当前页数(后台返回)
	    var pageSize = 10; //每页多少条
	    var totalPages = 0; //总页数(后台返回)
	    //加载页面数据
	    getDatas();
	    var dataList = '';
	function getDatas(){
	    	$.ajax({
	    		type:"GET",
	    		url:"/province/queryPage",
	    		dataType:"json",
	    		data:{pageNo:currPageNo, pageSize:pageSize,selectValue:$("#search_input").val()},
	    		success:function(result,status){
	    			dataList = result.data.list;
		        	//console.log(data.page)
		        	currPageNo = result.data.pageNum;//当前页数(后台返回)
			        totalPages = result.data.pages;//总页数(后台返回)
			        todoTable(dataList);
		        }
	    	})
	}
	function todoTable(){
		//渲染数据
		function renderDate(data,curr){
			var dataHtml = '';
			if(dataList.length != 0){
				for(var i=0;i<dataList.length;i++){
					dataHtml += '<tr>'
			    	+  '<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>'
			    	+  '<td>'+dataList[i].name+'</td>'
			    	+  '<td>'+dataList[i].createDate+'</td>'
			    	+  '<td>'
			    	+    '<a class="layui-btn layui-btn-mini data_detail" data-id="'+dataList[i].id+'"><i class="iconfont icon-detail" ></i> 查看</a>'
					+    '<a class="layui-btn layui-btn-mini data_edit" data-id="'+dataList[i].id+'"><i class="iconfont icon-edit" ></i> 编辑</a>'
					+    '<a class="layui-btn layui-btn-danger layui-btn-mini data_del" data-id="'+dataList[i].id+'"><i class="layui-icon">&#xe640;</i> 删除</a>'
			        +  '</td>'
			    	+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="8">暂无数据</td></tr>';
			}
		    return dataHtml;
		}

		//分页
		laypage({
			cont: 'page',
			pages: totalPages ,//得到总页数
            curr: currPageNo,//当前页
			jump: function(obj, first) {
				//得到了当前页，用于向服务端请求对应数据
				currPageNo = obj.curr;
				//pageFisrt = (obj.curr-1);
                
                $(".data_content").html(renderDate(dataList,obj.curr));
				$('.data_list thead input[type="checkbox"]').prop("checked",false);
		    	form.render();
		    	
				if(!first) {//一定要加此判断，否则初始时会无限刷新
					getDatas();//一定要把翻页的ajax请求放到这里，不然会请求两次。
					layer.msg('第 '+ obj.curr +' 页');
				}
			}
		})
	}
	
	//查看
	$("body").on("click",".data_detail",function(){  
		var _this = $(this);
		console.log(_this.attr("data-id"));
		//window.sessionStorage.setItem("ui",JSON.stringify(_this.attr("data-id")));
		var index = layui.layer.open({
			title : "Detail",
			type : 2,
			content : "/province/toDetail?id="+_this.attr("data-id"),
			success : function(layero, index){
				setTimeout(function(){
					layui.layer.tips('Click back', '.layui-layer-setwin .layui-layer-close', {
						tips: 3
					});
				},500)
			}
		})
		//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
		$(window).resize(function(){
			layui.layer.full(index);
		})
		layui.layer.full(index);
	})
	
})
</script>
</body>
</html>