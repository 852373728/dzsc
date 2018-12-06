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
		var url="pinpaiDetails";
		shuBiaoXuanFu();
		shuBiaoXuanFuCuXiao();
		fenye(url);
		sc();
	});


</script>
</head>
<body>
	<input type="hidden" id="spkTotal" value="${total}"/>
	<input type="hidden" id="spkCurrentPage" value="${page}"/>
	<input type="hidden" id="spkCurrentSize" value="${size}"/>
	<jsp:include page="common/topTop.jsp" flush="true"/>
	<jsp:include page="common/top.jsp" flush="true" />
	<input id="yeMianPanDing"  type="hidden" value="4"/><!-- 当前页面的判定 -->
	<div class="container">
		<div class="row">
			<div class="col-xs-12 margin_top10">
				<div class="show_brand_info">
					<div class="text">
						<i><img width="136" height="67" class="lazyImg" alt="${sccj.cjmc }" title="${sccj.cjmc }" data_src="${fn:substringBefore(sccj.tplj, ',')}"></i>
					</div>
					<div class="floatRight company-info">${sccj.cjjj }</div>
					<div class="clear"></div>
				</div>
				<div class="shop_filter margin_top10">
					<div class="filter_result margin_top10">
						<div id="list_view" class="big_img_list">
						<c:if test="${sccj.spkList!= null && fn:length(sccj.spkList) != 0}">
							<c:forEach items="${sccj.spkList }" var="spk" varStatus="status">
								<input class="spk_index" type="hidden" value="${status.index }"/>
								<dl class="list_info goods_item_info ">
									<dt class="info_img"><a href="goodsDetails.html?id=${spk.id }" target="_blank"><img width="168" height="168" class="lazyImg" data_src="${fn:substringBefore(spk.pict, ',')}"> </a></dt>
									<dd class="first_dd">
										<p class="list_product_name">
											<c:if test="${spk.ylmc!='' }">
												<span class="icos y-ico">${spk.ylmc}</span>
											</c:if>
											<a href="goodsDetails.html?id=${spk.id }" class="float_left productName" target="_blank" >${spk.spmc }</a>
										</p>
										<p class="none guige"><span class="no-none">规格：</span>${spk.spgg }</p>
										<p class="company"><a target="_blank" href="kegong.html?SCCJ1=${spk.SCCJ1 }">${spk.SCCJ1 }</a></p>
										<p class="none"><span class="no-none">库&nbsp;&nbsp;存：</span>有货</p>
									</dd>
									<dd class="second_dd">
										<p>
											<span class="no-none float_left">采购价：</span>
											<input type="hidden" value="￥${spk.xsjg }"/>
											<a class="login_look color_red">登录可见</a>
										</p>
										<p class="big-none"><span class="no-none">中包价：</span>--</p>
										<p class="big-none"><span class="no-none">整件价：</span>--</p>
										<p class="vip-price big-none"><span class="no-none">控销联盟价：</span>--</p>
										<p class="min-sale big-none"><span class="no-none float_left">中包/整件：</span>${spk.nbzsl }${spk.dw }/${spk.wbzsl }${spk.dw }</p>
										<p class="none">毛利率：--</p>
									</dd>
									<dd class="dd_goods_cart">
										<p class="big-none"><span class="no-none" style="color: #ee4444">有效期：</span>--</p>
										<div class="numbers big-none">
											<div class="goods_buy_number">
												<input type="text" value="1" class="num_input"/>
												<a href="#" class="up_btn"></a>
												<a href="#" class="lower_btn"></a>
											</div>
											<span class="basis_num">
												<span style="margin-left:5px;">${spk.dw }</span>
												<span style="margin-left:2px;"></span>
											</span>
										</div>
										<div class="handle margin_top10 bidui" shoucang="${spk.spdm }">
											<span class="add_cart">
												<i>加入购物车</i>
											</span>
											<span class="collect loginBtn"></span>
											<a href="#" class="big_show  loginBtn">收藏</a>
										</div>
									</dd>
								</dl>
								<div class="no_img_product_info">
									<div class="no_img_left_img">
										<img class="lazyImg" data_src="${fn:substringBefore(spk.pict, ',')}" width="160px" height="160px">
									</div>
									<ul class="no_img_right_info">
										<li>品名：<span>${spk.spmc } </span></li>
										<li>规格：<span>${spk.spgg }</span></li>
										<li>所属范围：<span>${spk.splb }</span></li>
										<li>药品编号：<span>${spk.spdm }</span></li>
										<li>批准文号/注册证号：<span>${spk.pzwh }</span></li>
									</ul>
								</div>
							</c:forEach>
							<div class="clear"></div>
							<div  class="floatRight feny">
								<ul id="frontPage" class="pagination fenyeClass"></ul>
								<div class="page_jump_btn">
									<a href="javascript:page_jump_btn('pinpaiDetails')"></a>
								</div>
							</div>
							</c:if>
							<c:if test="${sccj.spkList == null || fn:length(sccj.spkList) == 0}">
								<div class="error margin_top20">
									<h2 class="title">对不起, 没有符合筛选条件的商品</h2>
								</div>
							</c:if>
						</div>
						<div class="float_left r-frame">
							<div class="floatRight mode_right new-p-list">
								<div class="topic">
									<h2>热销新品<a href="#" class="more">更多</a></h2>
									<ul class="news_list">
										<c:forEach items="${hotNew }" var="spk">
											<li><a href="goodsDetails.html?id=${spk.id }" target="_blank">${spk.spmc }</a></li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</html>