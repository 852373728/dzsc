<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>近效期促销</title>
<script type="text/javascript">
$(function(){
	$('.cuxiao').hide();  
    $('.huoDongContent_td').mousemove(function(event){
    	event = event || window.event;
		var nX = event.pageX;
		var nY = event.pageY;
		var offset = event.pageY+15;
		var nH = $(".cuxiao")
				.outerHeight(true);
		if (nY + nH > $(window).height()
				+ $(window).scrollTop()) {
			offset -= 50;
		}
        $('.cuxiao').eq($(this).siblings("th").html()-1).show().css({  
        	"top" : offset,
			"left" : event.pageX+15
        }).siblings('.cuxiao').hide();  
    });  
    $('.huoDongContent_td').mouseleave(function(){  
        $('.cuxiao').hide();  
    });  
});
</script>
</head>
<body>
<div class="margin_top10">
	<table class="table table-hover table-striped ddtable" >
		<thead>
			<tr>
				<th>序号</th>
				<th>商品名称</th>
				<th>商品编号</th>
				<th>生产厂家</th>
				<th>商品单价</th>
				<th>活动内容</th>
				<th>有效期至</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${promotion }" var="promotion" varStatus="status">
				<tr class="qxsh_tr">
					<th>${status.index+1 }</th>
					<td><a class="shouc_a" target="_blank" href="goodsDetails.action?s_spk.nbspdm=${promotion.spk.nbspdm}">${promotion.spk.spmc }</a></td>
					<td>${promotion.spk.spdm }</td>
					<td>${promotion.spk.sccj.cjmc }</td>
					<td><span><fmt:formatNumber type="number" value="${promotion.spk.splsdj }" pattern="0.00" maxFractionDigits="2"/></span>&nbsp;元</td>
					<td class="huoDongContent_td"><div class="huoDongContent">${promotion.huoDongContent }</div> <div class="cuxiao">${promotion.huoDongContent }</div></td>
					<td><fmt:formatDate value="${promotion.mainTopThreeLevel.huoDongOver }" type="date" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>