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
	<blockquote class="layui-elem-quote news_search layui-form ">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<label class="layui-form-label">公司名称</label>
		    	<div class="layui-input-block">
		    		<input type="text" value="" placeholder="请输入关键字" class="layui-input search_input">
		    	</div>
		    </div>
		</div>
		<!-- <div class="layui-inline">
		    <label class="layui-form-label">查询日期</label>
		    <div class="layui-input-block">
		    	<input type="text" value="" placeholder="请输入查询日期" lay-verify="required|date" onclick="layui.laydate({elem: this,max: laydate.now()})" class="layui-input userBirthday">
		    </div>
		</div> -->
		<a class="layui-btn search_btn">查询</a>
		<!-- <div class="layui-inline">
			<a class="layui-btn layui-btn-normal add_btn">添加</a>
		</div> -->
		<!-- <div class="layui-inline">
			<a class="layui-btn layui-btn-danger batchDel">批量删除</a>
		</div> -->
	</blockquote>
	
	<table id="table" lay-filter="table_filter"></table>
	
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
		    ,id:"layui_table_id"
		    ,url: '<%=request.getContextPath()%>/transporter/company/queryPage' //数据接口
		    ,page: true //开启分页
		    ,cols: [[ //表头
		        {type: 'checkbox', fixed: 'left'},
               /*  {field: 'id', title: 'ID', width: '170', sort: true},  */
                {field:'name',title:'名称', width:'180'},
                {field:'code',title:'对应编码', width:'180'},
                {field:'email',title:'邮件', width:'180'},
                {field:'status',title:'状态', width:'180',templet: '#authTpl'},
                {field:'createDate',title:'创建时间', width:'180'},
                {field:'updateDate',title:'修改时间', width:'180'},
                {fixed: 'right', title:'操作', toolbar: '#bar', width:100}
		    ]]
		  });
		
		 table.on('checkbox(table_filter)', function(obj){
	           console.log(obj)
	     });
		 //监听工具条  
         table.on('tool(table_filter)', function(obj){ //注：tool是工具条事件名，table_filter是table原始容器的属性 lay-filter="对应的值"  
             var data = obj.data;
		    if(obj.event === 'del'){
		      layer.confirm('确认永久删除?', function(index){
		    	 $.ajax({  
		                url: "<%=request.getContextPath()%>/transporter/company/delete",
		                type: "post",
		                dataType:"json",
		                data:{id:data.id},
		                //contentType: "application/json",
		                success: function (data) {
		                	/* layer.alert(JSON.stringify(data.field), {
								title: '最终的提交信息'
							}); */
		                	if(data.code ==0){
		                		table.reload('layui_table_id');
		     			        layer.close(index);
		                	}else{
		                		layer.alert(data.msg, {
									title: '提示信息'
								});
		                	}
		                }, 
		    	 });
		      });
		    } else if(obj.event === 'edit'){
		    	 layui.use('layer', function(){
					  var layer = layui.layer;
					  layer.open({
						  type: 2,
						  area: ['90%', '90%'],
						  fixed: false, //不固定
						  maxmin: true,
						  content: "<%=request.getContextPath()%>/transporter/company/toEdit?id="+data.id,
						  /* success: function (layero, index) {  
			                    // 获取子页面的iframe  
			                    var iframe = window['layui-layer-iframe' + index];  
			                    // 向子页面的全局函数child传参  
			                    iframe.child(data);  
			                }   */
						}); 
					});
		    } else if(obj.event === 'detail'){
		    	 layui.use('layer', function(){
					  var layer = layui.layer;
					  layer.open({
						  type: 2,
						  area: ['90%', '90%'],
						  fixed: false, //不固定
						  maxmin: true,
						  content: "<%=request.getContextPath()%>/transporter/company/toDetail?id="+data.id,
						  /* success: function (layero, index) {  
			                    // 获取子页面的iframe  
			                    var iframe = window['layui-layer-iframe' + index];  
			                    // 向子页面的全局函数child传参  
			                    iframe.child(data);  
			                }   */
						}); 
					});
		    }else if(obj.event === 'editAuth'){
		    	 layui.use('layer', function(){
					  var layer = layui.layer;
					  layer.open({
						  type: 2,
						  area: ['90%', '90%'],
						  fixed: false, //不固定
						  maxmin: true,
						  content: "<%=request.getContextPath()%>/transporter/company/toEditAuth?id="+data.id,
						  /* success: function (layero, index) {  
			                    // 获取子页面的iframe  
			                    var iframe = window['layui-layer-iframe' + index];  
			                    // 向子页面的全局函数child传参  
			                    iframe.child(data);  
			                }   */
						}); 
					});
		    }
         });  
         $(".search_btn").click(function(){
        	 var select_input = $(".search_input").val();
        	 table.reload('layui_table_id', {
        		 where: { //设定异步数据接口的额外参数，任意设
        			    name: select_input
        			  }
        			  ,page: {
        			    curr: 1 //重新从第 1 页开始
        			  } 
        	 })
	  	  })
         $(".add_btn").click(function(){
 			layui.use('layer', function(){
 			  var layer = layui.layer;
 			  layer.open({
 				  type: 2,
 				  area: ['90%', '90%'],
 				  fixed: false, //不固定
 				  maxmin: true,
 				  content: '<%=request.getContextPath()%>/transporter/company/toAdd'
 				}); 
 			}); 
 		})
         //日期用法  
         laydate.render({  
             elem: '#applyDate'  
         });  
})
</script>
		<!-- 认证状态-->
	<script type="text/html" id="authTpl">
		    {{#  if(d.status == 0){ }}
		   		 未认证
		    {{# }else if(d.status == 1){ }}
		  		  待审核
		    {{#  } else{ }}
				审核通过			
			{{# }      }}
	</script> 
	<script type="text/html" id="bar">
	  <a class="layui-btn layui-btn-xs" lay-event="editAuth">审核</a>
	<!--  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	  <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="detail">详情</a>
	  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	-->
    </script>	
</body>
</html>