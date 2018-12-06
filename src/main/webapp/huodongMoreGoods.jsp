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
<script src="${pageContext.request.contextPath}/myJs/kegong.js"></script> 
<script type="text/javascript">
 $(function(){
	 var url="huodongMore";
	backGround();
	tabPicture();
	shuBiaoXuanFu();
	xiangXiLeiBie();
	leiBieKongZhi();
	TiaoJianGuoLv(url);
	fenye(url);
	xiaolingRenqiPaixu(url); 
	shuBiaoXuanFuCuXiao();
	jiajian();//商品数量的加减
	sc();
});  
 
</script>
</head>
<body>
	<jsp:include page="common/topTop.jsp" flush="true"/>
	<jsp:include page="common/top.jsp" flush="true"/>
	<input id="yeMianPanDing"  type="hidden" value="3"/><!-- 当前页面的判定 -->
	<div class="crumbs">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<p><a href="homePage.html">药品采购首页</a></p>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 margin_top10">
				<div class="filter-header">
					<a onclick="javascript:judgeZongLei_click()" class="filter-header_a" role="button" data-toggle="collapse" href="#zongLei" aria-expanded="false" aria-controls="zongLei">-收起</a>
					<input type="hidden" id="spkTotal" value="${total}"/>
					<input type="hidden" id="spkCurrentPage" value="${page}"/>
					<input type="hidden" id="spkCurrentSize" value="${size}"/>
					<%-- <span class="floatRight">共找到<i class="red">${total}</i>条相关产品</span> --%>
				</div>
				<div class="filter_item">
					<div class="collapse in" id="zongLei">
					 	<div>
					 		<dl>
					   			<dt>促销类型：</dt>
					   			<dd>
					   				<div class="morecate"><a class="zhankaiShouqi_a" role="button" data-toggle="collapse" href="#mainTopTwoLevel" aria-expanded="false" aria-controls="mainTopTwoLevel">展开</a></div>
					   				<ul class="zhankaiShouqi collapse" id="mainTopTwoLevel">
					   					<c:forEach items="${twobar }" var="twobar">
					   					<li><a class="condition"   adress="twobarName=${twobar.name }">${twobar.name }</a></li>
					   					</c:forEach>
					   				</ul>
					   			</dd>
					   		</dl>
					   		<dl>
					   			<dt>一级分类：</dt>
					   			<dd>
					   				<div class="morecate"><a class="zhankaiShouqi_a" role="button" data-toggle="collapse" href="#yijifenlei" aria-expanded="false" aria-controls="yijifenlei">展开</a></div>
					   				<ul class="zhankaiShouqi collapse" id="yijifenlei">
					   					<c:forEach items="${splbOneList }" var="scyjflb">
					   					<li><a class="condition"   adress="web_splbdm1=${scyjflb.web_splbdm }">${scyjflb.web_splb }</a></li>
					   					</c:forEach>
					   				</ul>
					   			</dd>
					   		</dl>
					   		<dl>
					   			<dt>二级分类：</dt>
					   			<dd>
					   				<div class="morecate"><a class="zhankaiShouqi_a" role="button" data-toggle="collapse" href="#erjifenlei" aria-expanded="false" aria-controls="erjifenlei">展开</a></div>
					   				<ul class="zhankaiShouqi collapse" id="erjifenlei">
					   					<c:forEach items="${splbTwoList }" var="scejflb">
					   					<li><a class="condition" adress="web_splbdm=${scejflb.web_splbdm }">${scejflb.web_splb }</a></li>
					   					</c:forEach>
					   				</ul>
					   			</dd>
					   		</dl>
					   		<dl>
					   			<dt>生产厂家：</dt>
					   			<dd>
					   				<div class="morecate"><a class="zhankaiShouqi_a" role="button" data-toggle="collapse" href="#sccj" aria-expanded="false" aria-controls="sccj">展开</a></div>
					   				<ul class="zhankaiShouqi collapse" id="sccj" >
					   					<c:forEach items="${sccjList }" var="sccj">
					   					<li><a class="condition" adress="SCCJ1=${sccj.SCCJ1 }">${sccj.SCCJ1 }</a></li>
					   					</c:forEach>
					   				</ul>
					   			</dd>
					   		</dl>
					   		<dl>
					   			<dt>剂型：</dt>
					   			<dd>
					   				<div class="morecate"><a class="zhankaiShouqi_a" role="button" data-toggle="collapse" href="#spjxb" aria-expanded="false" aria-controls="spjxb">展开</a></div>
					   				<ul class="zhankaiShouqi collapse" id="spjxb">
					   					<c:forEach items="${jxList }" var="spjxb">
					   					<li><a class="condition" adress="jxmc=${spjxb.jxmc }">${spjxb.jxmc }</a></li>
					   					</c:forEach>
					   				</ul>
					   			</dd>
					   		</dl>
					  	</div>
					</div>
				</div>
				<div class="filter_result margin_top10">
					<div class="info nav_sort">
						<div class="sort">
							<a class="condition1" adress="listPh=1">默认</a><a class="condition1" adress="listPh=2">销量</a><a class="condition1" adress="listPh=3">人气</a>
							<!-- <div class="stockExist">
								<input type="checkbox" id="stockCheck" name="stockCheck"/><label for="stockCheck">仅显示有货</label>
							</div> -->
						</div>
						<div class="viewbtns">
							<a class="img_list on">无图</a>
							<a class="list">列表</a>
							<a class="img_list">大图</a>
						</div>
					</div>
					<div id="list_view" class="no_img_list">
						<c:if test="${spkList!= null && fn:length(spkList) != 0}">
						<div class="list-header">
							<table>
								<tbody>
									<tr>
										<td class="no-name">商品名称</td>
										<td class="no-guige">规格</td>
										<td class="no-cj">生产厂家</td>
										<td class="no-p">采购价</td>
										<td class="no-p">库存数量</td>
										<td class="no-p">中包/整件</td>
										<td class="no-p">拆零限制</td>
										<td class="no-p">有效期</td>
										<td class="no-p">活动内容</td>
										<td>采购操作</td>
									</tr>
								</tbody>
							</table>
						</div>
						<c:forEach items="${spkList }" var="spk" varStatus="status">
							<input class="spk_index" type="hidden" value="${status.index }"/>
							<dl class="list_info goods_item_info ">
								<dt class="info_img"><a href="goodsDetails.html?id=${spk.id }" target="_blank"><img width="168" height="168" class="lazyImg_edit" data_src="${fn:substringBefore(spk.pict, ',')}"> </a></dt>
								<dd class="first_dd">
									<p class="list_product_name">
										<c:if test="${spk.ylmc!='' }">
											<span class="icos y-ico">${spk.ylmc}</span>
										</c:if>
										<a href="goodsDetails.html?id=${spk.id }" class="float_left productName" target="_blank" >${spk.spmc }</a>
									</p>
									<p class="none guige"><span class="no-none">规格：</span>${spk.spgg }</p>
									<p class="company"><a target="_blank" href="kegong.html?SCCJ1=${spk.SCCJ1 }">${spk.SCCJ1 }</a></p>
								</dd>
								<dd class="second_dd">
									<p>
										<span class="no-none float_left">采购价：</span>
										<input type="hidden" value="￥${spk.xsjg }"/>
										<a class="login_look color_red">登录可见</a>
									</p>
									<p class="big-none">
										<span class="no-none float_left">库存数量：</span>
										<input type="hidden" value="${spk.kysl>100?'>100':spk.kysl }"/>
										<a class="login_look">登录可见</a>
									</p>
									<p class="min-sale big-none"><span class="no-none float_left">中包/整件：</span>${spk.nbzsl }/${spk.wbzsl }</p>
									<p class="big-none vip-price" style="top: 50px;"><span class="no-none">拆零限制：</span>${spk.cl_xz==null?'允许':spk.cl_xz }</p>
									<p class="big-none vip-price"><span class="no-none" style="color: #ee4444">有效期：</span>${spk.yxq }</p>
									<p class="big-none">
										<span class="no-none float_left">活动内容：</span>
										<c:if test="${spk.huoDong!=null }">
											<a href="javascript:;" class="validPromotion" style="color: red;">${spk.huoDong.huoDongContent }</a> 
										</c:if>
									</p>
								</dd>
								<dd class="dd_goods_cart">
									<div class="numbers big-none">
										<div class="goods_buy_number">
											<input type="text" value="1" class="num_input"/>
											<a href="javascript:;" class="up_btn"></a>
											<a href="javascript:;" class="lower_btn"></a>
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
										<a href="javascript:;" class="big_show  loginBtn">收藏</a>
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
							<div class="cuxiao">${spk.huoDong.huoDongContent }</div>
						</c:forEach>
						<div class="clear"></div>
						<div  class="floatRight feny">
							<ul id="frontPage" class="pagination fenyeClass"></ul>
							<div class="page_jump_btn">
								<a href="javascript:page_jump_btn('huodongMore')"></a>
							</div>
						</div>
						</c:if>
						<c:if test="${spkList == null || fn:length(spkList) == 0}">
							<div class="error margin_top20">
								<h2 class="title">对不起, 没有符合筛选条件的商品</h2>
							</div>
						</c:if>
					</div>
					<div class="float_left r-frame" style="display: none;">
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
	
	
	<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</html>