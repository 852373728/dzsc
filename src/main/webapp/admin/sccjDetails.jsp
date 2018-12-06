<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>厂家详情</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<script type="text/javascript" src="${pageContext.request.contextPath}/myJs/judgeUser.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script> 
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/backStyle.css">
<script type="text/javascript">
	$(function(){
		$.post("sccj_getSccjById.action",{sccjId:'${param.sccjId}'},function(result){
			var sccj=result.sccj;
			$("#cjdm").html(sccj.cjdm);
			$("#cjmc").html(sccj.cjmc);
			$("#cjjj").html(sccj.cjjj);
			if(sccj.cjtplj_100x70==""){
				$("#cjtplj_100x70").attr("src","../image/default_100x100.jpg");
			}else{
				$("#cjtplj_100x70").attr("src",sccj.cjtplj_100x70);
				$("#cjtplj_100x70").attr("title","点击查看原大小");
				$("#100x70a").attr("href",sccj.cjtplj_100x70);
			}
			if(sccj.cjtplj_136x67==""){
				$("#cjtplj_136x67").attr("src","../image/default_100x100.jpg");
			}else{
				$("#cjtplj_136x67").attr("src",sccj.cjtplj_136x67);
				$("#cjtplj_136x67").attr("title","点击查看原大小");
				$("#136x67a").attr("href",sccj.cjtplj_136x67);
			}
		},"json");
	});
</script>
</head>
<body class="backBody">
<table class="tableBack table table-striped">
	<tbody>
		<tr>
			<th>代码：</th>
			<td><span id="cjdm"></span></td>
		</tr>
		<tr>
			<th>名称：</th>
			<td><span id="cjmc"></span></td>
		</tr>
		<tr>
			<th>简介：</th>
			<td><span id="cjjj"></span></td>
		</tr>
		<tr>
			<th>100px*70px：</th>
			<td><a id="100x70a" target="_blank"><img id="cjtplj_100x70"></a></td>
		</tr>
		<tr>
			<th>136px*67px：</th>
			<td><a id="136x67a" target="_blank"><img id="cjtplj_136x67"></a></td>
		</tr>
	</tbody>
</table>
</body>
</html>