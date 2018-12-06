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
<title>首页</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script> 
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
<script type="text/javascript">
	$(function(){
		carousel_style();
		tab_style();
		liebie_icon();
	});

	//轮播图片默认第一张显示
	function carousel_style(){
		$(".carousel_input").each(function(){
			if($(this).val()==0){
				$(this).parent().addClass('active');
			}			
		});
		$(".carousel_inputMax").each(function(){
			if($(this).val()==0){
				$(this).parent().parent().addClass('active');
			}			
		});
	}
	
	//推荐活动和活动专区模块默认第一个显示
	function tab_style(){
		$('.tuijianAndHuodong_ul').each(function(){
			$(this).find('li').eq(0).addClass('active');
			$(this).find('a').hover(function (e) {
				  e.preventDefault()
				  $(this).tab('show')
				});
		});
		$('.tuijianAndHuodong_bodyRight').each(function(){
			$(this).find('div>div').eq(0).addClass('active');
		});
		
	}
	
	function liebie_icon(){
		$('.floors_title_input').each(function(){
			if($(this).val()==0){
				$(this).parent().addClass("floors_title_icon0");
			}else if($(this).val()==1){
				$(this).parent().addClass("floors_title_icon1");
			}else if($(this).val()==2){
				$(this).parent().addClass("floors_title_icon2");
			}else if($(this).val()==3){
				$(this).parent().addClass("floors_title_icon3");
			}
			
		});
	}
	
	function backcolor(){
		var backli=$(".backli.active");
		var bc=backli.children('.cabackcol').val();
		backli.css({'background-color':bc});
	}
	
	function djtc(myself){
		if($(myself).attr("bz")==0){
			window.location.href="tuijianMore.html?twobarName="+$(myself).html();
		}else{
			window.location.href="huodongMore.html?twobarName="+$(myself).html();
		}
		
	}
</script>
</head>
<body>
	<jsp:include page="common/topTop.jsp" flush="true"/>
	<jsp:include page="common/top.jsp" flush="true"/>
	<input id="yeMianPanDing"  type="hidden" value="0"/><!-- 当前页面的判定 -->
	<div class="zbc" style="width: 100%;height: 350px">
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	  <ol class="carousel-indicators">
	    <c:forEach items="${listCarousel }" var="Carousel" varStatus="status">
	    	<li data-target="#carousel-example-generic" data-slide-to="${status.index }">
	    		<span><input class="carousel_inputMax" type="hidden" value="${status.index }" /></span>
	    	</li>
	    </c:forEach>
	  </ol>
	  <div class="carousel-inner tupian_1" role="listbox">
	    <c:forEach items="${listCarousel }" var="Carousel" varStatus="status">
	    <div class="item" style="background-color: ${Carousel.backcolor }">
	      <div style="width: 1200px;margin: 0 auto;">
	      <input class="carousel_inputMax" type="hidden" value="${status.index }" />
	      <a target="_blank" href="goodsDetails.html?id=${Carousel.spkid }"><img src="${Carousel.tplj }" alt="${Carousel.spk.spmc }" style="width: 1002px;height: 350px;" title="${Carousel.spk.spmc }"></a>
	   	  </div>
	    </div>
	    </c:forEach>
	  </div>
	</div>  
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-xs-12" style="margin-top: 10px">
				<div class="interested">
					<div class="interested_head">
						<p style="color: #337ab7;font-weight: bold;font-size: 15px;">新品上市</p>
						<p style="float: right;"><a style="color: #337ab7;font-weight: bold;font-size: 15px;" class="more" href="tuijianMore.html?twobarName=新品上市" target="_blank">更多</a></p>
					</div>
					<div class="interested_list">
						<ul>
							<c:forEach items="${listShouyexpss }" var="shouyexpss" varStatus="status">
								<li class="interested_list_li">
									<a href="goodsDetails.html?id=${shouyexpss.id }" target="_blank"><img class="lazyImg" alt="${shouyexpss.spmc }" title="${shouyexpss.spmc }" width="166" height="166" data_src="${fn:substringBefore(shouyexpss.pict, ',')}"> </a>
								</li>
							</c:forEach> 
						</ul>
					</div>
				</div>
				<div class="accordion_own">
					<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
					 <div class="panel panel-default">
					    <div class="accordion_ownHead" role="tab" id="heading2">
					        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse2" aria-expanded="true" aria-controls="collapse2">
					          	销量排行
					        </a>
					    </div>
					    <div id="collapse2" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading2" aria-expanded="true">
					      <div class="accordion_ownBody">
					      	<ul>
					      	<c:forEach items="${saleList }" var="xsjs" >
					      			<li>
					      				<span class="sptj_class">售${xsjs.xlph}件</span>
					      				<a class="sptj_a" target="_blank" href="goodsDetails.html?id=${xsjs.id}">${xsjs.spmc}</a>
					      			</li>
					      	</c:forEach>
					      	</ul>
					      </div>
					    </div>
					  </div>
					  <div class="panel panel-default">
					    <div class="accordion_ownHead" role="tab" id="heading3">
					        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse3" aria-expanded="false" aria-controls="collapse3">
					          	点击排行
					        </a>
					    </div>
					    <div id="collapse3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading3" aria-expanded="false">
					      <div class="accordion_ownBody">
					      	<ul>
					      	<c:forEach items="${clickList }" var="djjs" >
					      			<li>
					      				<span class="sptj_class">${djjs.djph}次</span>
					      				<a class="sptj_a" target="_blank" href="goodsDetails.html?id=${djjs.id}">${djjs.spmc}</a>
					      			</li>
					      	</c:forEach>
					      	</ul>
					      </div>
					    </div>
					  </div>
					</div>
				</div> 
			</div>
		</div>
		<c:forEach items="${listHdatj}" var="tuiJianAndHuoDong_bean" varStatus="tuiJianAndHuoDongStatus">
		<div class="row tuijianAndHuodong_parent">
			<div class="col-xs-12 tuijianAndHuodong">
				<div class="tuijianAndHuodong_head">
				  <h2>${tuiJianAndHuoDong_bean.name }</h2>
				  <ul class="nav nav-tabs tuijianAndHuodong_ul cajjj" role="tablist">
				  	<c:forEach items="${tuiJianAndHuoDong_bean.twoBarList }" var="mainTopTwoLevel" varStatus="status">
				    <li role="presentation" ><a onclick="djtc(this)" bz="${tuiJianAndHuoDongStatus.index }" href="#home${tuiJianAndHuoDongStatus.index }${status.index }" aria-controls="home${tuiJianAndHuoDongStatus.index }${status.index }" role="tab" data-toggle="tab">${mainTopTwoLevel.name }</a></li>
				  	</c:forEach>
				  </ul>
				  <a href="${tuiJianAndHuoDong_bean.url }" class="more_btn">${tuiJianAndHuoDong_bean.urlName }&gt;&gt;</a>
				</div>
				 <div class="tuijianAndHuodong_body">
					<div class="tuijianAndHuodong_bodyLeft">
						<c:if test="${tuiJianAndHuoDong_bean.tuiJianList!=null  && fn:length(tuiJianAndHuoDong_bean.tuiJianList) > 0 }">
						<div id="carousel-example-generic1" class="carousel slide" data-ride="carousel">
						  <ol class="carousel-indicators">
						    <c:forEach items="${tuiJianAndHuoDong_bean.tuiJianList }" var="Carousel" varStatus="status">
						    	<li data-target="#carousel-example-generic1" data-slide-to="${status.index }">
						    		<input class="carousel_input" type="hidden" value="${status.index }" />
						    	</li>
						    </c:forEach>
						  </ol>
						  <div class="carousel-inner" role="listbox">
						    <c:forEach items="${tuiJianAndHuoDong_bean.tuiJianList }" var="Carousel" varStatus="status">
						    <div class="item">
						      <input class="carousel_input" type="hidden" value="${status.index }" />
						      <a target="_blank" href="goodsDetails.html?id=${Carousel.spkId }"><img style="width: 200px;height: 288px;" src="${Carousel.homePageTuijianCarouselTp }" ></a>
						    </div>
						    </c:forEach>
						  </div>
						</div> 
						</c:if>
						<c:if test="${tuiJianAndHuoDong_bean.huoDongList!=null  && fn:length(tuiJianAndHuoDong_bean.huoDongList) > 0 }">
						<div id="carousel-example-generic2" class="carousel slide" data-ride="carousel">
						  <ol class="carousel-indicators">
						    <c:forEach items="${tuiJianAndHuoDong_bean.huoDongList }" var="Carousel" varStatus="status">
						    	<li data-target="#carousel-example-generic2" data-slide-to="${status.index }">
						    		<input class="carousel_input" type="hidden" value="${status.index }" />
						    	</li>
						    </c:forEach>
						  </ol>
						  <div class="carousel-inner" role="listbox">
						    <c:forEach items="${tuiJianAndHuoDong_bean.huoDongList }" var="Carousel" varStatus="status">
						    <div class="item">
						      <input class="carousel_input" type="hidden" value="${status.index }" />
						      <a target="_blank" href="goodsDetails.html?id=${Carousel.spkId }"><img style="width: 200px;height: 288px;" src="${Carousel.homePageHuoDongCarouselTp }"></a>
						    </div>
						    </c:forEach>
						  </div>
						</div> 
						</c:if>
					</div>
					<div class="tuijianAndHuodong_bodyRight">
					  <div class="tab-content">
					  	<c:forEach items="${tuiJianAndHuoDong_bean.twoBarList }" var="mainTopTwoLevel" varStatus="status">
					     <div role="tabpanel" class="tab-pane " id="home${tuiJianAndHuoDongStatus.index }${status.index }">
					     	<ul class="tuijianAndHuodong_list">
								<c:forEach items="${mainTopTwoLevel.tuiJianList }" var="mainTopGoods">
								<c:if test="${mainTopGoods.spk!=null }">
									<li>
										<div class="mainTopGoods_img">
											<a target="_blank" href="goodsDetails.html?id=${mainTopGoods.spk.id }">
											<img class="lazyImg" alt="${mainTopGoods.spk.spmc }" title="${mainTopGoods.spk.spmc }" data_src="${fn:substringBefore(mainTopGoods.spk.pict, ',')}"> 
											</a>
										</div>
										<div class="mainTopGoods_price">
											零售价：<span class="rmb">￥${mainTopGoods.spk.splsdj }</span>
										</div>
										<div class="mainTopGoods_purchase">
											<span class="red">采购价：</span>
											<input type="hidden" value="￥${mainTopGoods.spk.xsjg }"/>
											<a class="login_look">登录可见</a>
										</div>
										<div class="mainTopGoods_name">
											${mainTopGoods.spk.SCCJ1 }
										</div>
									</li>
								</c:if>
								</c:forEach>	
								 <c:forEach items="${mainTopTwoLevel.huoDongList }" var="huoDongGoods">
									<c:if test="${huoDongGoods.spk!=null }">
									<li>
										<div class="mainTopGoods_img">
											<a target="_blank" href="goodsDetails.html?id=${huoDongGoods.spk.id }">
											<img class="lazyImg" alt="${huoDongGoods.spk.spmc }" title="${huoDongGoods.spk.spmc }" data_src="${fn:substringBefore(huoDongGoods.spk.pict, ',')}">
											</a>
										</div>
										<div class="mainTopGoods_price">
											零售价：<span class="rmb">￥${huoDongGoods.spk.splsdj }</span>
										</div>
										<div class="mainTopGoods_purchase">
											<span class="red">采购价：</span>
											<input type="hidden" value="￥${huoDongGoods.spk.xsjg }"/>
											<a class="login_look1">登录可见</a>
										</div>
										<div class="mainTopGoods_name">
											${huoDongGoods.spk.SCCJ1 }
										</div>
									</li>
									</c:if>
								</c:forEach>
					     	</ul>
					     </div>
					  	</c:forEach>
					  </div> 
					</div>
				</div> 
			</div>
		</div>
		</c:forEach> 
	</div>
	
	<jsp:include page="common/foot.jsp"></jsp:include> 
</body>
</html>