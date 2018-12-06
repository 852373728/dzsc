<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/backStyle.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/farbtastic.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/farbtastic.css" type="text/css" />
<title>前台首页商品位置，感兴趣，热点，轮播，三张图片</title>
<script type="text/javascript">
var url;
var kk;
function searchMainShow(){
	$('#dg').datagrid("load",{
		"sywzdm":$("#leixing").combobox("getValue"),
		"searchName":$("#searchName").val()
	});
}

$(function(){
	$("#leixing").combobox({
		onSelect:function(record){
			$('#dg').datagrid("load",{
				"sywzdm":record.value,
				"searchName":$("#searchName").val()
			});
		}
	});
})

function formatSptplj(val,row){
	if(val==""){
		return "";
	}else{
		return "<a class='aa_focus' target='_blank' href='"+val+"'>已上传</a>";
	}
}

function bjys(val,row){
	if(val==""){
		return "";
	}else{
		return "<span style='background: "+val+";width:100%;height:100%;display: inline-block;'>"+val+"</span>";
	}
}

function spdm(val,row){
	if(row.spk!=null){
		return row.spk.spdm;
	}
}
function spmc(val,row){
	if(row.spk!=null){
		return row.spk.spmc;
	}
}

function openMainShowAddDialog(){
	$("#dlg").dialog("open").dialog("setTitle","添加首页展示商品");
	url="backMainShow/save.do";
}

function saveMainShow(){
	$("#fm").form("submit",{
		url:url,
		onSubmit:function(){
			if(!/^\d+$/.test($("#xh").val().trim()))  {
				$("#xh").val(0); 
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
				$.messager.alert("系统提示","添加失败");
			}
		}
	});
}

function openMainShowModifyDialog(){
	var selectedRows=$("#dg").datagrid('getSelections');
	if(selectedRows.length!=1){
		$.messager.alert("系统提示","请选择一条要编辑的数据！");
		return;
	}
	var row=selectedRows[0];
	$("#dlg").dialog("open").dialog("setTitle","修改首页展示商品");
	$('#fm').form('load',row);
	$('#spmc').val(row.spk.spmc);
	$.farbtastic(kk).setColor(row.backcolor);
	url="backMainShow/save.do?id="+row.id;
}

function deleteMainShow(){
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
			$.post("backMainShow/delete.do",{ids:ids},function(result){
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
	$("#spmc").val("");
	$("#xh").val("");
	$("#pic1").val("");
	$("#pic1").val("");
}

function closeMainShowDialog(){
	resetValue();
	$("#dlg").dialog("close");
}
$(document).ready(function() {
    kk= $('#colorpicker').farbtastic('#color');
  });
</script>
</head>
<body style="margin:1px;">
	<table id="dg" class="easyui-datagrid"
	 fitColumns="true" pagination="true" rownumbers="true"
	 url="backMainShow/list.do" fit="true" toolbar="#tb">
	 <thead>
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="spk.spmc" width="50" align="center" formatter="spmc">商品名称</th>
	 		<th field="spk.spdm" width="50" align="center" formatter="spdm">商品代码</th>
	 		<th field="sywzmc" width="50" align="center">所在位置名称</th>
	 		<th field="xh" width="20" align="center">展示顺序</th>
	 		<th field="tplj" width="50" align="center" formatter="formatSptplj">展示图片</th>
	 		<th field="backcolor" width="20" align="center" formatter="bjys">背景颜色</th>
	 	</tr>
	 </thead>
	</table>
	<div id="tb">
 		<div>
			<a href="javascript:;" onclick="openMainShowAddDialog()" class="easyui-linkbutton" iconCls="icon-add" >添加</a>
			<a href="javascript:;" onclick="openMainShowModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" >修改</a>
			<a href="javascript:;" onclick="deleteMainShow()" class="easyui-linkbutton" iconCls="icon-remove" >删除</a>
			<span class="zswz">
				轮播：1002px*350px
			</span>
		</div>
		 <div style="margin-top: 5px;">
			&nbsp;名称:&nbsp;<input type="text" id="searchName" size="20" onkeydown="if(event.keyCode==13) searchMainShow()"/>
			&nbsp;类型:&nbsp;<select id="leixing" class="easyui-combobox" data-options="panelHeight:'auto',editable:false" style="width:173px;">
								<option value="">all</option>
								<option value="1">热点</option>
	 							<option value="2">轮播</option>
							</select>
			<a href="javascript:searchMainShow()" class="easyui-linkbutton" iconCls="icon-search" style="vertical-align: top;">搜索</a>
		</div> 
	</div>
	<div id="dlg" class="easyui-dialog" style="width: 380px;height:500px;text-align: center;"
	 closed="true" buttons="#dlg-buttons">
		<form method="post" id="fm" style="display: inline-block;" enctype="multipart/form-data">
			<table cellspacing="8px">
				<tr>
	 				<td colspan="2" align="center"><a href="javascript:;" onclick="choseGoods()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >选择商品</a></td>
	 			</tr>
				 <tr>
	 				<td>商品名称</td>
	 				<td>
	 					<input id="spmc" type="text" readonly="readonly" class="easyui-validatebox" required="true"/>
						<input type="hidden" id="spkId" name="spkid"/>
					</td>
	 			</tr> 
	 			 <tr>
	 				<td>图片展示：</td>
	 				<td>
	 					<input id="pic1" type="file" style="width: 173px;" name="pic1"/>
	 				</td>
	 			</tr> 
	 			<tr>
	 				<td>展示位置：</td>
	 				<td>
	 					<select id="sywzdm" name="sywzdm" class="zswz">
	 						<option value="1">热点</option>
	 						<option value="2">轮播</option>
	 					</select>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td valign="top">颜色选择：</td>
	 				<td>
	 					<input type="text" id="color" name="backcolor" value="#123456" />
						<div id="colorpicker"></div>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>排列顺序：</td>
	 				<td><input  id="xh" type="text" name="xh"/></td>
	 			</tr>
			</table> 
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:;" onclick="saveMainShow()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:;" onclick="closeMainShowDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	<jsp:include page="spkBack.jsp" />
	
	
</body>
</html>