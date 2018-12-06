<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品库</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/backStyle.css">
<script type="text/javascript">
function searchSp(){
	$('#dg').datagrid("load",{
		"searchName":$("#searchName").val(),
		"sj_xz":$("#sj_xz").combobox("getValue"),
		"kx_xz":$("#kx_xz").combobox("getValue"),
		"st_lb":$("#st_lb").combobox("getValue")
	});
}

$(function(){
	$("#sj_xz").combobox({
		onSelect:function(record){
			$('#dg').datagrid("load",{
				"searchName":$("#searchName").val(),
				"sj_xz":record.id,
				"kx_xz":$("#kx_xz").combobox("getValue"),
				"st_lb":$("#st_lb").combobox("getValue")
			});
		}
	});
	$("#kx_xz").combobox({
		onSelect:function(record){
			$('#dg').datagrid("load",{
				"searchName":$("#searchName").val(),
				"sj_xz":$("#sj_xz").combobox("getValue"),
				"kx_xz":record.id,
				"st_lb":$("#st_lb").combobox("getValue")
			});
		}
	});
	$("#st_lb").combobox({
		onSelect:function(record){
			$('#dg').datagrid("load",{
				"searchName":$("#searchName").val(),
				"sj_xz":$("#sj_xz").combobox("getValue"),
				"kx_xz":$("#kx_xz").combobox("getValue"),
				"st_lb":record.id
			});
		}
	});
});

/* function aa(val,row){
	return "<a class='aa_focus' href='javascript:openDetails("+row.id+")'>详情</a>";
}

function openDetails(id){
	 window.parent.openTab('商品详情','spkDetails.jsp?spkId='+id,'icon-detail');
} */

</script>
</head>
<body style="margin:1px;">
<table id="dg" class="easyui-datagrid" fit="true"
 pagination="true" rownumbers="true"
 url="backSpk/listAll.do" toolbar="#tb" pageSize="20">
  <thead data-options="frozen:true">
 	<tr>
		<th field="cb" checkbox="true" align="center"></th>
		<th field="spmc" width="150px" align="center">商品名称</th>
		<th field="spdm" width="100px" align="center">厂家商品代码</th>
		<th field="SCCJ1" width="200px" align="center">生产企业</th>
	</tr>
  </thead>	
 <thead >
 	<tr>
 		<th field="sj_xz" width="50px" align="center">上架</th>
 		<th field="kx_xz" width="50px" align="center">控销</th>
 		<th field="st_lb" width="50px" align="center">在库</th>
 	</tr>
 </thead>
</table>
<div id="tb">
	<div style="margin-top: 5px;">
		&nbsp;名称:&nbsp;<input type="text" id="searchName" size="20" onkeydown="if(event.keyCode==13) searchSp()"/> 
		&nbsp;上架查询:&nbsp;<input id="sj_xz" class="easyui-combobox zidongyiCombobox" panelHeight="auto" editable="false" data-options="
					valueField: 'id',
					textField: 'text',
					data: [{
						id: '',
						text: '请选择',
						'selected':true
					},{
						id: '上架',
						text: '上架'
					}]" />
		&nbsp;控销查询:&nbsp;<input id="kx_xz" class="easyui-combobox zidongyiCombobox" panelHeight="auto" editable="false" data-options="
					valueField: 'id',
					textField: 'text',
					data: [{
						id: '',
						text: '请选择',
						'selected':true
					},{
						id: '控销',
						text: '控销'
					}]" />
		&nbsp;在库查询:&nbsp;<input id="st_lb" class="easyui-combobox zidongyiCombobox" panelHeight="auto" editable="false" data-options="
					valueField: 'id',
					textField: 'text',
					data: [{
						id: '',
						text: '请选择',
						'selected':true
					},{
						id: '在库',
						text: '在库'
					}]" />
		<a href="javascript:;" onclick="searchSp()" class="easyui-linkbutton" iconCls="icon-search" style="vertical-align: top;">搜索</a>
	</div> 
</div>
</body>
</html>