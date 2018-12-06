<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<script type="text/javascript">
	$(function(){
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
	
	function qxsh(nb){
		if(confirm("是否取消收藏")){
			$(nb).attr("disabled",true);
			$.post("/kh/reload.html",function(result){
				if(result.state){
					$.post("/collection/delete.html",{"id":$(nb).prev().val()},function(result){
						if(result.state){
							$(nb).parents("tr.qxsh_tr").remove();
						}else{
							alert(result.msg);
							shuaxin();
						}
					},"json");
				}
			},"json");
		}
	}

</script>
	<div style="border: 1px solid #ddd;margin-top: 10px;">
		<table class="table table-hover table-striped " >
		<thead>
			<tr>
				<th>序号</th>
				<th>商品名称</th>
				<th>商品编号</th>
				<th>生产厂家</th>
				<th>采购价</th>
				<th class="caozuo">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${collectionList }" var="collection" varStatus="status">
				<tr class="qxsh_tr">
					<th>${status.index+1 }</th>
					<td>
						<input type="hidden" value="${status.index }" />
						<c:if test="${collection.spk.huoDong!=null }">
							<a href="javascript:;" class="icos v-ico validPromotion"></a>
						</c:if>
						<div class="cuxiao">${collection.spk.huoDong.huoDongContent }</div>
						<a class="shouc_a" target="_blank" href="/goodsDetails.html?id=${collection.spk.id }">${collection.spk.spmc }</a>
					</td>
					<td><input type="hidden" class="nb_in" value="${collection.spk.spdm }"/> ${collection.spk.spdm }</td>
					<td>${collection.spk.SCCJ1 }</td>
					<td>
					<span>
					<c:choose>
						<c:when test="${collection.spk.xsjg==-1 }">
							控销
						</c:when>
						<c:otherwise>
							<fmt:formatNumber type="number" value="${collection.spk.xsjg }" pattern="0.00" maxFractionDigits="2"/>&nbsp;元
						</c:otherwise>
					</c:choose>
					</span>
					</td>
					<td><input type="hidden" value="${collection.id }"/><button onclick="qxsh(this)" type="button" class="btn btn-danger btn-xs">取消收藏</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
