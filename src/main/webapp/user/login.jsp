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
<title>登录</title>
</head>
<body>
	<jsp:include page="/common/topTop.jsp" flush="true"/>
	
	<script type="text/javascript">
	function loadimage(){
		document.getElementById("randImage").src = "${pageContext.request.contextPath}/image.jsp?"+Math.random();
	}

	$(function(){
		toyanzheng();
	});

	function toyanzheng(){
		 $("#loginBtnn").click(function() {  
	          var params = $("#myform").serialize();  
	          $.ajax( {  
	              type : "POST",  
	              url : "/kh/login.html",  
	              data : params,  
	              dataType:"json",
	              success : function(result) { 
	            	    if(result.state){
		               		 var currentUser= result.currentUser;
		         			 if($('#rememberr').is(':checked')){
		         				setCookieHasTime("email",currentUser.email);
		         				setCookieHasTime("password",currentUser.password);
		       				 }else{
		       					setCookieNoTime("email",currentUser.email);
		       					setCookieNoTime("password",currentUser.password);
		       				 }
		         			 window.location.href="/homePage.html"
		             	}else{
		             		$(".login_tips").attr("class","login_tips show");
		             		$('.msg').html(result.msg);
		             		loadimage();
		             	}
	              }  
	          });  
	      });
	}
</script>
	<input type="hidden" value="10" id="yeMianPanDing"/>
	<div class="member_login_box" >
		<div class="content w10">
			<div class="login_box" style="z-index: 1000;">
				<h1 class="title">登录</h1>
				<form id="myform" method="post">
					<div class="item  margin_top10">
						<span class="zhanghaomimatextLogin">账号：</span><input style="width: 196px;" AUTOCOMPLETE="off" type="text" name="email" class="username" id="username" value="" placeholder="账号">
					</div>
					<div class="item  margin_top10">
						<span class="zhanghaomimatextLogin">密码：</span>
						<input type="password" name="password" class="pwd" id="pwd" placeholder="密码" value="" style="width: 196px;">
					</div>
					<div class="item  margin_top10 captcha_box">
						<input AUTOCOMPLETE="off" type="text" class="captcha" id="captchaCode" name="imageCode" placeholder="验证码" value="">
						<img onclick="javascript:loadimage();" title="换一张试试" name="randImage" id="randImage" src="${pageContext.request.contextPath}/image.jsp" class="captcha_img" >
					</div>
					<div class="item info margin_top10">
						<div class="check">
							<input type="checkbox" id="rememberr"  checked="checked" >
							<label for="rememberr">下次自动登录</label>
						</div>
					</div>
					<div class="item">
						<button class="submit" id="loginBtnn" type="button">登&nbsp;&nbsp;录</button>
					</div>
				</form>
			</div>
			<div class="login_tips">
				<div class="msg"></div>
				<div class="arrow"></div>
			</div>
		</div>
	</div>
	<div id="wait" >正在登录...</div>
</body>
</html>
