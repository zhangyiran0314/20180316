<%@ include file="../common.jsp"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>manage</title>
</head>
<style>
body{padding: 20px; /*overflow-y: scroll;*/}
</style>
<body class="childrenBody">
	<blockquote class="layui-elem-quote news_search layui-form ">
		     <div class="layui-input-inline">
		    	<label class="layui-form-label">投保人公司</label>
		    	<div class="layui-input-block">
		    		<input type="text" value="" placeholder="请输入关键字" class="layui-input policyholderCompany">
		    	</div>
			</div>
		     <div class="layui-input-inline">
		    	<label class="layui-form-label">投保人姓名</label>
		    	<div class="layui-input-block">
		    		<input type="text" value="" placeholder="请输入关键字" class="layui-input policyholderName">
		    	</div>
		     </div>
		     <div class="layui-input-inline">
		    	<label class="layui-form-label">投保人手机</label>
		    	<div class="layui-input-block">
		    		<input type="text" value="" placeholder="请输入关键字" class="layui-input policyholderMobile">
		    	</div>
		     </div>
		<a class="layui-btn search_btn">查询</a>
	</blockquote>
	
	<table id="table" lay-filter="table_filter"></table>
	
	<div id="page"></div>
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
		    ,height: 500
		    ,id:"layui_table_id"
		    ,url: '<%=request.getContextPath()%>/insurance/queryPage' //数据接口
		    ,page: true //开启分页
		    ,cols: [[ //表头
		       /*  {type: 'checkbox', fixed: 'left'}, */
		        {field:'policyholderCompany',title:'投保人公司', width:'180'},
		        {field:'policyholderName',title:'投保人名字', width:'180'},
                {field:'policyholderMobile',title:'投保人手机', width:'180'},
                
                {field:'goodsName',title:'货物名称', width:'180'},
		        {field:'goodsNum',title:'货物数量', width:'180'},
                {field:'goodsValue',title:'货物价值', width:'180'},
                
                {field:'transportCompany',title:'运输单位公司', width:'180'},
		        {field:'transportName',title:'运输单位联系人', width:'180'},
                {field:'transportMobile',title:'运输单位手机', width:'180'},
                
                {field:'buyCompany',title:'购买人公司', width:'180'},
		        {field:'buyName',title:'购买人名字', width:'180',templet:'#nameTpl'},
                {field:'buyMobile',title:'购买人手机', width:'180'},
                {field:'buyEmail',title:'购买人email', width:'180'},
                
                {field:'departure',title:'出发地', width:'180',templet:'#departureTpl'},
                {field:'destination',title:'目的地', width:'180',templet:'#destinationTpl'},
                
                {field:'deliverDate',title:'发车日期', width:'180'},
                {field:'waybillNo',title:'运单编号', width:'180'},
                
                {field:'createDate',title:'创建时间', width:'180'},
                {field:'updateDate',title:'修改时间', width:'180'},
                /*  {fixed: 'right', title:'操作', toolbar: '#bar', width:150}  */
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
		                url: "<%=request.getContextPath()%>/insurance/delete",
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
						  content: "<%=request.getContextPath()%>/insurance/toEdit?id="+data.id,
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
						  content: "<%=request.getContextPath()%>/insurance/toDetail?id="+data.id,
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
						  content: "<%=request.getContextPath()%>/insurance/toEditAuth?id="+data.id,
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
        	 var policyholderCompany = $(".policyholderCompany").val();
        	 var policyholderName = $(".policyholderName").val();
        	 var policyholderMobile = $(".policyholderMobile").val();
        	 table.reload('layui_table_id', {
        		 where: { //设定异步数据接口的额外参数，任意设
        				 policyholderCompany: policyholderCompany,
        				 policyholderName: policyholderName,
        				 policyholderMobile: policyholderMobile
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
 				  content: '<%=request.getContextPath()%>/insurance/toAdd'
 				}); 
 			}); 
 		})
         //日期用法  
         laydate.render({  
             elem: '#applyDate'  
         });  
})
</script>
	<script type="text/html" id="nameTpl">
		<div>{{ d.buySurname + d.buyName }}</div>
		</script> 
		<script type="text/html" id="departureTpl">
		<div>{{ d.departureProvince.name + d.departureCity.name + d.departureArea.name }}</div>
		</script> 
		<script type="text/html" id="destinationTpl">
		<div>{{ d.destinationProvince.name + d.destinationCity.name + d.destinationArea.name }}</div>
		</script> 
		<script type="text/html" id="authTpl">
		    {{#  if(d.authStatus == 0){ }}
		   		 未授权
		    {{# }else if(d.authStatus == 1){ }}
		  		  已授权
		    {{#  } else{ }}
				授权取消			
			{{# }      }}
		</script> 
		<script type="text/html" id="statusTpl">
		    {{#  if(d.status == 0){ }}
		   		 发布中
		    {{# }else if(d.status == 1){ }}
		  		 已成交
		    {{#  } else{ }}
				已取消			
			{{# }      }}
		</script> 
		<script type="text/html" id="bar">
			<!--<a class="layui-btn layui-btn-xs" lay-event="editAuth">审核</a>
	  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a> -->
	  		<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="detail">详情</a>
	  		 <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a> -->
    	</script>
</body>
</html>