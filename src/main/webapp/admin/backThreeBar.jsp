<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>活动专区三级分类</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/backStyle.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function searchThreeBar(){
	$("#dg").datagrid("load",{
		"twoBarId":$("#ejzl").combobox("getValue"),
		"name":$("#searchName").val()
	});
}

$(function(){
	$("#ejzl").combobox({
		onSelect:function(record){
			$('#dg').datagrid("load",{
				"twoBarId":record.id,
				"name":$("#searchName").val()
			});
		}
	});
});

function twoBarName(val,row){
	return row.twoBar.name;
}

function carousel(val,row){
	if(val=="1"){
		return "是";
	}else{
		return "";
	}
}

function carouselTplj(val,row){
	if(val==""){
		return "";
	}else{
		return "<a class='aa_focus' target='_blank' href='"+val+"'>已上传</a>";
	}
}

function openThreeLevelAddDialog(){
	$("#dlg").dialog("open").dialog("setTitle","添加三级类别");
	url="backThreeBar/save.do";
}

function saveThreeLevel(){
	$("#fm").form("submit",{
		url:url,
		onSubmit:function(){
			if($("#twoBarId").combobox("getValue")==0){
				$.messager.alert("系统提示","请选择二级种类");
				return false;
			}
			if($("#huoDongOver").val()==""){
				$.messager.alert("系统提示","请选择活动结束时间");
				return false;
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

function openThreeLevelModifyDialog(){
	var selectedRows=$("#dg").datagrid('getSelections');
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一条要编辑的数据！");
		return;
	}
	var row=selectedRows[0];
	$('#fm').form('load',row);
	$("#dlg").dialog("open").dialog("setTitle","修改三级分类");
	url="backThreeBar/save.do?id="+row.id;
}

function deleteThreeLevel(){
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
			$.post("backThreeBar/delete.do",{ids:ids},function(result){
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
	$("#twoBarId").combobox("setValue","");
	$("#huoDongOver").val("");
	$("#carousel").val(0);
	$("#pic1").val("");
}

function closeThreeLeveldialog(){
	resetValue();
	$("#dlg").dialog("close");
}
</script>
</head>
<body style="margin:1px;">
<table id="dg" class="easyui-datagrid"
 fitColumns="true" pagination="true" rownumbers="true"
 url="backThreeBar/list.do" fit="true" toolbar="#tb">
 <thead>
 	<tr>
 		<th field="cb" checkbox="true" align="center"></th>
 		<th field="name" width="50" align="center">名称</th>
 		<th field="twoBarName" width="30" align="center" formatter="twoBarName">二级</th>
 		<th field="huoDongStart" width="50" align="center">开始时间</th>
 		<th field="huoDongOver" width="50" align="center">结束时间</th>
 		<th field="carousel" width="25" align="center" formatter="carousel">是否轮播</th>
 		<th field="carouselTplj" width="30" align="center" formatter="carouselTplj">轮播图片</th>
 	</tr>
 </thead>
</table>
<div id="tb">
	<div>
		<a href="javascript:;" onclick="openThreeLevelAddDialog()" class="easyui-linkbutton" iconCls="icon-add" >添加</a>
		<a href="javascript:;" onclick="openThreeLevelModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" >修改</a>
		<a href="javascript:;" onclick="deleteThreeLevel()" class="easyui-linkbutton" iconCls="icon-remove" >删除</a>
		<span class="zswz">轮播图片：活动专区下的轮播，大小925x338</span>
	</div>
	<div style="margin-top: 5px;">
		&nbsp;类型:&nbsp;<input type="text" id="searchName" size="20" onkeydown="if(event.keyCode==13) searchThreeBar()"/>
		&nbsp;二级分类:&nbsp;<input class="easyui-combobox" id="ejzl" data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'name',url:'BackTwobar/combobox/5.do'"/>
		<a href="javascript:searchThreeBar()" class="easyui-linkbutton" iconCls="icon-search" style="vertical-align: top;">搜索</a>
	</div> 
</div>
<div id="dlg" class="easyui-dialog" style="width:300px;height:250px;text-align: center;max-height: 100%;"
 closed="true" buttons="#dlg-buttons">
	<form method="post" id="fm" style="display: inline-block;" enctype="multipart/form-data">
		<table cellspacing="8px" >
 			<tr>
 				<td>名称：</td>
 				<td>
 					<input class="easyui-validatebox"  id="name" type="text" name="name" required="true"/>
 				</td>
 			</tr>
 			<tr>
 				<td>二级分类：</td>
 				<td>
 					<input name="twoBarId" class="easyui-combobox" id="twoBarId" data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'name',url:'BackTwobar/combobox/5.do'"/>
 				</td>
 			</tr>
 			<tr>
 				<td>结束时间：</td>
 				<td>
 					<input name="huoDongOver" style="cursor: pointer;" class="Wdate" id="huoDongOver" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd 00:00:00',readOnly:true})" />
 				</td>
 			</tr>
 			<tr>
 				<td>是否轮播：</td>
 				<td>
 					<select id="carousel" name="carousel" class="zswz">
 						<option value="0">否</option>
 						<option value="1">是</option>
 					</select>
 				</td>
 			</tr>
 			<tr>
 				<td align="right">图片：</td>
 				<td>
 					<input id="pic1" type="file" style="width: 173px;" name="pic1"/>
 				</td>
 			</tr>
		</table> 
	</form>
</div>
<div id="dlg-buttons">
	<a href="javascript:;" onclick="saveThreeLevel()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	<a href="javascript:;" onclick="closeThreeLeveldialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>

</body>
</html>