<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<title>首页</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script> 
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
</head>
<body>
	<jsp:include page="../common/topTop.jsp" flush="true"/>
	<jsp:include page="../common/top.jsp" flush="true"/>
	<input id="yeMianPanDing"  type="hidden" value="goodsDetail"/><!-- 当前页面的判定 -->
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="registerSuccess">
					注册成功，请与相关业务员联系，确保通过审核！
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>