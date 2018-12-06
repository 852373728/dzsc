<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<title>品牌专区</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script> 
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
<script src="${pageContext.request.contextPath}/myJs/kegong.js"></script> 
<script type="text/javascript">
	$(function(){
		var url="pinpai";
		fenye(url);
	});
	
</script>
</head>
<body>
	<jsp:include page="common/topTop.jsp" flush="true"/>
	<jsp:include page="common/top.jsp" flush="true"/>
	<input id="yeMianPanDing"  type="hidden" value="4"/><!-- 当前页面的判定 -->
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<input type="hidden" id="spkTotal" value="${total}"/>
				<input type="hidden" id="spkCurrentPage" value="${page}"/>
				<input type="hidden" id="spkCurrentSize" value="${size}"/>
				<c:forEach items="${listSccj }" var="sccj">
				<div class="brand_shop_list margin_top10 ">
					<dl>
						<dt>
							<div class="img"><a href="pinpaiDetails.html?cjmc=${sccj.cjmc }" target="_blank"><img class="lazyImg" title="${sccj.cjmc }" alt="${sccj.cjmc }" data_src="${fn:substringBefore(sccj.tplj, ',')}"></a></div>
							<p class="shop_des">${sccj.cjjj }</p>
							<a href="pinpaiDetails.html?cjmc=${sccj.cjmc }" target="_blank" class="go_shop_btn">进入品牌</a>
						</dt>
						<dd>
							<div class="border_left"><span></span></div>
							<div class="box">
								<ul>
								<c:forEach items="${sccj.spkList }" var="spk">
								<li>
									<a target="_blank" class="info_img" href="goodsDetails.html?id=${spk.id }"><img class="lazyImg" alt="${spk.spmc }" title="${spk.spmc }" data_src="${fn:substringBefore(spk.pict, ',')}"></a>
									<h4><a target="_blank" href="goodsDetails.html?id=${spk.id }">${spk.spmc }</a></h4>
									<p><span>零售价：</span><em>￥${spk.splsdj }</em></p>
									<p>
										<span class="price">采购价：</span>
										<input type="hidden" value="￥${spk.xsjg }"/>
										<a class="login_look color_red">登录可见</a>
									</p>
									<p><a href="kegong.html?SCCJ1=${sccj.cjmc }">${sccj.cjmc }</a></p>
								</li>
								</c:forEach>
								</ul>
							</div>
						</dd>
					</dl>
				</div>
				</c:forEach>
				<div  class="floatRight feny">
					<ul id="frontPage" class="pagination fenyeClass"></ul>
					<div class="page_jump_btn">
						<a href="javascript:page_jump_btn('pinpai')"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</html>