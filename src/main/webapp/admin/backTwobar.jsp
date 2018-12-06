<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>推荐专区，活动专区的二级分类</title>
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
function searchTwoBar(){
	$('#dg').datagrid("load",{
		"barId":$("#oneType").combobox("getValue"),
		"name":$("#searchName").val()
	});
}

function navigationBarName(val,row){
	return row.navigationBar.name;
}

$(function(){
	$("#oneType").combobox({
		onSelect:function(record){
			$('#dg').datagrid("load",{
				"barId":record.id,
				"name":$("#searchName").val()
			});
		}
	});
})


function openTwoLevelAddDialog(){
	$("#dlg").dialog("open").dialog("setTitle","添加二级类别");
	url="BackTwobar/save.do";
}

function saveTwoLevel(){
	$("#fm").form("submit",{
		url:url,
		onSubmit:function(){
			if(!/^\d+$/.test($("#px").val().trim()))  {
				$("#px").val(0); 
			}
			return $(this).form("validate");
		},
		success:function(result){
			var result=eval('('+result+')');
			if(result.state){
				$.messager.alert("系统提示",result.msg);
				resetValue();
				$("#dlg").dialog("close");
				$("#dg").datagrid("reload");
			}else{
				$.messager.alert("系统提示",result.msg);
			}
		}
	});
}

function openTwoLevelModifyDialog(){
	var selectedRows=$("#dg").datagrid('getSelections');
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一条要编辑的数据！");
		return;
	}
	var row=selectedRows[0];
	$("#dlg").dialog("open").dialog("setTitle","修改二级类别");
	$("#name").val(row.name);
	$("#yijifenlei").val(row.barId);
	$("#px").val(row.xh);
	url="BackTwobar/save.do?id="+row.id;
}

function deleteTwoLevel(){
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
			$.post("BackTwobar/delete.do",{ids:ids},function(result){
				if(result.state){
					$.messager.alert("系统提示",result.msg);
					$("#dg").datagrid("reload");
				}else{
					$.messager.alert("系统提示",result.msg);
					$("#dg").datagrid("reload");
				}
			},"json");
		}
	});
}


function resetValue(){
	$("#name").val("");
	$("#px").val("");
}

function closeTwoLeveldialog(){
	resetValue();
	$("#dlg").dialog("close");
}

</script>
</head>
<body style="margin:1px;">
	<table id="dg" class="easyui-datagrid"
	 fitColumns="true" pagination="true" rownumbers="true"
	 url="BackTwobar/list.html" fit="true" toolbar="#tb">
	 <thead>
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="name" width="50" align="center">名称</th>
	 		<th field="xh" width="15" align="center">排序</th>
	 		<th field="navigationBarName" width="30" align="center" formatter="navigationBarName">一级</th>
	 	</tr>
	 </thead>
	</table>
	<div id="tb">
 		<div>
			<a href="javascript:;" onclick="openTwoLevelAddDialog()" class="easyui-linkbutton" iconCls="icon-add" >添加</a>
			<a href="javascript:;" onclick="openTwoLevelModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" >修改</a>
			<a href="javascript:;" onclick="deleteTwoLevel()" class="easyui-linkbutton" iconCls="icon-remove" >删除</a>
		</div>
		<div style="margin-top: 5px;">
			&nbsp;名称:&nbsp;<input type="text" id="searchName" size="20"  onkeydown="if(event.keyCode==13) searchTwoBar()"/> 
			一级分类：<input id="oneType" class="easyui-combobox zidongyiCombobox" panelHeight="auto" editable="false" data-options="
					valueField: 'id',
					textField: 'text',
					data: [{
						id: 0,
						text: 'all',
						'selected':true
					},{
						id: 4,
						text: '推荐品种'
					},{
						id: 5,
						text: '活动专区'
					}]" />
			<a href="javascript:;" onclick="searchTwoBar()" class="easyui-linkbutton" iconCls="icon-search" style="vertical-align: top;">搜索</a>
		</div> 
	</div>
	<div id="dlg" class="easyui-dialog" style="width:300px;height:250px;text-align: center;max-height: 100%;"
	 closed="true" buttons="#dlg-buttons">
		<form method="post" id="fm" style="display: inline-block;">
			<table cellspacing="8px" >
	 			<tr>
	 				<td>名称：</td>
	 				<td>
	 					<input required="true" class="easyui-validatebox"  id="name" type="text" name="name"/>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>一级分类：</td>
	 				<td>
	 					<select id="yijifenlei" name="barId" class="zswz">
	 						<option value="4">推荐品种</option>
	 						<option value="5">活动专区</option>
	 					</select>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>排序：</td>
	 				<td>
	 					<input class="easyui-validatebox" id="px" type="text" name="xh"/>
	 				</td>
	 			</tr>
			</table> 
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:;" onclick="saveTwoLevel()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:;" onclick="closeTwoLeveldialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	
	
</body>
</html>