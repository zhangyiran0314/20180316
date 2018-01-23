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
		    	<label class="layui-form-label">订单号</label>
		    	<div class="layui-input-block">
		    		<input type="text" value="" placeholder="请输入关键字" class="layui-input orderNo">
		    	</div>
		     </div>
		     <div class="layui-input-inline">
		    	<label class="layui-form-label">货主公司</label>
		    	<div class="layui-input-block">
		    		<input type="text" value="" placeholder="请输入关键字" class="layui-input sCompanyName">
		    	</div>
			</div>
		     <div class="layui-input-inline">
		    	<label class="layui-form-label">货主手机</label>
		    	<div class="layui-input-block">
		    		<input type="text" value="" placeholder="请输入关键字" class="layui-input sMobile">
		    	</div>
		     </div>
		     <div class="layui-input-inline">
		    	<label class="layui-form-label">车主公司</label>
		    	<div class="layui-input-block">
		    		<input type="text" value="" placeholder="请输入关键字" class="layui-input tCompanyName">
		    	</div>
		    </div>
		     <div class="layui-input-inline">
		    	<label class="layui-form-label">车主手机</label>
		    	<div class="layui-input-block">
		    		<input type="text" value="" placeholder="请输入关键字" class="layui-input tMobile">
		    	</div>
		    </div>
		     <div class="layui-input-inline">
		    	<label class="layui-form-label">运单状态</label>
		    	<div class="layui-input-block">
			    	<select id="status" name="status">
					  <option value="">请选择</option>
					  <option value="0">待装车</option>
					  <option value="1">运输中</option>
					  <option value="2">待确认</option>
					  <option value="3">已完结</option>
					</select>   
				</div>
		    </div>
		     <div class="layui-input-inline">
		    	<label class="layui-form-label">派单状态</label>
		    	<div class="layui-input-block">
		    		<select id="dispenseStatus" name="dispenseStatus" lay-verify="">
					  <option value="">请选择</option>
					  <option value="0">未派单</option>
					  <option value="1">已派单</option>
					</select>   
		    	</div>
		    </div>
		     <div class="layui-input-inline">
		    	<label class="layui-form-label">司机手机</label>
		    	<div class="layui-input-block">
		    		<input type="text" value="" placeholder="请输入关键字" class="layui-input dMobile">
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
		    ,url: '<%=request.getContextPath()%>/waybill/queryPage' //数据接口
		    ,page: true //开启分页
		    ,cols: [[ //表头
		        {type: 'checkbox', fixed: 'left'},
		        {field:'orderNo',title:'订单号', width:'180'},
		        {field:'costs',title:'报价', width:'180'},
                {field:'status',title:'运单状态', width:'180',templet:'#statusTpl'},
                
                {field:'shipperComanyName',title:'货主公司', width:'180'},
                {field:'shipperMobile',title:'货主手机', width:'180'},
                
                {field:'transporterComanyName',title:'车主公司', width:'180'},
                {field:'transporterMobile',title:'车主手机', width:'180'},
                {field:'driverMobile',title:'司机手机', width:'180'},
                {field:'dispenseStatus',title:'派单状态', width:'180',templet:'#dispenseStatusTpl'},
                {field:'dispenseDate',title:'派单日期', width:'180'},
                {field:'carName',title:'车辆名称', width:'180'},
                {field:'carCode',title:'车牌', width:'180'},
                
                {field:'createDate',title:'创建时间', width:'180'},
                {field:'updateDate',title:'修改时间', width:'180'},
                 {fixed: 'right', title:'操作', toolbar: '#bar', width:150} 
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
		                url: "<%=request.getContextPath()%>/waybill/delete",
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
						  content: "<%=request.getContextPath()%>/waybill/toEdit?id="+data.id,
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
						  content: "<%=request.getContextPath()%>/waybill/toDetail?id="+data.id,
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
						  content: "<%=request.getContextPath()%>/waybill/toEditAuth?id="+data.id,
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
        	 var orderNo = $(".orderNo").val();
        	 var sMobile = $(".sMobile").val();
        	 var sCompanyName = $(".sCompanyName").val();
        	 var tMobile = $(".tMobile").val();
        	 var tCompanyName = $(".tCompanyName").val();
        	 var dMobile = $(".dMobile").val();
        	 var status = $("#status").val();
        	 var dispenseStatus = $("#dispenseStatus").val();
        	 table.reload('layui_table_id', {
        		 where: { //设定异步数据接口的额外参数，任意设
        			    orderNo: orderNo,
        			    status:status,
        			    dispenseStatus:dispenseStatus,
        			    sCompanyName: sCompanyName,
        			    sMobile:sMobile,
        			    tCompanyName: tCompanyName,
        			    tMobile:tMobile,
        			    dMobile:dMobile,
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
 				  content: '<%=request.getContextPath()%>/waybill/toAdd'
 				}); 
 			}); 
 		})
         //日期用法  
         laydate.render({  
             elem: '#applyDate'  
         });  
})
</script>
		<script type="text/html" id="departureTpl">
		<div>{{ d.departureProvince.name + d.departureCity.name + d.departureArea.name }}</div>
		</script> 
		<script type="text/html" id="destinationTpl">
		<div>{{ d.destinationProvince.name + d.destinationCity.name + d.destinationArea.name }}</div>
		</script> 
		<script type="text/html" id="dispenseStatusTpl">
		    {{#  if(d.dispenseStatus == 0){ }}
		   		 未派单
		    {{# }else if(d.dispenseStatus == 1){ }}
		  		  已派单
		    {{#  } else{ }}
				未知	
			{{# }      }}
		</script> 
		<script type="text/html" id="statusTpl">
		    {{#  if(d.status == 0){ }}
		   		待装车
		    {{# }else if(d.status == 1){ }}
		  		运输中
		    {{#  } if(d.status == 1){ }}
				待确认
 			{{#  } else{ }}
				已完结			
			{{# }      }}
		</script> 
		<script type="text/html" id="bar">
			<!--<a class="layui-btn layui-btn-xs" lay-event="editAuth">审核</a>
	  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a> -->
	  		<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="detail">详情</a>
	  		<!-- <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a> -->
    	</script>
</body>
</html>