<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<title>推荐品种</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script> 
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css">
<script src="${pageContext.request.contextPath}/bootstrap3/bootstrap3Tree/bootstrap-treeview.min.js"></script>
<script type="text/javascript">
function getTree() {
	var tree = [
		  {
		    text:"Parent 1"
		  },
		  {
		    text:"Parent 2"
		  },
		  {
		    text:"Parent 3"
		  },
		  {
		    text:"Parent 4"
		  },
		  {
		    text:"Parent 5"
		  }
		];  

    return tree;
}
 


$(function(){
	alert(getTree()) 
	$('#tree').treeview({data: getTree()});
})
</script>
</head>
<body style="margin: 0px;">
<div id="tree"></div>  
</body>
</html>
 