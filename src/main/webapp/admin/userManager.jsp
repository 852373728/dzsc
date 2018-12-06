<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<title>管理员</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/myJs/judgeUser.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.2/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/backStyle.css">
<script type="text/javascript">
var url;
function openUserAddDialog(){
	$("#dlg").dialog("open").dialog("setTitle","添加后台管理员");
	url="manager_save.action";
}

function saveUser(){
	$("#fm").form("submit",{
		url:url,
		onSubmit:function(){
			return $(this).form("validate");
		},
		success:function(result){
			var result=eval('('+result+')');
			if(result.state){
				$.messager.alert("系统提示",result.msg);
				resetValue();
				$("#dlg").dialog("close");
				$("#dg").datagrid("reload");
			}
		}
	});
}

function resetValue(){
	$("#account").val("");
	$("#password").val("");
}

function closeUserDialog (){
	$("#dlg").dialog("close");
	resetValue();
}

function openUserModifyDialog(){
	var selectedRows=$("#dg").datagrid('getSelections');
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一条要编辑的数据！");
		return;
	}
	var row=selectedRows[0];
	$("#dlg").dialog("open").dialog("setTitle","编辑管理员信息");
	$("#account").val(row.account);
	$("#password").val(row.password);
	url="manager_save.action?backstageManager.id="+row.id;
}

function deleteUser(){
	var selectedRows=$('#dg').datagrid("getSelections");
	if(selectedRows.length==0){
		$.messager.alert("系统提示","请选择要删除的数据！");
		return;
	}
	var strIds=[];
	for(var i=0;i<selectedRows.length;i++){
		strIds.push(selectedRows[i].id);
	}
	var ids=strIds.join(",");
	$.messager.confirm("系统提示","您确认要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
		if(r){
			$.post("manager_delete.action",{ids:ids},function(result){
				if(result.state){
					$.messager.alert("系统提示",result.msg);
					$("#dg").datagrid("reload");
				}
			},"json");
		}
	});
}

</script>
</head>
<body style="margin:1px;">
	<table id="dg" class="easyui-datagrid"
	 fitColumns="true" pagination="true" rownumbers="true"
	 url="manager_list.action" fit="true" toolbar="#tb">
	 <thead>
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="account" width="50" align="center">账号</th>
	 		<th field="password" width="50" align="center">密码</th>
	 	</tr>
	 </thead>
	</table>
 	<div id="tb">
 		<div>
			<a href="javascript:;" onclick="openUserAddDialog()" class="easyui-linkbutton" iconCls="icon-add" >添加</a>
			<a href="javascript:;" onclick="openUserModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" >修改</a>
			<a href="javascript:;" onclick="deleteUser()" class="easyui-linkbutton" iconCls="icon-remove" >删除</a>
		</div>
		<!-- <div>
			&nbsp;名称:&nbsp;<input type="text" id="name" size="20" onkeydown="if(event.keyCode==13) searchBigType()"/>
			<a href="javascript:searchBigType()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div> -->
	</div>
	<div id="dlg" class="easyui-dialog" style="width: 350px;height:180px;padding: 10px 20px;"
	 closed="true" buttons="#dlg-buttons">
		<form method="post" id="fm">
			<table cellspacing="8px">
				<tr>
	 				<td>账号：</td>
	 				<td><input type="text" id="account" name="backstageManager.account" class="easyui-validatebox" required="true"/></td>
	 			</tr>
	 			<tr>
	 				<td>密码：</td>
	 				<td><input type="text" id="password" name="backstageManager.password" class="easyui-validatebox" required="true" /></td>
	 			</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:;" onclick="saveUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:;" onclick="closeUserDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>