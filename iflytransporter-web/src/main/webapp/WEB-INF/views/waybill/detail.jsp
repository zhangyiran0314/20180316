<%@ include file="../common.jsp"%> 
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
			<label class="layui-form-label">出发地</label>
			 <div class="layui-input-inline">
					<label class="layui-form-label">省份</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input departureProvince">
					</div>
			</div>
			 <div class="layui-input-inline">
					<label class="layui-form-label">城市</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input departureCity">
					</div>
			</div>
			 <div class="layui-input-inline">
					<label class="layui-form-label">地区</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input departureArea">
					</div>
			 </div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">目的地</label>
			<div class="layui-input-inline">
					<label class="layui-form-label">省份</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input destinationProvince">
					</div>
			</div>
			 <div class="layui-input-inline">
					<label class="layui-form-label">城市</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input destinationCity">
					</div>
			</div>
			 <div class="layui-input-inline">
					<label class="layui-form-label">地区</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input destinationArea">
					</div>
			 </div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用车类型</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input useType">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">车辆类型</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input carType">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">货物类型</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input goodsType">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">装卸类型</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input handlingType">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">支付类型</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input paymentType">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">计量单位</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input goodsUnits">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">发货日期</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input orderDeliverDate">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input remark">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">报价</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input costs">
			</div>
		</div>
		
		
		<div class="layui-form-item">
		    <div class="layui-input-inline">
				<label class="layui-form-label">货主公司</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input shipperCompanyName">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">货主姓</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input shipperSurname">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">货主名</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input shipperName">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">货主电话</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input shipperMobile">
				</div>
			</div>
		</div>
		
		
		<div class="layui-form-item">
		    <div class="layui-input-inline">
				<label class="layui-form-label">车主公司</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input transporterCompanyName">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">车主姓</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input transporterSurname">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">车主名</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input transporterName">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">车主电话</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input transporterMobile">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
		    <label class="layui-form-label">运单状态</label>
		    <div class="layui-input-block" lay-filter="status">
		      	  <input type="radio" lay-filter="status_0" value="0" title="待装车">
			      <input type="radio" lay-filter="status_1" value="1" title="运输中">
			      <input type="radio" lay-filter="status_2" value="2" title="待确认">
			      <input type="radio" lay-filter="status_3" value="3" title="已完结">
		    </div>
		  </div>
		
		<div class="layui-form-item">
				<label class="layui-form-label">派单状态</label>
				<div class="layui-input-block" lay-filter="status">
				   <input type="radio" lay-filter="dispenseStatus_0" value="0" title="未派单">
			       <input type="radio" lay-filter="dispenseStatus_1" value="1" title="已派单">
				</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-inline">
				<label class="layui-form-label">司机姓</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input driverSurname">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">司机名</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input driverName">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">司机电话</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input driverMobile">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
		
			<div class="layui-input-inline">
				<label class="layui-form-label">车牌</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input carCode">
				</div>
			</div>
			<div class="layui-input-inline">
				<label class="layui-form-label">车辆类型</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input carName">
				</div>
			</div>
		</div>
		
		
		
		<div class="layui-form-item div_take" style="display:none">
			<div class="layui-input-inline">
				<label class="layui-form-label">收货日期</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input takeDate">
				</div>
			</div>
			<div class="layui-input-inline div_take_attachment1" style="display:none">
				<label class="layui-form-label">图片1</label>
				<div class="layui-input-block take_attachment1"></div>
			</div>
			<div class="layui-input-inline  div_take_attachment2" style="display:none">
				<label class="layui-form-label">图片2</label>
				<div class="layui-input-block take_attachment2"></div>
			</div>
			<div class="layui-input-inline  div_take_attachment3" style="display:none">
				<label class="layui-form-label">图片3</label>
				<div class="layui-input-block take_attachment3"></div>
			</div>
			<div class="layui-input-inline  div_take_attachment4" style="display:none">
				<label class="layui-form-label">图片4</label>
				<div class="layui-input-block take_attachment4">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item div_deliver" style="display:none">
			<div class="layui-input-inline">
				<label class="layui-form-label">交货日期</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input deliverDate">
				</div>
			</div>
			<div class="layui-input-inline div_deliver_attachment1" style="display:none">
				<label class="layui-form-label">图片1</label>
				<div class="layui-input-block deliver_attachment1"></div>
			</div>
			<div class="layui-input-inline  div_deliver_attachment2" style="display:none">
				<label class="layui-form-label">图片2</label>
				<div class="layui-input-block deliver_attachment2"></div>
			</div>
			<div class="layui-input-inline  div_deliver_attachment3" style="display:none">
				<label class="layui-form-label">图片3</label>
				<div class="layui-input-block deliver_attachment3"></div>
			</div>
			<div class="layui-input-inline  div_deliver_attachment4" style="display:none">
				<label class="layui-form-label">图片4</label>
				<div class="layui-input-block deliver_attachment4">
				</div>
			</div>
		</div>
			<div class="layui-form-item">
		    <label class="layui-form-label">确认时间</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input confirmDate">
			</div>
	    </div>
		
		<div class="layui-form-item">
		    <label class="layui-form-label">创建时间</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input createDate">
			</div>
	    </div>
		
		<div class="layui-form-item">
		    <label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input remark">
			</div>
	    </div>
	</form>
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
			url : "<%=request.getContextPath()%>/waybill/detail",
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
		$(".departureProvince").val(data.departureProvince.name);    
		$(".departureCity").val(data.departureCity.name);  
		$(".departureArea").val(data.departureArea.name);  
		
		$(".destinationProvince").val(data.destinationProvince.name);    
		$(".destinationCity").val(data.destinationCity.name);  
		$(".destinationArea").val(data.destinationArea.name);
		
		$(".useType").val(data.useType.name); 
		$(".carType").val(data.carType.name);     
		$(".goodsType").val(data.goodsType);  
		$(".handlingType").val(data.handlingType.name); 
		$(".paymentType").val(data.paymentType.name); 
		$(".goodsUnits").val(data.goodsUnits);    
		
		$(".orderDeliverDate").val(data.orderDeliverDate);   
		$(".remark").val(data.remark);  
		$(".costs").val(data.costs);  
		
		$(".shipperCompanyName").val(data.shipperCompanyName);
		$(".shipperSurname").val(data.shipperSurname);  
		$(".shipperName").val(data.shipperName);  
		$(".shipperMobile").val(data.shipperMobile);  
		
		$(".transporterCompanyName").val(data.transporterCompanyName);  
		$(".transporterSurname").val(data.transporterSurname);  
		$(".transporterName").val(data.transporterName);  
		$(".transporterMobile").val(data.transporterMobile); 
		
		$(".driverSurname").val(data.driverSurname);  
		$(".driverName").val(data.driverName);  
		$(".driverMobile").val(data.driverMobile); 
		
		$(".carCode").val(data.carCode);  
		$(".carName").val(data.carName);  
		
		if(data.takeAttachmentList!=undefined){
			$(".div_take").show();
			$(".takeDate").val(data.takeDate); 
			
			var takeAttachmentList = data.takeAttachmentList;
			if(takeAttachmentList.attachmentId1Link!=undefined){
				$(".div_take_attachment1").show();
				$(".take_attachment1").append("<img src="+takeAttachmentList.attachmentId1Link+">");
			}
			if(takeAttachmentList.attachmentId2Link!=undefined){
				$(".div_take_attachment2").show();
				$(".take_attachment2").append("<img src="+takeAttachmentList.attachmentId2Link+">");
			}
			if(takeAttachmentList.attachmentId3Link!=undefined){
				$(".div_take_attachment3").show();
				$(".take_attachment3").append("<img src="+takeAttachmentList.attachmentId3Link+">");
			}
			if(takeAttachmentList.attachmentId4Link!=undefined){
				$(".div_take_attachment4").show();
				$(".take_attachment4").append("<img src="+takeAttachmentList.attachmentId4Link+">");
			}
		}
		if(data.deliverAttachmentList!=undefined){
			$(".div_deliver").show();
			$(".deliverDate").val(data.deliverDate); 
			
			var deliverAttachmentList = data.deliverAttachmentList;
			if(deliverAttachmentList.attachmentId1Link!=undefined){
				$(".div_deliver_attachment1").show();
				$(".deliver_attachment1").append("<img src="+deliverAttachmentList.attachmentId1Link+">");
			}
			if(deliverAttachmentList.attachmentId2Link!=undefined){
				$(".div_deliver_attachment2").show();
				$(".deliver_attachment2").append("<img src="+deliverAttachmentList.attachmentId2Link+">");
			}
			if(deliverAttachmentList.attachmentId3Link!=undefined){
				$(".div_deliver_attachment3").show();
				$(".deliver_attachment3").append("<img src="+deliverAttachmentList.attachmentId3Link+">");
			}
			if(deliverAttachmentList.attachmentId4Link!=undefined){
				$(".div_deliver_attachment4").show();
				$(".deliver_attachment4").append("<img src="+deliverAttachmentList.attachmentId4Link+">");
			}
		}
		
		$(".confirmDate").val(data.confirmDate); 
		
		$(".createDate").val(data.createDate); 
		
		$('[lay-filter=status_'+data.status+']').prop('checked',true);  
		$('[lay-filter=dispenseStatus_'+data.dispenseStatus+']').prop('checked',true);  
		form.render("radio");
	}
})
</script>
</body>
</html>