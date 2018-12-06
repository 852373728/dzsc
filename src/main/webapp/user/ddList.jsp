<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="/static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(function(){
	var param={};
	list(param);
});

function list(param){
	$.post("/spdd/list.do",param,function(result){
		var spddList=result.spddList;
		var spddhtml='<div class="ddsearch">'
			+'订单日期：<input style="cursor: pointer;" id="condition1"  class="Wdate" onfocus="WdatePicker({dateFmt:\'yyyy-MM-dd\',readOnly:true})" />'
			+'——'
			+'<input style="cursor: pointer;" id="condition2" class="Wdate" onfocus="WdatePicker({dateFmt:\'yyyy-MM-dd\',readOnly:true})" />&nbsp;&nbsp;'
			+'订单状态：<select id="condition3"><option selected="selected" value="1">待发货</option>'
			+'<option value="2">卖家已发货</option>'
			+'<option value="3">已签收</option></select> &nbsp;&nbsp;'
			+'<button type="button" class="btn btn-primary btn-xs" id="findCondition" onclick="findCondition()">搜索</button>'
			+'</div>'
			+'<table class="table table-hover table-striped ddtable" >'
			+'<thead><tr><th>订单编号 </th><th>订单日期</th><th>金额</th><th>购买人</th><th>订单状态</th></tr></thead>'
			+'<tbody class="spddlist"></tbody>'
			+'</table>';
		$(".ddmax1").html(spddhtml);
		$("#condition3").val(param.zt==undefined?1:param.zt);
		var str='';
		for(var i in spddList){
			var zt="";
			if(spddList[i].zt==1){
				zt="待发货";
			}else if(spddList[i].zt==2){
				zt="卖家已发货";
			}else{
				zt="已签收";
			}
			str+='<tr>'
				+'<td><a href="javascript:;" onclick="seeOrderDetail(this)" class="ddbh_a">'+spddList[i].ddbh+'</a></td>'
				+'<td>'+spddList[i].zdrqStr+'</td>'
				+'<td>'+spddList[i].zongjia.toFixed(2)+'&nbsp;元</td>'
				+'<td>'+spddList[i].lxr+'</td>'
				+'<td>'+zt+'</td>'
				+'</tr>';
		}
		$(".spddlist").html(str);
	},"json")
}

function findCondition(){
	var startTime=$("#condition1").val();
	var endTime=$("#condition2").val();
	var zt=$("#condition3").val();
	var param={"startTime":startTime,"endTime":endTime,"zt":zt}
	list(param);
	
}


	function seeOrderDetail(ddbh){
		$(".ddmax1").empty();
		$.post("/kh/reload.html",function(result){
			if(result.state){
				$.post("/spdd/getOne.html",{"ddbh":$(ddbh).html()},function(result){
					$(".daohangerji").html("订单详情");
					var spddMxList=result.spdd.spddMxList;
					var spdd=result.spdd;
					var pingjie='<table class="w753">'+
									'<tbody>'+
										'<tr class="title" >'+
											'<td class="td_title" colspan="2">基本信息</td>'+
										'</tr>'+
										'<tr>'+
											'<th>订单编号：</th>'+
											'<td>'+spdd.ddbh+'</td>'+
										'</tr>'+
										'<tr>'+
											'<th>订单日期：</th>'+
											'<td>'+spdd.formatZdrq+'</td>'+
										'</tr>'+
										'<tr>'+
											'<th>订单金额：</th>'+
											'<td>￥'+spdd.zongjia.toFixed(2)+'</td>'+
										'</tr>'+
									'</tbody>'+
								'</table>'+
								'<div class="dingdanxiangxi margin_top10"><div class="title"> 订单详情</div>'+
								'<table class="table table-hover table-striped" >'+
									'<thead>'+
										'<tr>'+
											'<th>商品代码</th>'+
											'<th>商品批号</th>'+
											'<th>商品名称</th>'+
											'<th>单位</th>'+
											'<th>商品规格</th>'+
											'<th>采购价</th>'+
											'<th>购买数量</th>'+
											'<th>发货数量</th>'+
											'<th>优惠活动</th>'+
										'</tr>'+
									'</thead>'+
									'<tbody>';
					for(var i in spddMxList){
						var xiabiao=i;
						var fcsl=spddMxList[i].fcsl==undefined?0:spddMxList[i].fcsl;
						pingjie+='<tr><td>'+spddMxList[i].spdm+'</td>'+
						'<td>'+spddMxList[i].spph+'</td>'+
						'<td>'+spddMxList[i].spmc+'</td>'+
						'<td>'+spddMxList[i].dw+'</td>'+
						'<td>'+spddMxList[i].spgg+'</td>'+
						'<td>￥'+spddMxList[i].xsjg.toFixed(2)+'</td>'+
						'<td>'+spddMxList[i].sl+'</td>'+
						'<td>'+fcsl+'</td>'+
						'<td><div style="display:none;" class="cuxiao">'+spddMxList[i].hdnr+'</div><span class="hdys" onmouseleave="cuxiaoHide()" onmousemove="cuxiaoShow('+i+')">'+spddMxList[i].hdnr+'</span></td>'+
						'</tr>';
					}
					pingjie+='</tbody>'+
							 '</table></div>'+
							 '<div class="div_center margin_top10">'+
								'<button onclick="fanhui()" type="button" class="btn btn-primary btn-sm">返回</button>'+
							'</div>';
					$(".ddmax1").append(pingjie);
					
				},"json");
			}
		},"json");
	}
	
	function cuxiaoShow(i,event){
		event = event || window.event;
        $('.cuxiao').eq(i).show().css({  
        	"top" : event.pageY+15,
			"left" : event.pageX+15
        }).siblings('.cuxiao').hide();  
	}
	function cuxiaoHide(){
		 $('.cuxiao').hide();
	}
	
	function fanhui(){
		$(".daohangerji").html("订单查询");
		list({});
	}
	
</script>
	<div class="ddmax1 margin_top10" >
	
	</div>
