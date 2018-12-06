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
<title>活动专区</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script> 
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
</head>
<body>
	<jsp:include page="common/topTop.jsp" flush="true"/>
	<jsp:include page="common/top.jsp" flush="true"/>
	<input id="yeMianPanDing"  type="hidden" value="3"/><!-- 当前页面的判定 -->
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
			<c:forEach items="${allTwoBar }" var="twoBar">
				<div class="mode_floor margin_top20 handsel">
					<div class="title">
						<h2>${twoBar.name }</h2>
						<a class="more" href="huodongMore.html?twobarName=${twoBar.name }" target="_blank">更多</a>
					</div>
					<div class="cont">
						<dl>
							<dd class="promotion_list">
								<ul class="index_goods_list">
									<c:forEach items="${twoBar.huoDongList }" var="huoDongGoods">
									<li class="index_goods_item">
										<div class="mainTopGoods_img">
											<a href="goodsDetails.html?id=${huoDongGoods.spk.id }"><img class="lazyImg" width="179" height="179" alt="${huoDongGoods.spk.spmc }" title="${huoDongGoods.spk.spmc }" data_src="${fn:substringBefore(huoDongGoods.spk.pict, ',')}"></a>
										</div>
										<div class="mainTopGoods_price">零售价：<span class="rmb">￥${huoDongGoods.spk.splsdj }</span></div>
										<div class="mainTopGoods_purchase">
											<span class="red">采购价：</span>
											<input type="hidden" value="￥${huoDongGoods.spk.xsjg }"/>
											<a class="login_look">登录可见</a>
										</div>
										<div class="mainTopGoods_name">${huoDongGoods.spk.SCCJ1}</div>
									</li>
									</c:forEach>
								</ul>
							</dd>
						</dl>
					</div>
				</div>
			</c:forEach>
			</div>
		</div>
	</div>



	<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</html>