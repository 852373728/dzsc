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
<title>控销品种</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script> 
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
<script type="text/javascript">
$(function(){
	var url="kongxiao";
	fenye(url);
	backGround1();
	
	$(".downzjd").click(function(){
		if(currentUser!=null && currentUser.zt=="2"){
			alert("下载质检单");
		}else{
			pop_upLogin();
		}
	});	
});

//背景色的变化
function backGround1(){
	$('.limit-item').each(function(){
		if($(this).attr("zt")%2==1){
			$(this).addClass("odd");
		}
	});
	
}

//商品搜索
function searchKongxiao(){
	var tiaojian=$("#kongxiao-input").val();
	if(tiaojian==""){
		return ;
	}
	window.location.href="${pageContext.request.contextPath}/kongxiao.html?limitSearch="+tiaojian;
}
</script>
<script src="${pageContext.request.contextPath}/myJs/kegong.js"></script> 
</head>
<body>
	<jsp:include page="common/topTop.jsp" flush="true"/>
	<jsp:include page="common/top.jsp" flush="true"/>
	<input id="yeMianPanDing"  type="hidden" value="2"/><!-- 当前页面的判定 -->
	<div class="crumbs">
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<p>控销品种请选择电话下单</p>
			</div>
		</div>
	</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="margin_top10">
					<div class="limit-search">
						<input type="text" id="kongxiao-input" class="search-input" placeholder="请输入商品名称|商品助记码|厂家名称|功能主治进行搜索" value="">
						<button style="cursor: pointer;" onclick="searchKongxiao()">搜索控销品种</button>
					</div>
					<div class="limit-list">
						<input type="hidden" id="spkTotal" value="${total}"/>
						<input type="hidden" id="spkCurrentPage" value="${page}"/>
						<input type="hidden" id="spkCurrentSize" value="${size}"/>
						<c:forEach items="${kongxiaoList }" var="kongxiao" varStatus="status">
						<div class="over limit-item" zt="${status.index }">
							<div class="float_left img">
								<img alt="${kongxiao.spmc }" width="69px" height="69px" class="lazyImg" data_src="${fn:substringBefore(kongxiao.pict, ',')}">
							</div>
							<div class="floatRight limit-info">
								<p class="over name">
									<span class="float_left">${kongxiao.spmc }</span>
									<a href="javascript:;" class="floatRight down-btn downzjd">登录下载质检单</a>
								</p>
								<div class="over info-detail">
									<div class="float_left">
										<p>
											<span>规格：</span>
											<span>${kongxiao.spgg }</span>
										</p>
										<p>${kongxiao.SCCJ1 }</p>
									</div>
									<div class="float_left">
										<p>
											<span>所属范围:</span>
                                            <span>${kongxiao.splb }</span>
										</p>
										<p>
                                            <span>库  存:</span>
											<span>有货</span>
                                        </p>
									</div>
									<div class="floatRight">
										<p>
                                            <span>药品编号:</span>
                                            <span>${kongxiao.spdm }</span>
                                        </p>
                                        <p>
                                            <span>批准文号:</span>
                                            <span>${kongxiao.pzwh }</span>
                                        </p>
									</div>
								</div>
							</div>
						</div>
						</c:forEach>
					</div>
					<div  class="floatRight feny">
						<ul id="frontPage" class="pagination fenyeClass"></ul>
						<div class="page_jump_btn">
							<a href="javascript:page_jump_btn('kongxiao')"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</html>