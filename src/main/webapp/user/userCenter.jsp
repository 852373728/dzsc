<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script> 
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
<script src="${pageContext.request.contextPath}/myJs/jiajianchengchu.js"></script>
<script type="text/javascript">
	$(function(){
		TwoTitleAndTwoNavigation();
	});
	
	function shuaxin(){
		window.location.reload();
	}
	
	function TwoTitleAndTwoNavigation(){
		$(".userCenterTwoLevelName").each(function(){
			if($(this).html()==$(".daohangerji").html()){
				$(this).attr("class","userCenterTwoLevelName on");
				$(this).parents("div.collapse").attr("class","collapse in");
			}
		});
		
	}
</script>
<title>个人中心</title>
</head>
<body><!-- #337ab7 -->
	<jsp:include page="../common/topTop.jsp" flush="true"/>
	<jsp:include page="../common/top.jsp" flush="true"/>
	<input type="hidden" value="userCenter" id="yeMianPanDing"/>
	<div class="w10 margin_top10 content">
		<div class="left_side float_left">
			<c:forEach items="${userCenterList }" var="userCenter" varStatus="status">
			<dl>
				<dt role="button" data-toggle="collapse" href="#collapseExample${status.index }" aria-expanded="true" aria-controls="collapseExample${status.index }">
 					${userCenter.name }
					<i></i>
				</dt>
				<dd>
					<div class="collapse" id="collapseExample${status.index }" aria-expanded="true">
					<ul>
						<c:forEach items="${userCenter.userCenterList }" var="userCenterTwo">
						<li><a class="userCenterTwoLevelName" href="/userCenter.html?cansu=${userCenterTwo.name }" onclick="userqiuqing(this)">${userCenterTwo.name }</a></li>
						</c:forEach>
					</ul>
					</div>
				</dd>
			</dl>
			</c:forEach>
		</div>
		<div class="right_side floatRight">
			<div class="fn_mod">
				<div class="curm">
					<i class="ico"></i>
					<a >用户中心</a>&nbsp;&gt;&nbsp;<span>${userCenter.userCenter.name }</span>&nbsp;&gt;&nbsp;<span class="daohangerji">${userCenter.name }</span>
				</div>
				<jsp:include page="${userPage }" flush="true"/>
			</div>
		</div> 
		<div class="clear"></div>
	</div>
</body>
</html>