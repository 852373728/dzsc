<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<script type="text/javascript">
	$(function(){
		dongtai();
		zongji();
		cxzongji();
		xuhaoxuanzhong();
		shuBiaoXuanFuCuXiao();
	});
	
	//鼠标悬浮出现促销信息
	function shuBiaoXuanFuCuXiao(){
		$('.cuxiao').hide();  
	    $('.validPromotion').mousemove(function(event){
	    	event = event || window.event;
	        $('.cuxiao').eq($(this).prev().val()).show().css({  
	        	"top" : event.pageY+15,
				"left" : event.pageX+15
	        }).siblings('.cuxiao').hide();  
	    });  
	    $('.validPromotion').mouseleave(function(){  
	        $('.cuxiao').hide();  
	    });  
	}
	
	function dongtai(){
		$(".shopCarNum").on("input propertychange",function(){
			var count=$(this);
			var pattern = /^[0-9]*[1-9][0-9]*$/;
			if(!pattern.test(count.val())){
				count.val(1);
			}
			zongji();
		});
		$(".cxNum").on("input propertychange",function(){
			var count=$(this);
			var pattern = /^[0-9]*[1-9][0-9]*$/;
			if(!pattern.test(count.val())){
				count.val(1);
			}
			cxzongji();
		});
	}
	
	function cxzongji(){
		var cxtotal=0;
		$(".cxNum").each(function(){
			var num=$(this).val();
			var jg=$(this).next().val();
			cxtotal+=num*jg;
		});
		$("#cxzj").html("总计：￥<span class='zonggongyuan'>"+cxtotal.toFixed(2)+"</span>")
	}
	
	
	function zongji(){
		var total=0;
		$(".shopCarNum").each(function(){
			var pp=0;
			var num=$(this).val();
			var discountjg=$(this).next().val();
			var totalnum=$(this).parent().prev().prev().prev().children(".totalNum").html();
			var spzj=$.trim($(this).parent().next().next().children(".spzj").html());
			if(totalnum!=0 && spzj!=0 && num%totalnum==0 && discountjg!=1){
				pp=spzj*num;
			}else{
				var price=$(this).parent().next().children(".shopCarGoodPrice").html();
				if(isNaN($.trim(price))){
					price=0;
				}
				pp=numMulti(num, $.trim(price));
			}
			total=numAdd(total, pp);
		});
		
		$(".shopcarTotal").html("总计：￥<span class='zonggongyuan'>"+total.toFixed(2)+"</span>")
	}
	
	function deleteshopCar(name){
		if(confirm("确定删除吗")){
			$.post("/shopCar/delete.html",{"id":$(name).attr("shopId")},function(result){
				if(result.state){
					$(name).parents("tr").remove();
					zongji();
				}else{
					alert("该商品已不在购物车");
					window.location.reload();
				}
			},"json");
		}
	}
	
	function xuhaoxuanzhong(){
		$(".xuhao1").click(function(){ 
			if($(this).is(":checked")){ 
				$(this).parents("table.shopcarTable").find(".xuhao2").prop("checked", true);   
			}else{ 
				$(this).parents("table.shopcarTable").find(".xuhao2").prop("checked", false);   
			} 
		});
	}
	
	function buyOrder(){
		var flag=0;
		$(".xuhao2").each(function(){
			if($(this).is(":checked")){
				$(this).parents("tr").find("input[type='text']").attr("readonly","readonly");
				$(this).parents("table.shopcarTable").find(".caozuo").remove();
				flag=1;
			}
		});
		if(flag==0){
			alert("请至少选择一个商品！");
			return;
		}
		$(".xuhao2").each(function(){
			if(!$(this).is(":checked")){
				$(this).parents("tr").remove();
			}
		});
		zongji();
		cxzongji();
		$(".shopcarSecond").remove();
		$(".daohangerji").html("订单生成");
		$.post("/kh/reload.html",function(result){
			if(result.state){
				var currentUser=result.currentUser;
				var pingjie='<div class="querendingdan margin_top10">'+
				'<button onclick="shengchengdingdan(this)" type="button" class="btn btn-primary btn-sm">确认生成订单</button>&nbsp;'+
				'<button onclick="shuaxin()" type="button" class="btn btn-primary btn-sm">返回购物车</button>'+
			'</div>';
			$(".shopcarpingjie").append(pingjie);
			$(".checkboxduiqi").remove();
			}
		},"json");
		
	}
	
	function shengchengdingdan(myself){
		var total=0;
		$(".zonggongyuan").each(function(){
			total+=Number($(this).html());
		});
		var gdzj=$("#gdzj").val()
		if(total<gdzj){
			alert("总价不得低于"+gdzj+"元，请谅解！");
			return;
		}
		$(myself).attr('disabled',"true");
		var spdm=[];
		var sl=[];
		var spph=[];
		$(".shopSpdm").each(function(){
			spdm.push($(this).html());
			sl.push($(this).parents("tr").find("input[type='text']").val());
			var oneSpph=$(this).parents("tr").children(".shopSpph").html();
			if(oneSpph==undefined){
				oneSpph="sun";
			}
			spph.push(oneSpph);
		});
		var spdmStrs=spdm.join(",");
		var sls=sl.join(",");
		var spphs=spph.join(",");
		$.post("/spdd/add.html",{"spdmStrs":spdmStrs,"sls":sls,"spphs":spphs},function(result){
			if(result.state){
				alert(result.msg);
				window.location.reload();
			}else{
				alert(result.msg);
				window.location.reload();
			}
		},"json");
	}
</script>


	<div class="margin_top10 shopcarMax" >
	<table class="table table-hover table-striped shopcarTable" >
		<thead>
			<tr>
				<th><label><input type="checkbox" class="checkboxduiqi xuhao1" />序号</label> </th>
				<th>商品名称</th>
				<th>商品编号</th>
				<th>中包/整件</th>
				<th>拆零限制</th>
				<th>库存数量</th>
				<th>数量</th>
				<th>采购价</th>
				<th>整件价</th>
				<th class="caozuo">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${shopCarList }" var="shopCar" varStatus="status">
				<tr class="xuhaoTr">
					<th><label><input type="checkbox" class="checkboxduiqi xuhao2" />${status.index+1 }</label></th>
					<td>
						<input type="hidden" value="${status.index }" />
						<c:if test="${shopCar.spk.huoDong!=null }">
							<a href="javascript:;" class="icos v-ico validPromotion"></a>
						</c:if>
						<div class="cuxiao">${shopCar.spk.huoDong.huoDongContent }</div>
						<span>${shopCar.spk.spmc }</span>
					</td>
					<td class="shopSpdm">${shopCar.spk.spdm }</td>
					<td>${shopCar.spk.nbzsl }/<span class="totalNum">${shopCar.spk.wbzsl }</span></td>
					<td>${shopCar.spk.cl_xz==null?'允许':shopCar.spk.cl_xz }</td>
					<td>
					<c:choose>
						<c:when test="${shopCar.spk.kysl==null }">
							0
						</c:when>
						<c:when test="${shopCar.spk.kysl==-1 }">
							控销
						</c:when>
						<c:when test="${shopCar.spk.kysl>100 }">
							>100&nbsp;
						</c:when>
						<c:otherwise>
							${shopCar.spk.kysl}
						</c:otherwise>
					</c:choose>
					</td>
					<td><input  type="text" value="${shopCar.num }" class="shopCarNum"/><input  type="hidden" value="${shopCar.spk.discount }" class="discountjg"/></td>
					<td><span class="shopCarGoodPrice"><c:choose>
						<c:when test="${shopCar.spk.xsjg==-1 }">控销</c:when>
						<c:otherwise><fmt:formatNumber type="number" value="${shopCar.spk.xsjg }" pattern="0.00" maxFractionDigits="2"/></c:otherwise>
					</c:choose></span></td>
					<td><span class="spzj"><c:choose>
						<c:when test="${shopCar.spk.j_zj==-1 }">控销</c:when>
						<c:otherwise><fmt:formatNumber type="number" value="${shopCar.spk.j_zj }" pattern="0.00" maxFractionDigits="2"/></c:otherwise>
					</c:choose></span></td>
					<td class="caozuo">
						<div class="btn-group" role="group" aria-label="..." shoucang="${shopCar.spk.spdm }">
							<button shopId="${shopCar.id }" onclick="deleteshopCar(this)" type="button" class="btn btn-danger btn-xs">删除</button>
							<button type="button" class="btn btn-info btn-xs loginBtn" style="color: #fff;">收藏</button>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr >
				<td colspan="10">
					<span class="shopcarTotal"></span>
				</td>
			</tr>
		</tfoot>
	</table>
	</div>
	
	<div class="margin_top10 shopcarMax" >
	<div style="border-bottom:1px solid #ddd;height: 50px;text-align: center;font-size: 25px;line-height: 50px;color: red;">
		近效期商品
	</div>
	<table class="table table-hover table-striped shopcarTable" >
		<thead>
			<tr>
				<th><label><input type="checkbox" class="checkboxduiqi xuhao1"/>序号</label> </th>
				<th>商品名称</th>
				<th>商品编号</th>
				<th>商品批号</th>
				<th>有效期</th>
				<th>库存数量</th>
				<th>数量</th>
				<th>促销价</th>
				<th class="caozuo">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${shopCarCxList }" var="shopCar" varStatus="status">
				<tr>
					<th><label><input type="checkbox" class="checkboxduiqi xuhao2"/>${status.index+1 }</label></th>
					<td>
						<span>${shopCar.spmc }</span>
					</td>
					<td class="shopSpdm">${shopCar.spdm }</td>
					<td class="shopSpph">${shopCar.spph }</td>
					<td>${shopCar.yxq }</td>
					<td>${shopCar.kysl }</td>
					<td>
						<input class="cxNum" style="width:40px;" type="text" value="${shopCar.num }"/>
						<input type="hidden" value="${shopCar.cxdj }"/>
					</td>
					<td>${shopCar.cxdj }</td>
					<td class="caozuo">
						<div class="btn-group" role="group" aria-label="..." shoucang="${shopCar.spdm }">
							<button shopId="${shopCar.id }" onclick="deleteshopCar(this)" type="button" class="btn btn-danger btn-xs">删除</button>
							<button type="button" class="btn btn-info btn-xs loginBtn" style="color: #fff;">收藏</button>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr >
				<td colspan="9">
					<span id="cxzj" style="font-size: 20px;"></span>
				</td>
			</tr>
		</tfoot>
	</table>
	</div>
	
	<div class="shopcarpingjie">
	</div>
	<div class="shopcarSecond margin_top10">
		<button onclick="buyOrder()" type="button" class="btn btn-primary">生成订单</button>
	</div>
	<div class="wxts" style="margin-top: 15px;">
		${shopCarMsg.msg}
	</div>
	<input id="gdzj" type="hidden" value="${shopCarMsg.zj}"/>
