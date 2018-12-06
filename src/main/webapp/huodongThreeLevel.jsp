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
		var url="threeBar";
		fenye(url);
	});
</script>
</head>
<body>
	<input type="hidden" id="spkTotal" value="${total}"/>
	<input type="hidden" id="spkCurrentPage" value="${page}"/>
	<input type="hidden" id="spkCurrentSize" value="${size}"/>
	<jsp:include page="common/topTop.jsp" flush="true"/>
	<jsp:include page="common/top.jsp" flush="true"/>
	<input id="yeMianPanDing"  type="hidden" value="3"/><!-- 当前页面的判定 -->
	<div class="topic_banner margin_top20"><div class="box"></div></div>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
			<div class="special margin_top10">
				<h3 class="title">全部活动</h3>
				<c:forEach items="${threeBar }" var="mainTopThreeLevel">
				<div class="item margin_top20">
					<table>
						<tbody>
							<tr class="head">
								<th>
									<p>开始时间：<fmt:formatDate value="${mainTopThreeLevel.huoDongStart }"  type="date" pattern="yyyy-MM-dd"/></p>
									<p>结束时间：<fmt:formatDate value="${mainTopThreeLevel.huoDongOver }"  type="date" pattern="yyyy-MM-dd"/></p>
								</th>
								<td><a href="huodongMore.html?threebarid=${mainTopThreeLevel.id }">${mainTopThreeLevel.name }</a></td>
							</tr>
							<tr class="info"></tr>
						</tbody>
					</table>
				</div>
				</c:forEach>
				<div  class="floatRight feny">
					<ul id="frontPage" class="pagination fenyeClass"></ul>
					<div class="page_jump_btn">
						<a href="javascript:page_jump_btn('threeBar')"></a>
					</div>
				</div>
			</div>
			</div>
		</div>
	</div>
	
	
	<jsp:include page="common/foot.jsp"></jsp:include>
</body>
</html>