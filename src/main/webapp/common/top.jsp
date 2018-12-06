<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(function() {
		leibieColor();
		daleiIcon();
	});
	
	//类别的颜色
	function leibieColor() {
		$(".lbColor").each(function() {
			if ($(this).val() % 2 == 0) {
				$(this).parent().addClass('color_f1f1');
			}
		});
	}
	
	//类别的图标
	function daleiIcon() {
		$(".lbColor").each(function() {
			if ($(this).val() == 0) {
				$(this).prev().addClass('icon_1');
			} else if ($(this).val() == 1) {
				$(this).prev().addClass('icon_2');
			} else if ($(this).val() == 2) {
				$(this).prev().addClass('icon_3');
			} else if ($(this).val() == 3) {
				$(this).prev().addClass('icon_4');
			} else if ($(this).val() == 4) {
				$(this).prev().addClass('icon_5');
			}
		});
	}
</script>
<div class="own_nav1">
<div class="container ">
	<div class="row daohangtiao">
		<div class="col-xs-3">
			<div class="dropdown">
				<a target="_blank" href="kegong.action" class="dropdown-toggle" data-toggle="dropdown"
					role="button" aria-haspopup="true" aria-expanded="true"><h3
						class="title">全部商品分类</h3></a>
				<ul class="dropdown-menu swfw_ul moRenXianShi" >
					 <c:forEach items="${allSpkLbByLbparent }" var="allSpkLbList"
						varStatus="status">
						<li class="dalei ">
							<div class="dalei_nameBackground">
								<a class="dalei_a" href="${pageContext.request.contextPath}/kegong.html?web_splbdm1=${allSpkLbList.lbdm }">${allSpkLbList.lbmc }</a>
							</div> 
							<input type="hidden" class="lbColor" value="${status.index }" />
							<div class="xiaolei_div">
								<c:forEach items="${allSpkLbList.spklbList }" var="spklbList">
									<a href="${pageContext.request.contextPath}/kegong.html?web_splbdm=${spklbList.lbdm }">${spklbList.lbmc }&nbsp;&nbsp;</a>
								</c:forEach>
							</div>
						</li>
					</c:forEach> 
					<a class="duoyu"></a>
				</ul>
				
			</div>
		</div>
		<div class="col-xs-9">
			<ul class="mainTop">
				<c:forEach items="${navigationBarList }" var="navigationBar">
					<li >
					<a href="${pageContext.request.contextPath}/${navigationBar.url }" target="_blank">${navigationBar.name }</a>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
</div>
