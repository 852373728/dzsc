<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<title>碎片信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/backStyle.css">
<script src="${pageContext.request.contextPath}/static/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
var url;
function flag(val,row){
	if(val=="1"){
		return "是";
	}else{
		return "";
	}
}

function edit(){
	
	var selectedRows=$("#dg").datagrid('getSelections');
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一条要编辑的数据！");
		return;
	}
	var row=selectedRows[0];
	$("#dlg").dialog("open").dialog("setTitle","修改信息");
	$('#fm').form('load',row);
	CKEDITOR.instances.content.setData(row.msg);
	url="backScMsg/update.html?id="+row.id;
}

function save(){
	$("#fm").form("submit",{
		url:url,
		success:function(result){
			$.messager.alert("系统提示","修改成功");
			$("#dlg").dialog("close");
			$("#dg").datagrid("reload");
		}
	});
}

function closeDlg(){
	$("#dlg").dialog("close");
}
</script>
</head>
<body style="margin:1px;">
	<table id="dg" class="easyui-datagrid"
	 fitColumns="true" rownumbers="true"
	 url="backScMsg/list.do" fit="true" toolbar="#tb">
	 <thead>
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="msg" width="50" align="center">提示信息</th>
	 		<th field="zj" width="50" align="center">价格标准</th>
	 		<th field="flag" width="10" align="center" formatter="flag">是否有效</th>
	 	</tr>
	 </thead>
	</table>
 	<div id="tb">
 		<div>
			<a href="javascript:;" onclick="edit()" class="easyui-linkbutton" iconCls="icon-edit" >修改</a>
		</div>
	</div>
	<div id="dlg" class="easyui-dialog" style="width: 900px;height:500px;padding: 10px 20px;"
	 closed="true" buttons="#dlg-buttons">
		<form method="post" id="fm">
			<table cellspacing="8px">
				<tr>
	 				<td>是否有效：</td>
	 				<td>
	 					<select id="flag" name="flag" class="zswz">
	 						<option value="0">否</option>
	 						<option value="1">是</option>
	 					</select>
					</td>
	 			</tr>
				<tr>
	 				<td>价格标准：</td>
	 				<td><input type="text" id="zj" name="zj" class="easyui-validatebox" /></td>
	 			</tr>
				<tr>
	 				<td>提示信息：</td>
	 				<td><textarea id="content" name="msg" class="ckeditor" ></textarea></td>
	 			</tr>
	 			
	 			
			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:;" onclick="save()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:;" onclick="closeDlg()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>