<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="/js/topTop.js"></script>
<script src="${pageContext.request.contextPath}/js/jsPost.js"></script>

<script type="text/javascript">
	var $maskBg;
	var $frame_login;
	$(function(){
		$maskBg=$('#maskBg').remove();
		$frame_login=$('#frame_login').remove();
		dropdownOpen();
		topleft();
		judgingLogin();
		showSpfl();
		shopCarNumLoad();  
		loadlazy();
	});
	
	function loadlazy(){
	   $('.lazyImg').each(function(){
           	var src=$(this).attr("data_src");
            $(this).attr("src","${pageContext.request.contextPath}/picture.do?src="+src+"&width="+$(this).width()+"&height="+$(this).height());
       })
       $('.lazyImg_edit').each(function(){
           	var src=$(this).attr("data_src");
           	var width=$(this).attr("width");
           	var height=$(this).attr("height");
            $(this).attr("src","${pageContext.request.contextPath}/picture.do?src="+src+"&width="+width+"&height="+height);
       })
	}
	    
	function shopCarNumLoad(){
		$.post("${pageContext.request.contextPath}/shopCar/count.html",function(result){
			$("#shopCarCount").html(result.shopCarCount);
		},"json");
	}  
	//首页头部全部商品分类默认一直显示
	function showSpfl(){
		if($('#yeMianPanDing').val()==0){
			$('.moRenXianShi').css("display","block");
			$('.mainTop').find('li').eq(0).addClass("mainTop_li");
		}else if($('#yeMianPanDing').val()==1){
			$('.mainTop').find('li').eq(1).addClass("mainTop_li");
		}else if($('#yeMianPanDing').val()==2){
			$('.mainTop').find('li').eq(2).addClass("mainTop_li");
		}else if($('#yeMianPanDing').val()==3){
			$('.mainTop').find('li').eq(3).addClass("mainTop_li");
		}else if($('#yeMianPanDing').val()==4){
			$('.mainTop').find('li').eq(4).addClass("mainTop_li");
		}else if($('#yeMianPanDing').val()==5){
			$('.mainTop').find('li').eq(5).addClass("mainTop_li");
		}else if($('#yeMianPanDing').val()==6){
			$('.mainTop').find('li').eq(6).addClass("mainTop_li");
		}else if($('#yeMianPanDing').val()=="goodsDetail"){
			$('.mainTop').find('li').eq(0).addClass("mainTop_li");
		}else if($('#yeMianPanDing').val()=="w10"){
			$('.mainTop').find('li').eq(0).addClass("mainTop_li");
			$("#top").css("margin-bottom","0");
			$("#top").find(".col-xs-12").attr("class","w10");
			$("#header").find(".col-xs-12").attr("class","w10");
			$("#header").find(".yingyetupian").remove();
		}else if($("#yeMianPanDing").val()==10||$("#yeMianPanDing").val()==11){
			$("#top").css("margin-bottom","0");
			$("#top").find(".col-xs-12").attr("class","w1000");
			$("#header").find(".col-xs-12").attr("class","w1000");
			$("#header").find(".sousuo_").remove();
		}else if($('#yeMianPanDing').val()=="userCenter"){
			$('.mainTop').find('li').eq(0).addClass("mainTop_li");
			$("#top").css("margin-bottom","0");
			$("#top").find(".col-xs-12").attr("class","w10");
			$("#header").find(".col-xs-12").attr("class","w10");
			$("#header").find(".yingyetupian").remove();
			$(".daohangtiao").css({
			    width: "1100px",
		   		margin: "0 auto"
			});
		}
	}
		
		function judgingLogin(){
			$(".login_look").click(function(){
				$.post("/kh/reload.html",function(result){
					if(result.state){
						return;
					}else{
						pop_upLogin();
					}
				},"json");
			});	
			
			$(".add_cart").click(function(){
				var obj=$(this);
				$.post("/kh/reload.html",function(result){
					if(result.state){
						var spdm=obj.parents("dl.list_info").next().find("ul.no_img_right_info").children("li").eq(3).children("span").html();
						if(spdm==undefined){
							spdm=obj.attr("spdm");
						}
						var num=obj.parents("dd.dd_goods_cart").find("input.num_input").val();
						if(num==undefined){
							num=$(".num_input").val();
						}
						var spph=obj.attr("spph");
						$.post("/shopCar/add.html",{"spdm":spdm,"num":num},function(result){
							if(result.state){
								alert(result.msg);
								if(result.shopCarCount!=null){
									$("#shopCarCount").html(result.shopCarCount);
								}
							}else{
								alert(result.msg);
							}
						},"json");
					}else{
						pop_upLogin();
					}
				},"json");
			});
			$(".loginBtn").click(function(){
				var obj=$(this);
				$.post("/kh/reload.html",function(result){
					if(result.state){
						var pa=obj.parent();
						var spdm= obj.parent().attr("shoucang");
						$.post("/collection/save.html",{"spdm":spdm},function(result){
							if(result.state){
								alert(result.msg);
								pa.children("span.collect").attr("class","collect loginBtn on");
							}else{
								alert(result.msg);
							}
						},"json");
					}else{
						pop_upLogin();
					}
				},"json");
			});
		};
	
	function loadimage(){
		document.getElementById("randImage").src = "${pageContext.request.contextPath}/image.jsp?"+Math.random();
	}

	
	function closeLoginWindow(){
			$maskBg=$('#maskBg').remove();
			$frame_login=$('#frame_login').remove();
	}
	
	
	
	function topleft(){
		$.post("/kh/zzzl.html",function(result){
			if(result.state==false){
				delCookie("email");
				delCookie("password");
				window.location.href="/homePage.html";
			}
		},"json");
		$.post("/kh/ztOne.html",function(result){
			if(result.state){
				var cu= result.currentUser;
				$('.login_span').html(cu.lxr+'&nbsp;<a href="javascript:zhuxiao()" class="zhuxiaoBtn">注销</a>');
				if(cu.zt=="2"){
					if(cu.st_userclass=="客户" || cu.st_userclass=="业务员" || cu.st_userclass=="管理员"){
						$('.login_look').each(function(){
							$(this).html($(this).prev().val());
							if($(this).is(".color_red")){
								$(this).css({"color":"red"});
							}
							if($(this).is(".zengda")){
								$(this).css("font-size","20px");
							}
						});
						$('.showLoggedIn').each(function(){
							$(this).html($(this).prev().val());
						}); 
					}
				} 
			}else{
				$('.login_span').html('请&nbsp;<a href="javascript:pop_upLogin()" class="loginBtn">登录</a>');
			}
		},"json");
	}

	function pop_upLogin(){
		if($("#yeMianPanDing").val()==10){
			window.location.reload();
			return;
		}
		$maskBg.appendTo("body");
		$frame_login.appendTo("body");
		$("#maskBg").css("display","block");
		$(".frame_login").css("display","block");
		$('.frame_login').css({
			top:$(window).height()/2-$('.frame_login').height()/2,
			left:$(window).width()/2-$('.frame_login').width()/2
		});
	}
	
	
	function zhuxiao(){
		delCookie("email");
		delCookie("password");
		$('.zhuxiaoBtn').attr("disabled", true); 
		window.location.href="/homePage.html";
	}
	
	function dropdownOpen() {
		var $dropdownLi = $('.dropdown');
		$dropdownLi.mouseover(function() {
			$(this).addClass('open');
		}).mouseout(function() {
			$(this).removeClass('open');
		});
	}
	
	//商品搜索
	function searchGoods(){
		var tiaojian=$.trim($("#tiaojian").val());
		if($.trim(tiaojian)==""){
			return ;
		}
		window.location.href="${pageContext.request.contextPath}/kegong.html?bigSearch="+tiaojian;
	}
	
	//跳转登录，购物车，我的订单等登录，页面的最上面几个的登录跳转位置
	function jumpLogon(cansu){
		window.location.href="/userCenter.html?cansu="+cansu;
	}
	function zjd(){
		$.post("zjd.do",function(result){
			if(result.status){
				window.location.href="http://www.zjxhyy.cn:13245/xhzjd";/* http://www.zjxhyy.cn/xhzjd */
			}else{
				pop_upLogin();
			}
		},"json");
	}
	
	
	
</script>



	<div id="maskBg"></div>
	<div id="frame_login" class="login_box frame_login" >
		<a href="javascript:closeLoginWindow()" class="close1"></a>
		<h1 class="title">登录</h1>
		<form id="myform" method="post">
			<div class="item  margin_top10">
				<span class="zhanghaomimatext">账号：</span><input AUTOCOMPLETE="off" type="text" name="email" class="username" id="username" placeholder="账号">
			</div>
			<div class="item  margin_top10">
				<span class="zhanghaomimatext">密码：</span><input type="password" name="password" class="pwd" id="pwd" placeholder="密码" onkeydown="if(event.keyCode==13) toyanzheng()">
			</div>
			<div class="item  margin_top10 captcha_box">
				<span class="zhanghaomimatext">验证码：</span>
				<input AUTOCOMPLETE="off" type="text" class="captcha" id="captchaCode" name="imageCode" placeholder="验证码" value=""  onkeydown="if(event.keyCode==13) toyanzheng()">
				<img onclick="javascript:loadimage();" title="换一张试试" name="randImage" id="randImage" src="${pageContext.request.contextPath}/image.jsp" class="captcha_img" >
			</div>
			<div class="item info margin_top10">
				<div class="check">
					<input type="checkbox" id="remember"  checked="checked" >
					<label for="remember">下次自动登录</label>
				</div>
				<!-- <a href="forget.jsp">忘记密码?</a> -->
			</div>
			<div class="item">
				<button class="submit" id="loginBtn" onclick="toyanzheng()" type="button">登&nbsp;&nbsp;录</button>
			</div>
		</form>
		<div class="error_tips error1" id="loginMessage"></div>
	</div>
	<div id="wait" >正在登录...</div>
	<div id="top" style="margin-bottom:15px;">
		<div class="container ">
			<div class="row ">
				<div class="col-xs-12 ">
					<p>
						欢迎来祥合医药&nbsp;<span class="login_span"></span> 
					</p>
					<ul class="topnav">
						<li><a target="_blank" href="javascript:;" onclick="jumpLogon('流向查询')">流向查询</a></li>
						<li><a href="javascript:;" onclick="zjd()">质检单查询</a></li><!--  -->
						<li><a target="_blank" href="javascript:;" onclick="jumpLogon('我的购物车')">购物车(<span id="shopCarCount">0</span>)</a></li>
						<li>
							<div class="dropdown">
								<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人中心
									<span class="caret"></span>
								</a>
								<ul class="dropdown-menu dropdown-menu-right swfw_ul">
									<li class="swfw_li"><a target="_blank" href="javascript:;" onclick="jumpLogon('个人信息')">个人信息</a></li>
									<li class="swfw_li"><a target="_blank" href="javascript:;" onclick="jumpLogon('我的收藏夹')">我的收藏</a></li>
									<li class="swfw_li"><a target="_blank" href="javascript:;" onclick="jumpLogon('企业认证')">企业认证</a></li>
									<li class="swfw_li"><a target="_blank" href="javascript:;" onclick="jumpLogon('订单查询')">我的订单</a></li>
								</ul>
							</div>
						</li>
						<li>
							<a target="_blank" href="http://www.zjxhyy.cn">企业官网</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<div id="header">
		<div class="container ">
		<div class="row">
		<div class="col-xs-12">
			<div class="logo float_left">
				<a href="${pageContext.request.contextPath}/homePage.html"><img style="margin-top: 5px;" src="${pageContext.request.contextPath}/image/xianghe.jpg"></a>
			</div>
			<div class="sousuo_ float_left">
				<div class="input-group">
					<input onkeydown="if(event.keyCode==13) searchGoods()" value="${bigSearch }" id="tiaojian" type="text" class="form-control" placeholder="请输入商品名称|厂家名称|功能主治进行搜索">
					 <span class="input-group-btn">
						<button onclick="searchGoods()" class="btn  anniu_" type="button">搜索</button>
					</span>
				</div>
				<div class="hot">
					<c:forEach items="${hotList }" var="hot">
						<a class="hot_a" href="${pageContext.request.contextPath}/goodsDetails.html?id=${hot.spk.id }" target="_blank">${hot.spk.spmc }</a>
					</c:forEach>
				</div>
			</div>
			<!-- <div class="yingyetupian floatRight">
				营业执照
			</div> -->
		</div>
		</div>
		</div>
	</div>
	
