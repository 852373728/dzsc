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
<title>推荐品种</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script> 
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
<script type="text/javascript">
	$(function(){
		carousel_style();
		buTongYanSe();
	});

	//轮播图片默认第一张显示
	function carousel_style(){
		$(".carousel_input").each(function(){
			if($(this).val()==0){
				$(this).parent().addClass('active');
			}			
		});
	}
	
	//控制四个栏目的不同颜色等样式
	function buTongYanSe(){
		$('.mode_floor').each(function(){
			if($(this).prev().val()==0){
				$(this).addClass("handsel");
			}if($(this).prev().val()==1){
				$(this).addClass("special");
			}if($(this).prev().val()==2){
				$(this).addClass("standing");
			}if($(this).prev().val()==3){
				$(this).addClass("hot");
			}
		});
	}
</script>
</head>
<body>
	<jsp:include page="common/topTop.jsp" flush="true"/>
	<jsp:include page="common/top.jsp" flush="true"/>
	<input id="yeMianPanDing"  type="hidden" value="2"/><!-- 当前页面的判定 -->
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<c:forEach items="${twoBar }" var="mainTopTwoLevel" varStatus="status">
					<input type="hidden" value="${status.index }" />
					<div class="mode_floor margin_top20">
						<div class="title">
							<h2>${mainTopTwoLevel.name }</h2>
							<a class="more" href="tuijianMore.html?twobarName=${mainTopTwoLevel.name }" target="_blank">更多</a>
						</div>
						<div class="cont">
							<dl>
								<dt>
									<c:if test="${mainTopTwoLevel.tuiJian!=null }">
									<h3>${mainTopTwoLevel.tuiJian.spk.spmc }</h3>
									<a href="goodsDetails.html?id=${mainTopTwoLevel.tuiJian.spk.id }"><img src="${mainTopTwoLevel.tuiJian.sptpljLeft }" width="192" height="258" alt="${mainTopTwoLevel.tuiJian.spk.spmc }" title="${mainTopTwoLevel.tuiJian.spk.spmc }" ></a>
									</c:if>			
								</dt>
								<dd>
									<ul class="index_goods_list">
									<c:forEach items="${mainTopTwoLevel.tuiJianList }" var="mainTopGoodsList">
										<li class="index_goods_item">
											<div class="mainTopGoods_img">
												<a href="goodsDetails.html?id=${mainTopGoodsList.spk.id }"><img class="lazyImg" width="179" height="179" alt="${mainTopGoodsList.spk.spmc }" title="${mainTopGoodsList.spk.spmc }" data_src="${fn:substringBefore(mainTopGoodsList.spk.pict, ',')}"></a>
											</div>
											<div class="mainTopGoods_price">零售价：<span class="rmb">￥${mainTopGoodsList.spk.splsdj }</span></div>
											<div class="mainTopGoods_purchase">
												<span class="red">采购价：</span>
												<input type="hidden" value="￥${mainTopGoodsList.spk.xsjg }"/>
												<a class="login_look">登录可见</a>
											</div>
											<div class="mainTopGoods_name">${mainTopGoodsList.spk.SCCJ1}</div>
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