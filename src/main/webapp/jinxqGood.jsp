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
<title>促销商品详情</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script> 
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
<script type="text/javascript">
	$(function(){
		sptplj_60x60List();
		sptplj_379x379List();
		tupianXuanzhong();
		gundongtupian();
		showBigPicture(); 
		jiajian();
		sc();
		xxsms();
	});
	
	//说明图片的排列
	function xxsms(){
		var pict_sm=$("#pict_sm").val().split(",");
		pict_sm.pop();
		var str="";
		for(var i in pict_sm){
			str+="<img src='/files/"+pict_sm[i]+"'>";
		}
		$("#spsmsxx").html(str);
	}
	
	function sptplj_60x60List(){
		var thumblist=$("#thumblist");
		var sptplj_60x60=$("#pict").val().split(",");
		sptplj_60x60.pop();
		var str="";
		if(sptplj_60x60.length==0){
			str +="<li role='presentation'><a href='#home0' aria-controls='home0' role='tab' data-toggle='tab'><img class='lazyImg' data_src=''></a></li>";
			thumblist.css("width",60);
		}else{
			for(var i=0;i<sptplj_60x60.length;i++){
				str +="<li role='presentation'><a href='#home"+i+"' aria-controls='home"+i+"' role='tab' data-toggle='tab'><img class='lazyImg' data_src='"+sptplj_60x60[i]+"'></a></li>";
			}
			var ulWidth_60x60=sptplj_60x60.length*72;
			thumblist.css("width",ulWidth_60x60);
		}
		thumblist.append(str);
		thumblist.children("li").eq(0).addClass("active");
	}
	
	function sptplj_379x379List(){
		var content=$('.tab-content');
		var sptplj_800x800=$("#pict").val().split(",");
		sptplj_800x800.pop();
		var str="";
		if(sptplj_800x800.length==0){
			str +="<div role='tabpanel' class='tab-pane' id='home0'>"+
			"<div class='box_800x800' id='box_800x800'>"+
				"<div id='smallBox_800x800' class='small_800x800'>"+
					"<img class='lazyImg' width='378' height='378' data_src=''>"+
					"<div id='mask_800x800' class='mask_800x800'></div>"+
				"</div>"+
				"<div id='bigBox_800x800' class='big_800x800'>"+
					"<img data_src='' id='bigImg_800x800' class='bigImg_800x800 lazyImg'  width='800' height='800' />"+
				"</div>"+
			"</div>"+
			"</div>";
		}else{
		for(var i=0;i<sptplj_800x800.length;i++){
			str +="<div role='tabpanel' class='tab-pane' id='home"+i+"'>"+
			"<div class='box_800x800' id='box_800x800'>"+
				"<div id='smallBox_800x800' class='small_800x800'>"+
					"<img class='lazyImg' width='378' height='378' data_src='"+sptplj_800x800[i]+"'>"+
					"<div id='mask_800x800' class='mask_800x800'></div>"+
				"</div>"+
				"<div id='bigBox_800x800' class='big_800x800'>"+
					"<img data_src='"+sptplj_800x800[i]+"' id='bigImg_800x800' class='bigImg_800x800 lazyImg'  width='800' height='800' />"+
				"</div>"+
			"</div>"+
			"</div>";
		}
		}
		content.append(str);
		content.children("div.tab-pane").eq(0).addClass("active");
		
	}
		
	  //鼠标放入379px图片上显示800px图片的局部
	  function showBigPicture(){
		var box=$('.box_800x800');
		box.each(function(){
			var box1=$(this);
			var smallBox=$(this).find('.small_800x800');
			var bigBox = $(this).find(".big_800x800");
			var bigImg = $(this).find(".bigImg_800x800");
			var mask = $(this).find(".mask_800x800");
			smallBox.mouseover(function(){
				mask.show();
				bigBox.show();
				  });
			smallBox.mouseout(function(){
				mask.hide();
				bigBox.hide();
				  });
			smallBox.mousemove(function(event){
				var event = event || window.event;
				var pageX = event.pageX || event.clientX
						+ document.documentElement.scrollLeft;
				var pageY = event.pageY || event.clientY
						+ document.documentElement.scrollTop;
				var targetX = pageX-smallBox.offset().left;
				var targetY = pageY-smallBox.offset().top;
				var maskX = targetX - mask.width() /2;
				var maskY = targetY - mask.height() / 2;
				if (maskX < 0) {
					maskX = 0;
				}
				if (maskX > smallBox.width() - mask.width()) {
					maskX = smallBox.width() - mask.width();
				}
				if (maskY < 0) {
					maskY = 0;
				}
				if (maskY > smallBox.height() - mask.height()) {
					maskY = smallBox.height() - mask.height();
				}
				mask.css({top:maskY,left:maskX});
				var bigToMove = bigImg.width() - bigBox.width();
				var maskToMove = smallBox.width() - mask.width();
				var rate = bigToMove / maskToMove;
				bigImg.css({top:-rate * maskY,left:-rate * maskX});
			});
		});
	}  
	
	function tupianXuanzhong(){
		$("#thumblist a").click(function(){
			$("#thumblist a").removeClass("zoomThumbActive");
			$(this).addClass("zoomThumbActive");		
		});
	}
	
	//该商品点击向左或者向右滚动图片
	function gundongtupian(){
		var page= 1; 
		var i = 4;//每版四个图片 
		//向右滚动 
		$(".product_next").click(function(){ //点击事件 
		var v_wrap = $(this).parents(); // 根据当前点击的元素获取到父元素 
		var v_show = v_wrap.find("#thumblist"); //找到视频展示的区域 
		var v_cont = v_wrap.find(".tb-small-img-list"); //找到视频展示区域的外围区域 
		var v_width = v_cont.width(); 
		var len = v_show.find("li").length; //我的视频图片个数 
		var page_count = Math.ceil(len/i); //只要不是整数，就往大的方向取最小的整数 
		if(!v_show.is(":animated")){ 
		if(page == page_count){ 
		v_show.animate({left:'0px'},"slow"); 
		page =1; 
		}else{ 
		v_show.animate({left:'-='+v_width},"slow"); 
		page++; 
		} 
		} 
		}); 
		 //向左滚动 
		$(".product_prev").click(function(){ //点击事件 
		var v_wrap = $(this).parents(); // 根据当前点击的元素获取到父元素 
		var v_show = v_wrap.find("#thumblist"); //找到视频展示的区域 
		var v_cont = v_wrap.find(".tb-small-img-list"); //找到视频展示区域的外围区域 
		var v_width = v_cont.width(); 
		var len = v_show.find("li").length; //我的视频图片个数 
		var page_count = Math.ceil(len/i); //只要不是整数，就往大的方向取最小的整数 
		if(!v_show.is(":animated")){ 
		if(page == 1){ 
		v_show.animate({left:'-='+ v_width*(page_count-1)},"slow"); 
		page =page_count; 
		}else{ 
		v_show.animate({left:'+='+ v_width},"slow"); 
		page--; 
		} 
		} 
		}); 
	}
</script>
<script src="${pageContext.request.contextPath}/myJs/kegong.js"></script> 
</head>
<body>
	<jsp:include page="${pageContext.request.contextPath}/common/topTop.jsp" flush="true"/>
	<jsp:include page="${pageContext.request.contextPath}/common/top.jsp" flush="true"/>
	<input id="yeMianPanDing"  type="hidden" value="goodsDetail"/><!-- 当前页面的判定 -->
	
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="product_top margin_top10">
					<div class="left_info ">
						<div class="product_main">
							<div class="shop_img float_left">
								<p class="pro_text"></p>
								<div class="clearfix big_img" id="content">
									<div class="clearfix ">
										<div class="tab-content">
									    </div>
									</div>
									<div class="clearfix small_img">
										<a  class="btn1 prev product_prev">&lt;</a>
										<div class="tb-small-img-list small_img_list">
											<ul role="tablist" id="thumblist" class="clearfix" >
											</ul>
										</div>
										<a class="btn1 next product_next">&gt;</a>
									</div>
								</div>
							</div>
							<div class="shop_info floatRight">
								<input type="hidden" id="pict" value="${spk.pict}" />
								<h1>${spk.spmc }</h1>	
								<dl>
									<dt>商品编号：</dt>
									<dd style="width: 85.11px;">${spk.spdm }</dd>
									<dt>商品批号：</dt>
									<dd>${spk.spph }</dd>
								</dl>
								<dl>
									<dt>生产厂家：</dt>
									<dd>${spk.SCCJ1 }</dd>
								</dl>	
								<dl>
									<dt>规&nbsp;&nbsp;&nbsp;&nbsp;格：</dt>
									<dd>${spk.spgg }</dd>
								</dl>
								<dl>
									<dt>批准文号：</dt>
									<dd>${spk.pzwh }</dd>
								</dl>	
								<dl>
									<dd>
										<span class="pack c9">所属范围：</span>
										<em style="width: 85.11px;"><span class="float_left">${spk.splb }</span></em>
										<c:if test="${spk.ylmc!=null && spk.ylmc!='' }">
										<span class="pack c9">医保类型：</span>
										<em><span class="float_left">${spk.ylmc }类医保</span></em>
										</c:if>
									</dd>
								</dl>	
								<dl>
									<dd>
										<span class="pack c9">中&nbsp;包&nbsp;装：</span>
										<em><span class="float_left">${spk.nbzsl }</span></em>
										<span class="pack c9">大&nbsp;包&nbsp;装：</span>
										<em><span class="float_left">${spk.wbzsl }</span></em>
										<span class="pack c9">可&nbsp;拆&nbsp;零：</span>
										<em>允许</em>
									</dd>
								</dl>	
								<div class="buybox">
									<dl>
										<dd>
											<span class="pack c9">零&nbsp;售&nbsp;价：</span>
											<em><span class="float_left">￥${spk.splsdj }</span></em>
											<c:if test="${spk.lsdj!=0.0 }">
											<span class="pack c9">建议零售价：</span>
											<em style="width: 73.11px;"><span class="float_left">￥${spk.lsdj }</span></em>
											</c:if>
											<c:if test="${spk.cb4!=0.0 }">
											<span class="pack c9">医保支付价：</span>
											<em>￥${spk.cb4}</em>
											</c:if>
										</dd>
									</dl>
									<dl>
										<dt>采&nbsp;购&nbsp;价：</dt>
										<dd style="width: 85.11px;"> 
											<c:choose>
												<c:when test="${spk.xsjg==-1 }">
													<input type="hidden" value="控销"/>
												</c:when>
												<c:otherwise>
													<input type="hidden" value="￥${spk.xsjg }"/>
												</c:otherwise>
											</c:choose>
											<a class="login_look color_red zengda" style="line-height: 15px;height: 15px;">登陆可见</a>
										</dd>
										<dt>促&nbsp;销&nbsp;价：</dt>
										<dd> 
											<input type="hidden" value="￥${spk.cxdj }"/>
											<a class="login_look color_red zengda" style="line-height: 15px;height: 15px;">登陆可见</a>
										</dd>
									</dl>
									<dl class="num">
										<dt>购买数量：</dt>
										<dd >
											<div class="input">
												<input type="text" value="1" id="cxDetailsNum" class="num_input">
												<a  class="up_btn"></a>
												<a  class="lower_btn"></a>
											</div>&nbsp; 盒
										</dd>
										<dd class="store">
											<span class="float_left">库存数量：</span>
											<input type="hidden" value="${spk.kysl>100?'大于100':spk.kysl }"/>
											<span class="showLoggedIn">登录可见</span>
										</dd>
										<dd class="store">
											<span style="color:#ee4444">有效期至：</span>
											<span>${spk.yxq }</span>
										</dd>
									</dl>
									<dl class="buy_btn">
										<dt>&nbsp;</dt>
										<dd class="bidui" shoucang="${spk.spdm}">
											<a class="addCart_jinxq" onclick="addCart_jinxq(this)" spdm="${spk.spdm }" spph="${spk.spph }" href="javascript:;">加入购物车</a>
											<span id="addFavorite" class="collect loginBtn " >加入收藏夹</span>
										</dd>
									</dl>
								</div>	
							</div>
						</div>
						<div class="product_title margin_top20">
							<h2>商品详细信息</h2>
						</div>
						<div class="product_info cont">
							<div class="tips-info">注：说明书仅供参考，所有数据如有出入，以实物说明书为准!</div>
							<div class="description">
								<h3>
									<span>商品说明书</span>
								</h3>
								<input id="pict_sm" type="hidden" value="${spk.pict_sm }" />
								<div id="spsmsxx">
									
								</div>
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