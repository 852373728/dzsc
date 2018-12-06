//鼠标悬浮出现商品信息
	function shuBiaoXuanFu(){
		$('.no_img_product_info').hide();  
	    $('#list_view .productName').mousemove(function(event){
	    	event = event || window.event;
			var nX = event.pageX;
			var nY = event.pageY;
			var offset = -190;
			var nH = $(".no_img_product_info")
					.outerHeight(true);
			if (nY + nH > $(window).height()
					+ $(window).scrollTop()) {
				offset -= 200;
			}
	        $('.no_img_product_info').eq($(this).parents('dl').prev().val()).show().css({  
	        	"top" : event.pageY + offset,
				"left" :event.pageX- $('#list_view .productName').parents('.filter_result').offset().left+15
	        }).siblings('.no_img_product_info').hide();  
	    });  
	    $('#list_view .productName').mouseleave(function(){  
	        $('.no_img_product_info').hide();  
	    });  
	}
	
	//鼠标悬浮出现促销信息
	function shuBiaoXuanFuCuXiao(){
		$('.cuxiao').hide();  
	    $('.validPromotion').mousemove(function(event){
	    	event = event || window.event;
			var nX = event.pageX;
			var nY = event.pageY;
			var offset = -195;
			var nH = $(".cuxiao")
					.outerHeight(true);
			if (nY + nH > $(window).height()
					+ $(window).scrollTop()) {
				offset -= 50;
			}
	        $('.cuxiao').eq($(this).parents('dl').prev().val()).show().css({  
	        	"top" : event.pageY + offset,
				"left" : event.pageX- $('#list_view .productName').parents('.filter_result').offset().left+15
	        }).siblings('.cuxiao').hide();  
	    });  
	    $('.validPromotion').mouseleave(function(){  
	        $('.cuxiao').hide();  
	    });  
	}	
	
	//背景色的变化
	function backGround(){
		$('.spk_index').each(function(){
			if($(this).val()%2==1){
				$(this).next().addClass("bg");
			}
		});
		
	}
	
	//无图，列表，大图三种css的切换
	function tabPicture(){
		var viewbtns1=localStorage.getItem("viewbtns");
		if(viewbtns1==0){
			$('.viewbtns').children().eq(0).addClass('on').siblings('.on').removeClass('on');
			$("#list_view").attr("class", "no_img_list");
			$('.r-frame').hide();
		}else if(viewbtns1==1){
			$('.viewbtns').children().eq(1).addClass('on').siblings('.on').removeClass('on');
			$("#list_view").attr("class", "small_img_list");
			$('.r-frame').show();
		}else if(viewbtns1==2){
			$('.viewbtns').children().eq(2).addClass('on').siblings('.on').removeClass('on');
			$("#list_view").attr("class", "big_img_list");
			$('.r-frame').show();
		}
		
		$('.viewbtns').children().click(function(){
			if($(this).hasClass('on')) return;
            $(this).addClass('on').siblings('.on').removeClass('on');
		});
		$('.viewbtns').children().eq(0).click(function(){
			$("#list_view").attr("class", "no_img_list");
			localStorage.setItem("viewbtns",0);
			$('.r-frame').hide();
		});
		$('.viewbtns').children().eq(1).click(function(){
			$("#list_view").attr("class", "small_img_list");
			localStorage.setItem("viewbtns",1);
			$('.r-frame').show();
		});
		$('.viewbtns').children().eq(2).click(function(){
			$("#list_view").attr("class", "big_img_list");
			localStorage.setItem("viewbtns",2);
			$('.r-frame').show();
		});
		
	}
	
	function judgeZongLei_click(){
		if($('#zongLei').is('.in')){
			$('.filter-header_a').html("+展开");
			$('.filter_item').css({"padding":"0","border":"0"});
		}else{
			$('.filter-header_a').html("-收起");
			$('.filter_item').css({"padding":"1px","border":"1px solid #cae0e3"});
		}
	}
	
	function xiangXiLeiBie(){
		$('.zhankaiShouqi_a').click(function(){
			if($(this).parents("dd").children("ul").is('.in')){
				$(this).html("展开");
				$(this).parent().css("background","url(image/btn_unfold.gif) no-repeat right 0");
			}else{
				$(this).html("收起");
				$(this).parents("dd").css({"min-height":"36px","height":"inherit"});
				$(this).parent().css("background","url(image/btn_fewer.gif) no-repeat right 0");
			}
		});
	}
	
	//当商品不属于任何类型时，那个类型隐藏不见
	function leiBieKongZhi(){
		$('ul.zhankaiShouqi').each(function(){
			if($(this).find("li").length==0){
				$(this).parents("dl").hide();
			}
			if($(this).height()=="36"){
				$(this).prev().hide();
			}
		});
	}
	//商品数量的加减
	function jiajian(){
		$(".up_btn").click(function(){
			var count=$(this).parent().find('input[class=num_input]');
			count.val(parseInt(count.val())+1);
		});
		$(".lower_btn").click(function(){
			var count=$(this).parent().find('input[class=num_input]');
			count.val(parseInt(count.val())-1);
			if(parseInt(count.val())<1){
				count.val(1);
			}
		});
		
		$(".num_input").on("input propertychange",function(){
			var count=$(this).parent().find('input[class=num_input]');
			var pattern = /^[0-9]*[1-9][0-9]*$/;
			if(!pattern.test(count.val())){
				count.val(1);
			}
		});
	}
	
	//搜索条件过滤
	function TiaoJianGuoLv(url){
		$('.condition').click(function(){
			var params=window.location.search.replace("?", "&").split("&");
			for(var i=1;i<params.length;i++){
				if(params[i]=="page="+$('#weiyi').html()){
					params[i]="page=1";
				}
				var canshu=params[i].split("=")[0]+"="+decodeURI(params[i].split("=")[1]);//把地址栏的中文乱码转化为中文
				if(canshu==$(this).attr("adress")){
					$(this).attr("adress",'');
					params.splice(i,1);
					for(var i = 0; i < params.length; i++) {
				        if(params[i].length == 0) params.splice(i,1);
				    }
				}
				
			}
			window.location.href=url+".html?"+$(this).attr("adress")+params.join('&');
		});
		var params=window.location.search.replace("?", "&").split("&");
		for(var i=1;i<params.length;i++){
			var canshu=params[i].split("=")[0]+"="+decodeURI(params[i].split("=")[1]);//把地址栏的中文乱码转化为中文
			$('.condition').each(function(){
				var adress=$(this).attr('adress');
				if(adress==canshu){
					$(this).parent().addClass("on");
					$(this).parent().siblings().css({"display":"none"});
				}
			});
		}
		
	}
 
	//分页查询
	function fenye(url){
		var pageCode=$('#frontPage');
		var total=parseInt($("#spkTotal").val());//总条数
		if(total==0){
			return;
		}
		var pageSize=parseInt($("#spkCurrentSize").val());//每页显示商品数量
		var totalPage=total%pageSize==0?total/pageSize: Math.floor(total/pageSize)+1;//总页数
		var currentPage=parseInt($("#spkCurrentPage").val());//当前页数
		pageCode.append("<li><a href='javascript:page(1,\""+url+"\")'>首页</a></li>");
		if(currentPage>1){
			pageCode.append("<li><a href='javascript:page("+(currentPage-1)+",\""+url+"\")'>上一页</a></li>");			
		} 						
		for(var i=currentPage-4;i<=currentPage+4;i++){
			if(i<1||i>totalPage){
				continue;
			}
			if(i==currentPage){
				pageCode.append("<li class='active'><a id='weiyi' href='#'>" + i
						+ "</a></li>");	
			}else{
				pageCode.append("<li><a href='javascript:page("+i+",\""+url+"\")'>"+i+"</a></li>");	
			}
		}
		if(currentPage<totalPage){  
			pageCode.append("<li><a href='javascript:page("+(currentPage+1)+",\""+url+"\")'>下一页</a></li>");		
		}					
		pageCode.append("<li><a href='javascript:page("+totalPage+",\""+url+"\")'>尾页</a></li>");
		pageCode.append("<span>共"+totalPage+"页</span>");
		pageCode.append("<span>到</span>");
		pageCode.append("<input id='tiaoye' style='width:25px' type='text' onkeydown='if(event.keyCode==13) page_jump_btn(\""+url+"\")' />");
		pageCode.append("<span>页</span>");
	}
	
	
	function page(i,url){
		
		var params=window.location.search.replace("?", "&").split("&");
		for(var j=1;j<params.length;j++){
			if(params[j].length == 0) params.splice(j,1);
			if(params[j].split("=")[0]=="page"){
				params.splice(j,1);
			}
		}
		for(var j = 0; j < params.length; j++) {
	        if(params[j].length == 0) params.splice(j,1);
	    }
		params=params.join('&');
		var page="page="+i;
		if(params!=""){
			page="&page="+i;
		}
		params+=page;
		window.location.href=url+".html?"+params;
	}
	
	function page_jump_btn(url){
		var total=parseInt($("#spkTotal").val());//总条数
		var totalPage=total%5==0?total/5: Math.floor(total/5)+1;//总页数
		var tiaoye=$('#tiaoye').val();
		 if(tiaoye<=totalPage && (/^(\+|-)?\d+$/.test( tiaoye )) && tiaoye>0){  
			 page(tiaoye,url);
		}else{
			 page(1,url);
		}
	}
	
	//默认，销量，人气的选择
	function xiaolingRenqiPaixu(url){
		$('.condition1').click(function(){
			var params=window.location.search.replace("?", "&").split("&");
			for(var i=1;i<params.length;i++){
				if(params[i].split("=")[0]=="listPh"){
					params.splice(i,1);
				}
			}
			window.location.href=url+".html?"+$(this).attr("adress")+params.join('&');
		});
		var params=window.location.search.replace("?", "&").split("&");
		for(var i=1;i<params.length;i++){
			$('.condition1').each(function(){
				var adress=$(this).attr('adress');
				if(adress==params[i]){
					$(this).addClass("on");
				}
			});
		}
		
	}
	
	//已收藏的显示带颜色的星星
	function sc(){
		$.post("/kh/reload.html",function(result){
			if(result.state){
				$.post("/collection/list.html",function(result){
					var collectList=result.collectList;
					for(var i in collectList){
						$(".bidui").each(function(){
							if($(this).attr("shoucang")==collectList[i].spdm){
								$(this).children("span.collect").attr("class","collect loginBtn on");
								return false;
							}
						});
					}
				},"json");
			}
		},"json");
	}
	
	//促销商品添加进购物车
	function addCart_jinxq(myself){
		$.post("/kh/reload.html",function(result){
			if(result.state){
				var spph=$(myself).attr("spph");
				var spdm=$(myself).attr("spdm");
				var num=$(myself).parents("dd.dd_goods_cart").find("input.num_input").val();
				if(num==undefined){
					num=$("#cxDetailsNum").val();
				}
				$.post("/shopCar/addcx.html",{"spph":spph,"spdm":spdm,"num":num},function(result){
					alert(result.msg);
					if(result.shopCarCount!=null){
						$("#shopCarCount").html(result.shopCarCount);
					}
				},"json");
			}else{
				pop_upLogin();
			}
		},"json");
	}
	
	